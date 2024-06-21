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
        if (buildingRepository.existsByAddress(building.getAddress()) ){
            throw new RuntimeException("L'edificio con l'indirizzo:  " + building.getAddress()+ " è già in uso!");
        }
        buildingRepository.save(building);
        System.out.println("L'edificio " + building.getName() + " è stato aggiunto con successo nel db");
    }
    public Building findBuildingByIdWithStationList(String id) {
       return    buildingRepository.findByIdWithStations(UUID.fromString(id)).orElseThrow(() -> new ElementNotFound(id));

    }
}
