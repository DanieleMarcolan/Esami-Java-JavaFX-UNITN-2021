package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import java.util.Random;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Incontro extends HBox {
    Squadra casa;
    Squadra trasferta;
    Text squadraCasa;
    Text squadraTrasferta;
    Text risultato;
    
    public Incontro(Squadra s1, Squadra s2) {
        casa = s1;
        trasferta = s2;
        this.setSpacing(5);
        squadraCasa = new Text(s1.nome);
        squadraTrasferta = new Text(s2.nome);
        this.getChildren().addAll(squadraCasa, squadraTrasferta);
    }
    
    /**
     * Genera il risultato random di una partita 
     */
    public void giocaPartita(Girone g) {
        Random rng1 = new Random();
        Random rng2 = new Random();
        int golCasa = rng1.nextInt(3);
        int golTrasferta = rng2.nextInt(3);
        risultato = new Text("\t\t" + golCasa + ":" + golTrasferta);
        this.getChildren().add(risultato);
        
        if (golCasa == golTrasferta) {
            casa.punteggio++;
            trasferta.punteggio++;
        }
        else if (golCasa > golTrasferta) {
            casa.punteggio += 3;
        }
        else {
            trasferta.punteggio += 3;
        }
        
        g.aggiornaClassifica();
    }
}