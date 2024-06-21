package marinalucentini.backend_w5_esame.services;

import marinalucentini.backend_w5_esame.entities.User;
import marinalucentini.backend_w5_esame.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;
    public void saveUsers(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("L'email"+ user.getEmail() + "è già in uso");
        }
        userRepository.save(user);
        System.out.println("L'utente"+ user.getUsername() + " è stato salvato con successo!");

    }
}
