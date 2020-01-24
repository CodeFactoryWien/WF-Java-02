package sample;


import java.sql.Date;

public class invoice {
private String client_n;
private Date invoice_d;
private Date bookd_f;
private  Date bookd_e;
    private Integer room_id;
private Integer invoice_t;

    public invoice(String client_n, Date invoice_d, Date bookd_f, Date bookd_e, Integer room_id, Integer invoice_t) {
        this.client_n = client_n;
        this.invoice_d = invoice_d;
        this.bookd_f = bookd_f;
        this.bookd_e = bookd_e;
        this.room_id = room_id;
        this.invoice_t = invoice_t;
    }





    public String getClient_n() {
        return client_n;
    }

    public void setClient_n(String client_n) {
        this.client_n = client_n;
    }

    public Date getInvoice_d() {
        return invoice_d;
    }

    public void setInvoice_d(Date invoice_d) {
        this.invoice_d = invoice_d;
    }

    public Date getBookd_f() {
        return bookd_f;
    }

    public void setBookd_f(Date bookd_f) {
        this.bookd_f = bookd_f;
    }

    public Date getBookd_e() {
        return bookd_e;
    }

    public void setBookd_e(Date bookd_e) {
        this.bookd_e = bookd_e;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getInvoice_t() {
        return invoice_t;
    }

    public void setInvoice_t(Integer invoice_t) {
        this.invoice_t = invoice_t;
    }
}
