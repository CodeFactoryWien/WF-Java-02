package sample;

import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class Nbooking {
    private  String clientn;

    public String getClientn() {
        return clientn;
    }

    public void setClientn(String clientn) {
        this.clientn = clientn;
    }

    public String getClientln() {
        return clientln;
    }

    public void setClientln(String clientln) {
        this.clientln = clientln;
    }

    public String getClientem() {
        return clientem;
    }

    public void setClientem(String clientem) {
        this.clientem = clientem;
    }

    public String getClientadd() {
        return clientadd;
    }

    public void setClientadd(String clientadd) {
        this.clientadd = clientadd;
    }

    public Date getBookdf() {
        return bookdf;
    }

    public void setBookdf(Date bookdf) {
        this.bookdf = bookdf;
    }

    public Date getBookde() {
        return bookde;
    }

    public void setBookde(Date bookde) {
        this.bookde = bookde;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    private  String clientln;
    private  String clientem;

    private  String clientadd;

    public Nbooking(String clientn, String clientln, String clientem, String clientadd, Date bookdf, Date bookde, Integer r_id) {
        this.clientn = clientn;
        this.clientln = clientln;
        this.clientem = clientem;
        this.clientadd = clientadd;
        this.bookdf = bookdf;
        this.bookde = bookde;
        this.r_id = r_id;
    }

    private Date bookdf;
    private Date bookde;
    private Integer r_id;





}
