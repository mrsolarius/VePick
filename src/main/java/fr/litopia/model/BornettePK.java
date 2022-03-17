package fr.litopia.model;

import fr.litopia.respository.RepositoryFactory;
import fr.litopia.respository.api.BornetteRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class BornettePK implements Serializable {
    private static HashMap<Station,Long> idList = new HashMap<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "station_adresse", nullable = false)
    private Station station;

    @Column(name = "numero", nullable = false, updatable = false)
    private Long numero;

    public Station getStation() {
        return this.station;
    }

    public void setStation(Station station) {
        this.station = station;
        if(this.numero == null) {

        }
    }

    public void autoGenerateNumero(EntityManager entityManager) {
        if(idList.containsKey(station)) {
            RepositoryFactory repositoryFactory = new RepositoryFactory();
            BornetteRepository bornetteRepository = repositoryFactory.newBornetteRepository(entityManager);
            long id = bornetteRepository.getLastIdInStation(this.station);
            if (id > idList.get(station)) {
                idList.put(station, id+1);
            }else {
                idList.put(station, idList.get(station)+1);
            }
        }else {
            idList.put(station, 1L);
        }
        this.numero = idList.get(station);
    }

    public Long getNumero() {
        return this.numero;
    }


}