package com.hospital.patient.Hospital.Repository;

import com.hospital.patient.Hospital.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository  extends JpaRepository<Patient,Integer> {
    Patient findByPatientName(String name);
    Patient findByUserName(String name);
    Patient findByUserNameAndPassword(String userName,String Password);
}
