package sample;

import java.sql.Date;

public class Invoices {

    Integer Invoice_id;
    Integer Client_id;
    Integer  Invoice_total;
    java.util.Date Invoice_Date;

    public Invoices(Integer invoice_id, Integer client_id, Integer invoice_total, Date invoice_Date) {
        Invoice_id = invoice_id;
        Client_id = client_id;
        Invoice_total = invoice_total;
        Invoice_Date = invoice_Date;
    }

    public Integer getInvoice_id() {
        return Invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        Invoice_id = invoice_id;
    }

    public Integer getClient_id() {
        return Client_id;
    }

    public void setClient_id(Integer client_id) {
        Client_id = client_id;
    }

    public Integer getInvoice_total() {
        return Invoice_total;
    }

    public void setInvoice_total(Integer invoice_total) {
        Invoice_total = invoice_total;
    }

    public java.util.Date getInvoice_Date() {
        return Invoice_Date;
    }

    public void setInvoice_Date(Date invoice_Date) {
        Invoice_Date = invoice_Date;
    }

    @Override
    public String toString() {
        return "INVOICE ID:"+" "+getInvoice_id()+" "+"CLIENT ID:"+" "+getClient_id()+" "+"DATE:"+" "+getInvoice_Date()+" "+"TOTAL COST: "+getInvoice_total();
    }
}

