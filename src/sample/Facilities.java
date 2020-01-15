package sample;

public class Facilities {
    int is_balcony;
    int is_coffee_machine;
    int is_tv;
    int is_wifi;
    public Facilities(int is_balcony, int is_coffee_machine, int is_tv, int is_wifi) {
        this.is_balcony = is_balcony;
        this.is_coffee_machine = is_coffee_machine;
        this.is_tv = is_tv;
        this.is_wifi = is_wifi;
    }

    int facility_id;

    public int getIs_balcony() {
        return is_balcony;
    }

    public int getIs_coffee_machine() {
        return is_coffee_machine;
    }

    public int getIs_tv() {
        return is_tv;
    }

    public int getIs_wifi() {
        return is_wifi;
    }



}
