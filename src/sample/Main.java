package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        grid.setHgap(5);
        grid.setVgap(5);

        Text welcome = new Text("Popunite sljedeći formular: ");
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

        Label datumRodjenja = new Label("Datum rodjenja: ");
        grid.add(datumRodjenja,0,8);
        DatePicker dat = new DatePicker();
        dat.setPromptText("datum rođenja");
        grid.add(dat,1,8);

        Label mjestRodjenja = new Label("Mjesto rodjenja: ");
        ObservableList<String> mjestoRodjenja = FXCollections.observableArrayList(
                "Sarajevo","Tuzla","Zenica","Mostar","Bihać","Goražde"
        );
        grid.add(mjestRodjenja,0,9);
        final ComboBox mjesto = new ComboBox(mjestoRodjenja);
        mjesto.setEditable(true);
        mjesto.setPromptText("mjesto rođenja");
        grid.add(mjesto,1,9);

        Label kontakAdresa = new Label ("Kontakt adresa:");
        TextField adresa = new TextField();
        adresa.setPromptText("adresa");
        grid.add(kontakAdresa,0,13);
        grid.add(adresa ,1,13);


        Label kontakTelefon = new Label ("Kontakt telefon:");
        TextField telefon = new TextField();
        telefon.setPromptText("telefon");
        grid.add(kontakTelefon,0,14);
        grid.add(telefon ,1,14);


        Label email = new Label ("Email:");
        TextField emaila = new TextField();
        emaila.setPromptText("email");
        grid.add(email,0,15);
        grid.add(emaila ,1,15);

        Label smjer = new Label("Smjer: ");
        ObservableList<String> smje = FXCollections.observableArrayList(
                "Automatika i elektronika","Računarstvo i informatika","Telekomunikacije","Razvoj softvera","Elektroenergetika"
        );
        grid.add(smjer,0,19);
        final ComboBox smjero = new ComboBox(smje);
        smjero.setPromptText("smjer");
        grid.add(smjero,1,19);

        Label godinaStudija = new Label("Godina studija: ");
        grid.add(godinaStudija,0,20);
        ObservableList<String> god = FXCollections.observableArrayList(
                "Prva","Druga","Treća"
        );
        final ComboBox godina = new ComboBox(god);
        grid.add(godina,1,20);

        Label ciklusStudija = new Label ("Ciklus studija: ");
        grid.add(ciklusStudija,0,21);
        ObservableList<String> cik = FXCollections.observableArrayList("Bachlor", "Master","Doktorski studij", "Stručni studij");
        final ComboBox cikl = new ComboBox(cik);
        grid.add(cikl,1,21);

        CheckBox ch1 = new CheckBox();
        ch1.setText("Redovan");
        grid.add(ch1,1,22);
        CheckBox ch2 = new CheckBox();
        ch2.setText("Redovan samofinansirajući");
        grid.add(ch2,1,23);

        Label borackaKategorija = new Label("Da li pripadate nekoj od boračkih kategorija? : ");
        grid.add(borackaKategorija,0,24);
        CheckBox cb1 = new CheckBox();
        cb1.setText("DA");
        grid.add(cb1, 1,24);
        TextField kojaBO = new TextField();
        kojaBO.setPromptText("Ako DA, kojoj?");
        grid.add(kojaBO,2,24);
        CheckBox cb2 = new CheckBox();
        cb2.setText("NE");
        grid.add(cb2, 1,25);

        Button btn = new Button();
        btn.setText("Potvrdi");
        grid.add(btn,15,26);

        primaryStage.setScene(new Scene(grid, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


