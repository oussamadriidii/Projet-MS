package tn.esprit.spring.microservices_Employe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.microservices_Employe.dto.EmployeDto;
import tn.esprit.spring.microservices_Employe.entities.Employe;
import tn.esprit.spring.microservices_Employe.mappers.EmployeMapper;
import tn.esprit.spring.microservices_Employe.services.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {
private final EmployeService employeService;
    private final EmployeMapper employeMapper;

    @PostMapping
    public ResponseEntity<Employe> ajouter(@RequestBody Employe employe) {
        return new ResponseEntity<>(employeService.ajouterEmploye(employe), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.getAllEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable String id) {
        return ResponseEntity.ok(employeService.getEmployeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable String id, @RequestBody Employe employe) {
        return ResponseEntity.ok(employeService.updateEmploye(id, employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Affecter un employé à une entreprise
    @PutMapping("/{id}/assignEntreprise/{entrepriseId}")
    public EmployeDto assignEmployeToEntreprise(@PathVariable String id, @PathVariable Long entrepriseId) {
        return employeMapper.toDTO(employeService.assignEmployeToEntreprise(id, entrepriseId));
    }

    // ✅ Récupérer les employés d’une entreprise
    @GetMapping("/by-entreprise/{entrepriseId}")
    public List<EmployeDto> getEmployesByEntreprise(@PathVariable Long entrepriseId) {
        return employeMapper.toDTOs(employeService.getEmployesByEntreprise(entrepriseId));
    }
}
