package sample;


import java.sql.Date;

public class Booking {
    private Integer client_ID;
    private Integer room_ID;
    private Date f_Date;
    private Date e_Date;
    private String client_fname;
    private String client_Lname;


//setter

    public void setClient_fname(String client_fname) {
        this.client_fname = client_fname;
    }
    public void setClient_ID(Integer client_ID) {
        this.client_ID = client_ID;
    }
    public void setClient_Lname(String client_Lname) {
        this.client_Lname = client_Lname;
    }
    public void setRoom_ID(Integer room_ID) {
        this.room_ID = room_ID;
    }
    public void setF_Date(Date f_Date) {
        this.f_Date = f_Date;
    }
    public void setE_Date(Date e_Date) {
        this.e_Date = e_Date;
    }


// getter
    public String getClient_Lname() {
        return client_Lname;
    }
    public Integer getRoom_ID() {
        return room_ID;
    }
    public Integer getClient_ID() {
        return client_ID;
    }
    public String getClient_fname() {
        return client_fname;
    }
    public Date getF_Date() {
        return f_Date;
    }
    public Date getE_Date() {
        return e_Date;
    }


   //COns

    public Booking(Integer client_ID, String client_fname, String client_Lname, Integer room_ID, Date f_Date, Date e_Date) {
        this.client_ID = client_ID;
        this.client_fname = client_fname;
        this.client_Lname = client_Lname;
        this.room_ID = room_ID;
        this.f_Date = f_Date;
        this.e_Date = e_Date;
    }



}
