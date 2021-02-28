/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ameba
 */
public class BandieraACroce extends Bandiera {
    Rectangle sfondo;
    Line verticale;
    Line orizzontale;
    
    public BandieraACroce() {
        sfondo = new Rectangle(30, 20);
        verticale = new Line();
        orizzontale = new Line();
        verticale.setStrokeWidth(3);
        orizzontale.setStrokeWidth(3);
        verticale.setStartX(10);
        verticale.setEndX(10);
        verticale.setStartY(0);
        verticale.setEndY(20);
        verticale.setTranslateX(-5);
        orizzontale.setStartX(0);
        orizzontale.setEndX(30);
        orizzontale.setStartY(10);
        orizzontale.setEndY(10);
        super.getChildren().addAll(sfondo, verticale, orizzontale);
    }
    
    @Override
    public void build(String nomeSquadra) {
        if (nomeSquadra == "Svezia") {
            sfondo.setFill(Color.BLUE);
            verticale.setStroke(Color.YELLOW);
            orizzontale.setStroke(Color.YELLOW);
        }
        
        if (nomeSquadra == "Danimarca") {
            sfondo.setFill(Color.RED);
            verticale.setStroke(Color.WHITE);
            orizzontale.setStroke(Color.WHITE);
        }
        
        if (nomeSquadra == "Finlandia") {
            sfondo.setFill(Color.WHITE);
            verticale.setStroke(Color.LIGHTSKYBLUE);
            orizzontale.setStroke(Color.LIGHTSKYBLUE);
        }
    }   
}
