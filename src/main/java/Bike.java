import javax.naming.OperationNotSupportedException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bike implements Product{

    private float hourCost = 5;
    private float hourBreakPoint = 4;

    private float dayCost = 20;
    private float dayBreakPoint = 3;

    private float weekCost = 60;

    public float getSellPrice() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    public float getRentalPrice(LocalDateTime from, LocalDateTime to) throws DateTimeException {

        //first we check if dates are valid
        if (from.isAfter(to) || from.isEqual(to)){
            return 0;
            //throw new DateTimeException("Invalid Dates.");
        }

        long hoursDifference = ChronoUnit.HOURS.between(from, to);
        long daysDifference =  ChronoUnit.DAYS.between(from, to);
        long weeksDifference =  ChronoUnit.WEEKS.between(from, to);


        //WARNING: devolutions before 4am, charged as 1 day
        if (hoursDifference < hourBreakPoint) {
            int hourExeded = ChronoUnit.MINUTES.between(from, to.minusHours(hoursDifference)) > 0 ? 1 : 0;
            return (hoursDifference + hourExeded) * hourCost;
        }  else if (daysDifference == 0){
            return dayCost;
        } else if (daysDifference < dayBreakPoint ) {
            return ((daysDifference) * dayCost ) + getRentalPrice(from, to.minusDays(daysDifference));
        } else if (weeksDifference == 0){
            return weekCost;
        } else {
            return (weeksDifference * weekCost) + getRentalPrice(from, to.minusWeeks(weeksDifference));
        }

    }


}
