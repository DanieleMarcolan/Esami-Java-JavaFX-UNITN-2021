package it.unitn.disi.lingprog.daniele.marcolan.griglia;

import javafx.scene.control.Button;

class AlgButton extends Button {
    String etichetta;
    
    public AlgButton(MainWindow mw, String etichetta) {
        super(etichetta);
        super.setPrefHeight(20);
        this.etichetta = etichetta;
        
        this.setOnMouseClicked((evento) -> {
            switch (etichetta) {
                case "Alg 1":
                    mw.stato = 1;
                    this.setDisable(true);
                    mw.alg2.setDisable(false);
                    mw.alg3.setDisable(false);
                    break;
                case "Alg 2":
                    mw.stato = 2;
                    this.setDisable(true);
                    mw.alg1.setDisable(false);
                    mw.alg3.setDisable(false);
                    break;
                case "Alg 3":
                    mw.stato = 3;
                    this.setDisable(true);
                    mw.alg1.setDisable(false);
                    mw.alg2.setDisable(false);
                    break;
                default:
                    break;
            }
        });
    }
}