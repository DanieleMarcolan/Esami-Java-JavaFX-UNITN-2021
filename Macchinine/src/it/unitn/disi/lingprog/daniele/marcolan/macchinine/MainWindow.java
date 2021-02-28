package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainWindow extends VBox {
    Griglia griglia;
    int quanteAutoDisponibili;
    HBox barraDiStato;
    Label autoDisponibili;
    MyButton aggiungiAuto;
    MyButton inizia;
    boolean bottonePremuto;
    
    public MainWindow() {
        griglia = new Griglia(this);
        quanteAutoDisponibili = 3;
        autoDisponibili = new Label (" Auto disponibili: " + quanteAutoDisponibili);
        autoDisponibili.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 15));
        autoDisponibili.setPrefWidth(400 / 3);
        autoDisponibili.setPrefHeight(50);
        aggiungiAuto = new MyButton (this, "Aggiungi Auto");
        inizia = new MyButton (this, "Inizia");
                
        barraDiStato = new HBox();
        barraDiStato.setPrefHeight(50);
        barraDiStato.getChildren().addAll(autoDisponibili, aggiungiAuto, inizia);
        
        this.getChildren().addAll(griglia, barraDiStato);
        
        bottonePremuto = false;
    }
    
    public void aggiornaDisponibilita() {
        autoDisponibili.setText(" Auto disponibili: " + quanteAutoDisponibili);
        if (quanteAutoDisponibili <= 0) {
            aggiungiAuto.setDisable(true);
        }
    }
}