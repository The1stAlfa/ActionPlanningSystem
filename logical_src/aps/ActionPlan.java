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
    private String ap_id;
    private LocalDate date_created;
    private LocalDate date_modified;
    private LocalDateTime current_date;
    private byte execution; // Action Plan porcentage of execution
    
    /**
     *
     */
    public ActionPlan(){
        
    }

    /**
     *
     * @param ap_id
     * @param owner
     */
    public ActionPlan(Collaborator owner, String meetingID) {
        setAp_id(meetingID);
        this.owner = owner;
        this.date_created = LocalDate.now();
        this.summary = summary;
        actions_list = null;
    }

    public APSummary getSummary() {
        return summary;
    }
    
    /**
     *
     * @return
     */
    public Collaborator getOwner() {
        return owner;
    }

    public ArrayList<Action> getActions_list() {
        return actions_list;
    }

    public String getAp_id() {
        return ap_id;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public LocalDate getDate_modified() {
        return date_modified;
    }
    
    public byte getExecution() {
        return execution;
    }

    public LocalDateTime getCurrent_date() {
        return current_date;
    }

    public void setSummary(APSummary summary) {
        this.summary = summary;
    }

    public void setOwner(Collaborator owner) {
        this.owner = owner;
    }

    public void setActions_list(ArrayList<Action> actions_list) {
        this.actions_list = actions_list;
    }

    public void setAp_id(String ap_id) {
        this.ap_id = ap_id;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public void setDate_modified(LocalDate date_modified) {
        this.date_modified = date_modified;
    }

    public void setCurrent_date(LocalDateTime current_date) {
        this.current_date = current_date;
    }

    public void setExecution(byte execution) {
        this.execution = execution;
    }
    
    public ArrayList<Action> searchActionItems(ActionItemFilter filter, 
            String key){
        String query;
        if(filter.equals(ActionItemFilter.BY_ID)){
            query = "SELECT * FROM ACTION WHERE ITEM_ID='555'";
            
        }
        return null;
    }
    
    //Overload Method
    public ArrayList<Action> searchActionItems(ActionItemFilter filter, 
            int key){
        if(filter.equals(ActionItemFilter.BY_DURATION)){
            
        }
        return null;
    }
}
