package it.unitn.disi.lingprog.daniele.marcolan.booking;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.layout.VBox;

public class ListaAlloggi extends VBox {
    final static int QUANTI_MOSTRATI = 5;
    ArrayList<Alloggio> lista;
    
    public ListaAlloggi(MainWindow mw) {
        lista = new ArrayList<Alloggio>();
        this.setSpacing(5);
    
        Alloggio a1 = new Pensione(mw, "Alpenhof", 60, 8.5, Pensione.Tipo.MEZZA_PENSIONE);
        lista.add(a1);
        Alloggio a2 = new Albergo(mw, "Artemide", 100, 8.4, 4);
        lista.add(a2);
        Alloggio a3 = new Pensione(mw, "Belste", 35, 6.2, Pensione.Tipo.SOLO_COLAZIONE);
        lista.add(a3);
        Alloggio a4 = new Pensione(mw, "Gruber", 75, 9.3, Pensione.Tipo.PENSIONE_COMPLETA);
        lista.add(a4);
        Alloggio a5 = new Albergo(mw, "Majestic", 65, 8.8, 3);
        lista.add(a5);
        Alloggio a6 = new Albergo(mw, "Palace", 200, 8.3, 5);
        lista.add(a6);
        Alloggio a7 = new Appartamento(mw, "PietraBianca", 40, 9.5, 4);
        lista.add(a7);
        Alloggio a8 = new Appartamento(mw, "SaporeDiSale", 80, 7.9, 8);
        lista.add(a8);
        Alloggio a9 = new Appartamento(mw, "TenutaDiArtimino", 60, 5.5, 6);
        lista.add(a9);
        Alloggio a10 = new Albergo(mw, "Zenith", 70, 6.8, 3);
        lista.add(a10);
    }
    
    /**
     * Mostra i primi 5 alloggi
     */
    public void mostra() {
        this.getChildren().clear();
        Alloggio x;
        int counter = 0;
        Iterator<Alloggio> i = lista.iterator();
        while (i.hasNext() && counter < QUANTI_MOSTRATI) {
            x = i.next();
            this.getChildren().add(x);
            counter++;
        }
    }
    
    public void ordinaPerNome() {
        lista.sort((Alloggio o1, Alloggio o2) -> o1.nome.compareTo(o2.nome));
    }
    
    public void ordinaPerPrezzo() {
        lista.sort((Alloggio o1, Alloggio o2) -> {
            if (o1.prezzo > o2.prezzo) {
                return 1;
            }
            if(o1.prezzo < o2.prezzo) {
                return -1;
            }
            return 0;
        });
    }
    
    public void ordinaPerValutazione() {
        lista.sort((Alloggio a1, Alloggio a2) -> {
            if (a1.valutazione < a2.valutazione) {
                return 1;
            }
            if (a1.valutazione > a2.valutazione) {
                return -1;
            }
            return 0;
        });    
    }       
}