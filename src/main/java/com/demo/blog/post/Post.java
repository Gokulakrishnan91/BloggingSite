package com.demo.blog.post;

import lombok.*;

import javax.persistence.*;

import com.demo.blog.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_t")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private Long userId;
    private String postMessage;
    @Column(name = "post_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime postDateAndTime;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
    private User user;
}
