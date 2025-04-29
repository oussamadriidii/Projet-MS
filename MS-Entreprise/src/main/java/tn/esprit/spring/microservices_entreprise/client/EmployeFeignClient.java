package tn.esprit.spring.microservices_entreprise.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.microservices_entreprise.dto.EmployeDto;

import java.util.List;

@FeignClient(name = "ms-employe", url = "http://localhost:8082" , fallback = EmployeFeignClientFallback.class)
public interface EmployeFeignClient {

    @PutMapping("/api/employes/{id}/assignEntreprise/{entrepriseId}")
    EmployeDto assignEmployeToEntreprise(@PathVariable String id, @PathVariable Long entrepriseId);

    @GetMapping("/api/employes/by-entreprise/{entrepriseId}")
    List<EmployeDto> getEmployesByEntreprise(@PathVariable Long entrepriseId);
}