package com.demo.blog.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPost {
    @NotNull
    private Long userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String message;
}
