package marinalucentini.backend_w5_esame.runner;

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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;


@Order(1)
   // @Component
    public class CreateDb implements CommandLineRunner {
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

            Building building = context.getBean(Building.class);

            Station station = context.getBean(Station.class);




        }
    }

