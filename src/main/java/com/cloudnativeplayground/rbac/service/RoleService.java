package com.cloudnativeplayground.rbac.service;

import com.cloudnativeplayground.rbac.entity.Role;
import com.cloudnativeplayground.rbac.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Get all roles from the database.
     *
     * @return List of roles.
     */
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Get a role by its ID.
     *
     * @param id Role ID.
     * @return Optional Role.
     */
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    /**
     * Create or update a role in the database.
     *
     * @param role Role to save.
     * @return Saved Role.
     */
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Delete a role by its ID.
     *
     * @param id Role ID.
     */
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
