package com.autobid.service;

import com.autobid.model.User;

public interface IUserService {

    User getUserById(int userId);
    void insertUser(User user);
}