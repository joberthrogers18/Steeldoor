package com.steelDoor.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Long idCompany;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<User> users = new ArrayList<User>();

}
