package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.layout.HBox;

public class Albergo extends Alloggio {
    int numeroStelle;
    HBox boxStelle;
    
    public Albergo(MainWindow mw, String nome, int prezzo, double valutazione, int numeroStelle) {
        super(mw, nome, prezzo, valutazione);
        this.numeroStelle = numeroStelle;
        boxStelle = new HBox(5);
        if (numeroStelle >= 1 && numeroStelle <= 5) {
            for (int i = 0; i < numeroStelle; i++) {
                Stella stella = new Stella();
                boxStelle.getChildren().add(stella);
            }
            this.getChildren().add(boxStelle);
        }
    }
    
    @Override
    public HBox getExtra() {
        return boxStelle;
    }
}