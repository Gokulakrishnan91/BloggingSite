package com.demo.blog.servicePost;

import com.demo.blog.post.Post;
import com.demo.blog.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> retrieveAllPostsByUserId(String userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public List<Post> retrieveAllPosts() {
        Pageable sortedByName =
                PageRequest.of(0, 8, Sort.by("postDateAndTime").descending());
        return postRepository.findAll(sortedByName).getContent();
    }


}
