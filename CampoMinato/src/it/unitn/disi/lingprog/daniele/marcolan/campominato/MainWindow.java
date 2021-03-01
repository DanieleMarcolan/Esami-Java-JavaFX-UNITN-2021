package it.unitn.disi.lingprog.daniele.marcolan.campominato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {
    GridPane griglia;
    HBox buttonBar;
    MyButton random, test, abbandona, sbircia;
    Label celleDaScoprire;
    int quanteDaScoprire;
    boolean bottonePremuto;
    
    public MainWindow() {
        buildGriglia();
        inizializzaFinestra();
        this.setSpacing(0);
        bottonePremuto = false;
    }
    
    public void buildGriglia() {
        griglia = new GridPane();
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(60);
        griglia.getColumnConstraints().addAll(cc, cc, cc, cc, cc, cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(60);
        griglia.getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc);
        this.getChildren().add(griglia);
    }
            
    public void inizializzaFinestra() {
        quanteDaScoprire = 71;
        buttonBar = new HBox(15);
        buttonBar.setPrefHeight(60);
        celleDaScoprire = new Label("Celle da scoprire:\t" + quanteDaScoprire);
        celleDaScoprire.setPrefHeight(60);
        random = new MyButton(this, "Random");
        test = new MyButton(this, "Test");
        abbandona = new MyButton(this, "Abbandona");
        abbandona.setDisable(true);
        sbircia = new MyButton(this, "Sbircia");
        sbircia.setDisable(true);
        buttonBar.getChildren().addAll(random ,test, abbandona, sbircia, celleDaScoprire);
        this.getChildren().add(buttonBar);
    }
    
    //Uso un ArrayList per prendere tutte le 81 celle (partendo da popolaGrigliaRandom())
    //Collections.shuffle() per rodinarle a caso e reinserirle
    public void popolaGrigliaRandom() {
        popolaGrigliaTest();        
        ArrayList<Cella> tutte = new ArrayList<Cella>();
        for (Node x : this.griglia.getChildren()) {
            tutte.add((Cella)x);
        }
        Collections.shuffle(tutte);
        griglia.getChildren().clear();
        
        Cella c;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = tutte.get(i * 9 + j); //per prendere l'indice giusto
                //c.scopri(); //debug
                griglia.add(c, j, i);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Node x = getElementAt(griglia, i, j);
                if (x instanceof Inoffensiva) {
                    ((Inoffensiva)x).quanteBombeVicine = contaVicine(i, j);
                    ((Inoffensiva)x).aggiornaQuanteVicine();
                }
            }
        }
    }
    
    public void popolaGrigliaTest() {
        Cella b1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j || (i == 0 && j == 8)) {
                    b1 = new Bomba();
                    griglia.add(b1, j, i);
                    //b1.scopri(); //debug
                }
            }
        }
        Cella b2;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != j && (i != 0 || j != 8)) {
                    b2 = new Inoffensiva();
                    ((Inoffensiva)b2).quanteBombeVicine = contaVicine(i, j);
                    ((Inoffensiva)b2).aggiornaQuanteVicine();
                    griglia.add(b2, j, i);
                    //b2.scopri(); //debug
                }
            }
        }
    }
    
    public int contaVicine(int riga, int colonna) {
        int contatore = 0;
        if (getElementAt(this.griglia, riga-1, colonna-1) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga-1, colonna) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga-1, colonna+1) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga, colonna-1) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga, colonna) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga, colonna+1) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga+1, colonna-1) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga+1, colonna) instanceof Bomba) {
            contatore++;
        }
        if (getElementAt(this.griglia, riga+1, colonna+1) instanceof Bomba) {
            contatore++;
        }
        return contatore;
    }
    
    public Node getElementAt(GridPane griglia, int i, int j) {
        for (Node x : griglia.getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }
    
    public void attivaCelle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Cella c = (Cella)getElementAt(griglia, i, j);
                c.setOnMouseClicked((evento) -> {
                    if (!bottonePremuto) {
                        if (c instanceof Inoffensiva) {
                            if (c.coperta) {
                                quanteDaScoprire--;
                                c.scopri();
                            }
                            celleDaScoprire.setText("Celle da scoprire:\t" + quanteDaScoprire);
                            if (quanteDaScoprire == 0) {
                                Alert vittoria = new Alert(Alert.AlertType.INFORMATION);
                                vittoria.setTitle("Vittoria");
                                vittoria.setContentText("BRAVO");
                                vittoria.showAndWait();
                                this.getChildren().clear();
                                buildGriglia();
                                inizializzaFinestra();
                            }
                        }
                        if (c instanceof Bomba) {
                            c.scopri();
                            Alert sconfitta = new Alert(Alert.AlertType.WARNING);
                            sconfitta.setTitle("Sconfitta");
                            sconfitta.setContentText("GIT GUD");
                            sconfitta.showAndWait();
                            this.getChildren().clear();
                            buildGriglia();
                            inizializzaFinestra();
                        }
                    }
                    else if (bottonePremuto) {
                        Alert hint = new Alert(Alert.AlertType.INFORMATION);
                        hint.setTitle("Suggerimento");
                        if (c instanceof Bomba) {
                            hint.setContentText("E' una bomba!");
                        }
                        if (c instanceof Inoffensiva) {
                            hint.setContentText("Don't worry be happy");
                        }
                        hint.show();
                        bottonePremuto = false;
                        sbircia.setDisable(true);
                    }
                });
            }
        }
    }
}
