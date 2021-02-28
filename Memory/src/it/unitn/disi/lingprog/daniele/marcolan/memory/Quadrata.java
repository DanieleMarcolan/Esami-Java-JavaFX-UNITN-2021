package it.unitn.disi.lingprog.daniele.marcolan.memory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Quadrata extends Cella {
    int cifra;
    Text numero;
    Rectangle quadrato;
    
    public Quadrata(MainWindow mw, int cifra) {
        super(mw);
        this.cifra = cifra;
        
        this.setOnMouseClicked((evento) -> {
            scopri();
            if (mw.quanteScoperte == 0) {
                this.scopri();
                mw.quanteScoperte++;
                mw.celleScoperte[0] = this;
                mw.intScoperta1 = this.cifra;
            }
            else if (mw.quanteScoperte == 1) {
                this.scopri();
                mw.quanteScoperte++;
                mw.celleScoperte[1] = this;
                mw.intScoperta2 = this.cifra;
            }
            else if (mw.quanteScoperte == 2) {
                mw.checkUguali();
            }
        });
    }
    
    public void copri() {
        super.copri();
    }
    
    public void scopri() {
        super.sfondo.setFill(Color.YELLOW);
        if (quadrato != null) {
            this.getChildren().remove(quadrato);
        }
        quadrato = new Rectangle(50, 50);
        quadrato.setFill(Color.BLUE);
        if (numero != null) {
            this.getChildren().remove(numero);
        }
        numero = new Text ("" + cifra);
        numero.setStroke(Color.WHITE);
        super.getChildren().addAll(quadrato, numero);
    }
}