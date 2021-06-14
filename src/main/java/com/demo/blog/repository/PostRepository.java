package com.demo.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.blog.post.Post;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findByUserId(String userId);
}
