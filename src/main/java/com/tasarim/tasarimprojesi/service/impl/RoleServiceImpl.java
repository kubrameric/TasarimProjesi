package com.tasarim.tasarimprojesi.service.impl;

import com.tasarim.tasarimprojesi.exception.RoleNotFoundException;
import com.tasarim.tasarimprojesi.model.Role;
import com.tasarim.tasarimprojesi.model.RoleType;
import com.tasarim.tasarimprojesi.repository.RoleRepository;
import com.tasarim.tasarimprojesi.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role findByName(RoleType name) {
        Objects.requireNonNull(name, "role name cannot be null");
        return roleRepository.findByName(name).orElseThrow(RoleNotFoundException::new);
    }
}
