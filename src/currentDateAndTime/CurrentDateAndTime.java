package currentDateAndTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vicente
 * @since The public class currentDateAndTime has fundamentals methods to get a
 * current date or hours.
 */
public class CurrentDateAndTime {

    /**
     * @return It Returns the current date "yyyy-MM-dd".
     */
    public LocalDate getCurrentDate() {

        LocalDate localDate = LocalDate.now();

        return localDate;

    }

    
     /*@pamet String date ex: 2021-12-23
     * @return It Returns the current time "HH:mm:ss".
     */
    public LocalDate toLocalDate( String date ) {
        
        return LocalDate.parse((CharSequence)  date);
    }
    
    
    /**
     * @return It Returns the current time "HH:mm:ss".
     */
    public LocalTime getCurrentHour() {

        String dataFormatada = buildCurrentDateAndTime();

        // dataFormatada = "yyyy-MM-dd HH:mm:ss"
        // Return "HH:mm:ss"
        // Return the hours:minute:second
        String minhaHora = dataFormatada.substring(11);
        return LocalTime.parse((CharSequence)  minhaHora);
    }

    private String buildCurrentDateAndTime() {

        String dataFormatada;

        LocalDateTime dataDeHoje = LocalDateTime.now();

        DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        dataFormatada = dataDeHoje.format(data);

        return dataFormatada;

    }

}
