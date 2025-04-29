package tn.esprit.spring.microservices_Employe.services;

import tn.esprit.spring.microservices_Employe.dto.EmployeDto;
import tn.esprit.spring.microservices_Employe.entities.Employe;

import java.util.List;

public interface EmployeService {
    Employe ajouterEmploye(Employe employe);

    List<Employe> getAllEmployes();

    Employe getEmployeById(String id);

    Employe updateEmploye(String id, Employe employe);

    void deleteEmploye(String id);

    Employe assignEmployeToEntreprise(String employeId, Long entrepriseId);

    List<Employe> getEmployesByEntreprise(Long entrepriseId);

}