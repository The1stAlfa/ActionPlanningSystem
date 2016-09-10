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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Terminal{
    private byte id;
    private User _user;
    private final Random _RANDOM;
    private final Scanner console;
    private final int LINE_JUMPS = 100;
    private DataBase planB_DB;
    private static final String SALT = "MtO27:37";
    
    public Terminal() throws Exception {
        _RANDOM = new Random();
        this.id = (byte)_RANDOM.nextInt();
        if(this.id<0)
            id = (byte)(id *(-1));
        this.console = new Scanner(System.in);
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
   
    public boolean login(String username, String password) throws NoSuchAlgorithmException, SQLException, Exception{
        boolean isAuthenticated = false;
        int count;
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        String query = "SELECT COUNT(*) AS is_user FROM planb.user WHERE username='"
                +username+"' AND password='"+hashedPassword+"';";
        planB_DB.connection();
        ResultSet rs = planB_DB.selectQuery(query);
        rs.next();
        count = rs.getInt("is_user");
        if(count == 1){
            _user = new User();
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
            _user.setEmployeeId((short) rs.getInt("collaborator_id"));
        }
        planB_DB.disconnection();
        return isAuthenticated;
    }
    
    public boolean signup(String username, String password) throws NoSuchAlgorithmException{
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        return false;
    }
    
    public DefaultTableModel getTableContent(ActionItemFilter filter, String meeting) throws Exception{
        String id, responsible, date, status, duration;
        ActionPlan plan = getActionPlan(meeting);
        ArrayList<Action> list = new ArrayList();
        DefaultTableModel dm = new DefaultTableModel(null, new String [] {
                "id","Action Detail", "Owner", "Comments", 
                "Planned Start Date", "Planned Finish Date", "Real Finish Date",
                "Progress", "Status", "Duration" 
            });
        
        if(filter.equals(ActionItemFilter.ALL)){
            String query = "SELECT id,item_id,detail,comments,p_start_date,"
                    + "p_finish_date, r_finish_date,progress,status,"
                    + "duration FROM planb.action;";
            planB_DB.connection();
            ResultSet rs = planB_DB.selectQuery(query);
            if(rs != null){
                while(rs.next()){
                    Action action = new Action();
                    Vector row = new Vector();
                    id = rs.getString("id");
                    row.add(rs.getString("item_id"));
                    action.setID(rs.getString("item_id"));
                    row.add(rs.getString("detail"));
                    action.setDetail(rs.getString("detail"));
                    responsible = getOwnerAcronym(id);
                    row.add(responsible);
                    action.setResponsible(getCollaborator(responsible));
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
                    dm.addRow(row);
                    list.add(action);
                }
                plan.setActionList(list);
            }
            planB_DB.disconnection();
        }
        return dm;
    }
    
    public String getOwnerAcronym(String actionID) throws Exception{
        String query = "SELECT acronym_name FROM planb.collaborator INNER JOIN"
                + " planb.collaborator_action ON "
                + "collaborator.employee_id=collaborator_action.collaborator_id"
                + " AND collaborator_action.action_id ="+actionID+";";
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
    
    public ActionPlan getActionPlan(String meeting){
        return new ActionPlan();
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
}
