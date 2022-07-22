package com.service;

import com.model.User;

import java.util.List;

public interface IUserService {

    void save(User user);

    List<User> findAll();
}
