package com.demo.blog.user;

import lombok.*;

import javax.persistence.*;

import com.demo.blog.post.Post;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user_t")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDateTime lastLogin;
    @OneToMany(mappedBy="user")
    private Set<Post> userPosts;
}
