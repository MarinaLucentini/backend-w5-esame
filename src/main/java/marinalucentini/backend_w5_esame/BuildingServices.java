package marinalucentini.backend_w5_esame;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
