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
    //************************************************************************
    private String name;
    
    /** 
    * Class Empty constructor.
    */    
    public Facility(){
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Collaborator> getCollaborators_list() {
        return collaborators_list;
    }

    public void setCollaborators_list(ArrayList<Collaborator> collaborators_list) {
        this.collaborators_list = collaborators_list;
    }
    
    
    
}
