/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.time.LocalDate;

/**
 *
 * @author AI-Saac
 */
public class ActionPlan {
    private String id;
    private Collaborator owner;
    private LocalDate last_update;
    private APSummary summary;
    
    public ActionPlan(){
        
    }

    public ActionPlan(String id, Collaborator owner, LocalDate last_update, APSummary summary) {
        this.id = id;
        this.owner = owner;
        this.last_update = last_update;
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collaborator getOwner() {
        return owner;
    }

    public void setOwner(Collaborator owner) {
        this.owner = owner;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public APSummary getSummary() {
        return summary;
    }

    public void setSummary(APSummary summary) {
        this.summary = summary;
    }
    
    
}
