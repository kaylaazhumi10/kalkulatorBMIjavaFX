package com.mycompany.kalkulatorrbmi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController implements Initializable {

    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private Button btnHitung;
    @FXML private Label lblHasil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void hitungBMI(MouseEvent event) {
        try {
            double berat = Double.parseDouble(txtBerat.getText());
            double tinggiCm = Double.parseDouble(txtTinggi.getText());

            // Rumus BMI: Berat (kg) / (Tinggi (m) * Tinggi (m))
            double tinggiM = tinggiCm / 100.0;
            double bmi = berat / (tinggiM * tinggiM);

            String kategori;
            if (bmi < 18.5) {
                kategori = "Kekurangan Berat Badan (Underweight)";
            } else if (bmi < 24.9) {
                kategori = "Normal (Ideal)";
            } else if (bmi < 29.9) {
                kategori = "Kelebihan Berat Badan (Overweight)";
            } else {
                kategori = "Obesitas";
            }

            lblHasil.setText(String.format("Hasil BMI: %.2f\nKategori: %s", bmi, kategori));

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Input");
            alert.setHeaderText(null);
            alert.setContentText("Masukkan angka berat dan tinggi yang valid!");
            alert.show();
        }
    }
}