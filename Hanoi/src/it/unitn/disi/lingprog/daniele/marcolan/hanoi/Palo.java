package it.unitn.disi.lingprog.daniele.marcolan.hanoi;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Palo extends Rectangle {
    String nome;
    ArrayList<Disco> qualiDischi;
    
    public Palo(MainWindow mw, String nome) {
        this.setWidth(10);
        this.setHeight(100);
        this.setFill(Color.BLACK);
        this.nome = nome;
        qualiDischi = new ArrayList<Disco>();
        switch(nome) {
            case "p1":
                this.setTranslateX(-100);
                break;
            case "p3":
                this.setTranslateX(100);
                break;
            default:
                break;
        }
        
        this.setOnMouseClicked((evento) -> {
            if (mw.paloDiPartenza == null && mw.paloDiArrivo == null) {
                if (this.qualiDischi.size() == 0) {
                    mw.stampaErrore("Il palo di partenza non può essere vuoto");
                }
                else {
                    mw.from.setText(this.nome);
                    if (this.nome == "p1") {
                        mw.paloDiPartenza = mw.p1;
                    }
                    else if (this.nome == "p2") {
                        mw.paloDiPartenza = mw.p2;
                    }
                    if (this.nome == "p3") {
                        mw.paloDiPartenza = mw.p3;
                    }
                }
            }
            else if (mw.paloDiPartenza != null && mw.paloDiArrivo == null) {
                if (this.nome == mw.paloDiPartenza.nome) {
                    mw.stampaErrore("Il palo di partenza e quello di arrivo non possono coincidere");
                }
                else {
                    mw.to.setText(this.nome);
                    if (this.nome == "p1") {
                        mw.paloDiArrivo = mw.p1;
                    }
                    else if (this.nome == "p2") {
                        mw.paloDiArrivo = mw.p2;
                    }
                    if (this.nome == "p3") {
                        mw.paloDiArrivo = mw.p3;
                    }
                }
            }
            else if (mw.paloDiPartenza != null && mw.paloDiArrivo != null) {
                mw.stampaErrore("Il palo di partenza e quello di arrivo sono già definiti");
            }
        });
    }
    
    public boolean checkValido(Disco d1) {
        if (qualiDischi.size() == 0) {
            return true;
        }   
        Disco d2 = qualiDischi.get(qualiDischi.size() - 1);
        if (d1.lunghezza > d2.lunghezza) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void aggiungiDisco(MainWindow mw, Disco d) {
        if (checkValido(d)) {
            qualiDischi.add(d);
            switch(nome) {
                case "p1":
                    d.setTranslateX(-100);
                    break;
                case "p3":
                    d.setTranslateX(100);
                    break;
                default:
                    break;
            }
            int posizionamento = -10 * qualiDischi.size();
            arrivo.setTranslateY(posizionamento);
        }
    }
    
    public void rimuoviDisco(MainWindow mw) {
        if (qualiDischi.size() > 0) {
            qualiDischi.remove(qualiDischi.size() - 1);
        }
    }
}