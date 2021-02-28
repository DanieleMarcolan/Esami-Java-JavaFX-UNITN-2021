package it.unitn.disi.lingprog.daniele.marcolan.tavolodagioco;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyButton extends Button {
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        
        if (etichetta == "Nuova partita") {
            this.setOnAction((evento) -> {
                reset(mw);
            });
        }
        
        if (etichetta == "Stampa") {
            this.setOnAction((evento) -> {
                print(mw);
            });
        }
    }
    
    /**
    *  Resetta allo stato iniziale 
    */    
    public void reset(MainWindow mw) {
        mw.dadiera.getChildren().clear();
        mw.totaleDadi = 0;
        mw.punteggioAttuale = 30;
        mw.quantiDadi = 0;
        mw.aggiornaPunteggio();
        mw.aggiornaTotale();
    }
    
    /**
     * Crea una finestra che stampa i valori dei dadi, il punteggio e il totale dei valori dei dadi
     */
    public void print(MainWindow mw) {
        VBox root = new VBox(10);
        Text[] listaDadi = new Text[mw.quantiDadi];
        for (int i = 0; i < mw.quantiDadi; i++) {
            String testo = "Dado " + (i + 1) + ": " + mw.dadiInTavola[i].valore;
            listaDadi[i] = new Text(testo);
            listaDadi[i].setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
            listaDadi[i].setStroke(Color.PURPLE);
            root.getChildren().add(listaDadi[i]);
        }
        Text stampaTotale = new Text("Totale attuale: " + mw.totaleDadi);
        stampaTotale.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
        stampaTotale.setStroke(Color.PURPLE);
        Text stampaPunteggio = new Text("Punteggio attuale: " + mw.punteggioAttuale);
        stampaPunteggio.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 20));
        stampaPunteggio.setStroke(Color.PURPLE);
        root.getChildren().addAll(stampaTotale, stampaPunteggio);
        Scene anotherScene = new Scene(root, 200, 400);
        Stage anotherStage = new Stage();
        anotherStage.setTitle("Situazione attuale:");
        anotherStage.setScene(anotherScene);
        anotherStage.show();
    }        
}