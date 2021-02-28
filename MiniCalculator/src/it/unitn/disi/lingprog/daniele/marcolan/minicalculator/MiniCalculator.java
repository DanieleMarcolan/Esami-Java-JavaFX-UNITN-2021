package it.unitn.disi.lingprog.daniele.marcolan.minicalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiniCalculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainWindow root = new MainWindow();
        
        Scene scene = new Scene(root, 800, 300);
        
        primaryStage.setTitle("Daniele Marcolan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}