package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainWindow extends GridPane {
    Girone g1;
    Girone g2;
    Girone g3;
    Girone g4;
    
    public MainWindow() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(350);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(350);
        this.getColumnConstraints().addAll(cc, cc);
        this.getRowConstraints().addAll(rc, rc);

        g1 = new Girone (new Squadra("Austria"), new Squadra("Francia"),
                         new Squadra("Italia"), new Squadra("Germania"));
        g2 = new Girone (new Squadra("Olanda"), new Squadra("Bulgaria"),
                         new Squadra("Russia"), new Squadra("Spagna"));
        g3 = new Girone (new Squadra("Svezia"), new Squadra("Belgio"),
                         new Squadra("Irlanda"), new Squadra("Ungheria"));
        g4 = new Girone (new Squadra("Ucraina"), new Squadra("Polonia"),
                         new Squadra("Finlandia"), new Squadra("Danimarca"));
        
        this.add(g1, 0, 0);
        this.add(g2, 1, 0);
        g2.cambiaSfondo();
        this.add(g3, 0, 1);
        g3.cambiaSfondo();
        this.add(g4, 1, 1);
        
        creaPulsantiera();
    }
    
    public void creaPulsantiera() {
        Pulsantiera controllo = new Pulsantiera(this);
        Scene sceneControllo = new Scene (controllo, 450, 200);
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Gioca!");
        secondaryStage.setScene(sceneControllo);
        secondaryStage.show();
        secondaryStage.setAlwaysOnTop(true); //Piazza la pulsantiera in sovrimpressione
    }   
}