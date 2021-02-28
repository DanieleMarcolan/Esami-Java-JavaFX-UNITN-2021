package it.unitn.disi.lingprog.daniele.marcolan.hanoi;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyButton extends Button {
    String etichetta;
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        this.etichetta = etichetta;
        
        this.setOnMouseClicked((evento) -> {
            switch(etichetta) {
                case "Clear":
                    mw.paloDiPartenza = null;
                    mw.paloDiArrivo = null;
                    mw.from.setText("");
                    mw.to.setText("");
                    break;
                case "Reset":
                    mw.getChildren().clear();
                    mw.buildFinestra();
                    mw.buildGioco();
                    break;
                case "Move":
                    if (mw.paloDiPartenza == null || mw.paloDiArrivo == null) {
                        mw.stampaErrore("Pali di partenza e arrivo non definiti");
                    }
                    Disco d = mw.paloDiPartenza.qualiDischi.get(mw.paloDiPartenza.qualiDischi.size() - 1);
                    if (d.posizionaNelPalo(mw, mw.paloDiArrivo)) {
                        mw.paloDiPartenza.qualiDischi.remove(d);
                        mw.paloDiPartenza = null;
                        mw.paloDiArrivo = null;
                    }
                    else {
                        mw.stampaErrore("Impossibile appoggiare un disco su uno più piccolo");
                    }
                    break;
                default:
                    break;
            }
        });
    }
    
    public void togliAlert(Stage stage) {
        this.setOnMouseClicked((evento2) -> {
            if (this.etichetta == "Close") {
                stage.close();
            }
        });
    }
}