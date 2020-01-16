package sample;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DbConnection {

    private Connection conn;
    private static final String roomTable = "Rooms";
    private static final String facilityTable = "Facilities";
    private static final String bookingsTable = "Booking";
    private static final String clientsTable = "clients";

    public DbConnection() throws SQLException, ClassNotFoundException {

        //connecting to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to the CLASSES - Database...");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hoteldb" +
                        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                ""
        );
        conn.setAutoCommit(true);
        conn.setReadOnly(false);
    }

    //kills connection
    public void closeDb() throws SQLException {
        conn.close();
    }

    //select all rooms from the data base
    public List<Rooms> roomsList() throws SQLException {
        String sql = "SELECT * FROM " + roomTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Rooms> list = new ArrayList<>();

        while (rs.next()) {
            int room_id = rs.getInt("room_id");
            int room_is_booked = rs.getInt("room_is_booked");
            int room_type_id = rs.getInt("room_type_id");

            list.add(new Rooms(room_id, room_is_booked, room_type_id));
        }
        pstmnt.close();
        return list;
    }

    //select all the all facilities
    public List<Facilities> facilitiesList() throws SQLException {

        String sql = "SELECT * FROM " + facilityTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();


        while (rs.next()) {
            int is_balcony = rs.getInt("is_balcony");
            int is_coffee_machine = rs.getInt("is_coffee_machine");
            int is_tv = rs.getInt("is_tv");
            int is_wifi = rs.getInt("is_wifi");
            List<Facilities> listFacilities = new ArrayList<>();

            // for condetions (( can be added here ))
            listFacilities.add(new Facilities(is_balcony, is_coffee_machine, is_tv, is_wifi));
        }
        pstmnt.close();
        return facilitiesList();
    }

    // booking data
    public List<Booking> bookingList() throws SQLException {
        String sql = "SELECT * FROM " + bookingsTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();


        Date booking_start_date = rs.getDate("booking_start_date");
        Date booking_end_date = rs.getDate("booking_end_date");
        int booking_id = rs.getInt("booking_id");
        int client_id = rs.getInt("client_id");
        int room_id = rs.getInt("room_id");
        List<Booking> listBookings = new ArrayList<>();
        return listBookings;
    }

    // Clients data
    public List<Clients> clientsList() throws SQLException {
        String sql = "SELECT * FROM " + clientsTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Clients> list = new ArrayList<>();
        while (rs.next()) {
            String client_first_name = rs.getString("client_first_name");
            String client_email = rs.getString("client_email");
            String client_last_name = rs.getString("client_last_name");
            list.add(new Clients("", client_email, client_last_name, client_first_name, null));
        }
        pstmnt.close();
        return list;
    }
}

//todo look later for search

// SELECT client_first_name FROM `clients` WHERE client_first_name = "JOHN"
//String sqlsearch = "SELECT client_first_name FROM" + roomTable + "WHERE"  + "client_first_name ="+s;
//Search s = new Search("John");

   /* public List<Clients> clientsList2() throws SQLException {
        Search s = new Search("John");
        String sqlsearch = "SELECT client_first_name FROM" + roomTable + "WHERE" + "client_first_name =" + s;
        PreparedStatement pstmnt2 = conn.prepareStatement(sqlsearch);
        ResultSet rst = pstmnt2.executeQuery();
        List<Clients> list2 = new ArrayList<>();
        while (rst.next()) {
            String client_email = rst.getString("client_email");
            String client_last_name = rst.getString("client_last_name");
            String client_first_name = rst.getString("client_first_name");
            list2.add(new Clients("", client_email, client_last_name, client_first_name, null));
        }
        pstmnt2.close();
        return list2;

    }

    */
// TODO: 15.01.2020 if u need activate it

//  String client_address = rs.getString("client_address");
// String client_email = rs.getString("client_email");
//  String client_first_name = rs.getString("client_first_name");
// String client_last_name = rs.getString("client_last_name");
//  Integer client_id = rs.getInt("client_id");