package com.monitoringsystem.controller;

import com.monitoringsystem.model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class LoggedUser extends User {
    private LocalTime loginDate;

    public LoggedUser(Long id, String username,
                String password, String firstName, String lastName, Integer role, LocalTime loginDate) {
        super(id, username, password, firstName, lastName, role);
        this.loginDate = loginDate;
    }

    public LoggedUser(User user, LocalTime loginDate) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getFirstName(),
                user.getLastName(), user.getRole());
        this.loginDate = loginDate;
    }


    public LocalTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalTime loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "LoggedUser{" + super.toString() + " " +
                "loginDate=" + loginDate +
                '}';
    }
}
