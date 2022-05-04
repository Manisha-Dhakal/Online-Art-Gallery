package com.example.gallery.Modeldata;

public class Modelcategory {
    String pname, pdetail;
    int pimage;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdetail() {
        return pdetail;
    }

    public void setPdetail(String pdetail) {
        this.pdetail = pdetail;
    }

    public int getPimage() {
        return pimage;
    }

    public void setPimage(int pimage) {
        this.pimage = pimage;
    }

    public Modelcategory(String pname, String pdetail, int pimage) {
        this.pname = pname;
        this.pdetail = pdetail;
        this.pimage = pimage;


    }
}
