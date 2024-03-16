package com.hospital.patient.Hospital.Controller;

//import ch.qos.logback.core.model.Model;
import com.hospital.patient.Hospital.DTO.PatientDTO;
import com.hospital.patient.Hospital.Entity.Patient;
import com.hospital.patient.Hospital.Service.PatientService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class PatientController {
@Autowired
    private PatientService service;


    @ModelAttribute("patient")
    public Patient create()
    {
        return new Patient();
    }


    @GetMapping({"/", "/index"})
    public String indexPage(Model model) {
        // Add any model attributes if needed
        return "index"; // Return the name of your Thymeleaf template (e.g., index.html)
    }
    @GetMapping("/register")
    public String showRegister(Model model)
    {
        return "register";
    }
    @PostMapping("/modify")
    public String showModify(@ModelAttribute Patient patient,Model model)
    {
        Patient exist=service.getPatientByID(patient.getPatientId());
        System.out.println(exist+" Got it");
        model.addAttribute("patient",exist);
        return "modify";
    }
//    @GetMapping("/admin")
//    public List<Patient> admin()
//    {
//        return
//    }


    @GetMapping("/home")
    public String showHome(Model model)
    {
        return "home";
    }
    @GetMapping("/delete")
    public String delete(Model model)
    {
        return "delete";
    }



    @PostMapping("/add")
    public String addPatient(@ModelAttribute PatientDTO dto)
    {

        if(service.save(dto.toPatient()))
            return "redirect:/index?success";
        else
         return "redirect:/register?error";
    }

    @PostMapping(path="/signin")
    public String login(@ModelAttribute Patient patient,Model model)
    {
        Patient existingPatient=service.login(patient.getUserName(),patient.getPassword());
        System.out.println(existingPatient);

        if(existingPatient==null)
        {

            System.out.println("Not Found user not valid");
            return "redirect:/index?error";
        }
        else{
                if(existingPatient.getUserName().equals("sooryapandian37@gmail.com"))
                {
                    model.addAttribute("patients",service.getAllPatients());
                    return "admin";
                }
                model.addAttribute("patient",existingPatient);
                System.out.println("Found user valid");


            return "home";
        }
    }
    @PostMapping(path="/modifyUser")
    public String modify(@ModelAttribute Patient patient)
    {

        service.update(patient);
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String deletePatient(@ModelAttribute("patient") Patient patient) {
        // Implement your delete logic here using the provided patient ID
        // Return appropriate view or redirect
        int id=patient.getPatientId();
        System.out.println(patient);
        System.out.println(id);
        boolean deleteUser = service.delete(id);
        if (deleteUser) {
            return "redirect:/index";
        } else {
            return "redirect:/index";
        }
    }
//    @PostMapping("/admin")
//    public List<Patient>
//    @PostMapping("/add")
//    public String addPatient(@RequestBody PatientDTO dto)
//    {
//        return service.save(dto.toPatient());
//    }

//    @GetMapping("/login/user_name/{name}")
//    public Patient getPatient(@PathVariable(value="name")String name)
//    {
//        return service.getPatientByName(name);
//    }

//    @GetMapping("/login/{id}")
//    public Patient getPatient(@PathVariable(value="id")int id)
//    {
//        return service.getPatientByID(id);
//    }
}
