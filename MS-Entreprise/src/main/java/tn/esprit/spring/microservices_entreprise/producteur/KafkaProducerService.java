package tn.esprit.spring.microservices_entreprise.producteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "entreprise-topic";

    public void sendEntrepriseCreatedEvent(String entrepriseJson) {
        kafkaTemplate.send(TOPIC, entrepriseJson);
    }
}
