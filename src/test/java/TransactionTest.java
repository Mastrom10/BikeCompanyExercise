import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private LocalDateTime from, to1, to2;
    private Rental r1,r2,r3,r4;
    private Promotion promotion;
    private Transaction transaction;



    @BeforeEach
    void setUp() {
        from = LocalDateTime.of(2018, 10 , 1, 10, 0, 0);
        to1 = LocalDateTime.of(2018, 10 , 1, 11, 0, 0);
        to2 = LocalDateTime.of(2018, 10 , 1, 15, 0, 0);
        r1 = new Rental(from, to1, new Bike());
        r2 = new Rental(from, to1, new Bike());
        r3 = new Rental(from, to1, new Bike());
        r4 = new Rental(from, to2, new Bike());
        promotion = new FamilyRentalPromo();
        transaction = new Transaction(promotion);

    }

    @AfterEach
    void tearDown() {
        from = null;
        to1 = null;
        to2 = null;
        r1 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        promotion = null;
        transaction = null;
    }

    @Test
    void getDiscount() {
        transaction.addRental(r1).addRental(r2);
        assertEquals(0f,transaction.getDiscount());
        transaction.addRental(r3);
        assertEquals(15f*0.3f, transaction.getDiscount());
        transaction.addRental(r4);
        assertEquals(35f * 0.3f, transaction.getDiscount());
    }

    @Test
    void getPrice() {
        transaction.addRental(r1).addRental(r2);
        assertEquals(10f, transaction.getPrice());
        transaction.addRental(r3);
        assertEquals(15f, transaction.getPrice());
        transaction.addRental(r4);
        assertEquals(35f, transaction.getPrice());
    }

    @Test
    void getFinalPriceWithDiscount() {
        transaction.addRental(r1).addRental(r2);
        assertEquals(10f, transaction.getFinalPriceWithDiscount());
        transaction.addRental(r3);
        assertEquals(15f-(15f*0.3f), transaction.getFinalPriceWithDiscount());
        transaction.addRental(r4);
        assertEquals(35f-(35f*0.3f), transaction.getFinalPriceWithDiscount());
    }

    @Test
    void addRental() {
        transaction.addRental(r1)
                .addRental(r2)
                .addRental(r3);
    }

}