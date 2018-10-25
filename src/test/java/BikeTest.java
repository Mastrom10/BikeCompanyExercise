import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class BikeTest {
    private Bike b;

    @BeforeEach
    void setUp() {
        b = new Bike();
    }

    @AfterEach
    void tearDown() {
        b = null;
    }

    @Test
    void getSellPrice() {
        assertThrows(NotImplementedException.class,  b::getSellPrice );
    }

    @Test
    void getRentalPrice() {

        LocalDateTime from = LocalDateTime.of(2018, 10 , 1, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2018, 10 , 1, 10, 0, 0);

        assertEquals(0f, b.getRentalPrice(from, to),"Costo 0, misma fecha" );
        System.out.println("\n" + setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 1, 11, 0, 0);
        assertEquals(5f, b.getRentalPrice(from, to),"Costo 1 hora" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 1, 11, 30, 0);
        assertEquals(10f, b.getRentalPrice(from, to),"Costo 1 hora y media" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 1, 14, 0, 0);
        assertEquals(20f, b.getRentalPrice(from, to),"Costo 4 hs" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 9, 0, 0);
        assertEquals(20f, b.getRentalPrice(from, to),"Costo 23 hs (1 dia)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 10, 0, 0);
        assertEquals(20f, b.getRentalPrice(from, to),"Costo 24 hs (1 dia)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 10, 30, 0);
        assertEquals(25f, b.getRentalPrice(from, to),"Costo 1 dia y 30 minutos" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 11, 00, 0);
        assertEquals(25f, b.getRentalPrice(from, to),"Costo 1 dia y 1 hora" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 11, 30, 0);
        assertEquals(30f, b.getRentalPrice(from, to),"Costo 1 dia, 1 hora y 30 minutos" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 14, 0, 0);
        assertEquals(40f, b.getRentalPrice(from, to),"Costo 1 dia, 4 horas (breakPoint)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 2, 15, 0, 0);
        assertEquals(40f, b.getRentalPrice(from, to),"Costo 1 dia, 5hs (2 days)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 3, 9, 0, 0);
        assertEquals(40f, b.getRentalPrice(from, to),"Costo 1 dias, 23hs (2 days)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 3, 10, 0, 0);
        assertEquals(40f, b.getRentalPrice(from, to),"Costo 2 dias" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 3, 11, 0, 0);
        assertEquals(45f, b.getRentalPrice(from, to),"Costo 2 dias, 1hs" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 3, 11, 30, 0);
        assertEquals(50f, b.getRentalPrice(from, to),"Costo 2 dias, 1hs, 30 min" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 4, 9, 0, 0);
        assertEquals(60f, b.getRentalPrice(from, to),"Costo 2 dias, 23hs" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 5, 10, 0, 0);
        assertEquals(60f, b.getRentalPrice(from, to),"Costo 4 days (1 week)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 8, 10, 0, 0);
        assertEquals(60f, b.getRentalPrice(from, to),"Costo 1 week" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 8, 11, 0, 0);
        assertEquals(65f, b.getRentalPrice(from, to),"Costo 1 week, 1hs" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 9, 11, 0, 0);
        assertEquals(85f, b.getRentalPrice(from, to),"Costo 1 week, 1 day, 1hs" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 13, 10, 0, 0);
        assertEquals(120f, b.getRentalPrice(from, to),"Costo 1 week, 5 day (2 weeks)" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

        to = LocalDateTime.of(2018, 10 , 15, 10, 0, 0);
        assertEquals(120f, b.getRentalPrice(from, to),"Costo 2 weeks" );
        System.out.println(setTimeMessage(from, to) + " | PRICE: " + b.getRentalPrice(from, to));

    }


    private String setTimeMessage(LocalDateTime from, LocalDateTime to){
        return "Weeks: " + ChronoUnit.WEEKS.between(from, to) +
                " Days: " + ChronoUnit.DAYS.between(from, to.minusWeeks(ChronoUnit.WEEKS.between(from, to))) +
                " Hours: " + ChronoUnit.HOURS.between(from, to.minusDays(ChronoUnit.DAYS.between(from, to))) +
                " Minutes: " + ChronoUnit.MINUTES.between(from, to.minusHours(ChronoUnit.HOURS.between(from, to)));

    }
}