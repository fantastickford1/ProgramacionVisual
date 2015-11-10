/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpracticea;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Karlos
 */
public class UpDateController implements Initializable {

    @FXML TextField nameField,lastNField,addresField,phoneField,rfcField;
    @FXML Button updateBtn,deleteBtn;
    private ResultSet rs=null;
    private String nameF,lastNF,addresF,phoneF,rfcF;
    
    @FXML
    private void isEdited(KeyEvent event){
        if(nameField.getText().equals(nameF))
            updateBtn.setDisable(true);
        else
            updateBtn.setDisable(false);
        if(lastNField.getText().equals(lastNF))
            updateBtn.setDisable(true);
        else
            updateBtn.setDisable(false);
        if(addresField.getText().equals(addresF))
            updateBtn.setDisable(true);
        else
            updateBtn.setDisable(false);
        if(phoneField.getText().equals(phoneF))
            updateBtn.setDisable(true);
        else
            updateBtn.setDisable(false);
        if(rfcField.getText().equals(rfcF))
            updateBtn.setDisable(true);
        else
            updateBtn.setDisable(false);
            
    }
    
    @FXML
    private void deleteData(ActionEvent event){
       Conexion con = null; 
       try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD,"mynewdatabase");
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, e);
        }
        String rfc = rfcField.getText();
       
        Boolean resultado;
        resultado = con.borrar("DELETE FROM userdata WHERE RFC = '"+rfc+"';");
        System.out.println("El resultado es: "+resultado);
    }
    
    @FXML
    private void updateall(ActionEvent evente){
        Conexion con = null;
        try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD, "mynewdatabase");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE,null,e);
        }
        
        String name = nameField.getText();
        String lastN = lastNField.getText();
        String addr = addresField.getText();
        long phone = Long.parseLong(phoneField.getText());
        String rfc = rfcField.getText();
        
        boolean Update = con.actualizar("UPDATE userdata SET Nombres = '"+ name +"',Apellidos = '"+ lastN +"',Direccion = '"+ addr +"',Telefono = "+phone+",RFC = '"+rfc+"' WHERE RFC = '"+rfcF+"';");
        System.err.println(Update);
        
        
    }
    
    @FXML
    private void consultarDB(ActionEvent event){
        Conexion con = null;
        try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD,"mynewdatabase");
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, e);
        }
        rs=con.buscar("select * from userdata");
        nextData();
        deleteBtn.setDisable(false);
    }
    
    @FXML 
    private void nextData(){
        try {
            if(rs.next()){
                nameField.setText(rs.getString("Nombres"));
                lastNField.setText(rs.getString("Apellidos"));
                addresField.setText(rs.getString("Direccion"));
                phoneField.setText("" + rs.getLong("Telefono"));
                rfcField.setText(rs.getString("RFC"));
                nameF = nameField.getText();
                lastNF = lastNField.getText();
                addresF = addresField.getText();
                phoneF = phoneField.getText();
                rfcF = rfcField.getText();
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML 
    private void lastData(){
        try {
            if(rs.previous()){
                nameField.setText(rs.getString("Nombres"));
                lastNField.setText(rs.getString("Apellidos"));
                addresField.setText(rs.getString("Direccion"));
                phoneField.setText("" + rs.getLong("Telefono"));
                rfcField.setText(rs.getString("RFC"));
                nameF = nameField.getText();
                lastNF = lastNField.getText();
                addresF = addresField.getText();
                phoneF = phoneField.getText();
                rfcF = rfcField.getText();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
