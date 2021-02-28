package it.unitn.disi.lingprog.daniele.marcolan.griglia;

import javafx.scene.control.Button;

class MyButton extends Button {
    String etichetta;
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        super.setPrefHeight(20);
        this.etichetta = etichetta;
        
        this.setOnMouseClicked((evento) -> {
            switch(etichetta) {
                case "Clear":
                    mw.pulisci();
                    break;
                case "Step":
                    mw.effettuaStep();
                    break;
                case "Print":
                    mw.stampa();
                    break;
                default:
                    break;
            }
        });
    }
}