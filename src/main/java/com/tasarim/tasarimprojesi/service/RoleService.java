package com.tasarim.tasarimprojesi.service;

import com.tasarim.tasarimprojesi.model.Role;
import com.tasarim.tasarimprojesi.model.RoleType;

public interface RoleService {
    Role findByName(RoleType name);
}
