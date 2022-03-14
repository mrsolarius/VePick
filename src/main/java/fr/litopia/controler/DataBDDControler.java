package fr.litopia.controler;

import fr.litopia.model.Abonne;
import fr.litopia.model.Bornette;
import fr.litopia.model.Station;
import fr.litopia.model.enums.Etat;
import fr.litopia.model.enums.VStatus;
import fr.litopia.respository.api.*;
import fr.litopia.view.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataBDDControler extends Controler{
    private AbonneRepository abonneRepository;
    private BornetteRepository bornetteRepository;
    private LocationAbonneRepository locationAbonneRepository;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private ModeleRepository modeleRepository;
    private StationRepository stationRepository;
    private VeloRepository veloRepository;

    public DataBDDControler(View view) {
        super(view);
    }


    @Override
    public void init() {
    abonneRepository =daoFactory.newAbonneRepository(entityManager);
    bornetteRepository=daoFactory.newBornetteRepository(entityManager);
    locationAbonneRepository=daoFactory.newLocationAbonneRepository(entityManager);
    locationNonAbonneRepository=daoFactory.newLocationNonAbonneRepository(entityManager);
    modeleRepository=daoFactory.newModeleRepository(entityManager);
    stationRepository=daoFactory.newStationRepository(entityManager);
    veloRepository=daoFactory.newVeloRepository(entityManager);
    }

   public Station allStations(){
    /*------------------------------------------------------------------*/
    //   station victor hugo
    /*------------------------------------------------------------------*/
        Set<Station> stations  = new HashSet<>();
        Station victor_hugo= new Station();

        victor_hugo.setVStatus(VStatus.VMOINS);
        victor_hugo.setAdresse("12 place felix poulat 38000");

    /*----------les bornettes de victor hugo---------------------------*/
        Set<Bornette> bornettes_victor_hugo=new HashSet<>();

        Bornette bornette1_victor_hugo=new Bornette();
        Bornette bornette2_victor_hugo=new Bornette();
        Bornette bornette3_victor_hugo=new Bornette();

        bornette1_victor_hugo.setEtat(Etat.OK);
        bornette2_victor_hugo.setEtat(Etat.HS);
        bornette3_victor_hugo.setEtat(Etat.OK);

        bornettes_victor_hugo.add(bornette1_victor_hugo);
        bornettes_victor_hugo.add(bornette2_victor_hugo);
        bornettes_victor_hugo.add(bornette3_victor_hugo);

        victor_hugo.setBornettes(bornettes_victor_hugo);
        stations.add(victor_hugo);
   /*-----------------------------------------------------------------------------*/
   /*-----------------------------------------------------------------------------*/

       Station  malherbe = new Station();
        malherbe.setAdresse("7 rue des invalide 38000");
        malherbe.setVStatus(VStatus.VNUL);

       Set<Bornette> bornettes_malherbe=new HashSet<>();

       Bornette bornette1_malherbe=new Bornette();
       Bornette bornette2_malherbe=new Bornette();
       Bornette bornette3_malherbe=new Bornette();


       bornette1_malherbe.setEtat(Etat.OK);
       bornette2_malherbe.setEtat(Etat.OK);
       bornette3_malherbe.setEtat(Etat.OK);

       bornettes_malherbe.add(bornette1_malherbe);
       bornettes_malherbe.add(bornette2_malherbe);
       bornettes_malherbe.add(bornette3_malherbe);

       malherbe.setBornettes(bornettes_malherbe);
       stations.add(malherbe);



        Station gare = new Station();
        gare.setVStatus(VStatus.VPLUS);
        gare.setAdresse("19 rue paul janet 38000");

       Set<Bornette> bornettes_gare=new HashSet<>();
       Bornette bornette1_gare=new Bornette();
       Bornette bornette2_gare=new Bornette();
       Bornette bornette3_gare=new Bornette();

       bornette1_gare.setEtat(Etat.OK);
       bornette2_gare.setEtat(Etat.OK);
       bornette3_gare.setEtat(Etat.OK);

       bornettes_gare.add(bornette1_gare);
       bornettes_gare.add(bornette2_gare);
       bornettes_gare.add(bornette3_gare);
       gare.setBornettes(bornettes_gare);

        stations.add(gare);



        return (Station) stations;
   }





    public void initializeData() {
        //@TODO initialize toutes les données de la BDD

        entityManager.getTransaction().begin();

        for(Station stat:lesStations()){
            stationRepository.save(stat);
        }
        entityManager.getTransaction().commit();



    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
    }
}
