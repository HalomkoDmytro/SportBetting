package com.my.training.dao;

import com.my.training.model.user.Admin;
import com.my.training.model.usergroup.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String email);

    List<? extends Admin> findAllByRole(Role role);

}
