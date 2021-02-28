package it.unitn.disi.lingprog.daniele.marcolan.slotmachine;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends BorderPane {
    BarraBottoni bottoni;
    HBox contatori;
    HBox hBoxSimboli;
    CellaSimbolo schermoSimboli1;
    CellaSimbolo schermoSimboli2;
    CellaSimbolo schermoSimboli3;
    Salvadanaio salvadanaio;
    VBox schermo;
    Label labelCredito;
    Label labelPunteggio;
    
    int credito;
    int punteggio;
    
    public MainWindow() {
        build();
    }
    
    public void build() {
        Titolo title = new Titolo();
        this.setTop(title);
        
        credito = 0;
        punteggio = 0;
        
        bottoni = new BarraBottoni(this);
        this.setBottom(bottoni);
        
        schermo = new VBox();
        
        hBoxSimboli = new HBox();
        hBoxSimboli.setPrefSize(400, 200);
        schermoSimboli1 = new CellaSimbolo(this);
        schermoSimboli2 = new CellaSimbolo(this);
        schermoSimboli3 = new CellaSimbolo(this);
        hBoxSimboli.getChildren().addAll(schermoSimboli1, schermoSimboli2, schermoSimboli3);
        
        contatori = new HBox(50);
        contatori.setPrefSize(400, 100);
        labelCredito = new Label();
        labelPunteggio = new Label();
        aggiornaCredito();
        aggiornaPunteggio();
        labelCredito.setPrefSize(150, 100);
        labelPunteggio.setPrefSize(150, 100);
        labelCredito.setTranslateX(50);
        labelPunteggio.setTranslateX(50);
        contatori.getChildren().addAll(labelCredito, labelPunteggio);
        
        schermo.getChildren().addAll(hBoxSimboli, contatori);
        this.setCenter(schermo);
        
        salvadanaio = new Salvadanaio(this);
        this.setRight(salvadanaio);
    }
          
    public void aggiornaCredito() {
        labelCredito.setText("Credito: " + credito);
        if (credito >= 100) {
            this.bottoni.spin.setDisable(false);
            this.bottoni.pay.setDisable(false);
        }
        else if (credito == 0) {
            this.bottoni.spin.setDisable(true);
            this.bottoni.pay.setDisable(true);
        }
    }
    
    public void aggiornaPunteggio() {
        labelPunteggio.setText("Punteggio: " + punteggio);
    }
     
    public void checkVittoria() {
        if (this.schermoSimboli1 != null && this.schermoSimboli2 != null && this.schermoSimboli3 != null) {
            if (this.schermoSimboli1.tipoSimbolo == this.schermoSimboli2.tipoSimbolo &&
            this.schermoSimboli2.tipoSimbolo == this.schermoSimboli3.tipoSimbolo) {
                StackPane root = new StackPane();
                Text scritta = new Text("Hai vinto!");
                scritta.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
                Rectangle sfondo = new Rectangle(400, 200);
                sfondo.setFill(Color.KHAKI);
                root.getChildren().addAll(sfondo, scritta);
                Stage secondaryStage = new Stage();
                Scene scene2 = new Scene (root, 400, 200);
                secondaryStage.setScene(scene2);
                secondaryStage.setTitle("VITTORIA");
                secondaryStage.showAndWait();
                
                this.credito += this.punteggio * 100;
                this.punteggio = 0;
                aggiornaCredito();
                aggiornaPunteggio();
            }
        }
    }  
}