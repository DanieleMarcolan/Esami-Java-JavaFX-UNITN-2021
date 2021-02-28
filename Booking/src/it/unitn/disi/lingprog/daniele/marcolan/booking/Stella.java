package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Stella extends Polygon {
    
    /**
    * Crea il poligono a forma di stella
    */
    public Stella() {
        super();
        super.getPoints().addAll(new Double[] { 
            0.0, 8.0,
            8.0, 8.0,
            10.0, 0.0,
            12.0, 8.0,
            20.0, 8.0,
            14.0, 12.0,
            16.0, 20.0,
            10.0, 14.0,
            4.0, 20.0,
            6.0, 12.0
        });
        super.setFill(Color.YELLOW);
    }    
}