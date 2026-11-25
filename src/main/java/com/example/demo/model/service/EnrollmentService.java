package com.example.demo.model.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.domain.Enrollment;
import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;
import com.example.demo.model.repository.EnrollmentRepository;
import com.example.demo.model.repository.MemberRepository;
import com.example.demo.model.repository.PostRepository;
import org.springframework.context.ApplicationEventPublisher;
import com.example.demo.model.dto.Notification;
import com.example.demo.model.dto.SeatMessage;


@Service // [11주차] 단계 4 : 신청 서비스
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired // [12주차] 실시간 메시지 이벤트 발행
    private ApplicationEventPublisher eventPublisher;

    // 내 신청 내역 조회
    public List<Enrollment> findMine(String username) {
        return enrollmentRepository.findByMember_UsernameOrderByIdDesc(username);
    }

    // 단계 4 & 5 : 바구니의 모집글을 한 번에 신청 확정
    @Transactional // 단계 5 : 하나라도 실패하면 모두 취소 (롤백)
    public int confirm(String username, Collection<Long> postIds) {
        if (postIds.isEmpty()) {
            throw new IllegalStateException("바구니가 비어 있습니다.");
        }

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("회원이 존재하지 않습니다."));

        for (Long postId : postIds) {
            Post post = postRepository.findById(postId)
                    .orElseThrow(() -> new IllegalStateException("삭제된 모집글이 바구니에 있습니다."));

            if (enrollmentRepository.existsByMemberAndPost(member, post)) {
                throw new IllegalStateException("이미 신청한 모집글입니다 : " + post.getTitle());
            }

            if (post.isFull()) { // 담을 때는 자리가 있었지만, 그사이 마감됐을 수 있음
                throw new IllegalStateException("정원이 마감되었습니다 : " + post.getTitle());
            }

            Enrollment enrollment = new Enrollment();
            enrollment.setMember(member);
            enrollment.setPost(post);
            enrollment.setCreatedAt(LocalDateTime.now());

            // ① INSERT 신청 내역
            enrollmentRepository.save(enrollment);

            // ② UPDATE 신청 인원 +1 (남은 자리 -1)
            post.setAppliedCount(post.getAppliedCount() + 1);
            postRepository.save(post);

            post.setAppliedCount(post.getAppliedCount() + 1);
            postRepository.save(post);

            // [12주차] 단계 3 : 남은 자리 이벤트 발행 (커밋되면 RealtimeNotifier 가 전송)
            eventPublisher.publishEvent(SeatMessage.from(post));

            // [12주차] 단계 4 : 모집글 쓴 사람에게 개인 알림 (내 글에 내가 신청하면 생략)
            String writer = post.getAuthor().getUsername();
            if (!writer.equals(username)) {
                eventPublisher.publishEvent(new Notification(
                        writer,
                        member.getName() + "님이 '" + post.getTitle() + "' 에 신청했습니다. ("
                                + post.getAppliedCount() + "/" + post.getCapacity() + ")",
                        post.getId()
                ));
            }


        }

        

        return postIds.size();
    }


    // 연습 ① : 신청 취소 (본인 확인 + 변경 감지로 인원 -1 + 내역 삭제)
    @Transactional
    public void cancel(Long enrollmentId, String username) {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 신청 내역입니다."));

        if (!enrollment.getMember().getUsername().equals(username)) {
            throw new org.springframework.security.access.AccessDeniedException("본인의 신청만 취소할 수 있습니다.");
        }

        Post post = enrollment.getPost();
        post.setAppliedCount(post.getAppliedCount() - 1); // save() 없이 변경 감지로 UPDATE
        enrollmentRepository.delete(enrollment);

        
// [12주차 연습 ①] 취소 후 남은 자리 실시간 갱신 및 글쓴
// 이 알림
        eventPublisher.publishEvent(SeatMessage.from(post));

        String writer = post.getAuthor().getUsername();
        if (!writer.equals(username)) {
            eventPublisher.publishEvent(new Notification(
                    writer,
                    enrollment.getMember().getName() + "님이 '" + post.getTitle() + "' 신청을 취소했습니다.",
                    post.getId()
            ));
        }


    }
    
}