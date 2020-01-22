package sample;

public class Clients {

    String client_address;
    String client_email;
    String client_first_name;
    String client_last_name;
    Integer client_id;

    public Clients(String client_first_name, String client_last_name,String client_email,String client_address) {
        this.client_address = client_address;
        this.client_email = client_email;
        this.client_first_name = client_first_name;
        this.client_last_name = client_last_name;
          }

    public String getClient_email() {
        return client_email;
    }

    public String getClient_first_name() {
        return client_first_name;
    }

    public String getClient_last_name() {
        return client_last_name;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public void setClient_first_name(String client_first_name) {
        this.client_first_name = client_first_name;
    }

    public void setClient_last_name(String client_last_name) {
        this.client_last_name = client_last_name;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_address() {
        return client_address;
    }

    @Override
    public String toString() {
        return  getClient_first_name()+" "+getClient_last_name()+getClient_email()+getClient_address();
    }
}
