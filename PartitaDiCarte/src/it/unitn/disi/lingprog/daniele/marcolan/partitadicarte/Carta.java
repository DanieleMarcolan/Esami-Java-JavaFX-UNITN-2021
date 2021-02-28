package it.unitn.disi.lingprog.daniele.marcolan.partitadicarte;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Carta extends StackPane implements Comparable {
    int valore;
    char seme;
    
    public Carta(int valore, char seme) {
        this.valore = valore;
        this.seme = seme;
        this.setPrefSize(100, 100);
        this.setBackground(new Background(new BackgroundFill(
                           Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(
                       Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        this.getChildren().addAll(new Text(valore + "-" + seme));
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.valore;
        return hash;
    }
    
    /**
     * Due carte sono uguali se hanno lo stesso valore
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.valore != other.valore) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.valore + "-" + this.seme;
    }
    
    /**
     * Ordina in ordine crescente per valore
     * Se sono pari, in ordine alfabetico crescente per seme
     */
    @Override
    public int compareTo(Object o) {
        Carta card = (Carta) o;
        if (this.valore > card.valore) {
            return 1;
        }
        else if (this.valore < card.valore) {
            return -1;
        }
        else {
            if (this.seme < card.seme) {
                return -1;
            }
            else if (this.seme > card.seme) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}