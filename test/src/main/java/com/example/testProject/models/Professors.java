package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Float pay;

    public Professors(String name) {
        this.name=name;
    }

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
