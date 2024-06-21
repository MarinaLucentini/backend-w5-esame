package marinalucentini.backend_w5_esame;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.entities.User;
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
    @Override
    public void run(String... args) throws Exception {
        User user = context.getBean(User.class);
        System.out.println(user);
        Building building = context.getBean(Building.class);
        System.out.println(building);
        buildingServices.saveBuilding(building);
        Station station = context.getBean(Station.class);
        System.out.println(station);


    }
}
