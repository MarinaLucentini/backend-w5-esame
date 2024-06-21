package marinalucentini.backend_w5_esame.services;

import jakarta.transaction.Transactional;
import marinalucentini.backend_w5_esame.entities.Reservation;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.repositories.ReservationRepository;
import marinalucentini.backend_w5_esame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServices {
    @Autowired
    ReservationRepository reservationRepository;
   @Autowired
   UserServices userServices;
   @Autowired
   StationServices stationServices;
   @Transactional
    public void saveReservation(Reservation reservation, String username,  String typeStation, String city){
        User user = userServices.findByUsername(username);
        List<Station> stationsList = stationServices.findByTypeAndCity(typeStation, city);
        Station station = stationsList.isEmpty() ? null : stationsList.get(0);
        System.out.println("Ci sono: " + stationsList.size() + "postazioni per il tipo" + typeStation + "nella città di: " + city);
        if(station.getReservationList().stream().map(el-> el.getDate()) .anyMatch(date -> date.equals(reservation.getDate()))){
throw new RuntimeException("La postazione per quella data è occupata, non è possibile prenotare");
        }
        List<Reservation> reservationUpdate = user.getReservationList();
        if(reservationUpdate.isEmpty()){
            reservationUpdate = new ArrayList<>();
        } else{
            reservationUpdate = new ArrayList<>(reservationUpdate);
        }
user.setEmail(user.getEmail());
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        reservation.setStation(station);
        reservation.setUtente(user);
        reservationUpdate.add(reservation);
        user.setReservationList(reservationUpdate);
        userServices.saveUsers(user);
        reservationRepository.save(reservation);


    }
}
