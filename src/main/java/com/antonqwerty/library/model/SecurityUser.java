package com.antonqwerty.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "user")
@Data
@Table(name = "user")
public class SecurityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
}
