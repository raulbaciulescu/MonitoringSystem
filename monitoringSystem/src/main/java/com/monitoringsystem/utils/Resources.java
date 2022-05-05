package com.monitoringsystem.utils;


import com.monitoringsystem.repository.api.UserRepository;
import com.monitoringsystem.repository.impl.UserRepositoryImpl;
import com.monitoringsystem.service.api.UserService;
import com.monitoringsystem.service.impl.UserServiceImpl;

import java.sql.SQLException;

public class Resources {
    private static Resources instance = null;
    private static UserService userService;
    private static UserRepository userRepo;

    private Resources() throws SQLException {
        userRepo = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepo);
    }

    public UserService getUserService() {
        return userService;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public static Resources getInstance() throws SQLException {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
}
