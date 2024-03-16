package com.hospital.patient.Hospital.DTO;

import com.hospital.patient.Hospital.Entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class  PatientDTO {
    private String userName;
    private String password;
    private String patientName;
    private int age;
    private String mobileNumber;
    private String patientRemark;

    public Patient toPatient()
    {
       return new Patient(this.userName,this.password,this.patientName,this.age,this.mobileNumber,this.patientRemark);
    }
}
