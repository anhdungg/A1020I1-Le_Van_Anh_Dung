package vn.codegym.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Role;
import vn.codegym.model.User;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByUsers(User user);
}
