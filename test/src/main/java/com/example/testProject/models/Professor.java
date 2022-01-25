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

public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Float pay;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "prof_id")
    private List<ProfCourse> ppp = new ArrayList<ProfCourse>();

    public Professor(String name, String address, String phone, Float pay) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.pay = pay;
    }

    public Professor(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public List<ProfCourse> getPpp() {
        return ppp;
    }

    public void setPpp(List<ProfCourse> ppp) {
        this.ppp = ppp;
    }

}
