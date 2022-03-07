package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LesVelos")
public class Velo {
    @Id
    private int numero;
}