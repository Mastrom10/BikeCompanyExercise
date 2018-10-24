import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bike implements Product{

    private float hourCost = 5;
    private float dayCost = 20;
    private float weekCost = 60;

    private float hourBreakPoint, dayBreakPoint;


    public Bike() {
        this.hourBreakPoint = dayCost/hourCost;
        this.dayBreakPoint = weekCost/dayCost;
    }


    public float getSellPrice() throws NotImplementedException {
        throw new NotImplementedException();
    }


    public float getRentalPrice(LocalDateTime from, LocalDateTime to) {

        //first we check if dates are valid
        if (from.isAfter(to) || from.isEqual(to)){
            return 0;
        }

        long hoursDifference = ChronoUnit.HOURS.between(from, to);
        long daysDifference =  ChronoUnit.DAYS.between(from, to);
        long weeksDifference =  ChronoUnit.WEEKS.between(from, to);

        if (hoursDifference < hourBreakPoint) {
            int hourExceeded = ChronoUnit.MINUTES.between(from, to.minusHours(hoursDifference)) > 0 ? 1 : 0;
            return (hoursDifference + hourExceeded) * hourCost;
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
