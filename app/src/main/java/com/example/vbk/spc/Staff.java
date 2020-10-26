package com.example.vbk.spc;

/**
 * Created by vbk on 23/12/17.
 */

public class Staff {
    private String Name;
    private String Description;
    private String Image;
    private String Password;


    public Staff(){

    }

public Staff(String name,String description,String image,String password){

}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
