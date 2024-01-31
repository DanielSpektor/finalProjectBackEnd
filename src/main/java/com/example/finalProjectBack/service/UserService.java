package com.example.finalProjectBack.service;

import com.example.finalProjectBack.model.CustomUser;
import com.example.finalProjectBack.model.CustomUserRequest;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    CustomUser findUserByUsername(String username);
}
