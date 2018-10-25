import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private List<Rental> rentals;
    private Promotion promo;


    /**
     * Returns only the discount for the full transaction.
     * (ej: all the bikes)
     */
    public float getDiscount(){
        return promo.getPromotionDiscount(this.getPrice(), rentals.size());
    }

    /**
     * Returns only the total Price for the full transaction.
     * (ej: all the bikes)
     */
    public float getPrice(){
        float price = 0;
        for (Rental r :
                rentals) {
            price += r.getPrice();
        }
        return price;
    }

    /**
     * Returns the very final Price, with discount applied, for the full transaction.
     */
    public float getFinalPriceWithDiscount(){
        return this.getPrice() - this.getDiscount();
    }

    public Transaction(Promotion promo) {
        this.promo = promo;
        this.rentals = new ArrayList<>();
    }

    public Transaction addRental(Rental rental){
        rentals.add(rental);
        return this;
    }
}
