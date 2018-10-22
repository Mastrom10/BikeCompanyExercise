public class FamilyRentalPromo implements Promotion {

    public float getPromotionDisscount(float originalPrice) {
        return originalPrice * 30/100;
    }

    public boolean applyPromotionByQuantity(int quantity) {
        return quantity >= 3;
    }


}
