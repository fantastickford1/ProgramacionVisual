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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField nameField,lastNameField,rfcField,addresField,phoneField;
    
    @FXML
    private void sendData(ActionEvent event) {
        Conexion con = null;
        try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD,"mynewdatabase");
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        String name = nameField.getText();
        String lastname = lastNameField.getText();
        String rfc = rfcField.getText();
        String addr = addresField.getText();
        int phone = Integer.parseInt(phoneField.getText());
        Boolean resultado = false;
        resultado = con.insertar("INSERT INTO userdata(Nombres,Apellidos,Direccion,Telefono,RFC) VALUES('"+name+"','"+lastname+"','"+addr+"',"+phone+",'"+rfc+"');");
        System.out.println("El resultado es: "+resultado);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
