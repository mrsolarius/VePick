package fr.litopia.controler;

import fr.litopia.model.Abonne;
import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
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

    private Set<Bornette> getBornettes(int nb, Station s){
        Set<Bornette> lesBornettes = new HashSet<>();
        for (int i = 0; i < nb; i++) {
            Bornette b = new Bornette();
            BornettePK bpk = new BornettePK();
            bpk.setStation(s);
            b.setPk(bpk);
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
        Station victor_hugo= new Station();

        victor_hugo.setVStatus(VStatus.VMOINS);
        victor_hugo.setAdresse("12 place felix poulat 38000");

    /*----------les bornettes de victor hugo---------------------------*/
        victor_hugo.setBornettes(this.getBornettes(3, victor_hugo));
        stations.add(victor_hugo);
   /*-----------------------------------------------------------------------------*/
   /*-----------------------------------------------------------------------------*/

       Station  malherbe = new Station();
        malherbe.setAdresse("7 rue des invalide 38000");
        malherbe.setVStatus(VStatus.VNUL);
       malherbe.setBornettes(this.getBornettes(6, malherbe));
       stations.add(malherbe);



        Station gare = new Station();
        gare.setVStatus(VStatus.VPLUS);
        gare.setAdresse("19 rue paul janet 38000");
       gare.setBornettes(this.getBornettes(10,gare));

        stations.add(gare);



        return stations;
   }





    public void initializeData() {
        System.out.println("Là");
        //@TODO initialize toutes les données de la BDD

        entityManager.getTransaction().begin();
        System.out.println("allStation : "+ allStations().size());
        for(Station stat:allStations()){
            System.out.println("Station : "+stat.getAdresse()+" nb:"+stat.getBornettes().size());
            stationRepository.save(stat);
        }
        entityManager.getTransaction().commit();
    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
    }
}
