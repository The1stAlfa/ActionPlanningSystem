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


public class Terminal{
    private byte id;
    private User _user;
    private final Random _RANDOM;
    private final Scanner console;
    private final int LINE_JUMPS = 100;
    
    
    public Terminal() {
        _RANDOM = new Random();
        this.id = (byte)_RANDOM.nextInt();
        if(this.id<0)
            id = (byte)(id *(-1));
        this.console = new Scanner(System.in);
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
        
    }
}
