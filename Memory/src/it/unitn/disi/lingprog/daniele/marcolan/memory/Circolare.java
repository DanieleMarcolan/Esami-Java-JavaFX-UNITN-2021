package it.unitn.disi.lingprog.daniele.marcolan.memory;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Circolare extends Cella {
    char carattere;
    Text lettera;
    Circle cerchio;
    
    public Circolare(MainWindow mw, char carattere) {
        super(mw);
        this.carattere = carattere;
        
        this.setOnMouseClicked((evento) -> {
            scopri();
            if (mw.quanteScoperte == 0) {
                this.scopri();
                mw.quanteScoperte++;
                mw.celleScoperte[0] = this;
                mw.charScoperta1 = this.carattere;
            }
            else if (mw.quanteScoperte == 1) {
                this.scopri();
                mw.quanteScoperte++;
                mw.celleScoperte[1] = this;
                mw.charScoperta2 = this.carattere;
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
        if (cerchio != null) {
            this.getChildren().remove(cerchio);
        }
        cerchio = new Circle(30);
        cerchio.setFill(Color.BLUE);
        if (lettera != null) {
            this.getChildren().remove(lettera);
        }
        lettera = new Text ("" + carattere);
        lettera.setStroke(Color.WHITE);
        super.getChildren().addAll(cerchio, lettera);
    }
}