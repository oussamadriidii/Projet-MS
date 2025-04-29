package tn.esprit.spring.microservices_Employe.entities;

public class EmployeNotFoundException extends RuntimeException{
    public EmployeNotFoundException(String id){
        super("Employé avec l'id " + id + " non trouvé.");
    }
}
