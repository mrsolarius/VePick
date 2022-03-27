package fr.litopia.controler.impl;

import fr.litopia.controler.api.RetraitControler;
import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.respository.RepositoryFactory;
import fr.litopia.respository.api.BornetteRepository;
import fr.litopia.respository.api.LocationAbonneRepository;
import fr.litopia.respository.api.LocationNonAbonneRepository;

import java.util.Set;


public class RetraitControlerImpl extends ControlerImp implements RetraitControler {

    private BornetteRepository bornetteRepository;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private LocationAbonneRepository locationAbonneRepository;

    @Override
    public void init() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        bornetteRepository = repositoryFactory.newBornetteRepository(getEntityManager());
        locationNonAbonneRepository = repositoryFactory.newLocationNonAbonneRepository(getEntityManager());
        locationAbonneRepository = repositoryFactory.newLocationAbonneRepository(getEntityManager());
    }

    @Override
    public Bornette peutRendre(Station station) {
        Set<Bornette> set;
        set= bornetteRepository.getBornettesStationWithoutBike(station, Etat.OK);
        if(set.isEmpty()){
            return null;
        }
        else{
            return set.iterator().next();
        }
    }

    @Override
    public LocationNonAbonne checkCode(String code) {
        try{
            return locationNonAbonneRepository.getLocNonAbonne(code);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean isUnderFiveMinutes(Location loc) {
        return loc.isUnderFiveMinutes();
    }

    @Override
    public Double clotureLocationNonAbonne(Bornette bornette, LocationNonAbonne loc) {
        System.out.println("Info "+bornette.getNumero()+" : "+bornette.getStation().getAdresse());
        loc.cloreLocation(bornette);
        this.getEntityManager().getTransaction().begin();
        this.bornetteRepository.save(bornette);
        this.getEntityManager().merge(loc);
        this.getEntityManager().getTransaction().commit();
        return loc.getPrix();
    }

    @Override
    public Set<LocationAbonne> getLocationsEnCours(Abonne abonne) {
        return this.locationAbonneRepository.getLocationsEnCours(abonne);
    }

    @Override
    public Double clotureLocationAbonne(Bornette bornette, LocationAbonne loc) {
        System.out.println("Info "+bornette.getNumero()+" : "+bornette.getStation().getAdresse()+" vélo:"+bornette.getVelo());
        loc.cloreLocation(bornette);
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().getTransaction().rollback();
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().merge(loc);
        this.getEntityManager().merge(bornette);
        this.getEntityManager().getTransaction().commit();
        return loc.getPrix();
    }

    @Override
    public void clotureLocationHSUnderFiveMinutesNonAbo(Bornette bornette, Location loc) {
        loc.clotureLocationHSUnderFiveMinutes(bornette);
        this.getEntityManager().getTransaction().begin();
        this.bornetteRepository.save(bornette);
        this.getEntityManager().merge(loc);
        this.getEntityManager().getTransaction().commit();
    }

    public void clotureLocationHSUnderFiveMinutesAbo(Bornette bornette, Location loc) {
        loc.clotureLocationHSUnderFiveMinutes(bornette);
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().getTransaction().rollback();
        this.getEntityManager().getTransaction().begin();
        this.getEntityManager().merge(loc);
        this.getEntityManager().merge(bornette);
        this.getEntityManager().getTransaction().commit();
    }

    @Override
    public void changeBikeState(Location location, Etat state){
        Velo v = location.getVelo();   // On passe l'état du vélo à HS
        v.setEtat(state);
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(v);
        getEntityManager().getTransaction().commit();
    }
}
