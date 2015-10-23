/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skinchanger;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label titleLabel;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Button applyButton,resetButton,InfoButton,exitButton;
    @FXML
    private ProgressBar bar;
    @FXML
    private ProgressIndicator progressIN;
    @FXML
    private RadioButton lightRB,darkRB;
    
    private Scene scene;
    
    private String txt = "Empty";
    
    public void setScene(Scene scene){
        this.scene = scene;
    }
    
    @FXML
    private void close(){
        System.exit(0);
    }
    
    @FXML
    private void showInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Se ha realizado un cambio de tema");
        alert.setContentText("El skin activo ahora es: " + txt);
        alert.showAndWait();
    }
    
    @FXML
    private void apply(){
        String hexColor = colorPicker.getValue().toString();
        String hexColorFill = hexColor.substring(2, hexColor.length() - 2);
        String hexColorStyle = "-fx-background-color: #" + hexColor;
        
        applyButton.setStyle(hexColorStyle);
        InfoButton.setStyle(hexColorStyle);
        bar.setStyle("-fx-accent: #" + hexColorFill);
        progressIN.setStyle("-fx-accent: #" + hexColorFill);
        
        Color colorTextFill = Color.web(hexColorFill);
        
        darkRB.setTextFill(colorTextFill);
        lightRB.setTextFill(colorTextFill);
    }
    
    @FXML
    private void createToggleGroup(){
        ToggleGroup group = new ToggleGroup();
        lightRB.setToggleGroup(group);
        darkRB.setToggleGroup(group);
    }
    
    @FXML
    private void changed(){
        if (lightRB.isSelected()) txt = "Light";
        if (darkRB.isSelected()) txt = "Dark";
        
        scene.getStylesheets().clear();
        scene.getStylesheets().add(SkinChanger.class.getResource(txt+".css").toExternalForm());
    }
    
    @FXML
    private void resetButtonAction(){
        Color blackColor = Color.web("000000");
        scene.getStylesheets().clear();
        bar.setStyle(null);
        progressIN.setStyle(null);
        darkRB.setTextFill(blackColor);
        lightRB.setTextFill(blackColor);
        txt = "Vacio";
    }
    
    @FXML
    private void applyCSS(ActionEvent event){
        MenuItem item = (MenuItem) event.getSource();
        txt = item.getText();
        System.out.println("El skin seleccionado es:"+txt);
        scene.getStylesheets().clear();
        scene.getStylesheets().add(SkinChanger.class.getResource(txt+".css").toExternalForm());
    }
    
    @FXML
    private void aboutme(){
        Alert about = new Alert(Alert.AlertType.INFORMATION);
        about.setTitle("Information");
        about.setHeaderText("About:");
        about.setContentText("Nombre: Carlos Alejandro Zenteno Robles\nUniversidad Politecnica de Chiapas"
                + "\nCuatri:4   Grupo: 'A' ");
        about.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createToggleGroup();
    }    
    
}
