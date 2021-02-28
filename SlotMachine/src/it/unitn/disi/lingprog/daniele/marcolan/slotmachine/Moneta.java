package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Moneta extends Circle {
    
    public Moneta(MainWindow mw, Salvadanaio s) {
        this.setRadius(25);
        this.setFill(Color.GOLD);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(1);
        
        /**
        * Elimina la moneta e incrementa il credito di 100
        */
        this.setOnMouseClicked((evento) -> {
            mw.credito += 100;
            mw.aggiornaCredito();
            s.getChildren().remove(this);
            s.monete.remove(this);
        });
    }    
}