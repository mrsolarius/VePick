package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LesLocations")
public class Location {
    @Id
    private int id;
}