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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Formular");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        Text welcome = new Text("Popunite sljedeći formular: ");
        welcome.setFont(Font.font("Tahoma", FontWeight.LIGHT, 19));
        grid.add(welcome, 0, 0);

        Label ime = new Label("Ime: ");
        grid.add(ime, 0, 1);
        TextField txtime = new TextField();
        txtime.setPromptText("ime");
        grid.add(txtime, 1, 1);
        txtime.setOnAction(e->jelIme(txtime,txtime.getText()));

        Label prezime = new Label("Prezime: ");
        grid.add(prezime, 0, 2);
        TextField txtprezime = new TextField();
        txtprezime.setPromptText("prezime");
        grid.add(txtprezime, 1, 2);
        txtprezime.setOnAction(e->jelIme(txtprezime,txtprezime.getText()));

        Label brIndexa = new Label("Broj indeksa: ");
        grid.add(brIndexa, 0, 3);
        TextField txtbr = new TextField();
        txtbr.setPromptText("broj indeksa");
        grid.add(txtbr, 1, 3);
        txtbr.setOnAction(e->jelBroj(txtbr, txtbr.getText()));

        Label jmbg = new Label("JMBG:");
        grid.add(jmbg, 0, 7);
        TextField txtjmbg = new TextField();
        txtjmbg.setPromptText("JMBG");
        grid.add(txtjmbg, 1, 7);
        txtjmbg.setOnAction(e -> jelJmbg(txtjmbg,txtjmbg.getText()));

        Label datumRodjenja = new Label("Datum rodjenja: ");
        grid.add(datumRodjenja, 0, 8);
        DatePicker dat = new DatePicker();
        dat.setPromptText("datum rođenja");
        grid.add(dat, 1, 8);
        dat.setOnAction(e -> jelDatum(dat));

        Label mjestRodjenja = new Label("Mjesto rodjenja: ");
        ObservableList<String> mjestoRodjenja = FXCollections.observableArrayList(
                "Sarajevo", "Tuzla", "Zenica", "Mostar", "Bihać", "Goražde"
        );
        grid.add(mjestRodjenja, 0, 9);
        final ComboBox mjesto = new ComboBox(mjestoRodjenja);
        mjesto.setEditable(true);
        mjesto.setPromptText("mjesto rođenja");
        grid.add(mjesto, 1, 9);
        mjesto.setOnAction(e -> jelAdresa(mjesto.getEditor()));

        Label kontakAdresa = new Label("Kontakt adresa:");
        TextField adresa = new TextField();
        adresa.setPromptText("adresa");
        grid.add(kontakAdresa, 0, 13);
        grid.add(adresa, 1, 13);
        mjesto.setOnAction(e -> jelAdresa(adresa));

        Label kontakTelefon = new Label("Kontakt telefon(samo brojevi):");
        TextField telefon = new TextField();
        telefon.setPromptText("telefon");
        grid.add(kontakTelefon, 0, 14);
        grid.add(telefon, 1, 14);
        telefon.setOnAction(e -> jelTelefon(telefon ,telefon.getText()));


        Label email = new Label("Email:");
        TextField emaila = new TextField();
        emaila.setPromptText("email");
        grid.add(email, 0, 15);
        grid.add(emaila, 1, 15);
        emaila.setOnAction(e -> jelEmail(emaila,emaila.getText()));

        Label smjer = new Label("Smjer: ");
        ObservableList<String> smje = FXCollections.observableArrayList(
                "Automatika i elektronika", "Računarstvo i informatika", "Telekomunikacije", "Razvoj softvera", "Elektroenergetika"
        );
        grid.add(smjer, 0, 19);
        final ComboBox smjero = new ComboBox(smje);
        smjero.setPromptText("smjer");
        grid.add(smjero, 1, 19);

        Label godinaStudija = new Label("Godina studija: ");
        grid.add(godinaStudija, 0, 20);
        ObservableList<String> god = FXCollections.observableArrayList(
                "Prva", "Druga", "Treća"
        );
        final ComboBox godina = new ComboBox(god);
        grid.add(godina, 1, 20);

        Label ciklusStudija = new Label("Ciklus studija: ");
        grid.add(ciklusStudija, 0, 21);
        ObservableList<String> cik = FXCollections.observableArrayList("Bachlor", "Master", "Doktorski studij", "Stručni studij");
        final ComboBox cikl = new ComboBox(cik);
        grid.add(cikl, 1, 21);

        CheckBox ch1 = new CheckBox();
        ch1.setText("Redovan");
        grid.add(ch1, 1, 22);
        CheckBox ch2 = new CheckBox();
        ch2.setText("Redovan samofinansirajući");
        grid.add(ch2, 1, 23);

        Label borackaKategorija = new Label("Da li pripadate nekoj od boračkih kategorija? : ");
        grid.add(borackaKategorija, 0, 24);
        CheckBox cb1 = new CheckBox();
        cb1.setText("DA");
        grid.add(cb1, 1, 24);
        TextField kojaBO = new TextField();
        kojaBO.setPromptText("Ako DA, kojoj?");
        grid.add(kojaBO, 2, 24);
        CheckBox cb2 = new CheckBox();
        cb2.setText("NE");
        grid.add(cb2, 1, 25);

        Button btn = new Button();
        btn.setText("Potvrdi");
        grid.add(btn, 15, 26);
        btn.setOnAction(e -> jelMozePovrdi(telefon,txtime,txtprezime,txtbr,txtjmbg,dat,emaila,smjero,godina,cikl,ch1,ch2,cb1,cb2));

        primaryStage.setScene(new Scene(grid, 1000, 600));
        primaryStage.show();
    }

    public void upozorenje(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Neispravan unos");
        if(s.length()==0)alert.setContentText("Nešto nije ispravno, molim Vas popravite!");
        else alert.setContentText(s+" nije ispravno, molim Vas popravite!");
        alert.showAndWait();
    }

    public boolean jelMozePovrdi(TextField telefon,TextField txtime,TextField txtprezime,TextField txtbr,TextField txtjmbg, DatePicker dat, TextField email,ComboBox odsjek,ComboBox godina,ComboBox ciklus,CheckBox a,CheckBox b, CheckBox c,CheckBox d){
        if(!jelIme(txtime, txtime.getText())){upozorenje(txtime.getText());return false;}
        if(!jelIme(txtprezime, txtprezime.getText())){upozorenje(txtprezime.getText());return false;}
        if(!jelBroj(txtbr,txtbr.getText())){upozorenje(txtbr.getText());return false;}
        if(!jelJmbg(txtjmbg,txtjmbg.getText())){upozorenje(txtjmbg.getText());return false;}
        if(!jelDatum(dat)){upozorenje(dat.getEditor().getText());return false;}
        if(!jelTelefon(telefon,telefon.getText())){upozorenje(telefon.getText());return false;}
        if(!jelEmail(email,email.getText())){upozorenje(email.getText());return false;}
        if(odsjek.getSelectionModel().isEmpty()){upozorenje("Selekcija odsjeka");return false;}
        if(ciklus.getSelectionModel().isEmpty()){upozorenje("Selekcija ciklusa");return false;}
        if(godina.getSelectionModel().isEmpty()){upozorenje("Selekcija godine");return false;}
        if((a.isSelected() && b.isSelected()) || (!a.isSelected() && !b.isSelected())){upozorenje("Ne čekirati nijedno(ili čekirati oba) od ponuđenih načina finansiranja");return  false;}
        if((c.isSelected() && d.isSelected()) || (!c.isSelected() && !d.isSelected())){upozorenje("Ne čekirati nijedno(ili čekirati oba) od ponuđenih polja");return  false;}
        else {


            return true;
        }
    }


    public boolean jelIme(TextField polje, String uneseni){
        if(uneseni.length() > 0 && uneseni.length() <=20 ){polje.setStyle("-fx-control-inner-background: #adffac");return true;}
        polje.setStyle("-fx-control-inner-background: #ffb4aa");
        return false;
    }

    public  boolean jelBroj(TextField polje, String uneseni){
        try{
            int brIndeksa = Integer.parseInt(uneseni);
            if(brIndeksa > 0 && brIndeksa < 100000){
                polje.setStyle("-fx-control-inner-background: #adffac");
                return true;
            }
        }catch (NumberFormatException e){
            polje.setStyle("-fx-control-inner-background: #ffb4aa");
            return false;
        }
        polje.setStyle("-fx-control-inner-background: #ffb4aa");
        return false;
    }

    public boolean jelJmbg(TextField polje, String uneseni){
            if(uneseni.length() != 13){
                polje.setStyle("-fx-control-inner-background: #ffb4aa");
                return false;
            }
            polje.setStyle("-fx-control-inner-background: #adffac");
            return true;
    }


    public boolean jelDatum(DatePicker dat){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date test = new Date();
        try {
            test = sdf.parse(dat.getEditor().getText());
        }catch(ParseException e){
            return false;
        }
        if(!sdf.format(test).equals(dat.getEditor().getText()))return false;
        LocalDate localDate = dat.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        if(date.getYear() >= 2017 ||date.getDay()<= 0 || date.getDay()> 31 || date.getMonth() < 1 || date.getMonth() > 31 )return false;
        return true;
    }

    public boolean jelAdresa(TextField polje){
        polje.setStyle("-fx-control-inner-background: #adffac");
        return true;
    }

    public boolean jelTelefon(TextField polje, String uneseni){
        try{
            if(uneseni.charAt(0) == '0')uneseni = uneseni.substring(1);
            int brIndeksa = Integer.parseInt(uneseni);
                polje.setStyle("-fx-control-inner-background: #adffac");
                return true;
        }catch (NumberFormatException e){
            polje.setStyle("-fx-control-inner-background: #ffb4aa");
            return false;
        }
    }

    public boolean jelEmail(TextField polje ,String uneseni){
        Matcher matcher = VALIDEMAIL.matcher(uneseni);
        if(matcher.find()){
            polje.setStyle("-fx-control-inner-background: #adffac");
            return true;
        }
        polje.setStyle("-fx-control-inner-background: #ffb4aa");
        return false;
    }

    public static final Pattern VALIDEMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean jelOdabrao(TextField polje){
        if(polje.getText().length() != 0){
            polje.setStyle("-fx-background-color: #adffac");
            return true;
        }
        polje.setStyle("-fx-background-color: #ffb4aa");
        return false;
    }
    public static void main(String[] args) {
        launch(args);
    }
}


