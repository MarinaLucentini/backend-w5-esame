package marinalucentini.backend_w5_esame.services;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.exception.ElementNotFound;
import marinalucentini.backend_w5_esame.repositories.BuildingRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildingServices {
    @Autowired
    BuildingRepository buildingRepository;
    public void saveBuilding(Building building){
        buildingRepository.save(building);
        System.out.println("L'edificio " + building.getName() + " è stato aggiunto con successo nel db");

    }
    public Building findBuildingByIdWithStationList(String id) {
       return    buildingRepository.findByIdWithStations(UUID.fromString(id)).orElseThrow(() -> new ElementNotFound(id));
    }
    public Building findBuildingByName(String name){
        return buildingRepository.findByName(name);
    }
}
