package it.unitn.disi.lingprog.daniele.marcolan.tiroalbersaglio;

import javafx.scene.control.Button;

class MyButton extends Button {
    String etichetta;
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        this.etichetta = etichetta;
        
        switch(etichetta) {
            case "Start":
                mw.attiva= true;
                mw.iniziaGioco();
                break;
        }
    }           
}