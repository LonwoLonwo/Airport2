import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import com.skillbox.airport.Flight;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Terminal> terminals = airport.getTerminals();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, +2);
        Date plus2hours = calendar.getTime();

        for(Terminal t : terminals){
            t.getFlights().stream()
                    .filter(d -> d.getType().equals(Flight.Type.DEPARTURE))
                    .filter(s -> s.getDate().before(plus2hours) && s.getDate().after(new Date()))
                    .forEach(System.out::println);
        }
    }
}
