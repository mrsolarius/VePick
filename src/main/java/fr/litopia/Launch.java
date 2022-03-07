package fr.litopia;

import javax.persistence.Persistence;

public class Launch {
    public static void main(String[] args){
        Persistence.createEntityManagerFactory("JPA-HBM").createEntityManager();
    }
}
