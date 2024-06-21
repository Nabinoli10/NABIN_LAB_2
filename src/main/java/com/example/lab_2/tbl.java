package com.example.lab_2;

import javafx.scene.control.TableColumn;

public class tbl {

    private int ID;
    private String Username;

    private String College;

    private String Password;

    public tbl(int ID, String username, String college, String password) {
        this.ID = ID;
        Username = username;
        College = college;
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
