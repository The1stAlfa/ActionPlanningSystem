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
import java.sql.ResultSet;


public class Terminal{
    private byte id;
    private User _user;
    private final Random _RANDOM;
    private final Scanner console;
    private final int LINE_JUMPS = 100;
    private DataBase planB_DB;
    
    
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
    
    /*
    public User searchUser(String usrname){
        User temp_usr = new User();
        FileReader usrDB;
	String record = null,file = "database/userMap.txt";
		StringTokenizer usr_seek;
		{	try{
				usrDB = new FileReader(file);//Abre el archivo
				BufferedReader br = new BufferedReader(usrDB);//Crea un objeto para leer el archivo
				while((record=br.readLine())!= null){
					usr_seek = new StringTokenizer(record,";");
					temp_usr.setUsername(usr_seek.nextToken());
                                        if(temp_usr.getUsername().equalsIgnoreCase(usrname)){
                                            temp_usr.setId(Integer.parseInt(usr_seek.nextToken()));
                                            usrDB.close();
                                            break;
                                        }
                                        else
                                            usr_seek.nextToken();				
				}
				usrDB.close();
                                if(temp_usr.getId()!= 0){
                                        try{
                                            file = "database/user.txt";
                                            usrDB = new FileReader(file);
                                            br = new BufferedReader(usrDB);
                                            while((record=br.readLine())!= null){
                                                usr_seek = new StringTokenizer(record,";");
                                                if(temp_usr.getId() == Integer.parseInt(usr_seek.nextToken())){
                                                    temp_usr.setUsername(usr_seek.nextToken());
                                                    temp_usr.setPassword(usr_seek.nextToken());
                                                    temp_usr.setRole(usr_seek.nextToken());
                                                    temp_usr.setAccess_list(defineAccessList(usr_seek.nextToken()));
                                                    temp_usr.setEmployee_id(Byte.parseByte(usr_seek.nextToken()));
                                                    usrDB.close();
                                                    break;
                                                }
                                                else
                                                    usr_seek.nextToken();				
                                            }
                                            usrDB.close();
                                        }
                                        catch(IOException e){
                                            temp_usr = null;
                                            System.out.println("Database fail connection");
                                        }
                                }
                                else
                                    temp_usr = null;
			}
			catch(IOException e){
				temp_usr = null;
			}
		}
        return temp_usr;
    }
    */
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
   /* 
    public boolean authenticate(String usrname, String pswd){
        
        _user = searchUser(usrname);        
        if(_user != null){
            if(_user.getPassword().equals(pswd))
                return true;
            else
                System.out.println("Wrong Password");
        }
        System.out.println("system Login incorrect");
        return false;
        
    }*/
    
    public Object[][] getTableContent(ActionItemFilter filter) throws Exception{
        ArrayList<Object[]> list = new ArrayList<>();
        Object[][] o = null;
        String id, om, detail, owner, comments, p_start_date, p_finish_date,
                r_finish_date, progress, status, duration;
        
        if(filter.equals(ActionItemFilter.ALL)){
            String query = "SELECT id,item_id, om_number, om_detail, comments,p_start_date, p_finish_date, r_finish_date, progress,status, duration FROM planb.actionitem;";
            planB_DB.connection();
            ResultSet rs = planB_DB.selectQuery(query);
            if(rs != null){
                while(rs.next()){
                    ArrayList<Object> l = new ArrayList();
                    id = rs.getString("id");
                    l.add(rs.getString("item_id"));
                    l.add(rs.getString("om_number"));
                    l.add(rs.getString("om_detail")) ;
                    l.add(getOwnerAcronym(id));
                    l.add(rs.getString("comments"));
                    l.add(rs.getString("p_start_date"));
                    l.add(rs.getString("p_finish_date"));
                    l.add(rs.getString("r_finish_date"));
                    l.add(rs.getString("progress"));
                    l.add(getStatusName(rs.getInt("status")));
                    l.add(rs.getString("duration"));
                    list.add(l.toArray());
                }
                o = new Object[list.size()][11];
                for(int i=0;i<o.length;i++){
                    for(int j=0;j<11;j++){
                        o[i][j] = list.get(i);
                    }
                }
            }
            planB_DB.disconnection();
        }
        return o;
    }
    
    public String getOwnerAcronym(String actionItemID) throws Exception{
        String query = "SELECT acronym_name FROM planb.collaborator INNER "
                + "JOIN planb.collaborator_actionitem ON "
                + "collaborator.employee_id=collaborator_actionitem.collaborator_id "
                + "AND collaborator_actionitem.actionitem_id ="+actionItemID+";";
        DataBase db = new DataBase();
        db.connection();
        ResultSet rs = db.selectQuery(query);
        String acronym = rs.getString("acronym_name"); 
        db.disconnection();
        return acronym;
    }
    
    public String getStatusName(int status){
        Status st[] = Status.values();
        for(Status s:st){
            if(s.getValue()==status){
                return s.toString();
            }
        }
        return null;
    }
}
