package it.unitn.disi.lingprog.daniele.marcolan.concessionario;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyButton extends Button {
    
    public MyButton(MainWindow mw, String etichetta) {
        super(etichetta);
        
        this.setOnMouseClicked((evento) -> {
            if (etichetta == "New Auto") {
                mw.creaStageAuto();
            }
            if (etichetta == "New Person") {
                mw.creaStagePersona();
            }
            if (etichetta == "Conta Auto") {
                mw.boxAutomobili.getChildren().clear();
                int conta = mw.listaAutomobili.size();
                mw.boxAutomobili.getChildren().add(new Label("" + conta));
            }
            if (etichetta == "Conta Persone") {
                mw.boxPersone.getChildren().clear();
                int conta = mw.listaPersone.size();
                mw.boxPersone.getChildren().add(new Label("" + conta));
            }
            if (etichetta == "Mescola Auto") {
                ArrayList<Automobile> l = new ArrayList<Automobile>();
                l.addAll(mw.listaAutomobili);
                Collections.shuffle(l);
                mw.stampaBoxAutomobili(l);
            }
            if (etichetta == "Mescola Persone") {
                ArrayList<Persona> l = new ArrayList<Persona>();
                l.addAll(mw.listaPersone);
                Collections.shuffle(l);
                mw.stampaBoxPersone(l);
            }
            if (etichetta == "Ordina Auto") {
                ArrayList l = new ArrayList<>();
                l.addAll(mw.listaAutomobili);
                mw.ordina(l);
                mw.stampaBoxAutomobili(l);
            }
            if (etichetta == "Ordina Persone") {
                ArrayList l = new ArrayList<>();
                l.addAll(mw.listaPersone);
                mw.ordina(l);
                mw.stampaBoxPersone(l);
            }
            if (etichetta == "Ordina per anno") {
                ArrayList l = new ArrayList<>();
                l.addAll(mw.listaPersone);
                mw.ordinaSullIntero(l);
                mw.stampaBoxPersone(l);
            }
            if (etichetta == "Ordina per prezzo") {
                ArrayList l = new ArrayList<>();
                l.addAll(mw.listaAutomobili);
                mw.ordinaSullIntero(l);
                mw.stampaBoxAutomobili(l);
            }
        });
    } 
}