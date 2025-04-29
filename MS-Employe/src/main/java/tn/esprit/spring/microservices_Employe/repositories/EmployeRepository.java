package tn.esprit.spring.microservices_Employe.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.spring.microservices_Employe.entities.Employe;

import java.util.List;

public interface EmployeRepository extends MongoRepository<Employe, String> {
    List<Employe> findByEntrepriseId(Long entrepriseId);
}
