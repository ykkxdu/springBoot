package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */
@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public User(String user, String pass, List<String> roles, Object roles1) {
        this.username=user;
        this.password=pass;
        this.roles=roles;

    }
}
