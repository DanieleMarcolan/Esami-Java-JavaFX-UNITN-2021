package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import javafx.scene.layout.HBox;

public class BarraBottoni extends HBox {
    MyButton nuovaPartita;
    MyButton spin;
    MyButton pay;
            
    public BarraBottoni(MainWindow mw) {
        super(0);
        this.setPrefSize(400, 100);
        nuovaPartita = new MyButton(mw, "Nuova partita");
        spin = new MyButton(mw, "Spin");
        pay = new MyButton(mw, "Pay");
        nuovaPartita.setPrefSize(400 / 3, 100);
        spin.setPrefSize(400 / 3, 100);
        pay.setPrefSize(400 / 3, 100);
        this.getChildren().addAll(nuovaPartita, spin, pay);
    }
}