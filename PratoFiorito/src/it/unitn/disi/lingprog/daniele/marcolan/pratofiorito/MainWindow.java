package it.unitn.disi.lingprog.daniele.marcolan.pratofiorito;

import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class MainWindow extends BorderPane {
    HBox barraDiStato;
    Text labelPunteggio, labelPartiteVinte;
    int punteggio, partiteVinte;
    GridPane griglia;
    HBox barraBottoni;
    MyButton reset, cheat;
    
    public MainWindow() {
        punteggio = 0;
        partiteVinte = 0;
        build();
    }
    
    public void build() {
        barraDiStato = new HBox(20);
        labelPunteggio = new Text();
        aggiornaPunteggio();
        labelPartiteVinte = new Text();
        aggiornaPartiteVinte();
        barraDiStato.getChildren().addAll(labelPunteggio, labelPartiteVinte);
        barraDiStato.setAlignment(Pos.CENTER);
        this.setTop(barraDiStato);
        
        griglia = new GridPane();
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(100);
        griglia.getColumnConstraints().addAll(cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(100);
        griglia.getRowConstraints().addAll(rc, rc, rc, rc);
        
        ArrayList<Cella> listaCelle = new ArrayList<Cella>();
        Cella c;
        for (int i = 0; i < 16; i++) {
            if (i == 0) {
                c = new Vittoria(this);
            }
            else if (i == 1) {
                c = new Sconfitta(this);
            }
            else {
                c = new Numerica(this);
            }
            listaCelle.add(c);
        }
    
        Collections.shuffle(listaCelle);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                c = listaCelle.get(i * 4 + j);
                griglia.add(c, j, i);
            }
        }
        
        griglia.setAlignment(Pos.CENTER);
        this.setCenter(griglia);
        
        barraBottoni = new HBox(0);
        reset = new MyButton("Reset");
        cheat = new MyButton("Cheat");
        barraBottoni.getChildren().addAll(reset, cheat);
        barraBottoni.setAlignment(Pos.CENTER);
        this.setBottom(barraBottoni);
    }
    
    public void aggiornaPunteggio() {
        labelPunteggio.setText("Punteggio: " + punteggio);
    }
    
    public void aggiornaPartiteVinte() {
        labelPartiteVinte.setText("Partite vinte: " + partiteVinte);
    }
    
    public void mostraVittoria() {
        System.out.println("Complimenti, hai vinto!");
        partiteVinte++;
        aggiornaPartiteVinte();
        punteggio = 0;
        aggiornaPunteggio();
        this.getChildren().clear();
        build();
    }
    
    public void mostraSconfitta() {
        System.out.println("Peccato, hai perso!");
        System.exit(0);
    }
    
    public Cella getElementAt(GridPane griglia, int i, int j) {
        for (Node x : griglia.getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return (Cella)x;
            }
        }
        return null;
    }
}