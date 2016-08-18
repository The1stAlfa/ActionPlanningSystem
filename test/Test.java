
import java.time.LocalDate;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordone3
 */
public class Test {
     private static LocalDate date_modified = LocalDate.now();
     private static String acronym_name = new String();
     private static String firstName = "Joel";
     private static String lastName = "Ordonez Alarcon";
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(date_modified.toString());
        setAcronymName();
        System.out.println(acronym_name);
    }
    
    private static void setAcronymName(){
        acronym_name = firstName.substring(0,1);
        String[] names = lastName.split(" ");
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1);
    }
}
