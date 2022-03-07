package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LesStations")
public class Station {
    @Id
    private String address;
}