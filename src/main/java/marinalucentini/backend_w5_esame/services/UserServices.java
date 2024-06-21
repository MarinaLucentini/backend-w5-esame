package marinalucentini.backend_w5_esame.services;

import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.exception.ElementNotFound;
import marinalucentini.backend_w5_esame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public void saveUsers(User user){
        Optional<User> existingUser = userRepository.findById(user.getId());
        if(existingUser.isPresent()){
            User user1 = existingUser.get();
            if (!user1.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("L'email " + user.getEmail() + " è già in uso");
            }

            if (!user1.getUsername().equals(user.getUsername()) && userRepository.existsByUsername(user.getUsername())) {
                throw new RuntimeException("L'username " + user.getUsername() + " è già in uso");
            }

            userRepository.save(user);
            System.out.println("L'utente" + user.getUsername() + " è stato aggiornato!");
        } else{
            if(userRepository.existsByEmail(user.getEmail())  ){
                throw new RuntimeException("L'email"+ user.getEmail() + "è già in uso");
            }
            if(userRepository.existsByUsername(user.getUsername())){
                throw new RuntimeException("L'username" + user.getUsername()+ "è già in uso");
            }
            userRepository.save(user);
            System.out.println("L'utente "+ user.getUsername() + " è stato salvato con successo!");
        }


    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User findByNameAndSurname(String name, String surname){
        return userRepository.findByNameAndSurname(name, surname);
    }
    public User findById(String id){
        return  userRepository.findByIdWithReservation(UUID.fromString(id)).orElseThrow(()-> new ElementNotFound(id));
    }
}
