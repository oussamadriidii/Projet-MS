package tn.esprit.spring.microservices_entreprise.client;

import org.springframework.stereotype.Component;
import tn.esprit.spring.microservices_entreprise.dto.EmployeDto;

import java.util.Collections;
import java.util.List;
@Component
public class EmployeFeignClientFallback implements EmployeFeignClient {

    @Override
    public EmployeDto assignEmployeToEntreprise(String id, Long entrepriseId) {
        System.out.println("Fallback : assignEmployeToEntreprise - Service Employe indisponible");
        return null;
    }

    @Override
    public List<EmployeDto> getEmployesByEntreprise(Long entrepriseId) {
        System.out.println("Fallback : getEmployesByEntreprise - Service Employe indisponible");
        return Collections.emptyList();
    }

}
