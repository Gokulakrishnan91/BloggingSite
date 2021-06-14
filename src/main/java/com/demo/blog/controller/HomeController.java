package com.demo.blog.controller;

import com.demo.blog.post.Post;
import com.demo.blog.post.UserPost;
import com.demo.blog.servicePost.PostService;
import com.demo.blog.serviceuser.UserService;
import com.demo.blog.user.LoggedInUser;
import com.demo.blog.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    private static final String USER = "user";
    private static final String USER_ID = "userId";
    private static final String USER_POST = "userPost";
    private static final String USER_POSTS = "userPosts";
    private static final String COMMON_ABOUT_VIEW = "common/about";
    private static final String COMMON_HOMEPAGE_VIEW = "common/homepage";
    private static final String REDIRECT_TO_HOMEPAGE = "redirect:/homepage";

    @GetMapping("/")
    public String redirectHomepage() {
        return REDIRECT_TO_HOMEPAGE;
    }

    @GetMapping("/homepage")
    public String homepage(@ModelAttribute(USER_ID) String userId, Model model) {
        if (!userId.isBlank()) {
            User user = userService.findByUserId(Long.parseLong(userId));
            model.addAttribute(USER, new LoggedInUser(user.getUserId(), user.getUserName(), user.getEmail()));
        } else {
            model.addAttribute(USER, new LoggedInUser());
        }
        model.addAttribute(USER_POST, new UserPost());
        List<UserPost> posts = postService.retrieveAllPosts().stream()
                .map(post -> new UserPost(post.getUserId(), post.getUser().getUserName(), post.getPostMessage()))
                .collect(Collectors.toList());
        model.addAttribute(USER_POSTS, posts);
        return COMMON_HOMEPAGE_VIEW;
    }

    @PostMapping("/homepage")
    public String homepage(@ModelAttribute(USER_POST) @Valid UserPost userPost, RedirectAttributes redirectAttributes) {
        postService.savePost(Post.builder().postMessage(userPost.getMessage()).userId(userPost.getUserId()).postDateAndTime(LocalDateTime.now()).build());
        redirectAttributes.addAttribute(USER_ID, userPost.getUserId());
        return REDIRECT_TO_HOMEPAGE;
    }

    @GetMapping("/about")
    public String aboutPage() {
        return COMMON_ABOUT_VIEW;
    }
}
