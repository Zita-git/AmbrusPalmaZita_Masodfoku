package com.example.masodfoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

import java.util.Comparator;
import java.util.Random;

public class HelloController {
    @FXML
    public Label x1, x2,iksz2;
    @FXML
    public TextField elso, masodik, harmadik;
    @FXML
    private Button btnSzamol;

    private Double a, b, c, D, felso, also;
    private boolean joe;


    @FXML
    public void initialize(){
        elso.setText("");
        masodik.setText("");
        harmadik.setText("");
    }
    public void szame(){
        try {
            a = Double.parseDouble(elso.getText().trim());
            b = Double.parseDouble(masodik.getText().trim());
            c = Double.parseDouble(harmadik.getText().trim());
        } catch (NumberFormatException e) {
            Alert nem = new Alert(Alert.AlertType.ERROR,"A beviteli mezők csak számot tartalmazhatnak!");
            nem.show();

        }
    }
    public void ellenor(){
        szame();
        if (elso.getText().isEmpty() || masodik.getText().isEmpty() || harmadik.getText().isEmpty() ){
            Alert nem = new Alert(Alert.AlertType.WARNING,"Beviteli mező nem lehet üres!");
            nem.show();
        } else {
            D = (b * b) - (4 * a * c);
            felso = (-b + Math.sqrt(D)) / 2 * a;
            also = (-b - Math.sqrt(D)) / 2 * a;

            if (D < 0) {
                if (a < 0 || b < 0 || c < 0) {
                    Alert nem = new Alert(Alert.AlertType.ERROR, "0-nál nagyobb szám megadása szükséges!");
                    nem.show();
                }else {
                    x1.setText("Nem oldható meg a valós számok halmazán!");
                }
            }
            else {
                if (felso == also) {
                    x1.setText(" x2 ="+felso);
                    iksz2.setText("");
                }
                else {
                    x1.setText(Double.toString(felso));
                    x2.setText(Double.toString(also));
                }
            }

        }
    }
    public void onSzamolClick(ActionEvent actionEvent) {
        x1.setText("");
        x2.setText("");
        iksz2.setText("x2 =");
        ellenor();
    }
}