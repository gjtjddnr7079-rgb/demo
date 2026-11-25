package com.example.demo.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member author;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private int viewCount = 0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Comment> comments = new ArrayList<>();

    // [11주차] 단계 1 : 모집글 (정원이 있으면 모집글, null 이면 일반 글)
    private Integer capacity; // 정원 (모집 인원)

    @Column(nullable = false) // 신청한 인원 (신청 확정마다 1 증가)
    private int appliedCount = 0;

    private String posterFile; // 포스터 이미지 : uploads/에 저장된 파일 이름 (단계 2)

    public boolean isRecruit() { return capacity != null; } // 모집글인가
    public boolean isFull() { return isRecruit() && appliedCount >= capacity; } // 마감인가
    public int getRemaining() { return isRecruit() ? capacity - appliedCount : 0; } // 남은 자리
}