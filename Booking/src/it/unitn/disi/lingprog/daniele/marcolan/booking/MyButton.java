package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.control.Button;

public class MyButton extends Button {
    public MyButton (MainWindow mw, String etichetta) {
        this.setText(etichetta);

        this.setOnMouseClicked((evento) -> {
            switch (etichetta) {
                case "Nome":
                    mw.listaAlloggi.ordinaPerNome();
                    mw.listaAlloggi.mostra();
                    break;
                case "Prezzo":
                    mw.listaAlloggi.ordinaPerPrezzo();
                    mw.listaAlloggi.mostra();
                    break;
                case "Valutazione":
                    mw.listaAlloggi.ordinaPerValutazione();
                    mw.listaAlloggi.mostra();
                    break;
                default:
                    break;
            }
        });        
    }
}