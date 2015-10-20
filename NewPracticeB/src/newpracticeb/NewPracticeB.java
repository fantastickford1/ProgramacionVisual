/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpracticeb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Karlos
 */
public class NewPracticeB extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Stage ps;
        ps = primaryStage;
        ps.setTitle("Hi folks");
        ps.setMaximized(false);
        ps.setResizable(false);
        ps.setOpacity(1);
        EventHandler<WindowEvent> eh;
        eh = (WindowEvent event) -> {
            System.out.println("Cerrando");
        };
        ps.setOnCloseRequest(eh);
        ps.show();
        ps.centerOnScreen();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


/* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/