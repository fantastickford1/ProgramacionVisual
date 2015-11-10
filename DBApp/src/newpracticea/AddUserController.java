/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpracticea;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Karlos
 */
public class AddUserController implements Initializable {
    
    @FXML TextField nameField,lastnField,addresField,phonField,rfcField,delRFCField;
    String name,lastname,rfc,addr;
    long phone;
    boolean controler = true;
    
    @FXML
    private void sendData(ActionEvent event) {
        Conexion con = null;
        try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD,"mynewdatabase");
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        name = nameField.getText();
        lastname = lastnField.getText();
        rfc = rfcField.getText();
        addr = addresField.getText();
        
        try {
            phone = Long.parseLong(phonField.getText());
            controler = true;
        } catch (Exception e) {
            Alert alert0 = new Alert(Alert.AlertType.ERROR);
            alert0.setTitle("Error");
            alert0.setHeaderText("The phone is not a number");
            alert0.setContentText("Change the phone");
            Optional<ButtonType> okay = alert0.showAndWait();
            alert0.showAndWait();
            controler = false;
        }
        if(rfc.length() > 2 && controler == true){
            Boolean resultado = false;
            resultado = con.insertar("INSERT INTO userdata(Nombres,Apellidos,Direccion,Telefono,RFC) VALUES('"+name+"','"+lastname+"','"+addr+"',"+phone+",'"+rfc+"');");
            System.out.println("El resultado es: "+resultado);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("RFC is necesary");
            alert.setContentText("You have to especify the RFC");
            Optional<ButtonType> butt = alert.showAndWait();
            alert.showAndWait();
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
