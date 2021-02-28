package it.unitn.disi.lingprog.daniele.marcolan.booking;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Alloggio extends HBox {
    String nome;
    int prezzo;
    double valutazione;
    Label labelNome, labelPrezzo, labelValutazione;
    
    public Alloggio(MainWindow mw, String nome, int prezzo, double valutazione) {
        if (valutazione < 6.0 || valutazione > 10.0) {
            valutazione = 6.0;
        }
        this.nome = nome;
        labelNome = new Label(nome);
        labelNome.setPrefWidth(170);
        labelNome.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18));
        this.prezzo = prezzo;
        labelPrezzo = new Label("" + prezzo);
        labelPrezzo.setPrefWidth(100);
        labelPrezzo.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18));
        this.valutazione = valutazione;
        labelValutazione = new Label("" + valutazione);
        labelValutazione.setPrefWidth(40);
        labelValutazione.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 18));
        this.getChildren().addAll(labelNome, labelPrezzo, labelValutazione);
        this.setSpacing(7);
        
        /**
         * Mostra la foto dell'alloggio quando si clicca col mouse sull'etichetta del nome
         */
        this.labelNome.setOnMouseClicked((evento) -> {
            Image foto = new Image ("imgs/" + this.nome + ".jpg");
            mw.mostraFoto(foto);
        });
    }
    
    public abstract Object getExtra();
}