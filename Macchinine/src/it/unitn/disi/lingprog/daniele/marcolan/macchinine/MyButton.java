package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MyButton extends Button {
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        this.setPrefWidth(400/3);
        this.setPrefHeight(50);
        
        switch(etichetta) {
            case "Aggiungi Auto":
                this.setOnMouseClicked((evento) -> {
                    mw.bottonePremuto = true;
                });
                break;
            /**
             * Crea una nuova finestra con i pulsanti di controllo
             */
            case "Inizia":
                this.setOnMouseClicked((evento) -> {
                    FlowPane root2 = new FlowPane();
                    MyButton su, giu, destra, sinistra, random, start, stop;
                    su = new MyButton(mw, "Su");
                    giu = new MyButton(mw, "Giu");
                    destra = new MyButton(mw, "Destra");
                    sinistra = new MyButton(mw, "Sinistra");
                    root2.getChildren().addAll(su, giu, destra, sinistra);
                    Scene scene2 = new Scene(root2, 800/3, 200);
                    Stage stage2 = new Stage();
                    stage2.setTitle("Comandi");
                    stage2.setScene(scene2);
                    stage2.show();
                    stage2.setAlwaysOnTop(true);
                });
                break;
            case "Su":
                this.setOnMouseClicked((evento) -> {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            Strada t = mw.griglia.getElementAt(mw.griglia, i, j);
                            Strada s = mw.griglia.getElementAt(mw.griglia, i - 1, j);
                            mw.griglia.sposta(t, s);
                        }
                    }
                });
                break;
            case "Sinistra":
            this.setOnMouseClicked((evento) -> {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        Strada t = mw.griglia.getElementAt(mw.griglia, i, j);
                        Strada s = mw.griglia.getElementAt(mw.griglia, i, j - 1);
                        mw.griglia.sposta(t, s);
                    }
                }
            });
            break;
            /**
             * Qui devo scorrere al contrario la griglia, per evitare effetto cascata
             */
            case "Giu":
                this.setOnMouseClicked((evento) -> {
                    for (int i = 7; i >= 0; i--) {
                        for (int j = 7; j >= 0; j--) {
                            Strada t = mw.griglia.getElementAt(mw.griglia, i, j);
                            Strada s = mw.griglia.getElementAt(mw.griglia, i + 1, j);
                            mw.griglia.sposta(t, s);
                        }
                    }
                });
                break;
            /**
             * Qui devo scorrere al contrario la griglia, per evitare effetto cascata
             */
            case "Destra":
                this.setOnMouseClicked((evento) -> {
                    for (int i = 7; i >= 0; i--) {
                        for (int j = 7; j >= 0; j--) {
                            Strada t = mw.griglia.getElementAt(mw.griglia, i, j);
                            Strada s = mw.griglia.getElementAt(mw.griglia, i, j + 1);
                            mw.griglia.sposta(t, s);
                        }
                    }
                });
                break;
            default:
                break;
        }
    }    
}