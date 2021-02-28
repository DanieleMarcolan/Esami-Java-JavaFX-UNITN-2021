package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Pensione extends Alloggio {
    public enum Tipo {SOLO_COLAZIONE, MEZZA_PENSIONE, PENSIONE_COMPLETA};
    Tipo tipologia;
    Label labelTipo;
    
    public Pensione(MainWindow mw, String nome, int prezzo, double valutazione, Tipo tipologia) {
        super(mw, nome, prezzo, valutazione);
        this.tipologia = tipologia;
        labelTipo = new Label("" + tipologia);
        labelTipo.setFont(Font.font("Arial", FontWeight.LIGHT, 14));
        this.getChildren().add(labelTipo);
    }
    
    @Override
    public Label getExtra() {
        return labelTipo;
    }        
}