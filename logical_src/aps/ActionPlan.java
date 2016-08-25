/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.time.*;
import java.util.ArrayList;
import java.util.Optional;

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
    private short id;
    private LocalDateTime date_created;
    private LocalDateTime date_modified;
    private LocalDateTime current_date;
    private byte execution; // Action Plan porcentage of execution
    private short action_increment;
    private byte id_length;
    
    /**
     *
     */
    public ActionPlan(){
        this.actions_list = new ArrayList<>();
    }

    /**
     *
     * @param meetingid
     * @param owner
     */
    public ActionPlan(Collaborator owner, short id) {
        this.id = id;
        this.owner = owner;
        this.date_created = LocalDateTime.now();
        this.summary = summary;
        actions_list = null;
    }

    public APSummary getSummary() {
        return summary;
    }

    public Collaborator getOwner() {
        return owner;
    }

    public ArrayList<Action> getActions_list() {
        return actions_list;
    }

    public short getId() {
        return id;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public LocalDateTime getCurrent_date() {
        return current_date;
    }

    public byte getExecution() {
        return execution;
    }

    public short getAction_increment() {
        return action_increment;
    }
    
    public byte getId_length() {
        return id_length;
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

    public void setId(short id) {
        this.id = id;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public void setDate_modified(LocalDateTime date_modified) {
        this.date_modified = date_modified;
    }

    public void setCurrent_date(LocalDateTime current_date) {
        this.current_date = current_date;
    }

    public void setExecution(byte execution) {
        this.execution = execution;
    }    

    public void setAction_increment(short action_increment) {
        this.action_increment = action_increment;
    }
    
    public void setId_length(byte id_length) {
        this.id_length = id_length;
    }
    
    public Action searchActionItem(String key){
        Optional<Action> a = actions_list.stream()
        .filter(p -> p.getID().equals(key))
        .findFirst();
        return a.isPresent() ? a.get() : null;
        //return null;
    }
    
    public boolean insertActionItem(Action action){
        actions_list.add(action);
        action_increment += (short) 1;
        return true;
    }
    
    //Overload Method
    public ArrayList<Action> searchActionItems(ActionItemFilter filter, 
            int key){
        if(filter.equals(ActionItemFilter.BY_DURATION)){
            
        }
        return null;
    }
}
