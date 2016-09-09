package aps;
import java.time.LocalDate;  
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Cell of the logic model which is based the hole system. This class represents
 * an Action Item of an Action Plan.
 * 
 * @author AI-Saac
 */
public class Action {
    //aps Class Variables 
    private Collaborator responsible;
    private ArrayList<Task> tasks_list;
    private Status status;
    //************************************************************************
    // Format of a customize Action Plan
    private String itemID;
    private String detail;
    private String comments;
    private String benefit;
    private LocalDate planned_start_date;  // Equals to APP = As Per Plan
    private LocalDate planned_finish_date;
    private LocalDate real_finish_date;
    private LocalDateTime date_created;
    private LocalDateTime date_modified;
    private String tracking_by;
    private byte duration;
    private byte progress; //action percentage of completion
    private byte days_to_dueDate;
    private ArrayList<String> dependencies;  
    
    public Action(){
        
    }
    
    /** 
    * Class Empty constructor.
    */
    public Action(int facilty_id, String meeting, short number, byte zeros){
        setID(facilty_id, meeting,number, zeros);
    }
    
    /**
     *
     * @param ap_name
     * @param om_number
     * @param om_detail
     * @param responsable
     * @param planned_start_date
     * @param planned_finish_date
     * @param comments
     * @param benefit
     */
    public Action(String meeting_acronym,String detail, 
            Collaborator responsible, LocalDate planned_start_date, 
            LocalDate planned_finish_date,String comments, String benefit) {
        //setID(meeting_acronym,(byte)3);
        this.detail = detail;
        this.responsible = responsible;
        this.planned_start_date = planned_start_date;
        this.planned_finish_date = planned_finish_date;
        this.comments = comments;
        this.benefit = benefit;
        setStatus(status);
        this.date_created = LocalDateTime.now();
    }
     
    /**
     *
     * @return
     */
    public Collaborator getResponsible() {
        return responsible;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Task> getTasksList() {
        return tasks_list;
    }
    
    /**
     *
     * @return
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     *
     * @return
     */
    public String getID() {
        return itemID;
    }
    
    /**
     *
     * @return
     */
    public String getDetail() {
        return detail;
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
     * @return
     */
    public String getBenefit() {
        return benefit;
    }
    
    /**
     *
     * @return
     */
    public LocalDate getPlannedStartDate() {
        return planned_start_date;
    }
    
    /**
     *
     * @return
     */
    public LocalDate getPlannedFinishDate() {
        return planned_finish_date;
    }
    
    /**
     *
     * @return
     */
    public LocalDate getRealFinishDate() {
        return real_finish_date;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getDateCreated() {
        return date_created;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getDateModified() {
        return date_modified;
    }
    
    /**
     *
     * @return
     */
    public String getTrackingBy() {
        return tracking_by;
    }
    
    /**
     *
     * @return
     */
    public byte getDuration() {
        return duration;
    }
    
    /**
     *
     * @return
     */
    public byte getProgress() {
        return progress;
    }
    
    /**
     *
     * @return
     */
    public byte getDaysToDueDate() {
        return days_to_dueDate;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getDependencies() {
        return dependencies;
    }
    
    /**
     *
     * @param responsible
     */
    public void setResponsible(Collaborator responsible) {
        this.responsible = responsible;
    }
    
    /**
     *
     * @param tasks_list
     */
    public void setTasksList(ArrayList<Task> tasks_list) {
        this.tasks_list = tasks_list;
    }
    
    /**
     *
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    /**
     *
     * @param meeting_name
     * @param fa_name
     */
    public void setID(int facility_id, String meeting_name, short number, byte zeros) {
        itemID = String.format("%d%s%0" + zeros + "d", facility_id, meeting_name,
                (int)number + 1);
    }

    public void setID(String id){
        this.itemID = id;
    }
    
    /**
     *
     * @param detail
     */
    public void setDetail(String detail) {
        this.detail = detail;
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
     * @param benefit
     */
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
    
    /**
     *
     * @param planned_start_date
     */
    public void setPlannedStartDate(LocalDate planned_start_date) {
        this.planned_start_date = planned_start_date;
    }
    
    /**
     *
     * @param planned_finish_date
     */
    public void setPlannedFinishDate(LocalDate planned_finish_date) {
        this.planned_finish_date = planned_finish_date;
    }
   
    /**
     *
     * @param real_finish_date
     */
    public void setRealFinishDate(LocalDate real_finish_date) {
        this.real_finish_date = real_finish_date;
    }

    /**
     *
     * @param date_created
     */
    protected void setDateCreated(LocalDateTime date_created) {
        this.date_created = date_created;
    }
    
    /**
     *
     */
    public void setDateModified() {
        this.date_modified = LocalDateTime.now();
    }
    
    /**
     *
     * @param tracking_by
     */
    public void setTrackingBy(String tracking_by) {
        this.tracking_by = tracking_by;
    }
   
    /**
     *
     * @param duration
     */
    public void setDuration(byte duration) {
        this.duration = duration;
    }
    
    /**
     *
     * @param progress
     */
    public void setProgress(byte progress) {
        this.progress = progress;
    }
 
    /**
     *
     * @param day_to_dueDate
     */
    public void setDaysToDueDate(byte days_to_dueDate) {
        this.days_to_dueDate = days_to_dueDate;
    }
    
    /**
     *
     */
    public void setDependencies() {
        this.dependencies = null;
    }
    
    public boolean validateDate(String Date){
        return true;
    }

}
