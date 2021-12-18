package com.tasarim.tasarimprojesi.service.impl;


import com.tasarim.tasarimprojesi.dto.UserAdditionRequest;
import com.tasarim.tasarimprojesi.exception.UserNotFoundException;
import com.tasarim.tasarimprojesi.model.Role;
import com.tasarim.tasarimprojesi.model.RoleType;
import com.tasarim.tasarimprojesi.model.User;
import com.tasarim.tasarimprojesi.repository.UserRepository;
import com.tasarim.tasarimprojesi.service.RoleService;
import com.tasarim.tasarimprojesi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public User createNewUser(UserAdditionRequest request) {
        User user = User
                .builder()
                .name(request.getName())
                .surname(request.getSurname())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        Set<String> strRoles = new HashSet<>();
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName(RoleType.ROLE_USER);
        roles.add(role);
        user.setRoles(roles);
        return createNewUser(user);
    }
    @Override
    public User createNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Objects.requireNonNull(username, "username cannot be null");
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Boolean existsByUsername(String username) {
        Objects.requireNonNull(username, "username cannot be null");
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        Objects.requireNonNull(email, "email cannot be null");
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
