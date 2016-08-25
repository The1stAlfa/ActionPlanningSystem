/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class Facility {
    //aps Class Variables 
    private ArrayList<Collaborator> collaborators_list;
    private ArrayList<FuntionalArea> funtional_areas;
    private ArrayList<Meeting> meetings;
    //************************************************************************
    private byte id;
    private String name;
    private String acronym;
    
    /** 
    * Class Empty constructor.
    */    
    public Facility(){
        
    }

    public ArrayList<Collaborator> getCollaborators_list() {
        return collaborators_list;
    }

    public ArrayList<FuntionalArea> getFuntional_areas() {
        return funtional_areas;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setCollaborators_list(ArrayList<Collaborator> collaborators_list) {
        this.collaborators_list = collaborators_list;
    }

    public void setFuntional_areas(ArrayList<FuntionalArea> funtional_areas) {
        this.funtional_areas = funtional_areas;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
