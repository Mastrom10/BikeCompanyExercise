public class FamilyRentalPromo implements Promotion {
    @Override
    public float getPromotionDisscount(float originalPrice) {
        return originalPrice * 30/100;
    }
}
