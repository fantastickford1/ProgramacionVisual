/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicajavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnDisappear;
    @FXML
    private Pane Contenedor;
    @FXML
    private Pane ContenedorAbout;
    @FXML
    private Slider slider;
    @FXML
    private ProgressBar Bar;
    @FXML
    private TextArea txtArea;
    
    boolean editable = true;
    boolean visible = false;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    //Andres 1 , JAvier, Rito, Alexis Javier, Farelo, Julian, Sierra 
    @FXML
    private void Exit(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void CentrarApp(ActionEvent event){
        Stage stage = (Stage) Contenedor.getScene().getWindow();
        stage.centerOnScreen();
    }
    
    @FXML
    private void OnDisappear(ActionEvent event){
        String TextoBoton;
        TextoBoton = btnDisappear.getText();
        if("Disappear".equals(TextoBoton)){
            Contenedor.setVisible(false);
            btnDisappear.setText("Appear");
        }else{
            Contenedor.setVisible(true);
            btnDisappear.setText("Disappear");
        }
    }
    
    @FXML
    private void OnDisable(ActionEvent event){
        if(editable == true){
            editable = false;
            txtArea.setEditable(editable);
        }else{
            editable = true;
            txtArea.setEditable(editable);
        }
    }
    
    @FXML
    private void keyInput(KeyEvent event){
        slider.setMin(0);
        slider.setMax(50);
        slider.setValue(txtArea.getText().length());
        for(int i = 0; i < txtArea.getText().length(); i++){
            Bar.setProgress(0.02*i);
        }
        if (txtArea.getText().length() > 51) {
            event.consume();
        }
        
    }
    
    @FXML
    
    private void onCredits(ActionEvent event){
       if(visible == false){
          ContenedorAbout.setVisible(true);
          this.visible = true;
       }else{
           ContenedorAbout.setVisible(false);
           this.visible = false;
       }
    }   
    
        
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
