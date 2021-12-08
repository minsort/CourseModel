package com.example.testProject.report;

import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable {

     //ФИО профессора

    private String nameProfessors;


    //Сумарное колличество всех студентов

    private Integer allStudents;


    //Средняя успеваемость студентов

    private Float studentPerformance;

}