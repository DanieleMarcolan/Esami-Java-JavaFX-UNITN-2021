package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.layout.FlowPane;

public class Pulsantiera extends FlowPane {
    MyButton primaGiornata, secondaGiornata, terzaGiornata, quarti, semifinali, finale;
    
    public Pulsantiera(MainWindow mw) {
        primaGiornata = new MyButton(this, mw, "1a giornata");
        secondaGiornata = new MyButton(this, mw, "2a giornata");
        terzaGiornata = new MyButton(this, mw, "3a giornata");
        quarti = new MyButton(this, mw, "Quarti");
        semifinali = new MyButton(this, mw, "Semifinali");
        finale = new MyButton(this, mw, "Finale");
        secondaGiornata.setDisable(true);
        terzaGiornata.setDisable(true);
        quarti.setDisable(true);
        semifinali.setDisable(true);
        finale.setDisable(true);
        this.getChildren().addAll(primaGiornata, secondaGiornata, terzaGiornata, quarti, semifinali, finale);
    }
}