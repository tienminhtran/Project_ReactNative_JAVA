/**
 * @ (#) User.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entity;
import jakarta.persistence.*;
import lombok.*;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


}