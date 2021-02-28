package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BandieraABande extends Bandiera {
    Rectangle bandaSopra;
    Rectangle bandaSotto;
    
    public BandieraABande() {
        bandaSopra = new Rectangle(30, 10);
        bandaSotto = new Rectangle(30, 10);
        bandaSopra.setTranslateY(-5);
        bandaSotto.setTranslateY(5);
        super.getChildren().addAll(bandaSopra, bandaSotto);
    }
    
    @Override
    public void build (String nomeSquadra) {
        if (nomeSquadra == "Polonia") {
            bandaSopra.setFill(Color.WHITE);
            bandaSotto.setFill(Color.RED);
        }
        
        if (nomeSquadra == "Ucraina") {
            bandaSopra.setFill(Color.BLUE);
            bandaSotto.setFill(Color.YELLOW);
        }   
    }
}