package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Macchina extends Circle {

    public Macchina() {
        super(17);
        super.setFill(Color.RED);
        super.setStroke(Color.BLACK);
        super.setStrokeWidth(1);
    }    
}