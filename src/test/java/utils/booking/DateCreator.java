package utils.booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCreator {

    public String getOffsetDate(int days){
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return date;
    }
}
