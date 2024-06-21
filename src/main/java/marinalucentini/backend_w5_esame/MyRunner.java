package marinalucentini.backend_w5_esame;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.Reservation;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.services.BuildingServices;
import marinalucentini.backend_w5_esame.services.ReservationServices;
import marinalucentini.backend_w5_esame.services.StationServices;
import marinalucentini.backend_w5_esame.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

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
    @Autowired
    private ReservationServices reservationServices;
    @Override
    public void run(String... args) throws Exception {
        User user = context.getBean(User.class);
        System.out.println(user);
        Building building = context.getBean(Building.class);
        System.out.println(building);
      //  buildingServices.saveBuilding(building);
        Station station = context.getBean(Station.class);
       // System.out.println(station);
       // stationServices.saveStation(station, "19ab0c03-4e9f-4d1b-b0dd-17787a9773d1");
//        Building building1 =
//        buildingServices.findBuildingByIdWithStationList("1a640401-521d-4241-bd10-9f534178baef");
//        building1.getStationList().forEach(el-> System.out.println(el));
   //    userServices.saveUsers(user);
//        System.out.println(userServices.findByUsername("Hammond Eggs"));
//        System.out.println(userServices.findByNameAndSurname("Isira", "Palmieri"));
    stationServices.findByTypeAndCity("OPEN_SPACE", "San Ulrico").forEach(el-> System.out.println(el));
        Reservation reservation = new Reservation(LocalDate.now(), LocalTime.now());
      //  reservationServices.saveReservation(reservation, "Phil DeGrave", "OPEN_SPACE", "San Ulrico");
        userServices.findById("795950f4-1c8d-417f-bf29-52f8dd873ca4").getReservationList().forEach(el-> System.out.println(el));


    }
}
