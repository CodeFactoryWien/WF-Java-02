package sample;

public class Clients {
    public Integer getC_ID() {
        return C_ID;
    }

    public void setC_ID(Integer c_ID) {
        C_ID = c_ID;
    }

    public Clients(Integer c_ID, String firstN, String lastN, String email, String address) {
        C_ID = c_ID;
        this.firstN = firstN;
        this.lastN = lastN;
        this.email = email;
        this.address = address;
    }

    Integer C_ID;
    String firstN;
    String lastN;
    String email;
    String address;




    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }
    public void setLastN(String lastN) {
        this.lastN = lastN;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }



    public String getLastN() {
        return lastN;
    }
    public String getFirstN() {
        return firstN;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }





}
