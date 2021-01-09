package com.restapi.service;

import com.restapi.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User save(User user);
    void deleteById(long id);
}
