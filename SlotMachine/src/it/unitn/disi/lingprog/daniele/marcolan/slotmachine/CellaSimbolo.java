package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import java.util.Random;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class CellaSimbolo extends StackPane {
    Polygon simbolo;
    Rectangle sfondo;
    Random rng;
    int discriminante;
    int tipoSimbolo;
    
    public CellaSimbolo(MainWindow mw) {
        this.setPrefSize(400 / 3, 200);
        sfondo = new Rectangle (400 / 3, 200);
        sfondo.setFill(Color.LIGHTBLUE);
        sfondo.setStroke(Color.BLACK);
        sfondo.setStrokeWidth(1);
        mostraSimbolo(mw);
        
        /**
         * Cambia il simbolo in uno random
         */
        this.setOnMouseClicked((evento) -> {
            if (mw.punteggio > 0) {
                mw.punteggio = mw.punteggio / 2;
                mw.aggiornaPunteggio();
                this.getChildren().clear();
                mostraSimbolo(mw);
            }
        });
    }
    
    /**
     * Genera un simbolo random nella cella
     */
    public void mostraSimbolo(MainWindow mw) {
        rng = new Random();
        discriminante = rng.nextInt(6);
        switch (discriminante) {
            case 0:
                //quadrato
                simbolo = new Polygon (0.0, 0.0,
                                       60.0, 0.0,
                                       60.0, 60.0,
                                       0.0, 60.0);
                tipoSimbolo = 0;
                break;
            case 1:
                //triagolo
                simbolo = new Polygon (30.0, 0.0,
                                       60.0, 60.0,
                                       0.0, 60.0);
                tipoSimbolo = 1;
                break;
            case 2:
                //linea storta
                simbolo = new Polygon (50.0, 0.0,
                                       60.0, 10.0,
                                       10.0, 60.0,
                                       0.0, 50.0);
                tipoSimbolo = 2;
                break;
            case 3:
                //rombo
                simbolo = new Polygon (0.0, 30.0,
                                       30.0, 0.0,
                                       60.0, 30.0,
                                       30.0, 60.0);
                tipoSimbolo = 3;
                break;
            case 4:
                //stella
                simbolo = new Polygon (0.0, 24.0,
                                       24.0, 24.0,
                                       30.0, 0.0,
                                       36.0, 24.0,
                                       60.0, 24.0,
                                       42.0, 36.0,
                                       48.0, 60.0,
                                       30.0, 42.0,
                                       12.0, 60.0,
                                       18.0, 36.0);
                tipoSimbolo = 4;
                break;
            case 5:
                //freccia in giu
                simbolo = new Polygon (0.0, 0.0,
                                       30.0, 20.0,
                                       60.0, 0.0,
                                       30.0, 60.0);
                tipoSimbolo = 5;
                break;
            default:
                break;
        }
        simbolo.setFill(Color.BLUEVIOLET);
        simbolo.setStroke(Color.BLACK);
        simbolo.setStrokeWidth(1);
        this.getChildren().addAll(sfondo, simbolo);
        mw.checkVittoria();
    }
}