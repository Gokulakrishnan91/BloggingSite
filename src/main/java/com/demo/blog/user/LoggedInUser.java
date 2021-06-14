package com.demo.blog.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedInUser {
    @NotEmpty
    private Long userId;
    private String userName;
    private String email;
}
