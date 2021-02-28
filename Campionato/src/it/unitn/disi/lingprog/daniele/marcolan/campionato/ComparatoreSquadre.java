package it.unitn.disi.lingprog.daniele.marcolan.campionato;

import java.util.Comparator;

public class ComparatoreSquadre implements Comparator {
    
    @Override
    public int compare (Object o1, Object o2) {
        Squadra s1 = (Squadra)o1;
        Squadra s2 = (Squadra)o2;
        if (s1.punteggio > s2.punteggio) {
            return -1;
        }
        else if (s1.punteggio < s2.punteggio) {
            return 1;
        }
        else if (s1.punteggio == s2.punteggio) {
           return s1.nome.compareTo(s2.nome);
        }
        return 0;
    }     
}