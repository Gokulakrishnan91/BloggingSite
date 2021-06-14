package com.demo.blog.servicePost;

import java.util.List;

import com.demo.blog.post.Post;

public interface PostService {

    Post savePost(Post post);

    List<Post> retrieveAllPostsByUserId(String userId);

    List<Post> retrieveAllPosts();
}
