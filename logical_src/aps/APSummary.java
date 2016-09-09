/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.time.LocalDateTime;

/**
 *
 * @author AI-Saac
 */
public class APSummary {
    private LocalDateTime date_modified;
    private int ta_CANCELLED;
    private int ta;  // Total of Actions
    private int ta_C_AFTERAPP;  // Completed after as per plan
    private int ta_C_APP;  // Completed app = As Per Plan
    private int ta_IN_PROGRESS;
    private int ta_NEAR_DUE_DATE;
    private int ta_OVERDUE;
    
    /**
     *
     */
    public APSummary(){
        ta = 0;
        ta_C_APP = 0;
        ta_C_AFTERAPP = 0;
        ta_OVERDUE = 0;
        ta_NEAR_DUE_DATE = 0;
        ta_IN_PROGRESS = 0;
        ta_CANCELLED = 0;
    }

    public LocalDateTime getDateModified() {
        return date_modified;
    }

    public int getTaCANCELLED() {
        return ta_CANCELLED;
    }

    public int getTa() {
        return ta;
    }

    public int getTa_C_AFTERAPP() {
        return ta_C_AFTERAPP;
    }

    public int getTa_C_APP() {
        return ta_C_APP;
    }

    public int getTa_IN_PROGRESS() {
        return ta_IN_PROGRESS;
    }

    public int getTa_NEAR_DUE_DATE() {
        return ta_NEAR_DUE_DATE;
    }

    public int getTa_OVERDUE() {
        return ta_OVERDUE;
    }

    public void setDate_modified(LocalDateTime date_modified) {
        this.date_modified = date_modified;
    }

    public void setTa_CANCELLED(int ta_CANCELLED) {
        this.ta_CANCELLED = ta_CANCELLED;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public void setTa_C_AFTERAPP(int ta_C_AFTERAPP) {
        this.ta_C_AFTERAPP = ta_C_AFTERAPP;
    }

    public void setTa_C_APP(int ta_C_APP) {
        this.ta_C_APP = ta_C_APP;
    }

    public void setTa_IN_PROGRESS(int ta_IN_PROGRESS) {
        this.ta_IN_PROGRESS = ta_IN_PROGRESS;
    }

    public void setTa_NEAR_DUE_DATE(int ta_NEAR_DUE_DATE) {
        this.ta_NEAR_DUE_DATE = ta_NEAR_DUE_DATE;
    }

    public void setTa_OVERDUE(int ta_OVERDUE) {
        this.ta_OVERDUE = ta_OVERDUE;
    }    
}
