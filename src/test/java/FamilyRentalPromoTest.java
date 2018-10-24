import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyRentalPromoTest {
    @Test
    void getPromotionDiscount() {
        FamilyRentalPromo frp = new FamilyRentalPromo();
        assertEquals(30f, frp.getPromotionDiscount(100f, 3));
        assertEquals(30f, frp.getPromotionDiscount(100f, 5));
        assertEquals(30f, frp.getPromotionDiscount(100f, 8));
        assertEquals(0f, frp.getPromotionDiscount(100f, 2));
        assertEquals(0f, frp.getPromotionDiscount(100f, 1));
        assertEquals(0f, frp.getPromotionDiscount(100f, 0));
        assertEquals(0f, frp.getPromotionDiscount(0f, 0));
        assertEquals(0f, frp.getPromotionDiscount(0f, 3));
        frp = null;
    }

}