package it.unitn.disi.lingprog.daniele.marcolan.pratofiorito;

public class Vittoria extends Cella {
    
    public Vittoria(MainWindow mw) {
        this.setOnMouseClicked((evento) -> {
            if (this.coperta) {
                scopri();
                mw.mostraVittoria();
                mw.partiteVinte++;
                mw.aggiornaPartiteVinte();
            }
        });
    }
    
    @Override
    public void scopri() {
        coperta = false;
    }
}