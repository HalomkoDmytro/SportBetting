package com.epam.training.dao;

import com.epam.training.model.user.Admin;
import com.epam.training.model.usergroup.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);
    List<? extends Admin> findAllByRole(Role role);
}
