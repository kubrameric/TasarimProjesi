package com.tasarim.tasarimprojesi.service;


import com.tasarim.tasarimprojesi.dto.UserAdditionRequest;
import com.tasarim.tasarimprojesi.model.User;

import java.util.List;

public interface UserService {
    User createNewUser(UserAdditionRequest request);
    User createNewUser(User user);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<User> findAll();
}
