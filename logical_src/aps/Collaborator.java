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
    private String acronym_name; // This variable is exposed in the Action Plan
    private String charge;       // where the collaborator belongs.
    private short employee_id;
    private String firstName;
    private String lastName;
    
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
    public Collaborator(String firstName, String lastName, String charge) {
        // Variables Initialization
        this.firstName = firstName;
        this.lastName = lastName;
        this.charge = charge;
        setAcronym_name();
    }

    public FuntionalArea getF_area() {
        return f_area;
    }

    public String getAcronym_name() {
        return acronym_name;
    }
    
    public String getCharge() {
        return charge;
    }

    public short getEmployee_id() {
        return employee_id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setF_area(FuntionalArea f_area) {
        this.f_area = f_area;
    }

    private void setAcronym_name(){
        acronym_name = firstName.substring(0,1);
        String[] names = lastName.split(" ");
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1).toUpperCase();
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setEmployee_id(short employee_id) {
        this.employee_id = employee_id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
