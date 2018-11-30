package sample;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller {
    public TextField ime;
    public void imeKlinuto(ActionEvent actionEvent){
        System.out.println("klinuto" + ime.getText());
    }
}
