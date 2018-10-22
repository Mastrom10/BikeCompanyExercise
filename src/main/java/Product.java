import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;

public interface Product {
    float getSellPrice() throws OperationNotSupportedException;
    float getRentalPrice(LocalDateTime from, LocalDateTime to) throws OperationNotSupportedException;
}
