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
public class Collaborator {
    private String username;
    private String password;        
    private String names;
    private String charge;
    
    public Collaborator(){
        
    }

    public Collaborator(String username, String password, String names, String charge) {
        this.username = username;
        this.password = password;
        this.names = names;
        this.charge = charge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
    
    
}
