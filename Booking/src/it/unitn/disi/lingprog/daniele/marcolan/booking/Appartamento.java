package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Appartamento extends Alloggio {
    int numeroLetti;
    Label maxPersone;
    
    public Appartamento(MainWindow mw, String nome, int prezzo, double valutazione, int numeroLetti) {
        super(mw, nome, prezzo, valutazione);
        if (numeroLetti >= 2 && numeroLetti <= 8) {
            this.numeroLetti = numeroLetti;
            maxPersone = new Label ("max. Persone: " + numeroLetti);
            maxPersone.setFont(Font.font("Arial", FontWeight.LIGHT, 14));
            this.getChildren().add(maxPersone);
        }
    }
    
    @Override
    public Label getExtra() {
        return maxPersone;
    }
}