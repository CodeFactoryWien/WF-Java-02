package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scenes extends Application {
    Stage window;
    Scene Loginscene,Customerscene,Invoicescene,Searchscene,Bookingscene;

    public void start(Stage prim) throws Exception {

        window = prim;
        //Buttons for search and customer in login
        Button btnsearch  = new Button("Customer Search");
        btnsearch.setOnAction(event -> window.setScene(Searchscene));
        Button btncustomer = new Button("For new Customers");
        btncustomer.setOnAction(event -> window.setScene(Customerscene));

        //Layout
        VBox layout1 = new VBox(20);
        VBox Vbtnsearch = new VBox(btnsearch);
        Vbtnsearch.setPadding(new Insets(100,100,100,100));
        VBox Vbtncustomer = new VBox(btncustomer);
        Vbtncustomer.setPadding(new Insets(120,100,100,100));
        layout1.getChildren().addAll(Vbtnsearch,Vbtncustomer);
        Loginscene = new Scene(layout1,1370,700);

        Label lbl = new Label("HI");
        StackPane layout2 = new StackPane();
        Customerscene = new Scene(layout2,600,300);
        layout2.getChildren().add(lbl);

        window.setScene(Loginscene);
        window.setTitle("HOTEL MVMT");
        window.show();



}
    public static void main(String[] args) {
        launch(args);
    }
}
