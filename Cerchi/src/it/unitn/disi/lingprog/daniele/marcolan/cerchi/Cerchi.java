package it.unitn.disi.lingprog.daniele.marcolan.cerchi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cerchi extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainWindow root = new MainWindow();
        
        Scene scene = new Scene(root, 500, 550);
        
        primaryStage.setTitle("Daniele Marcolan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}