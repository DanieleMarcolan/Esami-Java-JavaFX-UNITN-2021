package it.unitn.disi.lingprog.daniele.marcolan.macchinine;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Griglia extends GridPane {
    
    public Griglia(MainWindow mw) {
        ColumnConstraints cc = new ColumnConstraints(400 / 8);
        this.getColumnConstraints().addAll(cc, cc, cc, cc, cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints(400 / 8);
        this.getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc);
        inizializzaGriglia(mw);
    }
    
    /**
     * Riempie la griglia, con celle Strada sul bordo e celle Prato all'interno
     */
    public void inizializzaGriglia(MainWindow mw) {
        Terreno cella = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 8 - 1 || j == 0 || j == 8 - 1) {
                    cella = new Strada(mw, i, j);
                    this.add(cella, j, i);
                }
                else {
                    cella = new Prato(mw, i, j);
                    this.add(cella, j, i);
                }
            }
        }
    }
    
    public Strada getElementAt(Griglia griglia, int i, int j) {
        for (Node x : this.getChildren()) {
            if (Griglia.getRowIndex(x) == i && Griglia.getColumnIndex(x) == j && x instanceof Strada) {
                return (Strada)x;
            }
        }
        return null;
    }
    
    /**
     * Sposta la macchina in base alle coordinate passate
     * Se due finierebbero una sopra l'altra, faccio un alert
     */
    public void sposta(Strada t, Strada s) {
        if (t != null && s != null && t.occupata && !s.occupata) {
            t.rimuoviAuto();
            s.aggiungiAuto();
        }
        if (t != null && s != null && t.occupata && s.occupata) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("CRASH");
            alert.showAndWait();
            System.exit(0);
        }
    }   
}