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
    private ArrayList<Collaborator> adt_participants; //aditional partcipants
    private WorkTeam team; 
    private ActionPlan plan;
 //************************************************************************
    private String name;
    private String purpose;
    private LocalDate date_created;
    private String id;
    
    /** 
    * Class Empty constructor.
    */
    public Meeting(String name){
        setId(name);
    }
    
    public Meeting(String name, String purpose, String id,
            LocalDate date_created){
        this.name = name;
        this.purpose = purpose;
        
    }
    
    public ArrayList<Collaborator> getAdt_participants() {
        return adt_participants;
    }

    public void setAdt_participants(ArrayList<Collaborator> adt_participants) {
        this.adt_participants = adt_participants;
    }

    public WorkTeam getTeam() {
        return team;
    }

    public void setTeam(WorkTeam team) {
        this.team = team;
    }

    public ActionPlan getPlan() {
        return plan;
    }

    public void setPlan(ActionPlan plan) {
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public String getId() {
        return id;
    }

    private void setId(String name) {
        this.id = "";
    }
    
    
}
