package com.thegym.eventtickets;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,updatable = false)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false,updatable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @CreatedDate
    @Column(name ="created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",nullable = false,updatable = true)
    private LocalDateTime updatedAt;
}
