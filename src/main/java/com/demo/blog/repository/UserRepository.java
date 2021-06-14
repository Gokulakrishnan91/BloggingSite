package com.demo.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.blog.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmailAndPassword(String email, String password);
}
