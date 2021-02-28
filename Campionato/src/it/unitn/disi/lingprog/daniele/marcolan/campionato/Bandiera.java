package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.layout.StackPane;

public abstract class Bandiera extends StackPane {
    
    public Bandiera() {
        this.setPrefSize(30, 20);
    }
    
    public abstract void build(String nomeSquadra);
}