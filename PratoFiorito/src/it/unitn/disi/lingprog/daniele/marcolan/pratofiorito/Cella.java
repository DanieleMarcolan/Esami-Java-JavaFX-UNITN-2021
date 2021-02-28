package it.unitn.disi.lingprog.daniele.marcolan.pratofiorito;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public abstract class Cella extends StackPane {
    boolean coperta;
    
    public Cella() {
        this.setPrefSize(100, 100);
        this.setBackground(new Background(new BackgroundFill(
                           Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(
                       Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        coperta = true;
    }
    
    public abstract void scopri();
}