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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Karlos
 */
public class UpDateController implements Initializable {

    @FXML Button consultBtn,updateBtn,lastBtn,nextBtn;
    @FXML TextField nameField,lastNField,addresField,phoneField,rfcField;
    @FXML CheckBox firstCheck,lastCheck,addresCheck,phoneCheck,rfcCheck;
    private ResultSet rs=null;
    
    @FXML
    private void consultarDB(ActionEvent event){
        Conexion con = null;
        try {
            con = new Conexion(Conexion.usrBD, Conexion.passBD,"userdata");
        }catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, e);
        }
        rs=con.buscar("select * from agenda");
        nextData();
    }
    
    @FXML 
    private void nextData(){
        try {
            if(rs.next()){
                nameField.setText(rs.getString("nombre"));
                lastNField.setText(rs.getString("apellido"));
                addresField.setText(rs.getString("direccion"));
                phoneField.setText("" + rs.getLong("telefono"));
                rfcField.setText(rs.getString("rfc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML 
    private void lastData(){
        try {
            if(rs.previous()){
                nameField.setText(rs.getString("nombre"));
                lastNField.setText(rs.getString("apellido"));
                addresField.setText(rs.getString("direccion"));
                phoneField.setText("" + rs.getLong("telefono"));
                rfcField.setText(rs.getString("rfc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpDateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void selected(){
        if(firstCheck.isSelected()){
            nameField.setEditable(true);
        }else{
            nameField.setEditable(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
