package it.unitn.disi.lingprog.daniele.marcolan.pratofiorito;

public class Sconfitta extends Cella {
    
    public Sconfitta(MainWindow mw) {
        this.setOnMouseClicked((evento) -> {
            if (this.coperta) {
                scopri();
                mw.mostraSconfitta();
            }
        });
    }
    
    @Override
    public void scopri() {
        coperta = false;
    }
}