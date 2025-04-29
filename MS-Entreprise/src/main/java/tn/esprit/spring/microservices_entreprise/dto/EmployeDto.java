package tn.esprit.spring.microservices_entreprise.dto;

import java.time.LocalDate;

public record EmployeDto(
        String id,
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String poste,
        LocalDate dateEmbauche,
        Long entrepriseId
) {}