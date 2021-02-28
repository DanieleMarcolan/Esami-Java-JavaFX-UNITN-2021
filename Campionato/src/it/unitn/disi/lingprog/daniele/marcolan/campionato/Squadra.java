package it.unitn.disi.lingprog.daniele.marcolan.campionato;

public class Squadra {
    Bandiera bandiera;
    String nome;
    int punteggio;
    
    public Squadra(String nome) {
        this.nome = nome;
        if (nome == "Italia" || nome == "Francia" || nome == "Belgio" || nome == "Irlanda") {
            bandiera = new BandieraAStrisce();
        }
        if (nome == "Austria" || nome == "Germania" || nome == "Bulgaria" || nome == "Olanda" || nome == "Russia" || nome == "Spagna" || nome == "Ungheria") {
            bandiera = new BandieraARighe();
        }
        if (nome == "Finlandia" || nome == "Danimarca" || nome == "Svezia") {
            bandiera = new BandieraACroce();
        }
        if (nome == "Polonia" || nome == "Ucraina") {
            bandiera = new BandieraABande();
        }
        bandiera.build(nome);    
    }
}