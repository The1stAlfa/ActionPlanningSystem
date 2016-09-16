/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author AI-Saac
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import aps.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Terminal{
    private byte id;
    private User _user;
    private DataBase planB_DB;
    private static final String SALT = "MtO27:37";
    
    public Terminal() throws Exception {
        _user = new User();
        planB_DB = new DataBase();
        boolean j = planB_DB.connection();
    }

    public void setUser(User _user) {
        this._user = _user;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }

    public User getUser() {
        return _user;
    }
    
    public ArrayList<String> defineAccessList(String accesses){
        ArrayList<String> _list = new ArrayList();
	char comparator = '-';
	int counter = -1;
	
                for(int i=0;i<accesses.length();i++){
			if(accesses.charAt(i) == comparator){
				_list.add(accesses.substring(counter+1,i));
				counter = i;	
			}
		}
		
                return _list;
    }
   
    public void loadBusinessInformation() throws Exception{
        String query;
        Facility facility = new Facility();
        
        query = "SELECT id, name, acronym, city FROM planb.facility INNER JOIN "
                + "planb.facility_collaborator ON id = facility_id AND "
                + "collaborator_id="+(int)_user.getEmployeeId()+";";
        planB_DB.connection();
        ResultSet rs = planB_DB.selectQuery(query);
        rs.next();
        if(rs != null){
            facility.setId(rs.getString("id"));
            facility.setName(rs.getString("name"));
            facility.setAcronym(rs.getString("acronym"));
            facility.setCity(rs.getString("city"));
            facility.setCollaboratorList(getCollaborators(facility.getId()));
            facility.setMeetings(getMeetings(facility.getId()));
            APSys.org.getFacilities().add(facility);
            
        }
        planB_DB.disconnection();
        
    }
    
    public boolean login(String username, String password) throws NoSuchAlgorithmException, SQLException, Exception{
        boolean isAuthenticated = false;
        int count;
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        String query = "SELECT COUNT(*) AS is_user FROM planb.user WHERE username='"
                +username+"' AND password='"+hashedPassword+"';";
        planB_DB.connection();
        ResultSet rs = planB_DB.selectQuery(query);
       if(rs != null){
            rs.next();
            count = rs.getInt("is_user");
            if(count == 1){
                isAuthenticated = true;
                query = "SELECT email,role from planb.user where username='"+username+"';";
                rs = planB_DB.selectQuery(query);
                rs.next();
                _user.setUsername(username);
                _user.setEmail(rs.getString("email"));
                _user.setRole(getRole(rs.getInt("role")));
                query = "SELECT collaborator_id FROM planb.user_collaborator WHERE username='"+username+"';";
                rs = planB_DB.selectQuery(query);
                rs.next();
                _user.setEmployeeId(rs.getInt("collaborator_id"));
            }
       }
        planB_DB.disconnection();
        return isAuthenticated;
    }
    
    public boolean signup(String username, String password) throws NoSuchAlgorithmException{
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        return false;
    }
    
    public Object[] getTableContent(ActionItemFilter filter, String meeting) throws Exception{
        String id, responsible, date, status, duration;
        ActionPlan plan;
        if(APSys.org.getFacility("01").searchMeeting(meeting) != null)
            plan = APSys.org.getFacility("01").searchMeeting(meeting).getActionPlan();
        else
            plan = new ActionPlan();
        ArrayList<Action> list = new ArrayList();
        DefaultTableModel dm = new DefaultTableModel(null, new String [] {
                "Id","Responsible", "Detail", "Comments", 
                "P.Start Date", "P.Finish Date", "R.Finish Date",
                "Progress", "Status", "Duration", ""
            }){
                public boolean isCellEditable(int row, int column){
                    if(column == 10)
                        return true;
                    return false;
                }
            };
        
        if(filter.equals(ActionItemFilter.ALL)){
            String query = "SELECT id,item_id,detail,comments,p_start_date,"
                    + "p_finish_date, r_finish_date,progress,status,"
                    + "timestampdiff(day,p_start_date,p_finish_date) AS duration "
                    + "FROM planb.action INNER JOIN planb.actionplan_action ON "
                    + "id=action_id and actionplan_id="+plan.getId()+";";
            planB_DB.connection();
            ResultSet rs = planB_DB.selectQuery(query);
            if(rs != null){
                while(rs.next()){
                    Action action = new Action();
                    Vector row = new Vector();
                    id = rs.getString("id");
                    row.add(rs.getString("item_id"));
                    action.setID(rs.getString("item_id"));
                    responsible = getOwnerAcronym(id);
                    row.add(responsible);
                    action.setResponsible(getCollaborator(responsible));
                    row.add(rs.getString("detail"));
                    action.setDetail(rs.getString("detail"));
                    row.add(rs.getString("comments"));
                    action.setComments(rs.getString("comments"));
                    date = rs.getString("p_start_date");
                    row.add(date);
                    action.setPlannedStartDate(parseDate(date));
                    date = rs.getString("p_finish_date");
                    row.add(date);
                    action.setPlannedFinishDate(parseDate(date));
                    date = rs.getString("r_finish_date");
                    row.add(date);
                    action.setRealFinishDate(parseDate(date));
                    row.add(rs.getString("progress"));
                    action.setProgress((byte) Integer.parseInt(rs.getString("progress")));
                    status = getStatusName(rs.getInt("status")); 
                    row.add(status);
                    action.setStatus(Status.valueOf(status));
                    duration = rs.getString("duration"); 
                    row.add(duration);
                    if(duration == null)
                        action.setDuration((byte)0);
                    else
                        action.setDuration((byte) Integer.parseInt(duration));
                    row.add(null);
                    dm.addRow(row);
                    list.add(action);
                }
                plan.setActionList(list);
            }
            planB_DB.disconnection();
        }
        return new Object[]{plan,dm};
    }
    
    public String getOwnerAcronym(String actionID) throws Exception{
        String query = "SELECT acronym_name FROM planb.collaborator INNER JOIN"
                + " planb.collaborator_action ON employee_id=collaborator_id"
                + " AND action_id ="+actionID+";";
        planB_DB.connection();
        ResultSet rs = planB_DB.selectQuery(query);
        rs.next();
        String acronym = rs.getString("acronym_name"); 
        planB_DB.disconnection();
        return acronym;
    }
    
    public String getStatusName(int status){
        Status st[] = Status.values();
        for(Status s:st){
            if(s.getValue()==status)
                return s.toString();
        }
        return null;
    }
    
    public Collaborator getCollaborator(String collaborator){
        return null;
    }
    
    public LocalDate parseDate(String date){
        if(date != null)
            return LocalDate.parse(date);
        return null;
    }
    
    private static String generateHash(String input) throws NoSuchAlgorithmException{
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++)
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        
        return sb.toString();
    }
    
    private Role getRole(int role){
        Role r[] = Role.values();
        for(Role _r:r){
            if(_r.getValue() == role)
                return _r;
        }
        return null;
    }
    
    private ArrayList getCollaborators(String id) throws SQLException{
        int collaborator_id,count=0;
        String query;
        Array result;
        ArrayList<Collaborator> list = new ArrayList<>();
        
        query = "SELECT collaborator_id FROM planb.facility_collaborator where id='"+id+"';";
        ResultSet rs = planB_DB.selectQuery(query);
        if(rs != null){
            result = rs.getArray("collaborator_id");
            int [] collaborators = (int[])result.getArray();
            while(count == collaborators.length){
                collaborator_id = collaborators[count];
                query = "SELECT firstname, middlename,lastname,acronym_name,charge FROM planb.collaborator where employee_id="+collaborator_id+";";
                rs = planB_DB.selectQuery(query);
                while(rs.next()){
                    Collaborator collaborator = new Collaborator();
                    collaborator.setEmployeeId(collaborator_id);
                    collaborator.setFirstName(rs.getString("firstname"));
                    collaborator.setMiddleName(rs.getString("middlename"));
                    collaborator.setLastName(rs.getString("lastname"));
                    collaborator.setCharge(rs.getString("charge"));
                    list.add(collaborator);                
                }
                count++;
            }
            return list;
        }
        return null;
    }
    
    private ArrayList getMeetings(String facility_id) throws SQLException{
        int count=0;
        String query;
        Object[] result;
        ArrayList<Meeting> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        result = getMeetingIds(facility_id);      
        if(result != null){
            while(count != result.length){
                query = "SELECT name,acronym,purpose,date_created FROM planb.meeting"
                        + " where meeting_id="+(int)result[count]+";";
                ResultSet rs = planB_DB.selectQuery(query);
                rs.next();
                Meeting meeting = new Meeting();
                meeting.setName(rs.getString("name"));
                meeting.setAcronym(rs.getString("acronym"));
                meeting.setPurpose(rs.getString("purpose"));
                meeting.setDateCreated(LocalDateTime.parse(rs.getString("date_created").substring(0,19),formatter));
                meeting.setActionPlan(getActionPlan(Integer.parseInt(result[count].toString())));
                list.add(meeting);   
                count++;
            }
            return list;
        }
        return null;
    }
    
    private ActionPlan getActionPlan(int meeting_id) throws SQLException{
        String query;
        ActionPlan action_plan = new ActionPlan();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        query = "SELECT id, date_created, date_modified, execution "
                + "FROM planb.actionplan INNER JOIN  planb.meeting_actionplan "
                + "ON id=actionplan_id AND meeting_id='"+meeting_id+"';";

        ResultSet rs = planB_DB.selectQuery(query);
        if(rs != null){
            rs.next();
            action_plan.setId((short) rs.getInt("id"));
            action_plan.setDateCreated(LocalDateTime.parse(rs.getString("date_created").substring(0,19), formatter));
            action_plan.setDateModified(LocalDateTime.parse(rs.getString("date_modified").substring(0,19), formatter));
            action_plan.setExecution((byte)rs.getInt("execution"));
            query = "SELECT date_modified, actions, actions_cancelled,"
                + "actions_completed_after_app,actions_completed_app,"
                + "actions_in_progress,actions_near_to_due_day,actions_overdue "
                + "FROM planb.apsummary INNER JOIN planb.actionplan_apsummary ON "
                + "id=apsummary_id and actionplan_id="+action_plan.getId()+";";
            rs = planB_DB.selectQuery(query);
            if(rs != null){
                rs.next();
                APSummary apsummary = new APSummary();
                apsummary.setDate_modified(LocalDateTime.parse(rs.getString("date_modified").substring(0,19), formatter));
                apsummary.setActions(rs.getInt("actions"));
                apsummary.setActionsCompletedAfterApp(rs.getInt("actions_completed_after_app"));
                apsummary.setActionsCompletedApp(rs.getInt("actions_completed_app"));
                apsummary.setActionsInProgress(rs.getInt("actions_in_progress"));
                apsummary.setActionsNearToDueDay(rs.getInt("actions_near_to_due_day"));
                apsummary.setActionsCancelled(rs.getInt("actions_cancelled"));
                apsummary.setActionsOverdue(rs.getInt("actions_overdue"));
                action_plan.setZeros(rs.getInt("actions"));
                action_plan.setSummary(apsummary);
                query = "SELECT employee_id, firstname, middlename, lastname, "
                        + "acronym_name, charge FROM planb.collaborator INNER JOIN"
                        + " planb.collaborator_actionplan ON "
                        + "employee_id=collaborator_id AND actionplan_id="+(int)action_plan.getId()+";";
                rs = planB_DB.selectQuery(query);
                if(rs != null){
                    rs.next();
                    Collaborator owner = new Collaborator();
                    owner.setEmployeeId(rs.getInt("employee_id"));
                    owner.setFirstName(rs.getString("firstname"));
                    owner.setMiddleName(rs.getString("middlename"));
                    owner.setLastName(rs.getString("lastname"));
                    owner.setAcronymName(rs.getString("acronym_name"));
                    owner.setCharge(rs.getString("charge"));
                    action_plan.setOwner(owner);
                    action_plan.setCurrentDate(LocalDateTime.now());
                }
            }
            return action_plan;
        }
        return null;
    }
    
    private Object[] getMeetingIds(String facility_id) throws SQLException{
        String query;
        ArrayList list = new ArrayList();
        
        query = "SELECT meeting_id FROM planb.facility_meeting where facility_id='"+facility_id+"';";
        ResultSet rs = planB_DB.selectQuery(query);
        if(rs != null){
            while(rs.next())
                list.add(rs.getInt("meeting_id"));
            return list.toArray();
        }
        return null;
    }
    
    public Object[] getMeetingsNames(){
        return APSys.org.getFacility("01").getMeetingsNames().toArray();
    }
}
