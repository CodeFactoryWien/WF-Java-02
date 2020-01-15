package sample;

public class Rooms {


    public int getRoom_id() {
        return Room_id;
    }

    public int getRoom_is_booked() {
        return room_is_booked;
    }

    public int getRoom_type_id() {
        return room_type_id;
    }

    private int Room_id;
    private int room_is_booked;
    private int room_type_id;
    public Rooms(int room_id, int room_is_booked, int room_type_id) {
        Room_id = room_id;
        this.room_is_booked = room_is_booked;
        this.room_type_id = room_type_id;
    }










}

