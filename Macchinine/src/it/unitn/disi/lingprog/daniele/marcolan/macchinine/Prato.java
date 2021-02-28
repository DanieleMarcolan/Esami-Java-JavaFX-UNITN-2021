package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.paint.Color;

public class Prato extends Terreno {
    
    public Prato(MainWindow mw, int i, int j) {
        super(mw, i, j);
        super.base.setFill(Color.GREEN);
        
        /**
         * Trasforma la cella in strada
         */
        this.setOnMouseClicked((evento) -> {
            this.swap(mw, i, j);
            mw.bottonePremuto = false;
        });
    }
    
    @Override
    public void swap(MainWindow mw, int i, int j) {
        mw.griglia.getChildren().remove(this);
        Terreno nuovaCella = new Strada(mw, i, j);
        mw.griglia.add(nuovaCella, j, i);
    }
}