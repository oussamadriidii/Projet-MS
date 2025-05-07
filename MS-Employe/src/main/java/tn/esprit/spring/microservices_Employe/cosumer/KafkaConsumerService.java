package tn.esprit.spring.microservices_Employe.cosumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "entreprise-topic", groupId = "employe-group")
    public void consume(String message) {
        System.out.println("Message reçu de Kafka : " + message);
        // Tu peux ici transformer le message en objet Entreprise et créer un employé
    }
}
