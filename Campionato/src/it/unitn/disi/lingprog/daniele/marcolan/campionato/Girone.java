package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Girone extends VBox {
    Label primaGiornata;
    Label secondaGiornata;
    Label terzaGiornata;
    Label classifica;
    Incontro[] incontri; 
    HBox[] posizioniClassifica;
    Label[] squadreClassifica;
    ArrayList<Squadra> squadre;
    
    public Girone(Squadra s1, Squadra s2, Squadra s3, Squadra s4) {
        squadre = new ArrayList<Squadra>(); 
        squadre.add(s1);
        squadre.add(s2);
        squadre.add(s3);
        squadre.add(s4);
        this.setSpacing(4);
        primaGiornata = new Label ("===1a giornata===");
        secondaGiornata = new Label ("===2a giornata===");
        terzaGiornata = new Label ("===3a giornata===");
        classifica = new Label ("\t\t\t\t CLASSIFICA");
        incontri = new Incontro[6];
        incontri[0] = new Incontro(s1, s2);
        incontri[1] = new Incontro(s3, s4);
        incontri[2] = new Incontro(s1, s3);
        incontri[3] = new Incontro(s2, s4);
        incontri[4] = new Incontro(s1, s4);
        incontri[5] = new Incontro(s2, s3);
        
        this.getChildren().addAll(primaGiornata, incontri[0], incontri[1],
                                  secondaGiornata, incontri[2], incontri[3],
                                  terzaGiornata, incontri[4], incontri[5],
                                  classifica);
        
        posizioniClassifica = new HBox[4];
        squadreClassifica = new Label[4];
        for (int i = 0; i < 4; i++) {
            posizioniClassifica[i] = new HBox(50);
            squadreClassifica[i] = new Label();
            squadreClassifica[i].setText(squadre.get(i).punteggio + "  " + squadre.get(i).nome);
            posizioniClassifica[i].getChildren().addAll(squadreClassifica[i], squadre.get(i).bandiera);
            this.getChildren().add(posizioniClassifica[i]);    
        }
    }
    
    /**
    *Mette lo sfondo color Khaki per due pannelli 
    */
    public void cambiaSfondo(){
        this.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    public void giocaGiornata(int numeroGiornata) {
        incontri[numeroGiornata].giocaPartita(this);
        aggiornaClassifica();
    }
    
    public void aggiornaClassifica() {
        Collections.sort(squadre, new ComparatoreSquadre());
        for (int i = 0; i < 4; i++) {
            this.getChildren().remove(posizioniClassifica[i]);
            posizioniClassifica[i] = new HBox(50);
            squadreClassifica[i] = new Label();
            
            squadreClassifica[i].setText(squadre.get(i).punteggio + "  " + squadre.get(i).nome);
            posizioniClassifica[i].getChildren().addAll(squadreClassifica[i], squadre.get(i).bandiera);
            
            this.getChildren().add(posizioniClassifica[i]); 
        }
    }
}