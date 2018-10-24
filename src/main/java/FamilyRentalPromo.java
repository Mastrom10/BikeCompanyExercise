public class FamilyRentalPromo implements Promotion {

    public float getPromotionDiscount(float originalPrice, int quantity) {
        if (quantity >= 3) {
            return originalPrice * 30 / 100;
        }
        return originalPrice;
    }

}
