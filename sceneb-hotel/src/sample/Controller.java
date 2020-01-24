package sample;

import com.mysql.cj.protocol.Resultset;
import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.net.URL;

import java.sql.*;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Controller implements Initializable {

    //Buttons for FXML
    @FXML    private Button insertButton;
    @FXML    private Button updateButton;
    @FXML    private Button deleteButton;




    //Defining observable list
    ObservableList<Booking> Bookinglist=FXCollections.observableArrayList();
    ObservableList<Rooms> oblistroom=FXCollections.observableArrayList();
    ObservableList<Clients> oblist= FXCollections.observableArrayList();
    ObservableList<invoice> invlist= FXCollections.observableArrayList();
    ObservableList<Nbooking> nblist= FXCollections.observableArrayList();



    //booking query for later: SELECT `bookings`.*, `clients`.`client_first_name`, `clients`.`client_last_name`
    //FROM `bookings`
    //	LEFT JOIN `clients` ON `bookings`.`client_id` = `clients`.`client_id`;

    ////////// ******/////////////
    @FXML

    private void insertButton() throws SQLException {
        String fname, lastname ,email, address;

        fname = first_N.getText();
        lastname= last_N.getText();
        email = Email_f.getText();
        address = Address_f.getText();
        Connection conn = DBConnector.getConnection();
        if(fname != "" || lastname != "" || email != "" || address != "") {
            String query = "INSERT INTO `clients` ( `client_first_name`, `client_last_name`, `client_email`, `client_address`) VALUES (?,?,?,?)";


            try {
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, fname);
                preparedStmt.setString(2, lastname);
                preparedStmt.setString(3, email);
                preparedStmt.setString(4, address);
                preparedStmt.execute();
                System.out.println("Update Successful");
            } catch (SQLException e3) {
                e3.printStackTrace();
                System.out.println("Update Failed");
            }
        }

}


    @FXML
    private void updateButton() throws SQLException {

    //end of customer page table click event

    //update button
        Clients selectedclient = table.getSelectionModel().getSelectedItem();
        int id =selectedclient.getC_ID();

        String fname, lname, email, address;

        fname = first_N.getText();
        lname = last_N.getText();
        email = Email_f.getText();
        address = Address_f.getText();


        Connection conn = DBConnector.getConnection();

        String query = "UPDATE clients SET client_first_name= ?, client_last_name = ?, client_email= ?, client_address = ? WHERE `clients`.`client_id` = ?;";

        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, fname);
            preparedStmt.setString(2, lname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, address);
            preparedStmt.setInt(5,id);


            preparedStmt.execute();
            System.out.println("Update Successful");
        }catch(SQLException e3) {
            e3.printStackTrace();
            System.out.println("Update Failed");
        }

    }

    @FXML
    private void deleteButton() throws SQLException {
        String query = "DELETE FROM clients WHERE client_first_name="+first_N.getText()+"";
        executeQuery(query);
        showclients();
    }

    public void executeQuery(String query) throws SQLException {
        Connection conn = DBConnector.getConnection();
       Resultset st;
        try {
            st = (Resultset) conn.createStatement().executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override

    public void initialize(URL location, ResourceBundle resources ) {
//calling methods
showclients();
showrooms();
showbooking();
 shownbooking();



    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // booking table for FXML
    @FXML private TableView<Booking>bookingtable;
    @FXML private TableColumn<Booking,Integer>client_ID;
    @FXML private TableColumn<Booking,String>client_fName;
    @FXML private TableColumn<Booking,String>client_Lname;
    @FXML private TableColumn<Booking,Integer>room_ID;
    @FXML private TableColumn<Booking, Date>f_Date;// booked from
    @FXML private TableColumn<Booking,Date>E_Date;// until
    public void showbooking(){
        try {
            Connection con = DBConnector.getConnection();
            //boooking table join

            ResultSet bs = con.createStatement().executeQuery("SELECT `bookings`.`client_id`, `clients`.`client_first_name`, `clients`.`client_last_name`, " +
                    "`bookings`.`room_id`, `bookings`.`booking_start_date`, `bookings`.`booking_end_date`FROM `bookings` LEFT JOIN `clients` ON `bookings`." +
                    "`client_id` = `clients`.`client_id` WHERE `bookings`.`client_id` = `clients`.`client_id`;");

            while (bs.next()) {


            Bookinglist.add(new Booking(bs.getInt(1), bs.getString(2), bs.getString(3), bs.getInt(4),bs.getDate(5),bs.getDate(6)));

            }
        }
        catch (SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        client_ID.setCellValueFactory(new PropertyValueFactory<>("client_ID"));
        client_fName.setCellValueFactory(new PropertyValueFactory<>("client_fname"));
        client_Lname.setCellValueFactory(new PropertyValueFactory<>("client_Lname"));
        room_ID.setCellValueFactory(new PropertyValueFactory<>("room_ID"));
        f_Date.setCellValueFactory(new PropertyValueFactory<>("f_Date"));
        E_Date.setCellValueFactory(new PropertyValueFactory<>("E_Date"));
        bookingtable.setItems(Bookinglist);

    }
    //Clients Table

    @FXML    private TableView<Clients>table;
    @FXML private TableColumn<Clients,Integer> C_ID;
    @FXML    private TableColumn<Clients,String>client_first_name;
    @FXML    private TableColumn<Clients,String>client_last_name;
    @FXML    private TableColumn<Clients,String>client_email;
    @FXML    private TableColumn<Clients,String>client_address;
    @FXML    private TextField first_N;
    @FXML    private TextField last_N;
    @FXML    private TextField Email_f;
    @FXML    private TextField Address_f;

    public void showclients() {
        try {
            Connection con = DBConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select client_id,client_first_name,client_last_name,client_email,client_address FROM clients");
            while (rs.next()) {
                oblist.add(new Clients(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
        }
        catch (SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }
        C_ID.setCellValueFactory(new PropertyValueFactory<>("C_ID"));
        client_first_name.setCellValueFactory(new PropertyValueFactory<>("firstN"));
        client_last_name.setCellValueFactory(new PropertyValueFactory<>("lastN"));
        client_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        client_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        table.setItems(oblist);}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //Room Table for FXML
    @FXML   private TableView<Rooms>roomtable;
    @FXML   private TableColumn<Rooms,Integer>roomid;
    @FXML   private TableColumn<Rooms,Boolean>availability;
    @FXML   private TableColumn<Rooms,Boolean>balcony;
    @FXML   private TableColumn<Rooms,Boolean>coffeemachine;
    @FXML   private TableColumn<Rooms,Boolean>tv;
    @FXML   private TableColumn<Rooms,Boolean>wifi;

        public void showrooms(){
        try {
            Connection con = DBConnector.getConnection();
            ResultSet rsr=con.createStatement().executeQuery("select  rooms.room_id,rooms.room_is_booked,facilities.* FROM rooms,facilities");
            while (rsr.next()) {
                oblistroom.add(new Rooms(rsr.getInt(1),rsr.getBoolean(2),rsr.getBoolean(3),rsr.getBoolean(4),rsr.getBoolean(5),rsr.getBoolean(6)));
            }
        }
        catch (SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }
            //room
            roomid.setCellValueFactory(new PropertyValueFactory<>("room_id"));
            availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
            balcony.setCellValueFactory(new PropertyValueFactory<>("balcony"));
            tv.setCellValueFactory(new PropertyValueFactory<>("tv"));
            wifi.setCellValueFactory(new PropertyValueFactory<>("wifi"));
            coffeemachine.setCellValueFactory(new PropertyValueFactory<>("coffeemachine"));
            roomtable.setItems(oblistroom);

        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    ///////////////////////////////////////////////////////////////

    //invoice
    @FXML   private TableView<invoice>invoicetable;
    @FXML   private TableColumn<invoice,String>client_n;
    @FXML   private TableColumn<invoice,Date>invoice_d;
    @FXML   private TableColumn<invoice,Date>bookd_f;
    @FXML   private TableColumn<invoice,Date>bookd_e;

    @FXML private TableColumn<invoice,Integer>room_id;
    @FXML private TableColumn<invoice,Integer>invoice_t;


    public void showinvoice(){
        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs=con.createStatement().executeQuery("SELECT `clients`.`client_first_name`, `invoices`.`invoice_date`, `bookings`.`booking_start_date`, `bookings`.`booking_end_date`, `bookings`.`room_id`, `invoices`.`invoice_total`\n" +
                    "FROM `clients` \n" +
                    "\tLEFT JOIN `invoices` ON `invoices`.`client_id` = `clients`.`client_id` \n" +
                    "\tLEFT JOIN `bookings` ON `bookings`.`client_id` = `clients`.`client_id`\n" +
                    "WHERE `clients`.`client_id` = `invoices`.`client_id``bookings`.`client_id` = `clients`.`client_id`;");
            while (rs.next()) {

                invlist.add(new invoice(rs.getString(1),rs.getDate(2),rs.getDate(3),rs.getDate(4),rs.getInt(5),rs.getInt(6)));
            }
        }
        catch (SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }
        //room
        client_n.setCellValueFactory(new PropertyValueFactory<>("client_n"));
        invoice_d.setCellValueFactory(new PropertyValueFactory<>("invoice_d"));
        bookd_f.setCellValueFactory(new PropertyValueFactory<>("bookd_f"));
        bookd_e.setCellValueFactory(new PropertyValueFactory<>("bookd_e"));
        room_id.setCellValueFactory(new PropertyValueFactory<>("room_id"));
        invoice_t.setCellValueFactory(new PropertyValueFactory<>("invoice_t"));
        invoicetable.setItems(invlist);

    }






    ////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    ///////////////////////////////////////////////////////////////

    //invoice
    @FXML   private TableView<Nbooking>nbooktable;
    @FXML   private TableColumn<Nbooking,String>clientn;
    @FXML   private TableColumn<Nbooking,String>clientln;
    @FXML   private TableColumn<Nbooking,String>clientem;
    @FXML   private TableColumn<Nbooking,String>clientadd;
    @FXML   private TableColumn<Nbooking,Date>bookdf;
    @FXML   private TableColumn<Nbooking,Date>bookde;
    @FXML   private TableColumn<Nbooking,Integer>r_id;
        public void shownbooking(){
        try {
            Connection con = DBConnector.getConnection();
            ResultSet rs=con.createStatement().executeQuery("SELECT `clients`.`client_first_name`, `clients`.`client_last_name`, `clients`.`client_email`, `clients`.`client_address`, `bookings`.`booking_start_date`, `bookings`.`booking_end_date`, `bookings`.`room_id`\n" +
                    "FROM `clients` \n" +
                    "\tLEFT JOIN `bookings` ON `bookings`.`client_id` = `clients`.`client_id`\n" +
                    "WHERE `clients`.`client_id` = `bookings`.`client_id`;");
            while (rs.next()) {

                nblist.add(new Nbooking(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7)));
            }
        }
        catch (SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,ex);
        }
        //room
        clientn.setCellValueFactory(new PropertyValueFactory<>("clientn"));
        clientln.setCellValueFactory(new PropertyValueFactory<>("clientln"));
        clientem.setCellValueFactory(new PropertyValueFactory<>("clientem"));
        clientadd.setCellValueFactory(new PropertyValueFactory<>("clientadd"));
       bookdf.setCellValueFactory(new PropertyValueFactory<>("bookdf"));
            bookde.setCellValueFactory(new PropertyValueFactory<>("bookde"));
       r_id.setCellValueFactory(new PropertyValueFactory<>("r_id"));
        nbooktable.setItems(nblist);

    }

    ////////////////////////
public void selectclient()
         {

            if (table.getSelectionModel().getSelectedItem() != null) {
                Clients selectedclient = table.getSelectionModel().getSelectedItem();
                first_N.setText(selectedclient.getFirstN());
                last_N.setText(selectedclient.getLastN());
                Email_f.setText(selectedclient.getEmail());
                Address_f.setText(selectedclient.getAddress());

            }
        }
    public void selectroom()
    {
        //onEdit();
        // check the table's selected item and get selected item
        if (roomtable.getSelectionModel().getSelectedItem() != null) {
            Clients selectedclient = roomtable.getSelectionModel().getSelectedItem();
            room.setText(selectedclient.getFirstN());
            last_N.setText(selectedclient.getLastN());
            Email_f.setText(selectedclient.getEmail());
            Address_f.setText(selectedclient.getAddress());

        }
    }
        public void selectroom(){}
        public void selectbooking(){}
////////////////////////////


}




