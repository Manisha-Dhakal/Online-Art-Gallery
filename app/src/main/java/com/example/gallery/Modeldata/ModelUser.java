package com.example.gallery.Modeldata;

public class ModelUser {
    private int id;
    private String name;
    private String gender;
    private String phoneno;
    private String address;
    private String email;
    private String psw;

    public ModelUser(int id, String name, String gender, String phoneno, String address, String email, String psw) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;
        this.address = address;
        this.email = email;
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
