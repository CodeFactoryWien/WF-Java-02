package sample;
// TODO: 15.01.2020 it will be activated if you activate the code that is in the last line
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;


public class Main extends Application {
    Stage window;
    Scene Loginscene,Customerscene,Invoicescene,Searchscene,Bookingscene;
    
    @Override
    public void start(Stage primaryStage) throws Exception{

        window=primaryStage;

        //Button
        Button searchbtn = new Button("SEARCH FOR CUSTOMER");
        searchbtn.setOnAction(event -> window.setScene(Searchscene));
        Button customerbtn = new Button("BOOK FOR NEW CUSTOMER");
        customerbtn.setOnAction(event -> window.setScene(Customerscene));
        Button checkit = new Button("CHECK AVAILABILITY");
        checkit.setOnAction(event -> System.out.println("CHECK"));
        Button invoice = new Button("GO TO INVOICE");
        invoice.setOnAction(event -> window.setScene(Invoicescene));
        // TODO: 16.01.2020  make print button print the data to Inovoice.txt file
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
        VbSearch.setPadding(new Insets(200,100,100,500));
        VBox VbCustomer = new VBox(customerbtn);
        VbCustomer.setPadding(new Insets(90,100,100,500));
        layout1.getChildren().addAll(VbSearch,VbCustomer);
        Loginscene = new Scene(layout1,1370,700);
        //**MAIN END

        //**CUSTOMER SCENE
        //Customerscene items
        //LABELS
        Label lblname = new Label("NAME:");
        Label lblsurename = new Label("SURENAME:");
        Label lblsuit = new Label("SUIT:");
        Label lblroom = new Label("ROOM:");
        //TextFields
        TextField txtname = new TextField();
        TextField txtsurename = new TextField();
        ComboBox csuit = new ComboBox();
        csuit.getItems().add("HI");
        csuit.getItems().add("HI2");
        csuit.getItems().add("HI3");
        csuit.getItems().add("HI4");
        csuit.getItems().add("HI5");
        TextField txtroom = new TextField();

        StackPane layout2 = new StackPane();
        Bookingscene = new Scene(layout2,1370,700);
        HBox hbadd = new HBox(btnadd);
        hbadd.setPadding(new Insets(10,10,10,10));
        HBox hbinv = new HBox(btninv);
        hbinv.setPadding(new Insets(10,10,10,10));
        HBox hname = new HBox(lblname,txtname);
        hname.setPadding(new Insets(10,10,10,10));
        hname.setSpacing(30);
        HBox hsurename = new HBox(lblsurename,txtsurename);
        hsurename.setPadding(new Insets(20,10,10,10));
        HBox hsuit = new HBox(lblsuit,csuit);
        hsuit.setPadding(new Insets(30,10,10,10));
        hsuit.setSpacing(40);
        HBox hroom = new HBox(lblroom,txtroom,checkit);
        hroom.setSpacing(30);
        hroom.setPadding(new Insets(40,10,10,10));
        VBox vall = new VBox(hname,hsurename,hsuit,hroom,hbadd,hbinv);
        //**CUSTOMER SCENE END

        //**INVOICE
        StackPane layout3 = new StackPane();
        Invoicescene = new Scene(layout3,1370,700);
        ListView costlist =  new ListView();
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.getItems().add("HI");
        costlist.setMaxHeight(400);
        Label lblinvname = new Label("NAME:");
        Label lblinvsuit = new Label ("SUIT:");
        Label lblinvroom = new Label("ROOM");
        Label lblinvprice = new Label("Cost");

        Label lblinvnamedb = new Label("Namefromdb");
        Label lblinvsuitdb = new Label("Suitfromdb");
        Label lblinvroomdb = new Label("roomfromdb");
        Label lblinvpricedb = new Label("pricefromdb");

        //HBOX AND VBOX
        VBox invlist = new VBox(costlist);
        invlist.setAlignment(Pos.TOP_CENTER);
        HBox invn = new HBox(lblinvname,lblinvnamedb);
        invn.setPadding(new Insets(30,10,10,500));
        invn.setSpacing(22);
        HBox invs = new HBox(lblinvsuit,lblinvsuitdb);
        invs.setPadding(new Insets(30,10,10,500));
        invs.setSpacing(30);
        HBox invr = new HBox(lblinvroom,lblinvroomdb);
        invr.setPadding(new Insets(30,10,10,500));
        invr.setSpacing(22);
        HBox invp = new HBox(lblinvprice,lblinvpricedb);
        invp.setPadding(new Insets(30,10,10,500));
        invp.setSpacing(30);
        VBox vprint = new VBox(printbtn);
        vprint.setPadding(new Insets(50,10,10,10));
        VBox vmain = new VBox(mainbtn);
        vmain.setPadding(new Insets(50,10,10,10));
        VBox vadd = new VBox(addbtn);
        vadd.setPadding(new Insets(50,10,10,10));

        VBox invall = new VBox(invlist,invn,invs,invr,invp,vprint,vadd,vmain);
        VBox all = new VBox(invall);
        layout3.getChildren().add(all);
        //**INVOICE END

        //**NEW CUSTOMER
        StackPane layout4 = new StackPane();
        Customerscene = new Scene(layout4,1370,700);
        Label lblcusname = new Label("NAME:");
        Label lblcusemail = new Label("EMAIL:");
        Label cussuit = new Label("SUIT:");
        Label cusroom = new Label("ROOM:");
        Label cussdate = new Label("Start DATE:");
        Label cusedate = new Label("End DATE");

        DatePicker start = new DatePicker();
        DatePicker end = new DatePicker();
        TextField txtcusname = new TextField();
        TextField txtemail = new TextField();
        ComboBox ccsuit = new ComboBox();
        csuit.getItems().add("HI");
        csuit.getItems().add("HI2");
        csuit.getItems().add("HI3");
        csuit.getItems().add("HI4");
        csuit.getItems().add("HI5");

        //HBOX AND VBOX
        HBox hcname = new HBox(lblcusname,txtcusname);
        hcname.setPadding(new Insets(200,10,10,500));
        hcname.setSpacing(22);
        HBox hcemail = new HBox(lblcusemail,txtemail);
        hcemail.setPadding(new Insets(20,10,10,500));
        hcemail.setSpacing(22);
        HBox hcsuit = new HBox(cussuit,ccsuit);
        hcsuit.setPadding(new Insets(20,10,10,500));
        hcsuit.setSpacing(22);
        HBox hcroom = new HBox(cusroom);
        hcroom.setPadding(new Insets(20,10,10,500));
        hcroom.setSpacing(22);
        HBox hcstartdate = new HBox(cussdate,start);
        hcstartdate.setPadding(new Insets(20,10,10,500));
        hcstartdate.setSpacing(22);
        HBox hcenddate = new HBox(cusedate,end);
        hcenddate.setPadding(new Insets(20,10,10,500));
        hcenddate.setSpacing(22);
        HBox hcinv = new HBox(invoice);
        hcinv.setPadding(new Insets(20,10,10,500));

        VBox cusall = new VBox(hcname,hcemail,hcroom,hcsuit,hcstartdate,hcenddate,hcinv);
        VBox call = new VBox(cusall);
        layout4.getChildren().add(call);
        //*NEW CUSTOMER END

        HBox Hcustomer = new HBox(vall);
        Hcustomer.setPadding(new Insets(190,1,1,450));
        layout2.getChildren().add(Hcustomer);


        //**Customer Search
        StackPane layout5 = new StackPane();
        Searchscene = new Scene(layout5,1370,700);
        ListView list = new ListView();
        list.getItems().add("1");
        list.getItems().add("2");
        list.getItems().add("3");
        list.setMaxWidth(200.0);
        Label scuslbl = new Label("Customer Name:");
        Button booking = new Button("BOOKING");
        booking.setOnAction(event -> window.setScene(Bookingscene));
        TextField txtsearch = new TextField("NAME FOR SEARCHING");
        //VBOX AND HBOX
        HBox hlist = new HBox(list,scuslbl,txtsearch,booking);
        hlist.setPadding(new Insets(130,10,10,500));
        hlist.setSpacing(30);
        HBox searchall = new HBox(hlist);
        VBox Vcall = new VBox(searchall);

        //EVENTS
        EventHandler <MouseEvent> m = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                txtsearch.setText("");
            }
        };
        txtsearch.addEventFilter(MouseEvent.MOUSE_CLICKED,m);

        EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    txtsearch.setText("");
                }
            }
        };
        txtsearch.addEventFilter(MouseEvent.MOUSE_CLICKED,m);
        txtsearch.addEventFilter(KeyEvent.KEY_PRESSED,keyEvent);
        layout5.getChildren().add(Vcall);
        //**Customer Search End

        window.setScene(Loginscene);
        window.setTitle("HOTEL MVMT");
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
