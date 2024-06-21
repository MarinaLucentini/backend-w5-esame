package marinalucentini.backend_w5_esame;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.services.BuildingServices;
import marinalucentini.backend_w5_esame.services.StationServices;
import marinalucentini.backend_w5_esame.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    AnnotationConfigApplicationContext context;
    @Autowired
    private BuildingServices buildingServices;
    @Autowired
    private StationServices stationServices;
    @Autowired
    private UserServices userServices;
    @Override
    public void run(String... args) throws Exception {
        User user = context.getBean(User.class);
        System.out.println(user);
        Building building = context.getBean(Building.class);
        System.out.println(building);
       // buildingServices.saveBuilding(building);
        Station station = context.getBean(Station.class);
        System.out.println(station);
      //  stationServices.saveStation(station, "1a640401-521d-4241-bd10-9f534178baef");
//        Building building1 =
//        buildingServices.findBuildingByIdWithStationList("1a640401-521d-4241-bd10-9f534178baef");
//        building1.getStationList().forEach(el-> System.out.println(el));
     //   userServices.saveUsers(user);
        System.out.println(userServices.findByUsername("Hammond Eggs"));
        System.out.println(userServices.findByNameAndSurname("Isira", "Palmieri"));


    }
}
