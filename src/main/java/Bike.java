import javax.naming.OperationNotSupportedException;
import java.util.Date;

public class Bike implements Product{

    public float getSellPrice() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    public float getRentalPrice(Date from, Date to) {



        return 0;
    }


}
