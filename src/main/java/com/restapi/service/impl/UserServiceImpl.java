package com.restapi.service.impl;

import com.restapi.exception.UserNotFoundException;
import com.restapi.model.User;
import com.restapi.repository.UserRepository;
import com.restapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_WITH_ID_NOT_FOUND = "User with id '%d' not found";
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(String.format(USER_WITH_ID_NOT_FOUND, id)));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(USER_WITH_ID_NOT_FOUND, id)));

        repository.deleteById(id);
    }
}
