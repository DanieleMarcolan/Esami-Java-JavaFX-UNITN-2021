package it.unitn.disi.lingprog.daniele.marcolan.memory;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cella extends StackPane {
    Rectangle sfondo;
    
    public Cella(MainWindow mw) {
        this.setPrefSize(100, 85);
        sfondo = new Rectangle(60, 60);
        this.getChildren().add(sfondo);
        copri();
    }
    
    public void copri() {
        sfondo.setFill(Color.BLUE);
    }
    
    public abstract void scopri();
}