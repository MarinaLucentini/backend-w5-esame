package marinalucentini.backend_w5_esame.services;

import marinalucentini.backend_w5_esame.entities.Reservation;
import marinalucentini.backend_w5_esame.entities.Station;
import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.repositories.ReservationRepository;
import marinalucentini.backend_w5_esame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServices {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    public void saveReservation(Reservation reservation, User user, Station station){

    }
}
