package it.unitn.disi.lingprog.daniele.marcolan.campominato;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bomba extends Cella {
    Circle cerchio;
    
    public Bomba() {
        super();
        cerchio = new Circle(25);
        cerchio.setFill(Color.RED);
    }
    
    public void scopri() {
        coperta = false;
        sfondo.setFill(Color.KHAKI);
        sfondo.setStroke(Color.BLACK);
        this.getChildren().add(cerchio);
    }
}