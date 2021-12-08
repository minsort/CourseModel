package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coursecompletion")
public class CourseCompletion {

    @Id
    private Long id;  //primary key
    private Integer score;   //for List in Students
    private String courseName;   //foreign key on course
    private String studentName;   //foreign key on students



}
