package com.hospital.patient.Hospital.Service;

import com.hospital.patient.Hospital.Entity.Patient;
import com.hospital.patient.Hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;

    public boolean save(Patient patient)
    {
        if(repository.findByUserName(patient.getUserName())==null) {
            repository.save(patient);
            return true;
        }


        System.out.println("User Already exist");
        return false;
    }
    public List<Patient> getAllPatients(){
        return repository.findAll();
    }

    public Patient getPatientByID(int id)
    {
        return repository.findById(id).orElse(null);
    }
    public Patient getPatientByName(String name)
    {
        return repository.findByPatientName(name);
    }
    public Patient login(String userName,String password)
    {
       // return repository.findByUserNameAndPassword(userName,password);
        return repository.findByUserNameAndPassword(userName,password);
    }
    public boolean delete(int id)
    {
        if(repository.existsById(id))
        {
            repository.deleteById(id);
            return true;
        }
        else
        {
            System.out.println("Invalid id");
            return false;
        }
    }
    public String update(Patient patient)
    {
        Patient existingPatient=repository.findById(patient.getPatientId()).orElse(null);
        if(existingPatient!=null) {
            existingPatient.setAge(patient.getAge());
            existingPatient.setPatientName(patient.getPatientName());
            existingPatient.setPatientRemark(patient.getPatientRemark());
            existingPatient.setMobileNumber(patient.getMobileNumber());
            repository.save(existingPatient);
            return "Modified Successfully";
        }
        else {
            return "Patient Id doesn't Match";
        }
    }

}

