package tn.esprit.spring.microservices_entreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.microservices_entreprise.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
}
