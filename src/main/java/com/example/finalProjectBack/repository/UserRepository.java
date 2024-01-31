package com.example.finalProjectBack.repository;

import com.example.finalProjectBack.model.CustomUser;

public interface UserRepository {

    void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
}
