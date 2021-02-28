package it.unitn.disi.lingprog.daniele.marcolan.partitadicarte;

import java.util.ArrayList;
import javafx.scene.layout.HBox;

public class Mano extends HBox {
    ArrayList<Carta> carteInMano;
    
    public Mano(MainWindow mw) {
        this.setSpacing(10);
        this.setPrefHeight(150);
        
        carteInMano = new ArrayList<Carta>();
        
        Carta inCima;
        inCima = mw.mazzo.get(mw.mazzo.size() - 1);
        mw.mazzo.remove(inCima);
        carteInMano.add(inCima);
        this.getChildren().add(inCima);

        inCima = mw.mazzo.get(mw.mazzo.size() - 2);
        mw.mazzo.remove(inCima);
        carteInMano.add(inCima);
        this.getChildren().add(inCima);

        inCima = mw.mazzo.get(mw.mazzo.size() - 3);
        mw.mazzo.remove(inCima);
        carteInMano.add(inCima);
        this.getChildren().add(inCima);

        inCima = mw.mazzo.get(mw.mazzo.size() - 4);
        mw.mazzo.remove(inCima);
        carteInMano.add(inCima);
        this.getChildren().add(inCima);

        carteInMano.sort((Carta c1, Carta c2) -> c1.compareTo(c2));
    }
}