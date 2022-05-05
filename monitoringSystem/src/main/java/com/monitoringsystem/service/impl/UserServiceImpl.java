package com.monitoringsystem.service.impl;

import com.monitoringsystem.model.User;
import com.monitoringsystem.repository.api.UserRepository;
import com.monitoringsystem.service.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Random random;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        random = new Random();
    }

    @Override
    public void add(String username, String password, String firstName, String lastName, Integer role) {
        long id = random.nextLong();
        userRepository.add(new User(id, username, password, firstName, lastName, role));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        return userRepository.findUser(new User(username, password));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAll();
    }
}
