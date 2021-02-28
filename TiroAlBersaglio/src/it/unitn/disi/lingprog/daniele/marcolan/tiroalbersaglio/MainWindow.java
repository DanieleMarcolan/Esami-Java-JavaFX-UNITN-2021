package it.unitn.disi.lingprog.daniele.marcolan.tiroalbersaglio;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainWindow extends VBox {
    HBox barraDiStato;
    MyButton inizia;
    MyButton arrenditi;
    int d1;
    int d2;
    int d3;
    TextField distanza1;
    TextField distanza2;
    Label titolo;
    Pane pannello;
    Random rng;
    Punto bersaglio;
    Rectangle quadratino;
    boolean attiva;
    
    public MainWindow() {
        build();
    }
    
    public void build() {
        this.getChildren().clear();
        
        attiva = false;
        d1 = 100;
        d2 = 50;
        d3 = 25; //debug
        
        titolo = new Label ("Chi cerca trova");
        titolo.setPrefSize(250, 50);
        titolo.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 24));
        titolo.setBackground(new Background(new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY)));
        titolo.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        
        barraDiStato = new HBox(0);
        inizia = new MyButton(this, "Start");
        inizia.setPrefSize(45, 50);
        arrenditi = new MyButton(this, "Leave");
        arrenditi.setPrefSize(60, 50);
        distanza1 = new TextField("D1: " + d1);
        distanza1.setPrefSize(72.5, 50);
        distanza2 = new TextField("D2: " + d2);
        distanza2.setPrefSize(72.5, 50);
        barraDiStato.getChildren().addAll(inizia, arrenditi, distanza1, distanza2);
        
        pannello = new Pane();
        pannello.setPrefSize(250, 150);
        pannello.setBackground(new Background(new BackgroundFill(Color.KHAKI, CornerRadii.EMPTY, Insets.EMPTY)));
        
        this.getChildren().addAll(titolo, pannello, barraDiStato);
        
        quadratino = new Rectangle(5, 5);
    }    
     
    public Punto randomPunto() {
        rng = new Random();
        Punto point = new Punto(rng.nextInt(250) + 1, rng.nextInt(150) + 1);
        return point;
    }
    
    public void checkVicinanza(Punto cliccato) {
        double vicinanza = bersaglio.contaDistanza(cliccato);
        if (vicinanza >= d2) {
            quadratino.setFill(Color.BLACK);
            quadratino.setX(cliccato.x);
            quadratino.setY(-cliccato.y);
            pannello.getChildren().add(quadratino);
        }
        else if (vicinanza < d2 && vicinanza >= d1) {
            quadratino.setFill(Color.GREEN);
            quadratino.setX(cliccato.x);
            quadratino.setY(cliccato.y);
            pannello.getChildren().add(quadratino);
        }
        else if (vicinanza < d1 && vicinanza >= d3) {
            quadratino.setFill(Color.BLUE);
            quadratino.setX(cliccato.x);
            quadratino.setY(cliccato.y);
            pannello.getChildren().add(quadratino);
        }
        else {
            quadratino.setFill(Color.RED);
            quadratino.setX(cliccato.x);
            quadratino.setY(cliccato.y);
            pannello.getChildren().add(quadratino);
            titolo.setText("Hai Vinto!");
        }
    }
    
    public void iniziaGioco() {
        this.pannello.setOnMouseClicked((evento) -> {
            if (attiva) {
                bersaglio = randomPunto();
                double x = (double)evento.getX();
                double y = (double)evento.getY();
                Punto cliccato = new Punto(x, y);
                checkVicinanza(cliccato);
            }
        });
    }
}