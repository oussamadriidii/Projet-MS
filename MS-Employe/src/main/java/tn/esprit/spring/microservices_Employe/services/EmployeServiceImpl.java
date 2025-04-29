package tn.esprit.spring.microservices_Employe.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.microservices_Employe.dto.EmployeDto;
import tn.esprit.spring.microservices_Employe.entities.Employe;
import tn.esprit.spring.microservices_Employe.entities.EmployeNotFoundException;
import tn.esprit.spring.microservices_Employe.mappers.EmployeMapper;
import tn.esprit.spring.microservices_Employe.repositories.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getEmployeById(String id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe non trouvé"));
    }

    @Override
    public Employe updateEmploye(String id, Employe employe) {
        Employe existing = getEmployeById(id);
        existing.setNom(employe.getNom());
        existing.setPrenom(employe.getPrenom());
        existing.setDateNaissance(employe.getDateNaissance());
        existing.setPoste(employe.getPoste());
        existing.setDateEmbauche(employe.getDateEmbauche());
        return employeRepository.save(existing);
    }

    @Override
    public void deleteEmploye(String id) {
        employeRepository.deleteById(id);

    }


    @Override
    public Employe assignEmployeToEntreprise(String employeId, Long entrepriseId) {
        Employe employe = getEmployeById(employeId);
        employe.setEntrepriseId(entrepriseId);
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getEmployesByEntreprise(Long entrepriseId) {
        return employeRepository.findByEntrepriseId(entrepriseId);
    }
}
