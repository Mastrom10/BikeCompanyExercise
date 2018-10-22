import java.util.List;

public interface Promotion {

    float getPromotionDisscount(float originalPrice);
    boolean applyPromotionByQuantity(int quantity);
}
