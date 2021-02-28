package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Titolo extends StackPane {
    Rectangle sfondo;
    Text scritta;
    
    public Titolo() {
        this.setPrefSize(400, 100);
        sfondo = new Rectangle(400, 100);
        sfondo.setFill(Color.RED);
        sfondo.setStroke(Color.BLACK);
        sfondo.setStrokeWidth(5);
        scritta = new Text("Super\n Slots");
        scritta.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 26));
        scritta.setFill(Color.GOLD);
        scritta.setStroke(Color.BLACK);
        scritta.setStrokeWidth(1);
        this.getChildren().addAll(sfondo, scritta);
        this.setTranslateX(-50);
    }
}