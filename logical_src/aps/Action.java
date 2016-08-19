/*
 * 
 */
package aps;
import java.time.LocalDate;  
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Cell of the logic model which is based the hole system. This class represents
 * an Action Item of an Action Plan.
 * 
 * @author AI-Saac
 * @param tasks_list
 * @param dependencies List of action items which restrict the start-up or finishing of the action execution.
 */
public class Action {
    //aps Class Variables 
    private ArrayList<Task> tasks_list;
    
    //************************************************************************
    // Format of a customize Action Plan
    private String id;
    private short om_number;  // om = Operational Measure
    private String om_detail;
    private Collaborator responsable;
    private String comments;
    private String benefit;
    private String status;
    private LocalDate planned_start_date;  // Equals to APP = As Per Plan
    private LocalDate planned_finish_date;
    private LocalDate real_finish_date;
    private short[] dependencies;  
    private LocalDateTime date_created;
    private LocalDateTime date_modified;
    
    /** 
    * Class Empty constructor.
    */
    public Action(){
        
    }
    
    /**
     *
     * @param id
     * @param om_number
     * @param om_detail
     * @param responsable
     * @param planned_start_date
     * @param planned_finish_date
     * @param real_finish_date
     * @param comments
     * @param benefit
     * @param status
     */
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
        this.date_created = LocalDateTime.now();
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
    public short getOm_number() {
        return om_number;
    }

    /**
     *
     * @param om_number
     */
    public void setOm_number(short om_number) {
        this.om_number = om_number;
    }

    /**
     *
     * @return
     */
    public String getOm_detail() {
        return om_detail;
    }

    /**
     *
     * @param om_detail
     */
    public void setOm_detail(String om_detail) {
        this.om_detail = om_detail;
    }

    /**
     *
     * @return
     */
    public Collaborator getOwner() {
        return responsable;
    }

    /**
     *
     * @param responsable
     */
    public void setOwner(Collaborator responsable) {
        this.responsable = responsable;
    }

    /**
     *
     * @return
     */
    public LocalDate getPlanned_start_date() {
        return planned_start_date;
    }

    /**
     *
     * @param planned_start_date
     */
    public void setPlanned_start_date(LocalDate planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    /**
     *
     * @return
     */
    public LocalDate getPlanned_finish_date() {
        return planned_finish_date;
    }

    /**
     *
     * @param planned_finish_date
     */
    public void setPlanned_finish_date(LocalDate planned_finish_date) {
        this.planned_finish_date = planned_finish_date;
    }

    /**
     *
     * @return
     */
    public LocalDate getReal_finish_date() {
        return real_finish_date;
    }

    /**
     *
     * @param real_finish_date
     */
    public void setReal_finish_date(LocalDate real_finish_date) {
        this.real_finish_date = real_finish_date;
    }

    /**
     *
     * @return
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getBenefit() {
        return benefit;
    }

    /**
     *
     * @param benefit
     */
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public ArrayList<Task> getTasks_list() {
        return tasks_list;
    }

    public void setTasks_list(ArrayList<Task> tasks_list) {
        this.tasks_list = tasks_list;
    }

    public Collaborator getResponsable() {
        return responsable;
    }

    public void setResponsable(Collaborator responsable) {
        this.responsable = responsable;
    }

    public short[] getDependencies() {
        return dependencies;
    }

    public void setDependencies(short[] dependencies) {
        this.dependencies = dependencies;
    }

    public LocalDateTime getDate_created() {
        return date_created;
    }

    protected void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public LocalDateTime getDate_modified() {
        return date_modified;
    }

    public void setDete_modified() {
        this.date_modified = LocalDateTime.now();
    }    
}
