package sample;

public class Rooms {



    private int room_id;
    private boolean availability;
    private boolean balcony;
    private boolean coffeemachine;
    private boolean tv;
    private boolean wifi;

    public Rooms(int room_id, boolean availability, boolean balcony, boolean coffeemachine, boolean tv, boolean wifi) {
        this.room_id = room_id;
        this.availability = availability;
        this.balcony = balcony;
        this.coffeemachine = coffeemachine;
        this.tv = tv;
        this.wifi = wifi;
    }


    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }



    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public void setCoffeemachine(boolean coffeemachine) {
        this.coffeemachine = coffeemachine;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }







    public boolean isBalcony() {
        return balcony;
    }

    public boolean isCoffeemachine() {
        return coffeemachine;
    }

    public boolean isTv() {
        return tv;
    }

    public boolean isWifi() {
        return wifi;
    }





















}

