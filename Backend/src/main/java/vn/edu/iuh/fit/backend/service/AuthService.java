/**
 * @ (#) AuthService.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */


import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entity.User;
import vn.edu.iuh.fit.backend.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
