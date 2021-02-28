package it.unitn.disi.lingprog.daniele.marcolan.minicalculator;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainWindow extends BorderPane {
    VBox centro;
    Text sinistra, sotto;
    MyButton destra;
    Label sopra;
    HBox bottoni;
    MyButton piu, meno, per, diviso;
    TextField campo1, campo2, risultato;
    
    public MainWindow() {
        sinistra = new Text("left");
        sinistra.setTranslateY(100);
        this.setLeft(sinistra);
        
        sopra = new Label("MiniCalculator");
        sopra.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        this.setTop(sopra);
        sopra.setTranslateX(330);
        
        sotto = new Text("@magicSoftware");
        this.setBottom(sotto);
        sotto.setTranslateX(670);
        
        build();
        piu.inAzione(this);
        meno.inAzione(this);
        per.inAzione(this);
        diviso.inAzione(this);
        destra.inAzione(this);
        
        attivaTasti();
    }
    
    public void build() {
        destra = new MyButton("clear");
        destra.setPrefSize(80, 30);
        destra.setTranslateY(100);
        this.setRight(destra);
        
        centro = new VBox();
        centro.setPrefSize(600, 250);
        campo1 = new TextField();
        campo1.setPrefSize(600, 50);
        campo1.setEditable(true);
        campo2 = new TextField();
        campo2.setPrefSize(600, 50);
        campo2.setEditable(true);
        bottoni = new HBox();
        bottoni.setPrefSize(600, 50);
        piu = new MyButton("PIU");
        meno = new MyButton("MENO");
        per = new MyButton("PER");
        diviso = new MyButton("DIVISO");
        bottoni.getChildren().addAll(piu, meno, per, diviso);
        risultato = new TextField();
        risultato.setPrefSize(600, 50);
        risultato.setEditable(false);
        centro.getChildren().addAll(campo1, campo2, bottoni, risultato);
        this.setCenter(centro);
        this.setMargin(centro, new Insets(0, 50, 0, 50));
    }
    
    public void attivaTasti() {
        this.setOnKeyTyped((evento) -> {
            String stringa1 = campo1.getText();
            String stringa2 = campo2.getText();
            float float1 = Float.parseFloat(stringa1);
            float float2 = Float.parseFloat(stringa2);
            float numero3 = 0;
            if (evento.getCharacter().equals("+")) {
                numero3 = float1 + float2;
            }
            else if (evento.getCharacter().equals("-")) {
                numero3 = float1 - float2;
            }
            else if (evento.getCharacter().equals("*")) {
                numero3 = float1 * float2;
            }
            else if (evento.getCharacter().equals("/")) {
                numero3 = float1 / float2;
            }
            else {
                return;
            }
            risultato.setText("" + numero3);
        });
    }
}