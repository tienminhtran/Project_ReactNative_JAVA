/**
 * @ (#) UserRepository.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.entity.User;

import java.util.Optional;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);
}