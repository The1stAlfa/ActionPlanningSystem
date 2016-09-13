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
    private static ArrayList<Collaborator> collaborator_list;
    private static ArrayList<FuntionalArea> funtional_areas;
    private ArrayList<Meeting> meetings;
    //************************************************************************
    private String id;
    private String name;
    private String acronym;
    private String city;
    
    /** 
    * Class Empty constructor.
    */    
    public Facility(){
        
    }

    public ArrayList<Collaborator> getCollaboratorList() {
        return collaborator_list;
    }

    public ArrayList<FuntionalArea> getFuntional_areas() {
        return funtional_areas;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getCity() {
        return city;
    }
    
    public ArrayList getMeetingsNames(){
        ArrayList s = new ArrayList();
        for(Meeting meeting:meetings)
            s.add(meeting.getName());
        return s;
    }

    public void setCollaboratorList(ArrayList<Collaborator> collaborator_list) {
        this.collaborator_list = collaborator_list;
    }

    public void setFuntionalAreas(ArrayList<FuntionalArea> funtional_areas) {
        this.funtional_areas = funtional_areas;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Meeting searchMeeting(String meeting){
        return null;
    }
}
