package it.unitn.disi.lingprog.daniele.marcolan.cerchi;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MainWindow extends VBox {
    HBox barraDiStato;
    StackPane pannello;
    TextField output, input;
    Button reset;
    int valoreInput, valoreOutput;
    Circle uno, due, tre, quattro;
    
    public MainWindow() {
        build();
        creaCerchi(valoreInput);
        
        pannello.setOnMouseClicked((evento) -> {
            double x = evento.getScreenX();
            double y = evento.getScreenY();
            Circle cliccato = new Circle(5);
            cliccato.setFill(Color.BLACK);
            pannello.getChildren().add(cliccato);
            cliccato.setCenterX(x);
            cliccato.setCenterY(y);
            cliccato.setTranslateX(x);
            cliccato.setTranslateY(y);
        });
    }
    
    public void build() {
        valoreInput = 45;
        valoreOutput = 0;
        
        input = new TextField("" + valoreInput);
        input.setPrefSize(150, 50);
        output = new TextField("" + valoreOutput);
        output.setPrefSize(150, 50);
        output.setEditable(false);
        reset = new Button("RESET");
        reset.setPrefSize(150, 50);
        
        barraDiStato = new HBox(25);
        barraDiStato.setPrefSize(500, 50);
        barraDiStato.getChildren().addAll(input, output, reset);
        pannello = new StackPane();
        pannello.setPrefSize(500, 500);
        this.getChildren().addAll(pannello, barraDiStato);
    }
    
    public void creaCerchi(int valoreInput) {
        pannello.getChildren().clear();
        uno = new Circle(valoreInput);
        uno.setStroke(Color.BLACK);
        uno.setStrokeWidth(1);
        uno.setFill(Color.WHITE);
        due = new Circle(valoreInput * 2);
        due.setStroke(Color.BLACK);
        due.setStrokeWidth(1);
        due.setFill(Color.WHITE);
        tre = new Circle(valoreInput * 3);
        tre.setStroke(Color.BLACK);
        tre.setStrokeWidth(1);
        tre.setFill(Color.WHITE);
        quattro = new Circle(valoreInput * 4);
        quattro.setStroke(Color.BLACK);
        quattro.setStrokeWidth(1);
        quattro.setFill(Color.WHITE);
        pannello.getChildren().addAll(quattro, tre, due, uno);
    }    
}