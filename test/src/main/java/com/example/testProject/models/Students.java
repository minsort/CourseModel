package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String numberPhone;
    private String email;
    private Integer recordBook; //номер зачетки
    private Float studentPerformance; //Средняя успеваемость

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "students_id")
    private List<Stud_Course> aaa = new ArrayList<Stud_Course>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "stud_id")
    private List<CourseCompletion> comments=new ArrayList<CourseCompletion>();

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
    public String getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getRecordBook() {
        return recordBook;
    }
    public void setRecordBook(Integer recordBook) {
        this.recordBook = recordBook;
    }
    public Float getStudentPerformance() {
        return studentPerformance;
    }
    public void setStudentPerformance(Float studentPerformance) {
        this.studentPerformance = studentPerformance;
    }
    public List<CourseCompletion> getComments() {
        return comments;
    }
    public void setComments(List<CourseCompletion> comments) {
        this.comments = comments;
    }
}
