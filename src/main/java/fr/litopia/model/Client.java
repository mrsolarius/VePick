package fr.litopia.model;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "LesClients")
public class Client {
    @Id
    @Column(nullable = false, length = 16)
    private String numCB;

    public String getNumCB() {
        return numCB;
    }
}