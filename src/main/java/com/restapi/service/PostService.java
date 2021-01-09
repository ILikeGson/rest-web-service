package com.restapi.service;

import com.restapi.model.Post;
import java.util.List;

public interface PostService {
    Post savePost(Post post);
    Post getById(long id);
    List<Post> getAll();
}
