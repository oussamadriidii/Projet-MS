package tn.esprit.spring.microservices_Employe.mappers;

import org.mapstruct.Mapper;
import tn.esprit.spring.microservices_Employe.dto.EmployeDto;
import tn.esprit.spring.microservices_Employe.entities.Employe;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeDto toDTO(Employe employe);
    Employe toEntity(EmployeDto dto);
    List<EmployeDto> toDTOs(List<Employe> employes);

}
