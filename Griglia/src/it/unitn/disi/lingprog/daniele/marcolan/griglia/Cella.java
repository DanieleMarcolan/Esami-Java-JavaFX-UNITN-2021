package it.unitn.disi.lingprog.daniele.marcolan.griglia;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Cella extends StackPane {
    Circle cerchio;
    
    /**
     * Ogni cella ha un cerchio, che viene reso visibile o invisibile
     * E' meglio che crearlo e toglierlo
     */
    public Cella() {
        super.setPrefSize(100, 100);
        this.setBorder(new Border(new BorderStroke(
                       Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        
        cerchio = new Circle(50);
        cerchio.setFill(Color.PURPLE);
        this.getChildren().add(cerchio);
        cerchio.setVisible(false);
        
        this.setOnMouseClicked((evento) -> {
            cerchio.setVisible(!cerchio.isVisible());
        });
    }
}