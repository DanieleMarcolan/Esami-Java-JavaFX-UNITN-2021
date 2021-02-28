package it.unitn.disi.lingprog.daniele.marcolan.partitadicarte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Mazzo extends ArrayList<Carta> {
    
    public Mazzo() {
        Carta c = null;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                switch(j) {
                    case 1:
                        c = new Carta(i, 'C');
                        break;
                    case 2:
                        c = new Carta(i, 'Q');
                        break;
                    case 3:
                        c = new Carta(i, 'F');
                        break;
                    case 4:
                        c = new Carta(i, 'P');
                        break;
                    default:
                        break;
                }
                this.add(c);
            }
        }
        c = new Carta(0, 'J');
        this.add(c);
    }
    
    /**
     * Stampa il mazzo in ordine casuale e poi ordinato
     */
    public void stampa() {
        Iterator<Carta> i = this.iterator();
        Collections.shuffle(this);
        Carta c;
        while (i.hasNext()) {
            c = i.next();
            System.out.println(c);
        }
        System.out.print('\n');
        
        this.sort((Carta c1, Carta c2) -> c1.compareTo(c2));
        Iterator<Carta> j = this.iterator();
        Carta d;
        while (j.hasNext()) {
            d = j.next();
            System.out.println(d);
        }
    }
    
    /**
     * Main di prova che stampa il mazzo 
     */
    public static void main(String[] args) {
        Mazzo m = new Mazzo();
        m.stampa();
    }
}