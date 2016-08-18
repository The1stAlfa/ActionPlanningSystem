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
    //aps Class Variables 
    private FuntionalArea f_area; // Example: Production, Accounting
    //************************************************************************
    private String username = null;
    private String password = null;        
    private String firstName;
    private String lastName;
    private String acronym_name; // This variable is exposed in the Action Plan
    private String charge;       // where the collaborator belongs.
    
    /** 
    * Class Empty constructor.
    */
    public Collaborator(){
        
    }

    /**
     *
     * @param username
     * @param password
     * @param names
     * @param charge
     */
    public Collaborator(String username, String password, String firstName,
            String lastName, String charge) {
        // Variables Initialization
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.charge = charge;
        setAcronymName();
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

    public String getLastNames() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
    
    private void setAcronymName(){
        acronym_name = firstName.substring(0,1);
        String[] names = lastName.split(" ");
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1);
    }
    
}
