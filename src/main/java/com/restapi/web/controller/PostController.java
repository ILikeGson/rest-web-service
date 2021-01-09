package com.restapi.web.controller;

import com.restapi.model.Post;
import com.restapi.model.User;
import com.restapi.service.PostService;
import com.restapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Void> createPost(@PathVariable("id") long userId, @RequestBody List<Post> posts) {
        User user = userService.findById(userId);
        user.setPosts(posts);
        URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path(String.format("/{%d}/posts", userId))
                                .build()
                                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable("id") long userId) {
        User user = userService.findById(userId);
        return user.getPosts();
    }

    @GetMapping("/{id}/posts/{post_id}")
    public Post retrievePost(@PathVariable("id") long userId, @PathVariable("post_id") long postId) {
        return postService.getById(postId);
    }
}
