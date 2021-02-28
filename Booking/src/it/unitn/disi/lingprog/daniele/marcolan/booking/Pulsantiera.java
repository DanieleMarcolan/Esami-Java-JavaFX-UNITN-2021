package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.layout.HBox;

public class Pulsantiera extends HBox {
    MyButton nome, prezzo, valutazione;
    
    public Pulsantiera(MainWindow mw) {
        nome = new MyButton(mw, "Nome");
        prezzo = new MyButton(mw, "Prezzo");
        valutazione = new MyButton(mw, "Valutazione");
        prezzo.setTranslateX(100);
        valutazione.setTranslateX(100);
        this.getChildren().addAll(nome, prezzo, valutazione);
    }
}