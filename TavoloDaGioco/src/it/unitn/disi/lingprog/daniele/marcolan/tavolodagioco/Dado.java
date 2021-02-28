package it.unitn.disi.lingprog.daniele.marcolan.tavolodagioco;

import java.util.Random;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Dado extends StackPane {
    Rectangle base;
    int valore;
    
    public Dado(MainWindow mw) {
        base = new Rectangle (50, 50);
        base.setStroke(Color.BLACK);
        base.setStrokeWidth(2);
        this.getChildren().add(base);
        base.setFill(Color.WHITE);
        assegnaValore();
        
        /**
         * Assegna un nuovo valore random al dado cliccato, decrementando il punteggio di 1 e aggiornando il totale
         */
        this.setOnMouseClicked((evento) -> {
            mw.totaleDadi = mw.totaleDadi - this.valore;
            assegnaValore();
            mw.punteggioAttuale--;
            mw.totaleDadi = mw.totaleDadi + this.valore;
            mw.aggiornaPunteggio();
            mw.aggiornaTotale();
        });
    }
        
    /**
     * Assegna un valore random al dado e ne crea la componente grafica
     */
    public void assegnaValore () {
        Random rng = new Random();
        this.valore = rng.nextInt(6) + 1; //Genera il valore casuale del dado, da 1 a 6
        this.getChildren().clear();
        this.getChildren().add(base);
        switch (valore) {
            case 1:
                Pallino p1 = new Pallino();
                this.getChildren().add(p1);
                break;
            case 2:
                Pallino[] p2 = new Pallino[valore];
                for (int i = 0; i < valore; i++) {
                    p2[i] = new Pallino();
                    this.getChildren().add(p2[i]);
                }
                p2[0].setTranslateX(17);
                p2[0].setTranslateY(-17);
                p2[1].setTranslateX(-17);
                p2[1].setTranslateY(17);
                break;
            case 3:
                Pallino[] p3 = new Pallino[valore];
                for (int i = 0; i < valore; i++) {
                    p3[i] = new Pallino();
                    this.getChildren().add(p3[i]);
                }
                p3[0].setTranslateX(17);
                p3[0].setTranslateY(-17);
                p3[1].setTranslateX(-17);
                p3[1].setTranslateY(17);
                break;
            case 4:
                Pallino[] p4 = new Pallino[valore];
                for (int i = 0; i < valore; i++) {
                    p4[i] = new Pallino();
                    this.getChildren().add(p4[i]);
                }
                p4[0].setTranslateX(17);
                p4[0].setTranslateY(-17);
                p4[1].setTranslateX(-17);
                p4[1].setTranslateY(17);
                p4[2].setTranslateX(17);
                p4[2].setTranslateY(17);
                p4[3].setTranslateX(-17);
                p4[3].setTranslateY(-17);
                break;
            case 5:
                Pallino[] p5 = new Pallino[valore];
                for (int i = 0; i < valore; i++) {
                    p5[i] = new Pallino();
                    this.getChildren().add(p5[i]);
                }
                p5[0].setTranslateX(17);
                p5[0].setTranslateY(-17);
                p5[1].setTranslateX(-17);
                p5[1].setTranslateY(17);
                p5[2].setTranslateX(17);
                p5[2].setTranslateY(17);
                p5[3].setTranslateX(-17);
                p5[3].setTranslateY(-17);
                break;
            case 6:
                Pallino[] p6 = new Pallino[valore];
                for (int i = 0; i < valore; i++) {
                    p6[i] = new Pallino();
                    this.getChildren().add(p6[i]);
                }
                p6[0].setTranslateX(17);
                p6[0].setTranslateY(-17);
                p6[1].setTranslateX(-17);
                p6[1].setTranslateY(17);
                p6[2].setTranslateX(17);
                p6[2].setTranslateY(17);
                p6[3].setTranslateX(-17);
                p6[3].setTranslateY(-17);
                p6[4].setTranslateX(17);
                p6[5].setTranslateX(-17);
                break;
            default:
                break;
        }
    }   
}