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
    public Station station;

    @Column(name = "numero", nullable = false, updatable = false)
    public Long numero;

    /**
     * Recupere la station de la bornette
     * @return la station de la bornette
     */
    public Station getStation() {
        return this.station;
    }

    /**
     * Permet de definir la station de la bornette
     * @param station la station de la bornette
     */
    public void setStation(Station station) {
        this.station = station;
    }

    /**
     * Fonction permettant d'auto générer le numéro de bornette relativement à la station
     * @param entityManager l'entity manager pour executer la requete
     *                      (pour récupérer le dernier id de la bornettes de la station)
     */
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

    /**
     * Fonction permettant de récupérer le numéro de bornette
     * @return le numéro de bornette
     */
    public Long getNumero() {
        return this.numero;
    }


}