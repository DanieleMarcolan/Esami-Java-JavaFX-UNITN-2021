package it.unitn.disi.lingprog.daniele.marcolan.pratofiorito;

import java.util.Random;
import javafx.scene.text.Text;

public class Numerica extends Cella {
    int numero;
    Text labelNumero;
    
    public Numerica(MainWindow mw) {
        Random rng = new Random();
        numero = rng.nextInt(9) + 1;
        labelNumero = new Text("" + numero);
        super.getChildren().add(labelNumero);
        nascondi();
        
        this.setOnMouseClicked((evento) -> {
            if (this.coperta) {
                scopri();
                mw.punteggio += numero;
                mw.aggiornaPunteggio();
            }
        });
    }
    
    public void nascondi() {
        coperta = true;
        labelNumero.setVisible(false);
    }
    
    @Override
    public void scopri() {
        coperta = false;
        labelNumero.setVisible(true);
    }
}