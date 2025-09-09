/**
 * @ (#) AuthController.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.entity.User;
import vn.edu.iuh.fit.backend.service.AuthService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        Optional<User> user = authService.login(username, password);

        Map<String, Object> res = new HashMap<>();
        if (user.isPresent()) {
            res.put("success", true);
            res.put("message", "Đăng nhập thành công");
            res.put("user", user.get());
        } else {
            res.put("success", false);
            res.put("message", "Sai nè tài khoản hoặc mật khẩu");
        }

        return res;
    }
}