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
public void haddleAddStationAtBuildig(Scanner scanner, Building buildingfound, boolean exit){
    int typeStation = 0;
    while (typeStation !=4){
        System.out.println("Premi 1 se vuoi aggiungere una postazione di tipo  PRIVATE");
        System.out.println("Premi 2 se vuoi aggiungere una postazione di tipo OPEN SPACE");
        System.out.println("Premi 3 se vuoi aggiungere una postazione di tipo MEETING ROOM");
        System.out.println("Premi 4 per tornare indietro");
        try{
            typeStation = Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e){
            System.err.println("Devi inserire un numero");
        }

        switch (typeStation){
            case 1:{
                type = TypeStation.PRIVATE;
                station.setType(type);
                typeStation = 4;
                break;
            }
            case 2:{
                type = TypeStation.OPEN_SPACE;
                station.setType(type);
                typeStation =4;
                break;
            }
            case 3:{
                type = TypeStation.MEETING_ROOM;
                station.setType(type);
                typeStation = 4;
                break;
            }
            case 4:{
                break;
            }
            default:{
                System.out.println("Selezione non valida");
            }
        }

    }
    System.out.println("Descrivi brevemente la postazione che vuoi aggiungere");
   String description = scanner.nextLine();
   station.setDescription(description);
    System.out.println("Indicami con un valore da 10 a 50 la capienza massima della postazione");
    try {
    int max_Capacity = Integer.parseInt(scanner.nextLine());
        station.setMaxCapacity(max_Capacity);
    } catch (NumberFormatException e){
        System.err.println("Devi inserire un numero");
    }
    stationServices.saveStation(station, building.getId().toString());
exit = true;


}
public void haddleAddBuilding(Scanner scanner, Building building, BuildingServices buildingServices, boolean exit){
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

    while (addBuilding != 2){
        System.out.println("Sei sicuro di voler aggiungere questo edificio?");
        System.out.println("Premi 1 per confermare");
        System.out.println("Premi 2 per tornare indietro");

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
                } catch (NumberFormatException e){
                    System.err.println("Devi inserire un numero");
                }
                switch (addStation){
                    case 1:{
                       haddleAddStationAtBuildig(scanner, buildingfound, exit);
                       exit = true;
                        break;
                    }
                    case 2:{
                        exit =true;
                        addBuilding = 3;
                        break;
                    }
                    default:{
                        System.out.println("Numero inserito non valido");
                        break;
                    }
                }

                break;
            }
            case 2:{
                exit= true;
                break;
            }
            default:{
                System.out.println("Valore inserito non valido");
                break;
            }
        }
    }



}
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuti nella nostra applicazione per la gestione delle prenotazioni");
        int sceltaIniziale= 0;
        while (sceltaIniziale != 4){
            System.out.println("Premi 1 se sei l'amministratore e vuoi creare una nuova postazione");
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

                    switch (password){
                        case "epicode":{
                            int selectionAdmin = 0;
                            while (selectionAdmin != 3){
                                System.out.println("Benvenuto!");
                                System.out.println("Premi 1 per aggiungere al database un edificio");
                                System.out.println("Premi 2 per aggiungere al database una nuova postazione");
                                System.out.println("Premi 3 per tornare indietro");
                                try{
                                    selectionAdmin = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException err){
                                    System.err.println("Devi inserire un numero");
                                }
                                boolean exit = false;
                                while (!exit){
                                    switch (selectionAdmin){
                                        case 1:{
                                   haddleAddBuilding(scanner, building, buildingServices, exit);
                                            //**** AGGIUNGERE EDIFICIO
                                            exit = true;
                                            break;
                                        }
                                        case  2:{
                                            // ***** AGGIUNGERE POSTAZIONE
                                            break;
                                        }
                                        case  3:{

                                            exit = true;
                                            break;
                                        }
                                        default:{
                                            System.out.println("Devi selezionare un numero valido");
                                            break;
                                        }
                                    }
                                }

                            }

                            break;

                        }
                        default: {
                            System.out.println("password non valida");
                            break;
                        }
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
