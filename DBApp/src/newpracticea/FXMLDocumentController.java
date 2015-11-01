/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpracticea;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    /*@FXML
    private TextField nameField,lastNameField,rfcField,addresField,phoneField;*/
    
    @FXML ToggleButton addDelete,upGet;
    
    @FXML
    private void newInsertDeleteWindow(ActionEvent e){
        if(addDelete.isSelected())
            newWindow("AddUser.fxml");
    }
    
    @FXML
    private void newUpdateGetWindow(ActionEvent e){
        if(upGet.isSelected())
            newWindow("upDate.fxml");
    }
    
    private void newWindow(String xmlfile){
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(xmlfile));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
