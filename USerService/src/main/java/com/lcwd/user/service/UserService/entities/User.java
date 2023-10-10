package com.lcwd.user.service.UserService.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    private String userId;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="about")
    private String about;
}
