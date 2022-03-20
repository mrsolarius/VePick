package fr.litopia.controler;

import fr.litopia.controler.impl.ControlerImp;
import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.model.Station;
import fr.litopia.model.enums.VStatus;
import fr.litopia.respository.api.*;
import fr.litopia.view.impl.ViewImpl;

import java.util.HashSet;
import java.util.Set;

public class DataBDDControler extends ControlerImp {
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
            Bornette b = new Bornette();
            BornettePK bpk = new BornettePK();
            bpk.setStation(s);
            bpk.autoGenerateNumero(getEntityManager());
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

        getEntityManager().getTransaction().begin();
        System.out.println("allStation : "+ allStations().size());
        for(Station stat:allStations()){
            System.out.println("Station : "+stat.getAdresse()+" nb:"+stat.getBornettes().size());
            stationRepository.save(stat);
        }
        getEntityManager().getTransaction().commit();
    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
    }
}
