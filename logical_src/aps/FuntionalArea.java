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
public class FuntionalArea {
    private String name;
    private String id;

    public FuntionalArea(String name) {
        this.name = name;
        setId(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    private void setId(String name) {
        this.id = "";
    } 
}
