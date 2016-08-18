/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AI-Saac
 */
public class ActionPlan {
    //aps Class Variables
    private APSummary summary;
    private Collaborator owner;
    private ArrayList<Action> actions_list;       
   //************************************************************************ 
    private String id;
    private LocalDate date_created;
    private LocalDate date_modified;
    
    /**
     *
     */
    public ActionPlan(){
        
    }

    /**
     *
     * @param id
     * @param owner
     */
    public ActionPlan(String id, Collaborator owner) {
        this.id = id;
        this.owner = owner;
        this.date_modified = LocalDate.now();
        this.summary = summary;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Collaborator getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Collaborator owner) {
        this.owner = owner;
    }

    /**
     *
     * @return
     */
    public LocalDate getDate_modified() {
        return date_modified;
    }

    /**
     *
     * @param date_modified
     */
    public void setLast_update(LocalDate date_modified) {
        this.date_modified = date_modified;
    }

    /**
     *
     * @return
     */
    public APSummary getSummary() {
        return summary;
    }

    /**
     *
     * @param summary
     */
    public void setSummary(APSummary summary) {
        this.summary = summary;
    }
    
    
}
