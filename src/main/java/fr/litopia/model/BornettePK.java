package fr.litopia.model;

import fr.litopia.repository.RepositoryFactory;
import fr.litopia.repository.api.BornetteRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

@Embeddable
public class BornettePK implements Serializable {
    private static HashMap<Station,Long> idList = new HashMap<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "station_adresse", nullable = false)
    public Station station;

    @Column(name = "numero", nullable = false, updatable = false)
    public Long numero;

    public Station getStation() {
        return this.station;
    }

    public void setStation(Station station) {
        this.station = station;
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