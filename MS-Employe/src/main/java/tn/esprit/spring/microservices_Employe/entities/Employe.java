package tn.esprit.spring.microservices_Employe.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.time.LocalDate;

@Document(collection = "employes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employe implements Serializable {

    @Id
    @Indexed
    @Setter(AccessLevel.MODULE)
    String id;

    String nom;
    String prenom;
    LocalDate dateNaissance;
    String poste;
    LocalDate dateEmbauche;

    private Long entrepriseId; // Pour référencer l'entreprise (du microservice entreprise)
}
