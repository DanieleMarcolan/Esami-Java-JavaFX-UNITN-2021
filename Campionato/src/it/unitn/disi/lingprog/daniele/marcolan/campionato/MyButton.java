package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MyButton extends Button {
    
    public MyButton(Pulsantiera cmd, MainWindow mw, String etichetta) {
        super(etichetta);
        this.setPrefSize(150, 100);
        
        this.setOnMouseClicked((evento) -> {
            switch (etichetta) {
                case "1a giornata":
                    mw.g1.giocaGiornata(0);
                    mw.g1.giocaGiornata(1);
                    mw.g2.giocaGiornata(0);
                    mw.g2.giocaGiornata(1);
                    mw.g3.giocaGiornata(0);
                    mw.g3.giocaGiornata(1);
                    mw.g4.giocaGiornata(0);
                    mw.g4.giocaGiornata(1);
                    cmd.secondaGiornata.setDisable(false);
                    this.setDisable(true);
                    break;
                case "2a giornata":
                    mw.g1.giocaGiornata(2);
                    mw.g1.giocaGiornata(3);
                    mw.g2.giocaGiornata(2);
                    mw.g2.giocaGiornata(3);
                    mw.g3.giocaGiornata(2);
                    mw.g3.giocaGiornata(3);
                    mw.g4.giocaGiornata(2);
                    mw.g4.giocaGiornata(3);
                    cmd.terzaGiornata.setDisable(false);
                    this.setDisable(true);
                    break;
                case "3a giornata":
                    mw.g1.giocaGiornata(4);
                    mw.g1.giocaGiornata(5);
                    mw.g2.giocaGiornata(4);
                    mw.g2.giocaGiornata(5);
                    mw.g3.giocaGiornata(4);
                    mw.g3.giocaGiornata(5);
                    mw.g4.giocaGiornata(4);
                    mw.g4.giocaGiornata(5);
                    cmd.quarti.setDisable(false);
                    this.setDisable(true);
                    break;
                case "Quarti":
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Non ancora implementato");
                    alert.showAndWait();
                    System.exit(0);
                    break;
            }
        });
    }
}