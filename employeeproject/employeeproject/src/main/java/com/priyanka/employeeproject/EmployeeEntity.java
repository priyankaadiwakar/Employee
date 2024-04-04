package com.priyanka.employeeproject;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employeeemp")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone_number;
    private String gmail_id;
}
