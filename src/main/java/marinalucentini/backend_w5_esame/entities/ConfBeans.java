package marinalucentini.backend_w5_esame.entities;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class ConfBeans {
    @Bean
    public Faker getFaker(){
        return new Faker(Locale.ITALY);
    }
    @Bean
    public User getUser(){
        return new User(getFaker().funnyName().name(), getFaker().name().firstName(), getFaker().name().lastName(), getFaker().internet().emailAddress());
    }
    @Bean
    public Building building(){
        return new Building(getFaker().address().firstName(), getFaker().address().streetAddress(),getFaker().address().cityName());
    }
}
