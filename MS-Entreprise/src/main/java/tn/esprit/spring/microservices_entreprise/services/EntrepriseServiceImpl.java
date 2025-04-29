package tn.esprit.spring.microservices_entreprise.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.microservices_entreprise.client.EmployeFeignClient;
import tn.esprit.spring.microservices_entreprise.dto.EmployeDto;
import tn.esprit.spring.microservices_entreprise.entities.Entreprise;
import tn.esprit.spring.microservices_entreprise.repositories.EntrepriseRepository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository;
    private final EmployeFeignClient employeFeignClient;

    @Override
    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @Override
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @Override
    public Optional<Entreprise> getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id);
    }

    @Override
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);

    }

    @Override
    public Entreprise updateEntreprise(Long id, Entreprise updatedEntreprise) {
        return entrepriseRepository.findById(id).map(entreprise -> {
            entreprise.setNom(updatedEntreprise.getNom());
            entreprise.setAdresse(updatedEntreprise.getAdresse());
            entreprise.setEmail(updatedEntreprise.getEmail());
            entreprise.setTelephone(updatedEntreprise.getTelephone());
            return entrepriseRepository.save(entreprise);
        }).orElse(null);
    }


    @Override
    public List<EmployeDto> getEmployesOfEntreprise(Long entrepriseId) {
        return employeFeignClient.getEmployesByEntreprise(entrepriseId);
    }

    @Override
    public EmployeDto assignEmploye(String employeId, Long entrepriseId) {
        return employeFeignClient.assignEmployeToEntreprise(employeId, entrepriseId);
    }
}
