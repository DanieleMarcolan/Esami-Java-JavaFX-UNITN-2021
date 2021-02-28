package it.unitn.disi.lingprog.daniele.marcolan.memory;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Killer extends Cella {
    Text ko;
    
    public Killer(MainWindow mw) {
        super(mw);
        this.setOnMouseClicked((evento) -> {
            scopri();
            Alert sconfitta = new Alert(Alert.AlertType.ERROR);
            sconfitta.setTitle("GIT GUD");
            sconfitta.setContentText("LOL REKT");
            sconfitta.showAndWait();
            System.exit(0);
        });
    }
    
    public void copri() {
        super.copri();
    }
    
    public void scopri() {
        if (ko != null) {
            this.getChildren().remove(ko);
        }
        ko = new Text("K.O.");
        ko.setStroke(Color.RED);
        this.getChildren().add(ko);
    }
}