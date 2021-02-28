package it.unitn.disi.lingprog.daniele.marcolan.tavolodagioco;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Pane {
    MyButton nuovaPartita, stampa;
    TextField totale, punteggio;
    HBox bottoni, dadiera, testi;
    Rectangle sfondo;
    int totaleDadi, punteggioAttuale;
    int quantiDadi;
    Dado[] dadiInTavola; //Memorizza i dadi presenti in tavola
    
    public MainWindow() {
        totaleDadi = 0;
        punteggioAttuale = 30;
        quantiDadi = 0;
        sfondo = new Rectangle (500, 500);
        sfondo.setFill(Color.GREEN);
        nuovaPartita = new MyButton(this, "Nuova partita");
        nuovaPartita.setMinWidth(250);
        stampa = new MyButton(this, "Stampa");
        stampa.setMinWidth(250);
        totale = new TextField("TOTALE: " + totaleDadi);
        totale.setMinWidth(250);
        totale.setEditable(false);
        punteggio = new TextField("PUNTEGGIO: " + punteggioAttuale);
        punteggio.setMinWidth(250);
        punteggio.setEditable(false);
        bottoni = new HBox();
        testi = new HBox();
        bottoni.getChildren().addAll(nuovaPartita, stampa);
        testi.getChildren().addAll(totale, punteggio);
        testi.setTranslateY(470);
        dadiera = new HBox(10);
        dadiera.setAlignment(Pos.CENTER);
        dadiera.setTranslateY(220);
        dadiera.setTranslateX(100);
        this.getChildren().addAll(sfondo, bottoni, testi, dadiera);
        dadiInTavola = new Dado[5];
        
        /**
         * Genera un nuovo dado al click sul campo verde (se ci sono meno di 5 dadi in tavola)
         */
        sfondo.setOnMouseClicked((evento) -> {
            if (quantiDadi < 5) {
                dadiInTavola[quantiDadi] = new Dado(this);
                dadiera.getChildren().add(dadiInTavola[quantiDadi]);
                totaleDadi = totaleDadi + dadiInTavola[quantiDadi].valore;
                punteggioAttuale = punteggioAttuale - 3;
                aggiornaPunteggio();
                aggiornaTotale();
                quantiDadi++;
            }
        });
        
        this.setOnKeyPressed((evento) -> {
            if (evento.getCode() == KeyCode.S) {
                stampa.print(this);
            }
            else if (evento.getCode() == KeyCode.N) {
                nuovaPartita.reset(this);
            }
        });
    }
    
    /**
     * Aggiorna il text field del punteggio ad ogni modifica
     */
    public void aggiornaPunteggio() {
        punteggio.setText("PUNTEGGIO: " + punteggioAttuale);
    }
    
    /**
     * Aggiorna il text field del totale dadi presenti sul tavolo ad ogni modifica
     * Se il totale arriva a 15, mostra la finestra che annuncia la vittoria
     */
    public void aggiornaTotale() {
        totale.setText("TOTALE: " + totaleDadi);
        if (totaleDadi == 15) {
            StackPane root2 = new StackPane();
            Rectangle sfondo2 = new Rectangle(400, 200);
            sfondo2.setFill(Color.KHAKI);
            Text vittoria = new Text("Hai vinto - Hai ottenuto " + punteggioAttuale + " punti");
            vittoria.setFont(Font.font("Arial", FontWeight.BOLD, 24));
            vittoria.setStroke(Color.PURPLE);
            root2.getChildren().addAll(sfondo2, vittoria);
            Scene scene2 = new Scene(root2, 400, 200);
            Stage secondaryStage = new Stage();
            secondaryStage.setTitle("Partita finita!");
            secondaryStage.setScene(scene2);
            //secondaryStage.show();
            secondaryStage.showAndWait();
            System.exit(0);
        }   
    }
}