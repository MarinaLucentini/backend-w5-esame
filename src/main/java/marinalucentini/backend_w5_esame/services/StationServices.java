package marinalucentini.backend_w5_esame.services;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.enums.TypeStation;
import marinalucentini.backend_w5_esame.exception.ElementNotFound;
import marinalucentini.backend_w5_esame.repositories.BuildingRepository;
import marinalucentini.backend_w5_esame.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class StationServices {
    @Autowired
    StationRepository stationRepository;
    @Autowired
    BuildingServices buildingServices;
    public void saveStation(Station station, String idBuilding){

            Building building = buildingServices.findBuildingByIdWithStationList(idBuilding);
            station.setBuilding(building);
            building.setName(building.getName());
            building.setCity(building.getCity());
            building.setAddress(building.getAddress());
        List<Station> stationsUpdate = building.getStationList();
 if(stationsUpdate == null){
     stationsUpdate = new ArrayList<>();
 } else {
     stationsUpdate = new ArrayList<>(stationsUpdate);
 }
        stationsUpdate.add(station);
            building.setStationList( stationsUpdate);
            buildingServices.saveBuilding(building);
            stationRepository.save(station);
        System.out.println("La postazione di tipo " + station.getType() + "è stata correttamente salvata nell'edificio: " + building.getName() + "situato in: " + building.getAddress());
    }
    public List<Station> findByTypeAndCity(String typeString, String city){
        TypeStation type;
    type = TypeStation.valueOf(typeString.toUpperCase());
 return    stationRepository.findByTypeAndCity(type, city);
    }
    public List<Station> findByCity(String city){
        return stationRepository.findByCity(city);
    }
}
