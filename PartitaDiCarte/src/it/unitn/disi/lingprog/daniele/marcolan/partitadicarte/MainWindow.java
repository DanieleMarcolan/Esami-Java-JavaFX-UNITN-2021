package it.unitn.disi.lingprog.daniele.marcolan.partitadicarte;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainWindow extends VBox {
    HBox giocatore1, giocatore2;
    Mano mano1, mano2;
    Text nomePippo, nomePluto;
    MyButton pescaDaPluto, pescaDaPippo, cercaLeCoppie1, cercaLeCoppie2, pescaDalMazzo1, pescaDalMazzo2;
    Mazzo mazzo;
    
    public MainWindow() {
        build();
        mazzo = new Mazzo();
        mano1 = new Mano(this);
        mano2 = new Mano(this);
        this.getChildren().addAll(giocatore1, mano1, mano2, giocatore2);
    }
    
    public void build() {
        giocatore1 = new HBox(20);
        giocatore1.setPrefHeight(50);
        giocatore2 = new HBox(20);
        giocatore2.setPrefHeight(50);
        
        nomePippo = new Text("PIPPO");
        nomePluto = new Text("PLUTO");
        pescaDaPluto = new MyButton("Pesca dall'avversario");
        pescaDaPippo = new MyButton("Pesca dall'avversario");
        cercaLeCoppie1 = new MyButton("Cerca le coppie");
        cercaLeCoppie2 = new MyButton("Cerca le coppie");
        pescaDalMazzo1 = new MyButton("Pesca dal mazzo");
        pescaDalMazzo2 = new MyButton("Pesca dal mazzo");
        
        giocatore1.getChildren().addAll(nomePluto, pescaDaPippo, cercaLeCoppie1, pescaDalMazzo1);
        giocatore2.getChildren().addAll(nomePippo, pescaDaPluto, cercaLeCoppie2, pescaDalMazzo2);
        giocatore1.setAlignment(Pos.CENTER);
        giocatore2.setAlignment(Pos.CENTER);
    }
}