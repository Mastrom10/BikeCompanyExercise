import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

public interface Product {
    /**
     * Returns the selling price of the product
     *
     * @throws NotImplementedException -> method not implemented yet.
     */
    float getSellPrice() throws NotImplementedException;

    /**
     * Returns the rental price for a certain range of dates.
     *
     * @param from date the rent begins
     * @param to date the rent end
     */
    float getRentalPrice(LocalDateTime from, LocalDateTime to);
}
