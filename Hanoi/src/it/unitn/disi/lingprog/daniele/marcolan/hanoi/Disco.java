package it.unitn.disi.lingprog.daniele.marcolan.hanoi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Disco extends Rectangle {
    double lunghezza;
    Color colore;
    
    public Disco(MainWindow mw, double lunghezza, Color colore) {
        this.setHeight(10);
        this.lunghezza = lunghezza;
        this.setWidth(lunghezza);
        this.colore = colore;
        this.setFill(colore);
        mw.p1.aggiungiDisco(mw, this);
    }
}