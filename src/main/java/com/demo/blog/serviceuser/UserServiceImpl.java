package com.demo.blog.serviceuser;

import com.demo.blog.repository.UserRepository;
import com.demo.blog.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElse(User.builder().build());
    }

    @Override
    public User retrieveUser(User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }
}
