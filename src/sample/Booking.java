package sample;

import java.util.Date;


public class Booking {
   Date booking_start_date;
    Date booking_end_date;
    int booking_id;
    int client_id;
    int room_id;

    public Date getBooking_start_date() {
        return booking_start_date;
    }

    public Date getBooking_end_date() {
        return booking_end_date;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getRoom_id() {
        return room_id;
    }




    public Booking(Date booking_start_date, Date booking_end_date, int booking_id, int client_id, int room_id) {
        this.booking_start_date = booking_start_date;
        this.booking_end_date = booking_end_date;
        this.booking_id = booking_id;
        this.client_id = client_id;
        this.room_id = room_id;
    }


}
