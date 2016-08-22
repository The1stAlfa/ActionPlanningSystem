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
public class WorkTeam {
    //aps Class Variables
    private ArrayList<Collaborator> members;
    private ArrayList<ActionPlan> plansID_list;
    //************************************************************************
    private String id;
    private byte performance; // Team APP Percentage of performance
    
    /**
     *
     */
    public WorkTeam(){
        
    }
    
    /**
     *
     * @param members
     * @param plansID_list
     */
    public WorkTeam(ArrayList<Collaborator> members, ArrayList<ActionPlan> plansID_list) {
        setID("122");
        this.members = members;
        this.plansID_list = plansID_list;
    }

    /**
     *
     * @return
     */
    public String getID() {
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
    public ArrayList<Collaborator> getMembers() {
        return members;
    }

    /**
     *
     * @param members
     */
    public void setMembers(ArrayList<Collaborator> members) {
        this.members = members;
    }

    /**
     *
     * @return
     */
    public ArrayList<ActionPlan> getPlansID_list() {
        return plansID_list;
    }

    /**
     *
     * @param plansID_list
     */
    public void setPlansID_list(ArrayList<ActionPlan> plansID_list) {
        this.plansID_list = plansID_list;
    }

    /**
     *
     * @return
     */
    public byte getPerformance() {
        return performance;
    }

    /**
     *
     * @param performance
     */
    public void setPerformance(byte performance) {
        this.performance = performance;
    }
}
