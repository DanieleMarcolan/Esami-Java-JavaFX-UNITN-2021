package it.unitn.disi.lingprog.daniele.marcolan.griglia;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends VBox {
    int N; //dimensione griglia, dato in input
    HBox barraAlg;
    HBox barraBottoni;
    GridPane griglia;
    AlgButton alg1, alg2, alg3;
    MyButton print, clear, step;
    int stato; //discriminante su quale algoritmo applicare, viene modificato dai bottoni alg
    
    public MainWindow(int N) {
        this.N = N;
        stato = 1;
        this.setSpacing(0);
        buildFinestra();
        
        this.setOnKeyPressed((evento) -> {
            if (evento.getCode() == KeyCode.C) {
                pulisci();
            }
            if (evento.getCode() == KeyCode.S) {
                effettuaStep();
            }
        });
    }
    
    public void buildFinestra() {
        barraAlg = new HBox(N * 5);
        barraAlg.setPrefHeight(20);
        barraBottoni = new HBox (N * 5);
        barraBottoni.setPrefHeight(20);
        alg1 = new AlgButton(this, "Alg 1");
        alg1.setDisable(true);
        alg2 = new AlgButton(this, "Alg 2");
        alg3 = new AlgButton(this, "Alg 3");
        print = new MyButton(this, "Print");
        clear = new MyButton(this, "Clear");
        step = new MyButton(this, "Step");
        barraAlg.getChildren().addAll(alg1, alg2, alg3);
        barraBottoni.getChildren().addAll(print, clear, step);
        barraAlg.setAlignment(Pos.CENTER);
        barraBottoni.setAlignment(Pos.CENTER);
        
        /**
         * Inizializzo la griglia, uso una funziona buildGriglia(GridPane g)
         * Perché poi mi servirà anche per stampare la matrice di occupazione
         */
        griglia = new GridPane();
        buildGriglia(griglia);
        Cella c;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c = new Cella();
                griglia.add(c, j, i);
            }
        }
        
        this.getChildren().addAll(barraAlg, griglia, barraBottoni);
    }
    
    public void buildGriglia(GridPane griglia) {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(100);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(100);
        for (int i = 0; i < N; i++) {
            griglia.getColumnConstraints().add(cc);
            griglia.getRowConstraints().add(rc);
        }
    }
    
    public Cella getElementAt(GridPane griglia, int i, int j) {
        for (Node x : griglia.getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return (Cella)x;
            }
        }
        return null;
    }
    
    public void effettuaStep() {
        Cella c1 = null;
        Cella c2 = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                switch (stato) {
                    case 1:
                        c1 = getElementAt(griglia, i, j);
                        if (c1.cerchio.isVisible()) {
                            c2 = getElementAt(griglia, i - 1, j + 1);
                        }
                        break;
                    case 2:
                        c1 = getElementAt(griglia, i, j);
                        if (c1.cerchio.isVisible()) {
                            c2 = getElementAt(griglia, i, j - 1);
                        }
                        break;
                    /**
                     * Qui devo scorrere la matrice al contrario, altrimenti fa effetto cascata
                     * Parto dal fondo e risalgo, applicando così i cambiamenti a celle già visitate
                     */
                    case 3:
                        c1 = getElementAt(griglia, N - i - 1, N - j - 1);
                        if (c1.cerchio.isVisible()) {
                            c2 = getElementAt(griglia, N - i, N - j - 1);
                        }
                        break;
                    default:
                        break;
                }
                /**
                 * Se non è su un bordo e la cella di destinazione non è occupata
                 */
                if (c2 != null && !c2.cerchio.isVisible()) {
                    c1.cerchio.setVisible(false);
                    c2.cerchio.setVisible(true);
                }
            }
        }
    }               
    
    /**
     * Rende tutti i cerchi invisibili
     */
    public void pulisci() {
        Cella c;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c = getElementAt(griglia, i, j);
                c.cerchio.setVisible(false);
            }
        }
    }
    
    /**
     * Stampa la matrice di occupazione, con buildGriglia(GridPane g)
     */
    public void stampa() {
        GridPane matrice = new GridPane();
        buildGriglia(matrice);
        Text scritta;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (getElementAt(griglia, i, j).cerchio.isVisible()) {
                    scritta = new Text("1");
                }
                else {
                    scritta = new Text("0");
                }
                matrice.add(scritta, j, i);
            }
        }
        Scene scene3 = new Scene(matrice, N * 100, N * 100);
        Stage stage3 = new Stage();
        stage3.setTitle("Matrice di occupazione:");
        stage3.setScene(scene3);
        stage3.show();
    }
}