package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {
    ImageView iw = null;
    ListaAlloggi listaAlloggi;
            
    public MainWindow() {
        Pulsantiera bottoni = new Pulsantiera(this);
        listaAlloggi = new ListaAlloggi(this);
        listaAlloggi.mostra();
        this.getChildren().addAll(bottoni, listaAlloggi);
        
        this.setOnKeyPressed((evento) -> {
            if (evento.getCode() == KeyCode.N) {
                this.listaAlloggi.ordinaPerNome();
                this.listaAlloggi.mostra();
            }
            else if (evento.getCode() == KeyCode.P) {
                this.listaAlloggi.ordinaPerPrezzo();
                this.listaAlloggi.mostra();
            }
            else if (evento.getCode() == KeyCode.V) {
                this.listaAlloggi.ordinaPerValutazione();
                this.listaAlloggi.mostra();
            }
        });
    }
    
    public void mostraFoto(Image foto) {
        this.getChildren().remove(iw);
        iw = new ImageView(foto);
        this.getChildren().add(iw);
    }  
}