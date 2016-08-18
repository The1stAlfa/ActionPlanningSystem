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
public class Action {
    private String id;
    private short om_number;  // om = Operational Measure
    private String om_detail;
    private Collaborator responsable;
    private LocalDate planned_start_date;  // Equals to APP = As Per Plan
    private LocalDate planned_finish_date;
    private LocalDate real_finish_date;
    private String comments;
    private String benefit;
    private String status;

    public Action(){
        
    }
    
    public Action(String id, short om_number, String om_detail, 
            Collaborator responsable, LocalDate planned_start_date, 
            LocalDate planned_finish_date, LocalDate real_finish_date, 
            String comments, String benefit, 
            String status) {
        this.id = id;
        this.om_number = om_number;
        this.om_detail = om_detail;
        this.responsable = responsable;
        this.planned_start_date = planned_start_date;
        this.planned_finish_date = planned_finish_date;
        this.real_finish_date = real_finish_date;
        this.comments = comments;
        this.benefit = benefit;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public short getOm_number() {
        return om_number;
    }

    public void setOm_number(short om_number) {
        this.om_number = om_number;
    }

    public String getOm_detail() {
        return om_detail;
    }

    public void setOm_detail(String om_detail) {
        this.om_detail = om_detail;
    }

    public Collaborator getOwner() {
        return responsable;
    }

    public void setOwner(Collaborator responsable) {
        this.responsable = responsable;
    }

    public LocalDate getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(LocalDate planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public LocalDate getPlanned_finish_date() {
        return planned_finish_date;
    }

    public void setPlanned_finish_date(LocalDate planned_finish_date) {
        this.planned_finish_date = planned_finish_date;
    }

    public LocalDate getReal_finish_date() {
        return real_finish_date;
    }

    public void setReal_finish_date(LocalDate real_finish_date) {
        this.real_finish_date = real_finish_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
    
    
}
