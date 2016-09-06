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
    private short om_number;  // om = Operational Measure
    private String om_detail;
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
    private byte day_to_dueDate;
    private ArrayList<String> dependencies;  
    
    public Action(){
        
    }
    
    /** 
    * Class Empty constructor.
    */
    public Action(String met, short inc, byte length){
        setID(met, inc, length);
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
    public Action(String meeting_acronym, short om_number, String om_detail, 
            Collaborator responsable, LocalDate planned_start_date, 
            LocalDate planned_finish_date,String comments, String benefit) {
        setID(meeting_acronym, om_number, (byte)3);
        this.om_number = om_number;
        this.om_detail = om_detail;
        this.responsible = responsable;
        this.planned_start_date = planned_start_date;
        this.planned_finish_date = planned_finish_date;
        this.comments = comments;
        this.benefit = benefit;
        setStatus();
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
    public ArrayList<Task> getTasks_list() {
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
    public short getOm_number() {
        return om_number;
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
    public LocalDate getPlanned_start_date() {
        return planned_start_date;
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
     * @return
     */
    public LocalDate getReal_finish_date() {
        return real_finish_date;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getDate_created() {
        return date_created;
    }
    
    /**
     *
     * @return
     */
    public LocalDateTime getDate_modified() {
        return date_modified;
    }
    
    /**
     *
     * @return
     */
    public String getTracking_by() {
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
    public byte getDay_to_dueDate() {
        return day_to_dueDate;
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
    public void setTasks_list(ArrayList<Task> tasks_list) {
        this.tasks_list = tasks_list;
    }
    
    /**
     *
     */
    public void setStatus() {
        this.status = this.status.IN_PROCESS;
    }
    
    /**
     *
     * @param meeting_name
     * @param fa_name
     */
    public void setID(String meeting_name, short inc, byte id_length) {
        itemID = String.format("%s%0" + id_length + "d", meeting_name,
                (int)inc + 1);
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
     * @param om_detail
     */
    public void setOm_detail(String om_detail) {
        this.om_detail = om_detail;
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
    public void setPlanned_start_date(LocalDate planned_start_date) {
        this.planned_start_date = planned_start_date;
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
     * @param real_finish_date
     */
    public void setReal_finish_date(LocalDate real_finish_date) {
        this.real_finish_date = real_finish_date;
    }

    /**
     *
     * @param date_created
     */
    protected void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }
    
    /**
     *
     */
    public void setDate_modified() {
        this.date_modified = LocalDateTime.now();
    }
    
    /**
     *
     * @param tracking_by
     */
    public void setTracking_by(String tracking_by) {
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
    public void setDay_to_dueDate(byte day_to_dueDate) {
        this.day_to_dueDate = day_to_dueDate;
    }
    
    /**
     *
     */
    public void setDependencies() {
        this.dependencies = null;
    }

}
