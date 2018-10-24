import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    @Test
    void getPrice() {
        LocalDateTime from = LocalDateTime.of(2018, 10 , 1, 10, 0, 0);
        LocalDateTime to = LocalDateTime.of(2018, 10 , 1, 12, 0, 0);
        Product p = new Bike();
        Rental r = new Rental(from, to, p);

        assertEquals(10f, r.getPrice());
        assertEquals(p.getRentalPrice(from, to), r.getPrice());


    }

}