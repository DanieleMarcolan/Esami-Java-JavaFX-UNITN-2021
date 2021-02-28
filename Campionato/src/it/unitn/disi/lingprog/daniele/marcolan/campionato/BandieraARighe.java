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
public class BandieraARighe extends Bandiera {
    Rectangle bandaSopra;
    Rectangle bandaCentro;
    Rectangle bandaSotto;
    
    public BandieraARighe() {
        bandaSopra = new Rectangle(30, 20/3);
        bandaCentro = new Rectangle(30, 20/3);
        bandaSotto = new Rectangle(30, 20/3);
        bandaSopra.setTranslateY(-20/3);
        bandaSotto.setTranslateY(20/3);
        super.getChildren().addAll(bandaSopra, bandaCentro, bandaSotto);
    }
    
    @Override
    public void build (String nomeSquadra) {
        if (nomeSquadra == "Austria") {
            bandaSopra.setFill(Color.RED);
            bandaCentro.setFill(Color.WHITE);
            bandaSotto.setFill(Color.RED);
        }
        
        if (nomeSquadra == "Germania") {
            bandaSopra.setFill(Color.RED);
            bandaCentro.setFill(Color.YELLOW);
            bandaSotto.setFill(Color.BLACK);
        }
        
        if (nomeSquadra == "Bulgaria") {
            bandaSopra.setFill(Color.WHITE);
            bandaCentro.setFill(Color.GREEN);
            bandaSotto.setFill(Color.RED);
        }
        
        if (nomeSquadra == "Olanda") {
            bandaSopra.setFill(Color.RED);
            bandaCentro.setFill(Color.WHITE);
            bandaSotto.setFill(Color.BLUE);
        }
        
        if (nomeSquadra == "Russia") {
            bandaSopra.setFill(Color.WHITE);
            bandaCentro.setFill(Color.RED);
            bandaSotto.setFill(Color.BLUE);
        }
        
        if (nomeSquadra == "Spagna") {
            bandaSopra.setFill(Color.RED);
            bandaCentro.setFill(Color.YELLOW);
            bandaSotto.setFill(Color.RED);
        }
        
        if (nomeSquadra == "Ungheria") {
            bandaSopra.setFill(Color.RED);
            bandaCentro.setFill(Color.WHITE);
            bandaSotto.setFill(Color.GREEN);
        }
    }
}
