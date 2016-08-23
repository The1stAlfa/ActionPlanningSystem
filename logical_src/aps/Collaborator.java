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
    private short employee_id;
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
     * @param firstName
     * @param lastName
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
        setAcronym_name();
    }

    /**
     *
     * @return
     */
    public FuntionalArea getF_area() {
        return f_area;
    }

    /**
     *
     * @return
     */
    public short getEmployee_id() {
        return employee_id;
    }
    
    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return
     */
    public String getCharge() {
        return charge;
    }

    /**
     *
     * @param f_area
     */
    public void setF_area(FuntionalArea f_area) {
        this.f_area = f_area;
    }

    public void setEmployee_id(short employee_id) {
        this.employee_id = employee_id;
    }
    
    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     *
     * @param password
     */
    protected void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *
     * @param charge
     */
    public void setCharge(String charge) {
        this.charge = charge;
    }
    
    private void setAcronym_name(){
        acronym_name = firstName.substring(0,1);
        String[] names = lastName.split(" ");
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1);
    }
    
}
