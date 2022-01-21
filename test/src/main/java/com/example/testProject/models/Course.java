package com.example.testProject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
        @Id
        private Long id;
        private String name;
        private int number;
        private float cost;

        @OneToMany (cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        private List<Stud_Course> ccc = new ArrayList<Stud_Course>();

        @OneToMany (cascade = CascadeType.ALL)
        @JoinColumn(name = "course_id")
        private List<Prof_Course> ppp = new ArrayList<Prof_Course>();

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
        public int getNumber() {
                return number;
        }
        public void setNumber(int number) {
                this.number = number;
        }
        public float getCost() {
                return cost;
        }
        public void setCost(float cost) {
                this.cost = cost;
        }
        public Course() {}
        public Course(Long id, String name, int number, float cost, List<Students> iStudent) {
                this.id = id;
                this.name = name;
                this.number = number;
                this.cost = cost;
        }
}
