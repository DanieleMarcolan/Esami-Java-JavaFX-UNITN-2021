/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ameba
 */
public class BandieraAStrisce extends Bandiera {
    Rectangle sinistra;
    Rectangle centro;
    Rectangle destra;
    
    public BandieraAStrisce() {
        sinistra = new Rectangle(10, 20);
        centro = new Rectangle(10, 20);
        destra = new Rectangle(10, 20);
        sinistra.setTranslateX(-10);
        destra.setTranslateX(10);
        super.getChildren().addAll(sinistra, centro, destra);
    }
    
    @Override
    public void build(String nomeSquadra) {
        if (nomeSquadra == "Italia") {
            sinistra.setFill(Color.RED);
            centro.setFill(Color.WHITE);
            destra.setFill(Color.GREEN);
        }
        if (nomeSquadra == "Francia") {
            sinistra.setFill(Color.RED);
            centro.setFill(Color.WHITE);
            destra.setFill(Color.BLUE);
        }
        if (nomeSquadra == "Irlanda") {
            sinistra.setFill(Color.ORANGE);
            centro.setFill(Color.WHITE);
            destra.setFill(Color.LIGHTGREEN);
        }
        if (nomeSquadra == "Belgio") {
            sinistra.setFill(Color.RED);
            centro.setFill(Color.YELLOW);
            destra.setFill(Color.BLACK);
        }
    }
}
