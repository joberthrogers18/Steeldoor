package com.steelDoor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user_system")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "type_user", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Job> jobs = new ArrayList<>();

    @ManyToOne
    private Company company;

}
