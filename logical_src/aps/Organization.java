/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class Organization {
    //aps Class Variables 
    private ArrayList<Facility> facilities;
    //************************************************************************
    private final String brand_name = "Holcim";
       
    /**
     *
     */
    public Organization(){
        setFacilities();
    }

    /**
     *
     * @return
     */
    public ArrayList<Facility> getFacilities() {
        return facilities;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return brand_name;
    }   

    /**
     *
     * @param facilities
     */
    public void setFacilities() {
        facilities = new ArrayList();
    }
}
