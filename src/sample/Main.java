package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Menu Bar
        Rectangle rectangle = new Rectangle(1750, 100);
        rectangle.setFill(Color.FIREBRICK);
        GridPane gridpane = new GridPane();

        //List
        //todo re-creat it to database list
        ListView list = new ListView();
        list.getItems().add("HI1");
        list.getItems().add("HI2");
        list.getItems().add("HI3");
        list.getItems().add("HI4");
        list.getItems().add("HI5");
        list.getItems().add("HI6");
        list.getItems().add("HI7");
        list.getItems().add("HI8");
        list.getItems().add("HI9");
        list.getItems().add("HI10");
        list.getItems().add("HI11");
        list.getItems().add("HI12");
        list.setMaxWidth(200);


        //User Infos
        Label lblCustomer = new Label("CUSTOMER :");
        Label lblSuitType = new Label("SUIT TYPE :");
        Label lblDays = new Label("DAY :");
        Label lblCost = new Label("COST :");
        Label lblRegisterDate = new Label("REGISTER DATE :");

        Label lblcustomerheredb = new Label("1");
        Label lblsuitheredb = new Label("2");
        Label lbldaysheredb = new Label("3");
        Label lblcostheredb = new Label("4");
        Label lblregisterheredb = new Label("5");

        //VBOX and HBOX
        //HBOX

        HBox hbcust = new HBox(lblCustomer, lblcustomerheredb);//Customer HBOX
        hbcust.setPadding(new Insets(20, 1, 1, 1));

        HBox hbsuit = new HBox(lblSuitType, lblsuitheredb);//Suit HBOX
        hbsuit.setPadding(new Insets(20, 1, 1, 1));

        HBox hbdays = new HBox(lblDays, lbldaysheredb);//Day HBOX
        hbdays.setPadding(new Insets(20, 1, 1, 1));

        HBox hbcost = new HBox(lblCost, lblcostheredb);//Cost HBOX
        hbcost.setPadding(new Insets(20, 1, 1, 1));

        HBox hbregister = new HBox(lblRegisterDate, lblregisterheredb);//Register HBOX
        hbregister.setPadding(new Insets(20, 1, 1, 1));

        //VBOX
        VBox vboxall = new VBox(hbcust, hbsuit, hbdays, hbcost, hbregister);
        vboxall.setPadding(new Insets(90, 1, 1, 650));

        VBox vblist = new VBox(list);//List VBox
        vblist.setPadding(new Insets(20, 1, 1, 400));

        //GridPane
        gridpane.add(rectangle, 1, 0, 1, 1);
        gridpane.add(vblist, 1, 1, 1, 1);
        gridpane.add(vboxall, 1, 1, 1, 1);

        //Stage
        primaryStage.setTitle("Hotel MVMT");
        Scene sc = new Scene(gridpane, 1370, 700);
        primaryStage.setScene(sc);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
