package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    Stage window;
    Scene Loginscene, Customerscene, Invoicescene, Searchscene, Bookingscene;
    private ObservableList<Clients> data;
    private ListView<Invoices> listinv;
    private ObservableList<Invoices> datainv;
    private DbConnection dbaccess;
    private TextField txtsearch;
    private TextField txtsearchsn;
    private TableView tbl;
    public  String ax;
    public ComboBox com;

    public void setEventOnRoom()
    {
        com.setOnMouseClicked(event ->
        {
            RoomType rommType = (RoomType) com.getSelectionModel().getSelectedItem();
            System.out.println(rommType.roomtype_id);
        });
    }


    @Override
    public void init() {
        try {
            dbaccess = new DbConnection();
        } catch (Exception e) {
            displayException(e);
        }
    }

    @Override
    public void stop() {
        try {
            dbaccess.closeDb();
        }
        catch(Exception e)
        {
            displayException(e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        //Button
        Button searchbtn = new Button("SEARCH FOR CUSTOMER");
        searchbtn.setOnAction(event -> window.setScene(Searchscene));
        Button customerbtn = new Button("BOOK FOR NEW CUSTOMER");
        customerbtn.setOnAction(event -> window.setScene(Customerscene));
        Button invoice = new Button("GO TO INVOICE");
        invoice.setOnAction(event -> window.setScene(Invoicescene));
        Button checkit = new Button("CHECK AVAILABILITY");
        checkit.setOnAction(event -> System.out.println("CHECK"));
        Button printbtn = new Button("PRINT INVOICE");
        Button mainbtn = new Button("MAIN");
        mainbtn.setOnAction(event -> window.setScene(Loginscene));
        Button addbtn = new Button("ADD");
        addbtn.setOnAction(event -> window.setScene(Bookingscene));
        Button btnadd = new Button("ADD TO INVOICE");
        btnadd.setOnAction(event -> window.setScene(Invoicescene));
        Button btninv = new Button("BACK TO INVOICE");
        btninv.setOnAction(event -> window.setScene(Invoicescene));

        //Layout
        //**MAIN (LOGIN SCENE)
        VBox layout1 = new VBox(20);
        VBox VbSearch = new VBox(searchbtn);
        VbSearch.setPadding(new Insets(200, 100, 100, 500));
        VBox VbCustomer = new VBox(customerbtn);
        VbCustomer.setPadding(new Insets(90, 100, 100, 500));
        layout1.getChildren().addAll(VbSearch, VbCustomer);
        Loginscene = new Scene(layout1, 1370, 700);
        //**MAIN END

        //Booking items
        //LABELS
        //dataroom = getDbDataRoomType();
        Label lblname = new Label("NAME:");
        Label lblsurename = new Label("SURENAME:");
        Label lblsuit = new Label("SUIT:");
        Label lblroom = new Label("ROOM:");
        TextField txtname = new TextField();
        TextField txtsname = new TextField();
        ObservableList<RoomType> room =FXCollections.observableList(dbaccess.roomTypeList());
        ComboBox com = new ComboBox();
        com.setItems(room);


        StackPane layout2 = new StackPane();
        Bookingscene = new Scene(layout2, 1370, 700);
        HBox hbadd = new HBox(btnadd);
        hbadd.setPadding(new Insets(10, 10, 10, 10));
        HBox hbinv = new HBox(btninv);
        hbinv.setPadding(new Insets(10, 10, 10, 10));
        HBox hname = new HBox(lblname, txtname);
        hname.setPadding(new Insets(10, 10, 10, 10));
        hname.setSpacing(30);
        HBox hsurename = new HBox(lblsurename, txtsname);
        hsurename.setPadding(new Insets(20, 10, 10, 10));
        HBox hsuit = new HBox(lblsuit, com);
        hsuit.setPadding(new Insets(30, 10, 10, 10));
        hsuit.setSpacing(40);
        HBox hroom = new HBox(lblroom, checkit);
        hroom.setSpacing(30);
        hroom.setPadding(new Insets(40, 10, 10, 10));
        VBox vall = new VBox(hname, hsurename, hsuit, hroom, hbadd, hbinv);
        //**Booking END

        //**INVOICE
        StackPane layout3 = new StackPane();
        Invoicescene = new Scene(layout3, 1370, 700);

        Label lblinvname = new Label("NAME:");
        Label lblinvid = new Label("INVOICE ID:");
        Label lblinvdate = new Label("DATE");
        Label lblinvprice = new Label("COST");

        Label lblinvnamedb = new Label("Namefromdb");
        Label lblinviddb = new Label("Invoicedb");
        Label lblinvdatedb = new Label("datefromdb");
        Label lblinvpricedb = new Label("price");

        listinv = new ListView<>();
        listinv.getSelectionModel().selectedIndexProperty().addListener(new ListSelectChangeListener());
        listinv.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->
        {
            lblinvnamedb.setText(String.valueOf(newValue.Client_id));
            lblinviddb.setText(String.valueOf(newValue.Invoice_id));
            lblinvdatedb.setText(String.valueOf(newValue.Invoice_Date));
            lblinvpricedb.setText(String.valueOf(newValue.Invoice_total));
        });
        datainv = getDbDataInv();
        listinv.setItems(datainv);
        listinv.setMaxHeight(400);

        //HBOX AND VBOX
        VBox invlist = new VBox(listinv);
        invlist.setAlignment(Pos.TOP_CENTER);
        HBox invn = new HBox(lblinvname, lblinvnamedb);
        invn.setPadding(new Insets(30, 10, 10, 500));
        invn.setSpacing(22);
        HBox invs = new HBox(lblinvid, lblinviddb);
        invs.setPadding(new Insets(30, 10, 10, 500));
        invs.setSpacing(30);
        HBox invr = new HBox(lblinvdate, lblinvdatedb);
        invr.setPadding(new Insets(30, 10, 10, 500));
        invr.setSpacing(22);
        HBox invp = new HBox(lblinvprice, lblinvpricedb);
        invp.setPadding(new Insets(30, 10, 10, 500));
        invp.setSpacing(30);
        VBox vprint = new VBox(printbtn);
        vprint.setPadding(new Insets(50, 10, 10, 10));
        VBox vmain = new VBox(mainbtn);
        vmain.setPadding(new Insets(50, 10, 10, 10));
        VBox vadd = new VBox(addbtn);
        vadd.setPadding(new Insets(50, 10, 10, 10));

        VBox invall = new VBox(invlist, invn, invs, invr, invp, vprint, vadd, vmain);
        VBox all = new VBox(invall);
        layout3.getChildren().add(all);
        //**INVOICE END

        //**NEW CUSTOMER
        StackPane layout4 = new StackPane();
        Customerscene = new Scene(layout4, 1370, 700);
        Label lblcusname = new Label("NAME:");
        Label lblcussur = new Label("SURENAME:");
        Label cusemail = new Label("EMAIL:");
        Label cusaddress = new Label("ADDRESS:");
        Button bookingcustomer = new Button("BOOKING");

        TextField txtcusname = new TextField();
        TextField txtsur = new TextField();
        TextField txtemail = new TextField();
        TextField txtaddress = new TextField();
        EventHandler<MouseEvent> go = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setScene(Bookingscene);
                txtsname.setText(txtsur.getText());
                txtname.setText(txtcusname.getText());
                txtname.setDisable(true);
                txtsname.setDisable(true);
                dbaccess.insert(txtcusname.getText(), txtsur.getText(), txtemail.getText(), txtaddress.getText());
            }
        };
        bookingcustomer.addEventFilter(MouseEvent.MOUSE_CLICKED, go);

        //HBOX AND VBOX
        HBox hcname = new HBox(lblcusname, txtcusname);
        hcname.setPadding(new Insets(200, 10, 10, 500));
        hcname.setSpacing(22);
        HBox hcsur = new HBox(lblcussur, txtsur);
        hcsur.setPadding(new Insets(20, 10, 10, 500));
        hcsur.setSpacing(22);
        HBox hcmail = new HBox(cusemail, txtemail);
        hcmail.setPadding(new Insets(20, 10, 10, 500));
        hcmail.setSpacing(22);
        HBox hcadress = new HBox(cusaddress, txtaddress);
        hcadress.setPadding(new Insets(20, 10, 10, 500));
        hcadress.setSpacing(22);
        HBox hcinv = new HBox(bookingcustomer);
        hcinv.setPadding(new Insets(20, 10, 10, 500));

        VBox cusall = new VBox(hcname, hcsur, hcmail, hcadress, hcinv);
        VBox call = new VBox(cusall);
        layout4.getChildren().add(call);
        //*NEW CUSTOMER END

        HBox Hcustomer = new HBox(vall);
        Hcustomer.setPadding(new Insets(190, 1, 1, 450));
        layout2.getChildren().add(Hcustomer);


        //**Customer Search
        StackPane layout5 = new StackPane();
        Searchscene = new Scene(layout5, 1370, 700);
        Label scuslbl = new Label("Customer Name:");
        Label scusurlbl = new Label("Customer Surname:");
        Label av = new Label("X");
        Button booking = new Button("BOOKING");
        txtsearch = new TextField();
        txtsearchsn = new TextField();
        data = getDbData();
        tbl = new TableView();
        tbl.setMaxWidth(700);
        TableColumn<String, Clients> column1 = new TableColumn<>("First Name");
        TableColumn<String, Clients> column2 = new TableColumn<>("Last Name");
        TableColumn<String, Clients> column3 = new TableColumn<>("E-MAIL");
        TableColumn<String, Clients> column4 = new TableColumn<>("Address");
        column1.setCellValueFactory(new PropertyValueFactory<>("client_first_name"));
        tbl.getColumns().add(column1);
        column2.setCellValueFactory(new PropertyValueFactory<>("client_last_name"));
        tbl.getColumns().add(column2);
        column3.setCellValueFactory(new PropertyValueFactory<>("client_email"));
        tbl.getColumns().add(column3);
        column4.setCellValueFactory(new PropertyValueFactory<>("client_address"));
        tbl.getColumns().add(column4);
        tbl.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtsearch.setText(String.valueOf((tbl.getSelectionModel().getSelectedItems().get(0))));
            }
        });
        for (int i = 0; i < dbaccess.clientsList().size(); i++) {
            tbl.getItems().add(new Clients(dbaccess.clientsList().get(i).client_first_name, dbaccess.clientsList().get(i).client_last_name, dbaccess.clientsList().get(i).client_email, dbaccess.clientsList().get(i).client_address));
        }
        Button search = new Button("Search");
        EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (txtsearch.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Empty Customer Name");
                    alert.setHeaderText("Sorry for breaking your search but I need a first name to search");
                    alert.setContentText("Please,enter a Name");
                    alert.showAndWait();
                }
                if (txtsearchsn.getText().isEmpty()) {
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert2.setTitle("Empty Customer Surname");
                    alert2.setHeaderText("Sorry for breaking your search but I need a surname to search");
                    alert2.setContentText("Please,enter a Surname");
                    alert2.showAndWait();
                }
                try {

                    List name = (dbaccess.clientsearch(txtsearch.getText(), txtsearchsn.getText()));
                    String convertedName = name.toString();

                    if (convertedName.contains(txtsearch.getText()) && convertedName.contains(txtsearchsn.getText())) {
                        av.setText("Available");
                        av.setTextFill(Color.GREEN);
                        EventHandler<MouseEvent> gowithname = new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                window.setScene(Bookingscene);
                                txtname.setText(txtsearch.getText());
                                txtsname.setText(txtsearchsn.getText());
                                txtsearch.setText("");
                                txtsearchsn.setText("");
                                txtname.setDisable(true);
                                txtsname.setDisable(true);
                            }
                        };
                        booking.addEventFilter(MouseEvent.MOUSE_CLICKED, gowithname);
                    } else {
                        Alert notav = new Alert(Alert.AlertType.WARNING);
                        notav.setContentText("NOT AVAILABLE CUSTOMER : " + txtsearch.getText() + " " + txtsearchsn.getText());
                        notav.setHeaderText("NOT AVAILABLE");
                        notav.setTitle("OOPS...");
                        notav.showAndWait();
                        Alert info = new Alert(Alert.AlertType.INFORMATION);
                        info.setContentText("You will be transfered to the page new customer");
                        info.setHeaderText("TRANSFER");
                        info.setTitle("INFO");
                        info.showAndWait();
                        window.setScene(Customerscene);
                    }
                    if (txtsearchsn.getText().isEmpty() || txtsearch.getText().isEmpty()) {
                        Alert alert3 = new Alert(Alert.AlertType.WARNING);
                        alert3.setTitle("Empty INFOS");
                        alert3.setHeaderText("Sorry for breaking your search but I need some INFOS");
                        alert3.setContentText("Please,enter some INFOS");
                        alert3.showAndWait();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        };
            search.addEventFilter(MouseEvent.MOUSE_CLICKED, click);

        //VBOX AND HBOX
        VBox vlist = new VBox(scuslbl,txtsearch,scusurlbl,txtsearchsn,av,booking,search);
        HBox hlist = new HBox(tbl,vlist);
        hlist.setPadding(new Insets(130, 10, 10, 400));
        hlist.setSpacing(10);
        HBox searchall = new HBox(hlist);
        VBox Vcall = new VBox(searchall);

        //EVENTS
        EventHandler<MouseEvent> m = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                txtsearch.setText("");
            }
        };
        txtsearch.addEventFilter(MouseEvent.MOUSE_CLICKED, m);

        EventHandler<MouseEvent> t = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                txtsearchsn.setText("");
            }
        };
        txtsearchsn.addEventFilter(MouseEvent.MOUSE_CLICKED, t);

        EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                // TODO: 16.01.2020 call the name from client table so u can compare it with the textfield
                if (event.getCode() == KeyCode.ENTER) {
                    txtsearch.setText("");
                }
            }
        };
        EventHandler<KeyEvent> esc = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent escevent) {
                if (escevent.getCode() == KeyCode.ESCAPE) {
                    window.close();
                }
            }
        };
        window.addEventFilter(KeyEvent.KEY_PRESSED,esc);
        txtsearch.addEventFilter(MouseEvent.MOUSE_CLICKED, m);
        txtsearch.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent);
        layout5.getChildren().add(Vcall);
        //**Customer Search End

        window.setScene(Loginscene);
        window.setTitle("HOTEL MVMT");
        window.show();
    }

    private ObservableList<Clients> getDbData() {
        List<Clients> list = null;
        try {
            list = dbaccess.clientsList();
        } catch (Exception e) {

            displayException(e);
        }
        ObservableList<Clients> dbData = FXCollections.observableList(list);
        return dbData;
    }

    private ObservableList<Invoices> getDbDataInv() {
        List<Invoices> list2 = null;
        try {
            list2 = dbaccess.invoicesList();
        } catch (Exception e) {

            displayException(e);
        }
        ObservableList<Invoices> dbData = FXCollections.observableList(list2);
        return dbData;
    }

    private void displayException(Exception e) {

        System.out.println("###### Exception ######");
        e.printStackTrace();
        System.exit(0);
    }

    private   class  ListSelectChangeListener implements  ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            if ((new_val.intValue() < 0) || (new_val.intValue() >= data.size())) {

                return; // invalid data
            }
        }
    }
            public static void main (String[]args){
                launch(args);
            }
        }


