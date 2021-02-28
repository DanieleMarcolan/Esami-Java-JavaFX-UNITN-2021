package it.unitn.disi.lingprog.daniele.marcolan.concessionario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends GridPane {
    HashSet<Persona> listaPersone;
    HashSet<Automobile> listaAutomobili;
    VBox boxPersone, boxAutomobili;
    VBox bottoniPersone, bottoniAutomobili;
    MyButton mescolaPersone, ordinaPersone, contaPersone, ordinaPerAnno, newPerson;
    MyButton mescolaAuto, ordinaAuto, contaAuto, ordinaPerPrezzo, newAuto;
    
    public MainWindow() {
        build();
        listaPersone = new HashSet<Persona>();
        listaAutomobili = new HashSet<Automobile>();
    }
    
    public void build() {
        ColumnConstraints cc = new ColumnConstraints();
        cc.setPrefWidth(200);
        this.getColumnConstraints().addAll(cc, cc);
        RowConstraints rc = new RowConstraints();
        rc.setPrefHeight(200);
        this.getRowConstraints().addAll(rc, rc);
        
        boxPersone = new VBox(5);
        boxPersone.setPrefHeight(200);
        boxPersone.setPrefWidth(200);
        boxAutomobili = new VBox(5);
        boxAutomobili.setPrefHeight(200);
        boxAutomobili.setPrefWidth(200);
        bottoniPersone = new VBox();
        bottoniAutomobili = new VBox();
        this.add(boxPersone, 0, 0);
        this.add(boxAutomobili, 1, 0);
        this.add(bottoniPersone, 0, 1);
        this.add(bottoniAutomobili, 1, 1);
        
        mescolaPersone = new MyButton(this, "Mescola Persone");
        ordinaPersone = new MyButton(this, "Ordina Persone");
        contaPersone = new MyButton(this, "Conta Persone");
        ordinaPerAnno = new MyButton(this, "Ordina per anno");
        newPerson = new MyButton(this, "New Person");
        
        mescolaAuto = new MyButton(this, "Mescola Auto");
        ordinaAuto = new MyButton(this, "Ordina Auto");
        contaAuto = new MyButton(this, "Conta Auto");
        ordinaPerPrezzo = new MyButton(this, "Ordina per prezzo");
        newAuto = new MyButton(this, "New Auto");
        
        bottoniPersone.getChildren().addAll(mescolaPersone, ordinaPersone, contaPersone, ordinaPerAnno, newPerson);
        newPerson.setTranslateY(45);
        bottoniAutomobili.getChildren().addAll(mescolaAuto, ordinaAuto, contaAuto, ordinaPerPrezzo, newAuto);
        newAuto.setTranslateY(45);
    }
    
    public void creaStageAuto() {
        VBox root2 = new VBox(10);
        TextField marca = new TextField();
        marca.setText("Marca");
        TextField modello = new TextField();
        marca.setText("Modello");
        TextField prezzo = new TextField();
        marca.setText("Prezzo");
        Button controllaAuto = new Button("Controlla e inserisci auto");
        root2.getChildren().addAll(marca, modello, prezzo, controllaAuto);
        controllaAuto.setTranslateY(200);
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(root2, 400, 400);
        stage2.setScene(scene2);
        stage2.show();
        stage2.setAlwaysOnTop(true);
        
        controllaAuto.setOnMouseClicked((evento) -> {
            int x = Integer.parseInt(prezzo.getText());
            Automobile a = new Automobile(marca.getText(), modello.getText(), x);
            listaAutomobili.add(a);
            stage2.close();
            stampaBoxAutomobili(listaAutomobili);
        });
    }
    
    public void creaStagePersona() {
        VBox root3 = new VBox(10);
        TextField nome = new TextField();
        nome.setText("Nome");
        TextField cognome = new TextField();
        cognome.setText("Cognome");
        TextField annoDiNascita = new TextField();
        annoDiNascita.setText("Anno di nascita");
        Button controllaPersona = new Button("Controlla e inserisci persona");
        root3.getChildren().addAll(nome, cognome, annoDiNascita, controllaPersona);
        controllaPersona.setTranslateY(200);
        Stage stage3 = new Stage();
        Scene scene3 = new Scene(root3, 400, 400);
        stage3.setScene(scene3);
        stage3.show();
        stage3.setAlwaysOnTop(true);
        
        controllaPersona.setOnMouseClicked((evento) -> {
            int x = Integer.parseInt(annoDiNascita.getText());
            Persona p = new Persona(nome.getText(), cognome.getText(), x);
            listaPersone.add(p);
            stage3.close();
            stampaBoxPersone(listaPersone);
        });
    }
    
    public void stampaBoxAutomobili(Collection c) {
        Label l;
        boxAutomobili.getChildren().clear();
        Iterator<Automobile> i = c.iterator();
        while (i.hasNext()) {
            l = new Label(i.next().toString());
            boxAutomobili.getChildren().add(l);
        }
    }
    
    public void stampaBoxPersone(Collection c) {
        Label l;
        boxPersone.getChildren().clear();
        Iterator<Persona> i = c.iterator();
        while (i.hasNext()) {
            l = new Label(i.next().toString());
            boxPersone.getChildren().add(l);
        }
    }
    
    public void ordina(ArrayList<Record> l) {
        l.sort((Record r1, Record r2) -> r1.field2.compareTo(r2.field2));
    }
    
    public void ordinaSullIntero(ArrayList<Record> l) {
        l.sort((Record r1, Record r2) -> {
            if (r1.field3 > r2.field3) {
                return 1;
            }
            else if (r1.field3 < r2.field3) {
                return -1;
            }
            return 0;
        });
    }
}