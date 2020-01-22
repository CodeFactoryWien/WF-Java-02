package sample;

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
    private static final String invoiceTable = "invoices";
    private static final String roomtypeTable = "roomtypes";

    public DbConnection() throws SQLException, ClassNotFoundException {

        //connecting to the database
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to the Hotel Database - Database...");
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

    public List<RoomType> roomTypeList() throws SQLException {
        String sql = "SELECT roomtype_id,roomtype_name,room_price FROM " + roomtypeTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<RoomType> a = new ArrayList<>();
        while (rs.next()) {
            Integer roomtype_id = Integer.parseInt(rs.getString("roomtype_id"));
            String roomtype_name = rs.getString("roomtype_name");
            Integer room_price = Integer.parseInt(rs.getString("room_price"));
            a.add(new RoomType(roomtype_id,roomtype_name, room_price));
        }
        pstmnt.close();
        return a;
    }


        public List<Invoices> invoicesList() throws SQLException {
        String sql = "SELECT * FROM " + invoiceTable;
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Invoices> list = new ArrayList<>();

        while (rs.next()) {
            int Invoice_id = rs.getInt("invoice_id");
            int Client_id = rs.getInt("client_id");
            int Cost_id = rs.getInt("invoice_total");
            Date Date_id = rs.getDate("invoice_date");
            list.add(new Invoices(Invoice_id, Client_id, Cost_id, (java.sql.Date) Date_id));
        }
        pstmnt.close();
        return list;
    }

       public List<Rooms> roomsList(int a) throws SQLException {
        String sql = "SELECT room_id FROM " + roomTable + " WHERE room_is_booked=0 AND roomtype_id='"+roomTypeList().get(a).roomtype_id+"'";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Rooms> list = new ArrayList<>();
        while (rs.next()) {
            int room_id = rs.getInt("room_id");
            int room_is_booked = rs.getInt("room_is_booked");
           // int room_type_id = rs.getInt("room_type_id");
            list.add(new Rooms(room_id));
        }
        pstmnt.close();
        return list;
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
            String client_last_name = rs.getString("client_last_name");
            String client_email= rs.getString("client_email");
            String client_address = rs.getString("client_address");
            list.add(new Clients(client_first_name, client_last_name,client_email,client_address));
        }
        pstmnt.close();
        return list;
    }
        public void insert(String name,String sname,String email,String address)
        {
            try {
                String sqladd = "INSERT INTO clients (client_first_name,client_last_name,client_email,client_address) VALUES ('" + name + "','" + sname + "','" + email + "','" + address + "')";
                PreparedStatement pstmnt = conn.prepareStatement(sqladd);
                pstmnt.executeUpdate(sqladd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    //buttonu setonaction(e-> insert())

    public List<Clients> clientsearch(String s, String r) throws SQLException {
        //SELECT * FROM clients WHERE client_first_name="John"
        String sqlsearch = "SELECT * FROM " + clientsTable + " WHERE client_first_name='" + s + "' AND client_last_name='" + r + "'";
        PreparedStatement pstmntsearch = conn.prepareStatement(sqlsearch);
        ResultSet rss = pstmntsearch.executeQuery();
        List<Clients> listsearch = new ArrayList<>();
        while (rss.next()) {
            String client_first_name = rss.getString("client_first_name");
            String client_last_name = rss.getString("client_last_name");
            String client_email = rss.getString("client_email");
            String client_address= rss.getString("client_address");
            listsearch.add(new Clients(client_last_name, client_first_name,client_email,client_address));
        }
        pstmntsearch.close();
        return listsearch;
    }
    public List<Clients> clientfilter(String a,String b) throws SQLException {
        String sql = "SELECT * FROM " + clientsTable +" WHERE client_first_name='"+ a +"' AND client_last_name='"+ b +"'";
        PreparedStatement pstmnt = conn.prepareStatement(sql);
        ResultSet rs = pstmnt.executeQuery();
        List<Clients> list = new ArrayList<>();
        while (rs.next()) {
            String client_first_name = rs.getString("client_first_name");
            String client_last_name = rs.getString("client_last_name");
            String client_email= rs.getString("client_email");
            String client_address = rs.getString("client_address");
            list.add(new Clients(client_first_name, client_last_name,client_email,client_address));
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

// TODO: 16.01.2020 not needed if u need activate it
/*
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
*/

// TODO: 21.01.2020  for filter

 /*   public List<Clients> clientfilter(String a) throws SQLException {
        String sqlfilter = "SELECT client_first_name FROM " + clientsTable + " WHERE client_first_name='" + a +"'";
        PreparedStatement pstmntsearch = conn.prepareStatement(sqlfilter);
        ResultSet rss = pstmntsearch.executeQuery();
        List<Clients> listfilter = new ArrayList<>();
        while (rss.next()) {
            String client_first_name = rss.getString("client_first_name");
            String client_last_name = rss.getString("client_last_name");
            listfilter.add(new Clients(client_first_name, client_last_name));
        }
        pstmntsearch.close();
        return listfilter;
    }

    public List<Clients> clientfiltersn(String b) throws SQLException {
        String sqlfilter = "SELECT client_last_name FROM " + clientsTable + " WHERE  client_last_name='" + b + "'";
        PreparedStatement pstmntsearch = conn.prepareStatement(sqlfilter);
        ResultSet rss = pstmntsearch.executeQuery();
        List<Clients> listfilter = new ArrayList<>();
        while (rss.next()) {
            String client_first_name = rss.getString("client_first_name");
            String client_last_name = rss.getString("client_last_name");
            listfilter.add(new Clients(client_first_name, client_last_name));
        }
        pstmntsearch.close();
        return listfilter;
    }

  */