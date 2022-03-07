package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LesBornettes")
public class Bornette {
    @Id
    private int numero;
}