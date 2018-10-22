import javax.naming.OperationNotSupportedException;
import java.util.Date;

public interface Product {
    float getSellPrice() throws OperationNotSupportedException;
    float getRentalPrice(Date from, Date to) throws OperationNotSupportedException;
}
