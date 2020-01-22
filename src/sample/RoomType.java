package sample;

public class RoomType {
    public int roomtype_id;
    public String roomtype_name;
    public int room_price;
    public String room_capacity;
    public String room_size;

    // TODO: 21.01.2020 add room type ID
    public RoomType(int roomtype_id ,String roomtype_name,int room_price) {
        this.roomtype_id = roomtype_id;
        this.roomtype_name = roomtype_name;
        this.room_price = room_price;
        this.room_capacity = room_capacity;
        this.room_size = room_size;
    }

    public int getRoomtype_id() {
        return roomtype_id;
    }

    public String getRoomtype_name() {
        return roomtype_name;
    }

    public int getRoom_price() {
        return room_price;
    }

    public String getRoom_capacity() {
        return room_capacity;
    }

    public String getRoom_size() {
        return room_size;
    }

    @Override
    public String toString() {
        return getRoomtype_id()+" "+getRoomtype_name()+" "+"Price: "+getRoom_price();
    }
}
