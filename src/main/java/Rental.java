import java.time.LocalDateTime;

public class Rental {

    private LocalDateTime from;
    private LocalDateTime to;
    private Product product;

    public Rental(LocalDateTime from, LocalDateTime to, Product product) {
        this.from = from;
        this.to = to;
        this.product = product;
    }

    private LocalDateTime getFrom() {
        return from;
    }

    private LocalDateTime getTo() {
        return to;
    }

    float getPrice(){
        return product.getRentalPrice(this.getFrom(), this.getTo());
    }
}
