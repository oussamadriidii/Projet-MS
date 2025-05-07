package tn.esprit.spring.microservices_entreprise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.microservices_entreprise.dto.EmployeDto;
import tn.esprit.spring.microservices_entreprise.entities.Entreprise;
import tn.esprit.spring.microservices_entreprise.producteur.KafkaProducerService;
import tn.esprit.spring.microservices_entreprise.services.EntrepriseService;

import java.util.List;

@RestController
@RequestMapping("/api/entreprises")
@RequiredArgsConstructor
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @PostMapping
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseService.saveEntreprise(entreprise);
    }

    @GetMapping
    public List<Entreprise> getAllEntreprises() {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/{id}")
    public Entreprise getEntrepriseById(@PathVariable Long id) {
        return entrepriseService.getEntrepriseById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Entreprise updateEntreprise(@PathVariable Long id, @RequestBody Entreprise entreprise) {
        return entrepriseService.updateEntreprise(id, entreprise);
    }

    @DeleteMapping("/{id}")
    public void deleteEntreprise(@PathVariable Long id) {
        entrepriseService.deleteEntreprise(id);
    }


    @GetMapping("/{id}/employes")
    public List<EmployeDto> getEmployesByEntreprise(@PathVariable Long id) {
        return entrepriseService.getEmployesOfEntreprise(id);
    }

    @PutMapping("/{entrepriseId}/assign-employe/{employeId}")
    public EmployeDto assignEmploye(@PathVariable Long entrepriseId, @PathVariable String employeId) {
        return entrepriseService.assignEmploye(employeId, entrepriseId);
    }

    @Autowired
    private KafkaProducerService kafkaProducer;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Entreprise e) throws JsonProcessingException {
        // logique de sauvegarde...
        kafkaProducer.sendEntrepriseCreatedEvent(new ObjectMapper().writeValueAsString(e));
        return ResponseEntity.ok("Entreprise créée et événement publié");
    }

}
