package it.unitn.disi.lingprog.daniele.marcolan.tiroalbersaglio;

public class Punto {
    double x;
    double y;
    
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double contaDistanza(Punto cliccato) {
        double distanzaX = cliccato.x - this.x;
        double distanzaY = cliccato.y - this.y;
        if (distanzaX < 0) {
            distanzaX = -distanzaX;
        }
        if (distanzaY < 0) {
            distanzaY = -distanzaY;
        }
        if (distanzaX > distanzaY) {
            return distanzaX;
        }
        if (distanzaX < distanzaY) {
            return distanzaY;
        }
        return 0;
    }
}