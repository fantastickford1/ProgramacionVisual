/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinchanger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Karlos
 */
public class SkinChanger extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader myloader = new FXMLLoader(getClass().getResource("/skinchanger/FXMLDocument.fxml"));
        Parent root = (Parent) myloader.load();
        FXMLDocumentController controller = myloader.getController();
        
        Scene scene = new Scene(root);
        
        myloader.setScene(scene);
        
        stage.setScene(scene);
        stage.setTitle("SkinChanger");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
