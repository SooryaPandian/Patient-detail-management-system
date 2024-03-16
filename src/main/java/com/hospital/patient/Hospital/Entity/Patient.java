package com.hospital.patient.Hospital.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @Column(name = "patient_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patientId;
    @Column(name = "user_name", length = 50)
    private String userName;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "patient_name", length = 50)
    private String patientName;
    @Column(name = "patient_age", length = 10)
    private int age;
    @Column(name = "patient_mobile", length = 50)
    private String mobileNumber;
    @Column(name = "patient_remark", length = 50)
    private String patientRemark;

    public Patient(String patientName,int age,String mobileNumber,String patientRemark)
    {
        this.patientName=patientName;
        this.age=age;
        this.mobileNumber=mobileNumber;
        this.patientRemark=patientRemark;
    }
    public Patient(String userName,String password,String patientName,int age,String mobileNumber,String patientRemark)
    {
        this.userName=userName;
        this.password=password;
        this.patientName=patientName;
        this.age=age;
        this.mobileNumber=mobileNumber;
        this.patientRemark=patientRemark;
    }
    public Patient(String userName,String password)
    {
        this.userName=userName;
        this.password=password;

    }
}
