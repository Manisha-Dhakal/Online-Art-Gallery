package com.example.gallery.Modeldata;

public class ModelOrder {
    private  int id;
    private String pname, price, pdetails, image;

    public ModelOrder(int id, String pname, String price, String pdetails, String image) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.pdetails = pdetails;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPdetails() {
        return pdetails;
    }

    public void setPdetails(String pdetails) {
        this.pdetails = pdetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
