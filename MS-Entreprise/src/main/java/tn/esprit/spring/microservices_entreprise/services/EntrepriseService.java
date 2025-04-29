package tn.esprit.spring.microservices_entreprise.services;

import tn.esprit.spring.microservices_entreprise.dto.EmployeDto;
import tn.esprit.spring.microservices_entreprise.entities.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Entreprise saveEntreprise(Entreprise entreprise);

    List<Entreprise> getAllEntreprises();

    Optional<Entreprise> getEntrepriseById(Long id);

    void deleteEntreprise(Long id);

    Entreprise updateEntreprise(Long id, Entreprise updatedEntreprise);

    List<EmployeDto> getEmployesOfEntreprise(Long entrepriseId);
    EmployeDto assignEmploye(String employeId, Long entrepriseId);
}
