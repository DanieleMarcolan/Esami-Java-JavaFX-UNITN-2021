package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyButton extends Button {
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        
        switch (etichetta) {
            case "Spin":
                this.setOnMouseClicked((evento) -> {
                    this.setDisable(false);
                    if (mw.punteggio == 1) {
                        mw.punteggio = 0;
                    }
                    else {
                        mw.punteggio = mw.punteggio / 2;
                    }
                    mw.aggiornaPunteggio();
                    mw.schermoSimboli1.getChildren().clear();
                    mw.schermoSimboli1.mostraSimbolo(mw);
                    mw.schermoSimboli2.getChildren().clear();
                    mw.schermoSimboli2.mostraSimbolo(mw);
                    mw.schermoSimboli3.getChildren().clear();
                    mw.schermoSimboli3.mostraSimbolo(mw);
                   
                });
                break;
            case "Pay":
                this.setOnMouseClicked((evento) -> {
                    StackPane root = new StackPane();
                    Text scritta = new Text("Hai vinto " + (mw.credito / 100) + " Euro");
                    scritta.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
                    Rectangle sfondo = new Rectangle(400, 200);
                    sfondo.setFill(Color.KHAKI);
                    root.getChildren().addAll(sfondo, scritta);
                    Stage secondaryStage = new Stage();
                    Scene scene2 = new Scene (root, 400, 200);
                    secondaryStage.setScene(scene2);
                    secondaryStage.setTitle("DLING DLING DLING! JACKPOT!");
                    secondaryStage.showAndWait();
                    mw.getChildren().clear();
                    mw.build();
                });
                break;
            case "Nuova partita":
                this.setOnMouseClicked((evento) -> {
                    if (mw.credito < 100) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("ATTENZIONE!!! ATTENZIONE!!! ATTENZIONE!!!");
                        alert.setContentText("Il tuo credito è inferiore a 100");
                        alert.showAndWait();
                    }
                    else {
                        mw.credito -= 100;
                        mw.aggiornaCredito();
                        mw.punteggio = 128;
                        mw.aggiornaPunteggio();
                    }
                });
                break;
            default:
                break;
        }
    }
}