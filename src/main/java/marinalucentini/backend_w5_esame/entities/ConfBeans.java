package marinalucentini.backend_w5_esame.entities;

import com.github.javafaker.Faker;
import marinalucentini.backend_w5_esame.enums.TypeStation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.Random;

@Configuration
public class ConfBeans {
    @Bean
    public Faker getFaker(){
        return new Faker(Locale.ITALY);
    }
    @Bean
    public Random getRandom(){
        return new Random();
    }
    @Bean
    public User getUser(){
        return new User(getFaker().funnyName().name(), getFaker().name().firstName(), getFaker().name().lastName(), getFaker().internet().emailAddress());
    }
    @Bean
    public Building building(){
        return new Building(getFaker().address().firstName(), getFaker().address().streetAddress(),getFaker().address().cityName());
    }
    @Bean
    public Station station(){
        TypeStation typeStation = TypeStation.PRIVATE;
        switch (getRandom().nextInt(1,3)){
            case 1:{
                typeStation = TypeStation.OPEN_SPACE;
                break;
            }
            case 2:{
                typeStation= TypeStation.MEETING_ROOM;
                break;
            }
            default: {
                typeStation = TypeStation.PRIVATE;
                break;
            }
        }
        return new Station(getFaker().lorem().paragraph(2), getRandom().nextInt(10,50), typeStation );
    }
}
