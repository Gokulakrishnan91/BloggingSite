package com.demo.blog.serviceuser;

import com.demo.blog.user.User;

public interface UserService {

    User saveUser(User user);

    User findByUserId(Long userId);

    User retrieveUser(User user);
}
