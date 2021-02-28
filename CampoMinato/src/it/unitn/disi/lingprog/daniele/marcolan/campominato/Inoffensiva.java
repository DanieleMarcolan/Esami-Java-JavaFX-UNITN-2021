package it.unitn.disi.lingprog.daniele.marcolan.campominato;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Inoffensiva extends Cella {
    int quanteBombeVicine;
    Text numero;
    
    public Inoffensiva() {
        super();
        quanteBombeVicine = 0;
        numero = new Text();
        aggiornaQuanteVicine();
    }
    
    public void aggiornaQuanteVicine() {
        numero.setText("" + quanteBombeVicine);
    }
    
    public void scopri() {
        coperta = false;
        sfondo.setFill(Color.KHAKI);
        sfondo.setStroke(Color.BLACK);
        this.getChildren().add(numero);
    }
}