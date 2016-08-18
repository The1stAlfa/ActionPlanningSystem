/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private ArrayList<String> access_list;
    private byte employee_id;
    
    public User() {
        this.id = 0;
    }
  
    public User(int id, String username, String password, String role, ArrayList<String> access_list, byte employee_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.access_list = access_list;
        this.employee_id = employee_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccess_list(ArrayList<String> access_list) {
        this.access_list = access_list;
    }

    public void setEmployee_id(byte employee_id) {
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public ArrayList<String> getAccess_list() {
        return access_list;
    }

    public byte getEmployee_id() {
        return employee_id;
    }
}
