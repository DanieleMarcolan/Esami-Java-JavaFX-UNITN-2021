package it.unitn.disi.lingprog.daniele.marcolan.minicalculator;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MyButton extends Button {
    String etichetta;
    
    public MyButton(String etichetta) {
        super(etichetta);
        this.etichetta = etichetta;
        this.setPrefSize(150, 50);
    }
    
    public void inAzione(MainWindow mw) {
        this.setOnMouseClicked((evento) -> {
            String stringa1 = mw.campo1.getText();
            String stringa2 = mw.campo2.getText();
            try {
                float float1 = Float.parseFloat(stringa1);
                float float2 = Float.parseFloat(stringa2);
                float numero3 = 0;
                switch(etichetta) {
                    case "PIU":
                        numero3 = float1 + float2;
                        break;
                    case "MENO":
                        numero3 = float1 - float2;
                        break;
                    case "PER": 
                        numero3 = float1 * float2;
                        break;
                    case "DIVISO": 
                        numero3 = float1 / float2;
                        break;
                    case "clear":
                        mw.campo1.setText("");
                        mw.campo2.setText("");
                        mw.risultato.setText("");
                    default:
                        break;
                }
                mw.risultato.setText("" + numero3);
            }
            catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Input non valido");
                alert.showAndWait();
            }
        });
    }
}