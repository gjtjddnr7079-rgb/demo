package com.example.demo.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.domain.Member;
import com.example.demo.model.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    Page<Post> search(@Param("keyword") String keyword, Pageable pageable);



// [연습문제 2] 작성자 이름으로 검색 (글 -> 작성자 -> 이름)
    @Query("SELECT p FROM Post p WHERE p.author.name LIKE %:name%")
    Page<Post> searchByAuthorName(@Param("name") String name, Pageable pageable);


    // [연습문제 1] 내가 쓴 글 페이징
    Page<Post> findByAuthor_Username(String username, Pageable pageable);


    boolean existsByAuthor(Member author);

    
}