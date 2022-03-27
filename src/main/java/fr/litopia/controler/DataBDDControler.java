package fr.litopia.controler;

import fr.litopia.controler.impl.ControlerImpl;
import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.model.enums.VStatus;
import fr.litopia.repository.api.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataBDDControler extends ControlerImpl {
    private AbonneRepository abonneRepository;
    private BornetteRepository bornetteRepository;
    private LocationAbonneRepository locationAbonneRepository;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private ModeleRepository modeleRepository;
    private StationRepository stationRepository;
    private VeloRepository veloRepository;

    public DataBDDControler() {
        super();
    }


    @Override
    public void init() {
    abonneRepository =getRepositoryFactory().newAbonneRepository(getEntityManager());
    bornetteRepository=getRepositoryFactory().newBornetteRepository(getEntityManager());
    locationAbonneRepository=getRepositoryFactory().newLocationAbonneRepository(getEntityManager());
    locationNonAbonneRepository=getRepositoryFactory().newLocationNonAbonneRepository(getEntityManager());
    modeleRepository=getRepositoryFactory().newModeleRepository(getEntityManager());
    stationRepository=getRepositoryFactory().newStationRepository(getEntityManager());
    veloRepository=getRepositoryFactory().newVeloRepository(getEntityManager());
    }

    private Set<Bornette> getBornettes(int nb, Station s){
        Set<Bornette> lesBornettes = new HashSet<>();
        for (int i = 0; i < nb; i++) {
            BornettePK bpk = new BornettePK();
            bpk.setStation(s);
            bpk.autoGenerateNumero(getEntityManager());
            Bornette b = new Bornette(bpk);
            System.out.println("Id "+b.getNumero());
            lesBornettes.add(b);
        }
        return lesBornettes;
    }


   public Set<Station> allStations(){
    /*------------------------------------------------------------------*/
    //   station victor hugo
    /*------------------------------------------------------------------*/
        Set<Station> stations  = new HashSet<>();
        Station victor_hugo= new Station("12 place felix poulat 38000",VStatus.VMOINS);

    /*----------les bornettes de victor hugo---------------------------*/
        victor_hugo.setBornettes(this.getBornettes(3, victor_hugo));
        stations.add(victor_hugo);
   /*-----------------------------------------------------------------------------*/
   /*-----------------------------------------------------------------------------*/

       Station  malherbe = new Station("7 rue des invalide 38000",VStatus.VNUL);
       malherbe.setBornettes(this.getBornettes(6, malherbe));
       stations.add(malherbe);



        Station gare = new Station("19 rue paul janet 38000",VStatus.VPLUS);
       gare.setBornettes(this.getBornettes(10,gare));

        stations.add(gare);



        return stations;
   }

    public Set<Modele> allModele() {

        Set<Modele> velo_modeles = new HashSet<>();
        double val_non_null_prix = 5.0;
        String tupeModels[] = {"Velo électrique", "velo tout terrain",
                "Velo de ville", "velo pour enfant", "velo de descente"};

        for (int i = 0; i < tupeModels.length; i++) {
            Modele model = new Modele();

            model.setName(tupeModels[i]);
            model.setPrixHoraire(i * 2 + val_non_null_prix);
            velo_modeles.add(model);
        }

        return velo_modeles;
    }





    public void initializeData() {
        System.out.println("Là");
        //@TODO initialize toutes les données de la BDD

        getEntityManager().getTransaction().begin();
        System.out.println("allStation : "+ allStations().size());
        for(Station stat:allStations()){
            System.out.println("Station : "+stat.getAdresse()+" nb:"+stat.getBornettes().size());
            stationRepository.save(stat);
        }

        for(Modele mod :allModele()){
            modeleRepository.save(mod);
            for(Velo velos :getVelos(12,mod)){
                veloRepository.save(velos);
            }
        }



        getEntityManager().getTransaction().commit();
    }

    public Set<Velo> getVelos(int nb, Modele m) {
        Set<Velo> lesVelos = new HashSet<>();
        for (int i = 0; i < nb; i++) {

            int t = new Random().nextInt(Etat.values().length);
           Date date =new Date(2022,04,17);
            Velo v = new Velo(date,Etat.values()[t],m);

            lesVelos.add(v);
        }
        return lesVelos;
    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
        getEntityManager().getTransaction().begin();
        getEntityManager().createNativeQuery("drop table LesBornettes").executeUpdate();
        getEntityManager().createNativeQuery("drop table LesLocations").executeUpdate();
        getEntityManager().createNativeQuery("drop table LesAbonnes").executeUpdate();
        getEntityManager().createNativeQuery("drop table LesStations").executeUpdate();
        getEntityManager().createNativeQuery("drop table LesVelos").executeUpdate();
        getEntityManager().createNativeQuery("drop table LesModeles").executeUpdate();
        getEntityManager().createNativeQuery("drop table hibernate_sequence").executeUpdate();
        getEntityManager().getTransaction().commit();
    }
}
