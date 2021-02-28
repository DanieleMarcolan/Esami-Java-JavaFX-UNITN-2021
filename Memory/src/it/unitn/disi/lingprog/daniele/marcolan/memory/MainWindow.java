package it.unitn.disi.lingprog.daniele.marcolan.memory;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainWindow extends VBox {
    GridPane griglia;
    HBox barraDiStato;
    MyButton randomReset;
    Text rimanenti;
    int quanteRimanenti;
    int quanteScoperte;
    char charScoperta1;
    char charScoperta2;
    int intScoperta1;
    int intScoperta2;
    Cella[] celleScoperte;
    
    public MainWindow() {
        griglia = new GridPane();
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(100);
        griglia.getColumnConstraints().addAll(cc, cc, cc, cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(85);
        griglia.getRowConstraints().addAll(rc, rc, rc, rc, rc);
        
        randomReset = new MyButton(this, "Random Reset");
        
        quanteRimanenti = 24;
        rimanenti = new Text("" + quanteRimanenti);
        
        barraDiStato = new HBox(20);
        barraDiStato.setPrefHeight(25);
        barraDiStato.setAlignment(Pos.CENTER);
        barraDiStato.getChildren().addAll(randomReset, rimanenti);
        
        this.getChildren().addAll(griglia, barraDiStato);
        
        build();
        
        quanteScoperte = 0;
        celleScoperte = new Cella[2];
    }
    
    public void aggiornaRimanenti() {
        rimanenti.setText("" + quanteRimanenti);
    }
    
    public void build() {
        Cella x;
        int valore = 0;
        char carattere = 'a';
        int controller = 0;
        int controller2 = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 4 && j == 4) {
                    x = new Killer(this);
                    griglia.add(x, j, i);
                    //x.scopri(); //debug
                }
                else if ((i < 2) || (i == 2 && j < 2)) {
                    x = new Quadrata(this, valore);
                    if (controller % 2 != 0) {
                        valore++;
                    }
                    controller++;
                    griglia.add(x, j, i);
                    //x.scopri(); //debug
                }
                else {
                    x = new Circolare(this, carattere);
                    if (controller2 % 2 != 0) {
                        carattere++;
                    }
                    controller2++;
                    griglia.add(x, j, i);
                    //x.scopri(); //debug
                }
            }
        }
    }
    
    public void checkUguali() {
        if (charScoperta1 != charScoperta2) {
            celleScoperte[0].copri();
            celleScoperte[1].copri();
            quanteScoperte = 0;
            charScoperta1 = 'z';
            charScoperta2 = 'z';
        }
        else {
            
        }
    }
}