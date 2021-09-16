package RestricoesEmHoras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vicente
 * @since The public class currentDateAndTime has fundamentals methods to 
 * get a current date or hours.
 */
public class CurrentDateAndTime {
    
    /**
     * @return It Returns the current date "yyyy-MM-dd".
     */
    public String getCurrentDate() {

            String dataFormatada = buildCurrentDateAndTime();
 
            // dataFormatada = "yyyy-MM-dd HH:mm:ss"
            // Return "yyyy-MM-dd"
            // Return the year-Month-day
            return dataFormatada.substring(0, 10); 
          
          

        }

    /**
     * @return It Returns the current time "HH:mm:ss".
     */
    public String getCurrentHour(){
        
          String dataFormatada = buildCurrentDateAndTime();
          
            // dataFormatada = "yyyy-MM-dd HH:mm:ss"
            // Return "HH:mm:ss"
            // Return the hours:minute:second
            return dataFormatada.substring(11);
    }
    
    
    private String buildCurrentDateAndTime(){
    
            String dataFormatada;

            LocalDateTime dataDeHoje = LocalDateTime.now();

            DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            dataFormatada = dataDeHoje.format(data);
            
            return dataFormatada;
    
    }
    
    
    
}
