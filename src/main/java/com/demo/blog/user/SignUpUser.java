package com.demo.blog.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpUser {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;
}
