package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.paint.Color;

public class Strada extends Terreno {
    boolean occupata;
    Macchina m;
    
    public Strada(MainWindow mw, int i, int j) {
        super(mw, i, j);
        super.base.setFill(Color.GREY);
        occupata = false;
        m = new Macchina();
        this.getChildren().add(m);
        m.setVisible(false);
            
        this.setOnMouseClicked((evento) -> {
            if (!occupata) {
                if (!mw.bottonePremuto) {
                    swap(mw, i, j);
                    mw.bottonePremuto = false;
                }
                else if (mw.bottonePremuto && mw.quanteAutoDisponibili > 0) {
                    aggiungiAuto();
                    mw.bottonePremuto = false;
                    mw.quanteAutoDisponibili--;
                    mw.aggiornaDisponibilita();
                }
            }
        });
    }
    
    /**
     * Se non c'è una macchina, ne aggiunge una
     */
    public void aggiungiAuto() {
        if (!occupata) {
            m.setVisible(true);
            occupata = true;
        }
    }
    
    public void rimuoviAuto() {
        if (occupata) {
            m.setVisible(false);
            occupata = false;
        }
    }
    
    @Override
    public void swap(MainWindow mw, int i, int j) {
        if (!occupata) {
            mw.griglia.getChildren().remove(this);
            Terreno nuovaCella = new Prato(mw, i, j);
            mw.griglia.add(nuovaCella, j, i);
        }
    }
}