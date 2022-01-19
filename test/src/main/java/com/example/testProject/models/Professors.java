package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professors")

public class Professors {
    @Id
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Float pay;

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "prof_id")
    private List<Prof_Course> ppp = new ArrayList<Prof_Course>();
}
