package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Terreno extends StackPane {
    Rectangle base;
    int coordinataX, coordinataY;
    
    public Terreno(MainWindow mw, int i, int j) {
        coordinataX = i;
        coordinataY = j;
        base = new Rectangle(49, 49);
        base.setStroke(Color.BLACK);
        base.setStrokeWidth(1);
        this.getChildren().add(base);
    }
    
    /**
     * Inverte al click, se è strada diventa prato, se è prato diventa strada
     */
    public abstract void swap(MainWindow mw, int i, int j);    
}