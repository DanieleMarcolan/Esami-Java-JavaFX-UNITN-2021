package it.unitn.disi.lingprog.daniele.marcolan.campominato;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    Rectangle sfondo;
    boolean coperta;
    
    public Cella() {
        sfondo = new Rectangle(60, 60);
        sfondo.setStrokeWidth(1);
        copri();
        this.getChildren().add(sfondo);
    }
    
    public void copri() {
        coperta = true;
        sfondo.setFill(Color.BLUE);
        sfondo.setStroke(Color.WHITE);
    }
    
    public abstract void scopri();
}