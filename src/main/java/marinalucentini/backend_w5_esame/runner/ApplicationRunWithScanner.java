package marinalucentini.backend_w5_esame.runner;

import marinalucentini.backend_w5_esame.entities.Building;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.enums.TypeStation;
import marinalucentini.backend_w5_esame.services.BuildingServices;
import marinalucentini.backend_w5_esame.services.StationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Order(2)
@Component
public class ApplicationRunWithScanner implements CommandLineRunner {
@Autowired
AnnotationConfigApplicationContext context;
//Scanner scanner = context.getBean(Scanner.class);
private Building building = new Building();
private Station station = new Station();
private TypeStation type = TypeStation.PRIVATE;
@Autowired
    BuildingServices buildingServices;
@Autowired
    StationServices stationServices;
public void haddleAddStationAtBuildig(Scanner scanner, Building buildingfound){
    int typeStation = 0;
    boolean exitStation = false;

    while (!exitStation){
        System.out.println("Premi 1 se vuoi aggiungere una postazione di tipo  PRIVATE");
        System.out.println("Premi 2 se vuoi aggiungere una postazione di tipo OPEN SPACE");
        System.out.println("Premi 3 se vuoi aggiungere una postazione di tipo MEETING ROOM");
        System.out.println("Premi 4 per tornare indietro");
        try{
            typeStation = Integer.parseInt(scanner.nextLine());
            switch (typeStation){
                case 1:{
                    type = TypeStation.PRIVATE;
                    station.setType(type);
exitStation= true;
                    break;
                }
                case 2:{
                    type = TypeStation.OPEN_SPACE;
                    station.setType(type);
exitStation=true;
                    break;
                }
                case 3:{
                    type = TypeStation.MEETING_ROOM;
                    station.setType(type);
exitStation=true;
                    break;
                }
                case 4:{
                    return;
                }
                default:{
                    System.out.println("Selezione non valida");
                }
            }

        } catch (NumberFormatException e){
            System.err.println("Devi inserire un numero");
        }



    }
    System.out.println("Descrivi brevemente la postazione che vuoi aggiungere");
   String description = scanner.nextLine();
   station.setDescription(description);
   int maxCapacity = 0;
   boolean validCapacity = false;
   while (!validCapacity){
       System.out.println("Indicami con un valore da 10 a 50 la capienza massima della postazione");
       try {
           maxCapacity = Integer.parseInt(scanner.nextLine());
       if(maxCapacity >10 && maxCapacity< 50){
           station.setMaxCapacity(maxCapacity);
           validCapacity = true;
       } else {
           System.out.println("Devi inserire un valore tra 10 e 50");
       }
       } catch (NumberFormatException e){
           System.err.println("Devi inserire un numero");
       }
   }

    stationServices.saveStation(station, buildingfound.getId().toString());

}
public void haddleAddBuilding(Scanner scanner, Building building, BuildingServices buildingServices){
    System.out.println("Scrivi il nome dell'edificifio che vuoi aggiungere al database");
    String nameBuilding = scanner.nextLine();
    System.out.println("Scrivi l'indirizzo dell'edificio, ex: Via Roma, 45");
    String addressBuilding = scanner.nextLine();
    System.out.println("Scrivi la città della città");
    String cityBuilding= scanner.nextLine();
    building.setName(nameBuilding);
    building.setAddress(addressBuilding);
    building.setCity(cityBuilding);
    int addBuilding = 0;
boolean exitBuilding = false;
    while (!exitBuilding){
        System.out.println("Sei sicuro di voler aggiungere questo edificio?");
        System.out.println("Premi 1 per confermare");
        System.out.println("Premi 2 per tornare indietro");
        try{

        addBuilding = Integer.parseInt(scanner.nextLine());
            switch (addBuilding){
                case 1:{
                    buildingServices.saveBuilding(building);
                    Building buildingfound = buildingServices.findBuildingByName(building.getName());
                    System.out.println("Vuoi aggiungere all'edificio " + buildingfound.getName() + "con id " + buildingfound.getId() + " una postazione?");
                    System.out.println("Premi 1 per aggiungere una postazione");
                    System.out.println("Premi 2 per tornare indietro");
                    int addStation = 0;
                    try{
                        addStation = Integer.parseInt(scanner.nextLine());
                        if(addStation == 1){
                            haddleAddStationAtBuildig(scanner, buildingfound);
                        }
                    } catch (NumberFormatException e){
                        System.err.println("Devi inserire un numero");
                    }
                    exitBuilding = true;


                    break;
                }
                case 2:{
                    exitBuilding = true;

                    break;
                }
                default:{
                    System.out.println("Valore inserito non valido");
                    break;
                }
            }
        } catch (NumberFormatException e){
            System.err.println("Devi inserire un numero");
        }

    }



}
public void haddleAddStationAtABuilngFond(Scanner scanner, BuildingServices buildingServices){

   List<Building>  allBuildingFound = buildingServices.findAllBuilding();
    System.out.println("Gli edifici disponibili nel database sono " + allBuildingFound.size());
    System.out.println("Ecco la lista completa");
    for (int i = 0; i < allBuildingFound.size(); i++) {
        Building el = allBuildingFound.get(i);
        System.out.println("Numero: " + (i +1) + " " +
                "Nome:" + el.getName());
    }
    int buildingIndex = -1;
while (true){
    System.out.println("Inidicami il numero dell'edificio al quale vuoi inserire la postazione");
    try {
        buildingIndex = Integer.parseInt(scanner.nextLine()) - 1;
        if (buildingIndex >= 0 && buildingIndex < allBuildingFound.size()) {
            Building selectedBuilding = allBuildingFound.get(buildingIndex);
            System.out.println("L'edificio che hai selezionato è: " + selectedBuilding.getName() + " con id: " + selectedBuilding.getId());
            System.out.println("Sei sicuro di voler aggiungere la postazione a questo edificio?");
            System.out.println("Premi 1 per continuare");
            System.out.println("Premi 2 per tornare indietro");

            int confirmation = Integer.parseInt(scanner.nextLine());
            if (confirmation == 1) {
                haddleAddStationAtBuildig(scanner, selectedBuilding);
                break;
            } else if (confirmation == 2) {
                break;
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        } else {
            System.err.println("Numero non valido, riprova.");
        }
    } catch (NumberFormatException e) {
        System.err.println("Devi inserire un numero");
    }
}


}
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nella nostra applicazione per la gestione delle prenotazioni");
        int sceltaIniziale= 0;
        while (sceltaIniziale != 4){
            System.out.println("Premi 1 se sei l'amministratore e vuoi creare una nuova postazione o un nuovo edificio");
            System.out.println("Premi 2 se sei un nuovo utente e vuoi registrarti");
            System.out.println("Premi 3 se sei un utente già registrato e vuoi prenotare una postazione");
            System.out.println("Premi 4 per uscire");
            try{
            sceltaIniziale = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException err){
                System.err.println("Devi inserire un numero");
            }
            switch (sceltaIniziale){
                case 1:{
                    // ****** ADMIN ******
                    System.out.println("Immetti la password per favore");
                    String password = scanner.nextLine();
                    if("epicode".equals(password)){
                        boolean exitAdmin = false;
                        while (!exitAdmin){
                            System.out.println("Benvenuto!");
                            System.out.println("Premi 1 per aggiungere al database un edificio");
                            System.out.println("Premi 2 per aggiungere al database una nuova postazione");
                            System.out.println("Premi 3 per tornare indietro");
                            try{
                                int selectionAdim = Integer.parseInt(scanner.nextLine());
                                switch (selectionAdim){
                                    case 1:
                                        haddleAddBuilding(scanner, building, buildingServices);

                                        break;
                                    case 2:
haddleAddStationAtABuilngFond(scanner,buildingServices);
                                        // ***** AGGIUNGERE POSTAZIONE *****
                                        break;
                                    case 3:
                                        exitAdmin = true;
                                        break;
                                    default:
                                        System.out.println("Devi selezionare un numero valido");
                                }
                            } catch (NumberFormatException e){
                                System.err.println("Devi inserire un numero");
                            }
                        }
                    }
                    else {
                        System.out.println("password non valida");
                    }
                    break;
                }
                case 2:{
                    // **** NUOVO UTENTE
                    break;
                }
                case 3:{
                    // **** UTENTE REGISTRATO
                    break;
                }
                case 4:{
                    System.out.println("Grazie per averci scelto arrivederci!");
                    // *** USCITA DALL'APPLICAZIONE
                    break;
                }
                default:{
                    System.out.println("Scelta non valida");
                    break;
                }
            }
        }
        scanner.close();
    }
}
