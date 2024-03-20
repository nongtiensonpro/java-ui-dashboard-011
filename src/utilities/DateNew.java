/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Nong_Tien_Son
 */
public class DateNew {
    LocalDateTime current = LocalDateTime.now();
    
    public String dayNew(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        String formatted = current.format(formatter);
        return formatted;
    }
    public String dayTextNew(){
        DayOfWeek dayOfWeek = current.getDayOfWeek();
        String formatted = dayOfWeek.toString();
        return formatted;
    }
    public String monthNew(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String formatted = current.format(formatter);
        return formatted;
    }
    public String yearNew(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String formatted = current.format(formatter);
        return formatted;
    }
}
