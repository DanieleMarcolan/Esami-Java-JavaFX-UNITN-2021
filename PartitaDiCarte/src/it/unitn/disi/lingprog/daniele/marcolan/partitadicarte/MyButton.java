package it.unitn.disi.lingprog.daniele.marcolan.partitadicarte;

import javafx.scene.control.Button;

class MyButton extends Button {
    String etichetta;
    
    public MyButton(String etichetta) {
        super(etichetta);
        this.etichetta = etichetta;
    }
}