package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LesModels")
public class Model {
    @Id
    private String name;
}