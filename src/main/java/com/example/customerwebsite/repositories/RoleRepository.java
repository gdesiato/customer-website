package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    boolean existsByName(String roleName);
    Role findRoleByName(String roleName);
}
