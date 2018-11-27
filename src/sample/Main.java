package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Formular");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text welcome = new Text("Popunite sljdeći formular(sva polja su obavezna):");
        welcome.setFont(Font.font("Tahoma", FontWeight.LIGHT, 19));
        grid.add(welcome,0,0);

        Label ime = new Label("Ime: ");
        grid.add(ime, 0,1);
        TextField txtime = new TextField();
        txtime.setPromptText("ime");
        grid.add(txtime,1,1);

        Label prezime = new Label("Prezime: ");
        grid.add(prezime, 0,2);
        TextField txtprezime = new TextField();
        txtprezime.setPromptText("prezime");
        grid.add(txtprezime,1,2);

        Label brIndexa = new Label("Broj indeksa: ");
        grid.add(brIndexa,0,3);
        TextField txtbr = new TextField();
        txtbr.setPromptText("broj indeksa");
        grid.add(txtbr,1,3);

        Label jmbg = new Label("JMBG:");
        grid.add(jmbg,0,7);
        TextField txtjmbg = new TextField();
        txtjmbg.setPromptText("JMBG");
        grid.add(txtjmbg,1,7);

        Label datum = new Label("Datum rođenja: ");
        grid.add(datum, 0 ,8);
        TextField txtdatum = new TextField();
        txtdatum.setPromptText("datum rođenja");
        grid.add(txtdatum,1,8);


        primaryStage.setScene(new Scene(grid, 1000, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


