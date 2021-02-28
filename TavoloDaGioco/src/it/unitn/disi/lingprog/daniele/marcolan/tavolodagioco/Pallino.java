package it.unitn.disi.lingprog.daniele.marcolan.tavolodagioco;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Classe grafica per i pallini sulla faccia del dado
 */
public class Pallino extends Circle {
    
    /**
     * Crea un pallino nero grande 5 pixel, da applicare sulla faccia del dado
     */
    public Pallino() {
        super(5);
        this.setFill(Color.BLACK);
    }    
}