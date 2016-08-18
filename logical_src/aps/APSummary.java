/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

/**
 *
 * @author AI-Saac
 */
public class APSummary {
    private int t_actions;  // Total of Actions
    private int t_actions_completed_app;  // app = As Per Plan
    private int t_actions_completed;
    private int t_actions_overdue;
    private int t_near_due_date;
    private int t_in_progress;

    public APSummary(){
        
    }
    
    public APSummary(int t_actions, int t_actions_completed_app, 
            int t_actions_completed, int t_actions_overdue, 
            int t_near_due_date, int t_in_progress) {
        this.t_actions = t_actions;
        this.t_actions_completed_app = t_actions_completed_app;
        this.t_actions_completed = t_actions_completed;
        this.t_actions_overdue = t_actions_overdue;
        this.t_near_due_date = t_near_due_date;
        this.t_in_progress = t_in_progress;
    }

    public int getT_actions() {
        return t_actions;
    }

    public void setT_actions(int t_actions) {
        this.t_actions = t_actions;
    }

    public int getT_actions_completed_app() {
        return t_actions_completed_app;
    }

    public void setT_actions_completed_app(int t_actions_completed_app) {
        this.t_actions_completed_app = t_actions_completed_app;
    }

    public int getT_actions_completed() {
        return t_actions_completed;
    }

    public void setT_actions_completed(int t_actions_completed) {
        this.t_actions_completed = t_actions_completed;
    }

    public int getT_actions_overdue() {
        return t_actions_overdue;
    }

    public void setT_actions_overdue(int t_actions_overdue) {
        this.t_actions_overdue = t_actions_overdue;
    }

    public int getT_near_due_date() {
        return t_near_due_date;
    }

    public void setT_near_due_date(int t_near_due_date) {
        this.t_near_due_date = t_near_due_date;
    }

    public int getT_in_progress() {
        return t_in_progress;
    }

    public void setT_in_progress(int t_in_progress) {
        this.t_in_progress = t_in_progress;
    }
    
    
}
