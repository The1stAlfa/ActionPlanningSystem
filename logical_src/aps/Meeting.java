/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class Meeting {
    //aps Class Variables 
    private ArrayList<Collaborator> adt_participants;
    private WorkTeam team; 
    private ActionPlan plan;
 //************************************************************************
    private String name;
    private String purpose;
    private LocalDate date_created;
    
    /** 
    * Class Empty constructor.
    */
    public Meeting(){
        
    }
}
