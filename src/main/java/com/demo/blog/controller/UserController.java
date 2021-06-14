package com.demo.blog.controller;

import com.demo.blog.serviceuser.UserService;
import com.demo.blog.user.LoginUser;
import com.demo.blog.user.SignUpUser;
import com.demo.blog.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final String USER = "user";
    private static final String USER_ID = "userId";
    private static final String ERROR = "error";
    private static final String MESSAGE = "message";
    private static final String PLEASE_ENTER_YOUR_EMAIL_PASSWORD = "Please Enter Your Email/Password";
    private static final String USER_LOGIN_VIEW = "user/login";
    private static final String INVALID_CREDENTIALS = "Invalid Credentials";
    private static final String USER_SIGNUP_VIEW = "user/signup";
    private static final String REDIRECT_TO_HOMEPAGE = "redirect:/homepage";
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute(USER, new LoginUser());
        model.addAttribute(ERROR, false);
        model.addAttribute(MESSAGE, PLEASE_ENTER_YOUR_EMAIL_PASSWORD);
        return USER_LOGIN_VIEW;
    }

    @PostMapping("/login")
    public String tryLogin(@Valid @ModelAttribute(USER) LoginUser user, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute(ERROR, true);
        model.addAttribute(MESSAGE, INVALID_CREDENTIALS);
        User validUser = userService.retrieveUser(User.builder().email(user.getEmail()).password(user.getPassword()).build());
        if (result.hasErrors() || validUser == null) {
            return USER_LOGIN_VIEW;
        }
        redirectAttributes.addAttribute(USER_ID, validUser.getUserId());
        return REDIRECT_TO_HOMEPAGE;
    }

    @PostMapping("/signup")
    public String userSignUp(@Valid @ModelAttribute(USER) SignUpUser user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return USER_SIGNUP_VIEW;
        }
        userService.saveUser(User.builder().email(user.getEmail()).password(user.getPassword()).userName(user.getUserName()).build());
        model.addAttribute(MESSAGE, PLEASE_ENTER_YOUR_EMAIL_PASSWORD);
        model.addAttribute(ERROR, false);
        return USER_LOGIN_VIEW;
    }

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute(USER, new SignUpUser());
        return USER_SIGNUP_VIEW;
    }
}
