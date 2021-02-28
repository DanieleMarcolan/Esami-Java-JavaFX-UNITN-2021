package it.unitn.disi.lingprog.daniele.marcolan.campominato;

import javafx.scene.control.Button;

public class MyButton extends Button {
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        super.setPrefHeight(60);
        
        this.setOnMouseClicked((evento1) -> {
            switch (etichetta) {
                case "Test":
                    if (!mw.test.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                        mw.popolaGrigliaTest();
                        mw.sbircia.setDisable(false);
                        mw.abbandona.setDisable(false);
                        mw.attivaCelle();
                    }
                    break;
                case "Random": 
                    if (!mw.random.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                        mw.popolaGrigliaRandom();
                        mw.sbircia.setDisable(false);
                        mw.abbandona.setDisable(false);
                        mw.attivaCelle();
                    }
                    break;
                case "Sbircia":
                    if (!mw.sbircia.isDisable()) {
                        mw.bottonePremuto = true;
                    }
                    break;
                case "Abbandona":
                    if (!mw.abbandona.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                    }
                    break;
                default:
                    break;
            }
        });
        
        /**
         * Non so perché, qui il focus non dà problemi
         */
        this.setOnKeyTyped((evento2) -> {
            switch (evento2.getCharacter()) {
                case "T":
                    if (!mw.test.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                        mw.popolaGrigliaTest();
                        mw.sbircia.setDisable(false);
                        mw.abbandona.setDisable(false);
                        mw.attivaCelle();
                    }
                    break;
                case "R":
                    if (!mw.random.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                        mw.popolaGrigliaRandom();
                        mw.sbircia.setDisable(false);
                        mw.abbandona.setDisable(false);
                        mw.attivaCelle();
                    }
                    break;
                case "S":
                    if (!mw.sbircia.isDisable()) {
                        mw.bottonePremuto = true;
                    }
                    break;
                case "A":
                    if (!mw.abbandona.isDisable()) {
                        mw.getChildren().clear();
                        mw.buildGriglia();
                        mw.inizializzaFinestra();
                    }
                    break;
                default:
                    break;
            }
        });          
    }
}