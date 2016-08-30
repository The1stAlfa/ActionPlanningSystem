
import java.time.LocalDate;

import aps.*;

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
     private static ActionPlan ap;
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(date_modified.toString());
        setAcronymName();
        System.out.println(acronym_name);
        
        Action ac1 = new Action();
        ac1.setID("IND", (short)1,(byte)4);
        Action ac2 = new Action();
        ac2.setID("RES",(short)146,(byte)4);
        ap = new ActionPlan();
        ap.setAction_increment((short)4); 
        ap.insertActionItem(ac1);
        ap.insertActionItem(ac2);
        Action s = ap.searchActionItem("RES0147");
        System.out.println(s.getID());
        System.out.println("");
        
        String original = "000433";
        String incremented = String.format("%0" + original.length() + "d", 
                Integer.parseInt(original) + 1000);
        System.out.println(incremented);
        PFrame p = new PFrame();
        p.setVisible(true);
        p.setExtendedState(6);
        
    }
    
    private static void setAcronymName(){
        acronym_name = firstName.substring(0,1);
        String[] names = lastName.split(" ");
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1);
    }
}
