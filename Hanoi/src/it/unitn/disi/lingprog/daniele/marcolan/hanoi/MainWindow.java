package it.unitn.disi.lingprog.daniele.marcolan.hanoi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends BorderPane {
    StackPane centro;
    MyButton close, reset, clear, move;
    TextField from, to;
    Palo p1, p2, p3;
    Disco arancione, viola, verde, azzurro;
    Palo partenza, arrivo;
    
    public MainWindow() {
        partenza = null;
        arrivo = null;
        buildFinestra();
        buildGioco();
    }
    
    public void buildFinestra() {
        close = new MyButton(this, "Close");
        close.setDisable(true);
        reset = new MyButton(this, "Reset");
        clear = new MyButton(this, "Clear");
        move = new MyButton(this, "Move");
        from = new TextField("");
        from.setEditable(false);
        from.setPrefWidth(100);
        to = new TextField("");
        to.setEditable(false);
        to.setPrefWidth(100);
        Label labelFrom = new Label("from");
        Label labelTo = new Label("to");
        HBox sopra = new HBox(20);
        sopra.setAlignment(Pos.CENTER);
        sopra.getChildren().addAll(labelFrom, from, labelTo, to, clear);
        this.setTop(sopra);
        BorderPane.setAlignment(sopra, Pos.CENTER);
        this.setLeft(close);
        BorderPane.setAlignment(close, Pos.CENTER);
        this.setRight(reset);
        BorderPane.setAlignment(reset, Pos.CENTER);
        this.setBottom(move);
        BorderPane.setAlignment(move, Pos.CENTER);
        centro = new StackPane();
        centro.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setCenter(centro);
    }
    
    public void buildGioco() {
        p1 = new Palo(this, "p1");
        p2 = new Palo(this, "p2");
        p3 = new Palo(this, "p3");
        centro.getChildren().addAll(p1, p2, p3);
        arancione = new Disco(this, 80, Color.ORANGE);
        viola = new Disco(this, 60, Color.PURPLE);
        verde = new Disco(this, 40, Color.LIGHTGREEN);
        azzurro = new Disco(this, 20, Color.LIGHTBLUE);
        centro.getChildren().addAll(arancione, viola, verde, azzurro);
    }
    
    public void stampaErrore(String testo) {
        StackPane root2 = new StackPane();
        Text errore = new Text(testo);
        root2.getChildren().add(errore);
        Scene scene2 = new Scene(root2, 450, 100);
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene2);
        close.setDisable(false);
        close.togliAlert(secondaryStage);
        secondaryStage.showAndWait();
        close.setDisable(true);
    }
}