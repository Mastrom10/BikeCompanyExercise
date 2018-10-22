import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {



    @BeforeEach
    void setUp() {

    }

    @Test
    void getRentalPrice() {

        LocalDateTime from = LocalDateTime.of(2018, 10 , 1, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2018, 10 , 9, 11, 10, 0);
        Bike b = new Bike();

       System.out.println(setTimeMessage(from, to) + " | PRECIO: " + b.getRentalPrice(from, to));


    }

    String setTimeMessage(LocalDateTime from, LocalDateTime to){
        return "Weeks: " + ChronoUnit.WEEKS.between(from, to) + " Days: " +
                ChronoUnit.DAYS.between(from, to.minusWeeks(ChronoUnit.WEEKS.between(from, to))) +
                " Hours: " + ChronoUnit.HOURS.between(from, to.minusDays(ChronoUnit.DAYS.between(from, to.minusWeeks(ChronoUnit.WEEKS.between(from, to))))) +
                " Minutes: " + ChronoUnit.MINUTES.between(from, to.minusHours(ChronoUnit.HOURS.between(from, to.minusDays(ChronoUnit.DAYS.between(from, to.minusWeeks(ChronoUnit.WEEKS.between(from, to)))))));

    }
}