package com.restapi.service.impl;

import com.restapi.exception.PostNotFoundException;
import com.restapi.model.Post;
import com.restapi.repository.PostRepository;
import com.restapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final String POST_WITH_ID_NOT_FOUND = "Post with id '%d' not found";
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(String.format(POST_WITH_ID_NOT_FOUND, id)));
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
