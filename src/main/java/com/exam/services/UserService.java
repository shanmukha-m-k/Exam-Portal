package com.exam.services;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.Set;

public interface UserService {

    //create user
    public User createUser(User user , Set<UserRole> userRole) throws Exception;
}
