package it.unitn.disi.lingprog.daniele.marcolan.griglia;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Griglia extends Application {
    Text testo;
    TextField input;
    Button conferma;
    int N;
    Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        VBox root = new VBox(20);
        testo = new Text("Scegli la dimensione");
        input = new TextField();
        conferma = new Button("Conferma");
        root.getChildren().addAll(testo, input, conferma);
        root.setAlignment(Pos.CENTER);
        
        crea();
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("Daniele Marcolan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Crea la griglia effettiva, dopo un try and catch sull'input della prima finestra
     */
    public void crea() {
        conferma.setOnMouseClicked((evento) -> {
            try {
                String in = input.getText();
                N = Integer.parseInt(in);
                MainWindow root2 = new MainWindow(N);
                Scene scene2 = new Scene(root2, N * 100, N * 100 + 80);
                Stage stage2 = new Stage();
                stage2.setTitle("Daniele Marcolan");
                stage2.setScene(scene2);
                stage2.show();
                primaryStage.close();
            }
            catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Inserisci un numero intero");
                alert.showAndWait();
            }
        });
    }
}