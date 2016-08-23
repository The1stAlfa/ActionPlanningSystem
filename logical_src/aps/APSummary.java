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
    private int ta;  // Total of Actions
    private int ta_C_APP;  // Completed app = As Per Plan
    private int ta_C_AFTERAPP;  //
    private int ta_OVERDUE;
    private int ta_NEAR_DUE_DATE;
    private int ta_IN_PROGRESS;
    private int ta_CANCELLED;

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
    
    /**
     *
     * @return
     */
    public int getTA() {
        return ta;
    }

    /**
     *
     * @param ta
     */
    public void setTA(int ta) {
        this.ta = ta;
    }

    /**
     *
     * @return
     */
    public int getTA_C_APP() {
        return ta_C_APP;
    }

    /**
     *
     * @param ta_C_APP
     */
    public void setTA_C_APP(int ta_C_APP) {
        this.ta_C_APP = ta_C_APP;
    }

    /**
     *
     * @return
     */
    public int getTA_C_AFTERAPP() {
        return ta_C_AFTERAPP;
    }

    /**
     *
     * @param ta_C_AFTERAPP
     */
    public void setTA_C_AFTERAPP(int ta_C_AFTERAPP) {
        this.ta_C_AFTERAPP = ta_C_AFTERAPP;
    }

    /**
     *
     * @return
     */
    public int getTA_OVERDUE() {
        return ta_OVERDUE;
    }

    /**
     *
     * @param ta_OVERDUE
     */
    public void setTA_OVERDUE(int ta_OVERDUE) {
        this.ta_OVERDUE = ta_OVERDUE;
    }

    /**
     *
     * @return
     */
    public int getTA_NEAR_DUE_DATE() {
        return ta_NEAR_DUE_DATE;
    }

    /**
     *
     * @param ta_NEAR_DUE_DATE
     */
    public void setTA_NEAR_DUE_DATE(int ta_NEAR_DUE_DATE) {
        this.ta_NEAR_DUE_DATE = ta_NEAR_DUE_DATE;
    }

    /**
     *
     * @return
     */
    public int getTA_IN_PROGRESS() {
        return ta_IN_PROGRESS;
    }

    /**
     *
     * @param ta_IN_PROGRESS
     */
    public void setTA_IN_PROGRESS(int ta_IN_PROGRESS) {
        this.ta_IN_PROGRESS = ta_IN_PROGRESS;
    }

    /**
     *
     * @return
     */
    public int getTA_CANCELLED() {
        return ta_CANCELLED;
    }

    /**
     *
     * @param ta_CANCELLED
     */
    public void setTA_CANCELLED(int ta_CANCELLED) {
        this.ta_CANCELLED = ta_CANCELLED;
    }
}
