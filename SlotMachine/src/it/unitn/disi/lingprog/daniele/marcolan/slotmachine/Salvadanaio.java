package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import java.util.ArrayList;
import javafx.scene.layout.VBox;

public class Salvadanaio extends VBox {
    int numeroMonete;
    ArrayList<Moneta> monete;
    
    public Salvadanaio(MainWindow mw) {
        this.setPrefSize(100, 500);
        this.setSpacing(10);
        numeroMonete = 3;
        monete = new ArrayList<Moneta>();
        for (int j = 0; j < numeroMonete; j++) {
            Moneta moneta = new Moneta(mw, this);
            monete.add(moneta);
            this.getChildren().add(moneta);
            moneta.setTranslateX(25);
            moneta.setTranslateY(-100);
        }
    }
}