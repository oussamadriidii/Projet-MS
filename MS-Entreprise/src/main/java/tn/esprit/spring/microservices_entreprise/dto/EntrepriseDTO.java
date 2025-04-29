package tn.esprit.spring.microservices_entreprise.dto;

import java.util.List;

public record EntrepriseDTO(
        Long id,
        String nom,
        String adresse,
        List<String> employeIds
) {}