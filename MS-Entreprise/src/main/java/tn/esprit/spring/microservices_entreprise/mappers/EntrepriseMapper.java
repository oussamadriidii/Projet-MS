package tn.esprit.spring.microservices_entreprise.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.microservices_entreprise.dto.EntrepriseDTO;
import tn.esprit.spring.microservices_entreprise.entities.Entreprise;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    EntrepriseDTO toDTO(Entreprise entreprise);
    Entreprise toEntity(EntrepriseDTO dto);
}
