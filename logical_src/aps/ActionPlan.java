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
    private LocalDateTime current_date;
    private byte execution; // Action Plan porcentage of execution
    
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
    public ActionPlan(Collaborator owner, String meetingID) {
        setID(meetingID);
        this.owner = owner;
        this.date_created = LocalDate.now();
        this.summary = summary;
        actions_list = null;
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
    private void setID(String id) {
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

    /**
     *
     * @return
     */
    public ArrayList<Action> getActions_list() {
        return actions_list;
    }

    /**
     *
     * @param actions_list
     */
    public void setActions_list(ArrayList<Action> actions_list) {
        this.actions_list = actions_list;
    }

    /**
     *
     * @return
     */
    public LocalDate getDate_created() {
        return date_created;
    }

    /**
     *
     * @param date_created
     */
    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getCurrent_date() {
        return current_date;
    }

    /**
     *
     * @param current_date
     */
    public void setCurrent_date(LocalDateTime current_date) {
        this.current_date = current_date;
    }

    /**
     *
     * @return
     */
    public byte getExecution() {
        return execution;
    }

    /**
     *
     * @param execution
     */
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
