/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropaint;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML Canvas TheCanvas; 
    private GraphicsContext[] gcs;
    
    private boolean drawline = false,drawoval = false,drawrectangle = false,erase = false, freedesign = true;
    private int fig = 0;
    private double startX,startY,bouferX, bouferY;


    @FXML
    private void setOvalAsCurrentShape(ActionEvent e){
        drawline = false;
        drawoval = true;
        drawrectangle = false;
        freedesign = false;
        erase = false;
        
    }
    
     @FXML
    private void setLineAsCurrentShape(ActionEvent e){
        drawline = true;
        drawoval = false;
        drawrectangle = false;
        freedesign = false;
        erase = false;
    }
     @FXML
    private void setRectangleAsCurrentShape(ActionEvent e){
        drawline = false;
        drawoval = false;
        freedesign = false;
        erase=false;
        drawrectangle = true;
    }
    
    @FXML
    private void setErase(ActionEvent e){
        drawline = false;
        drawoval = false;
        drawrectangle = false;    
        erase = true;
        freedesign= false;
    }
    
    @FXML
    private void setFreeDesign(ActionEvent e){
        drawline = false;
        drawoval = false;
        drawrectangle = false;    
        erase = false;
        freedesign = true;
    }
    
    @FXML
    private void onMousePressedListener(MouseEvent e){
        gcs[fig]=TheCanvas.getGraphicsContext2D();
  
        this.startX = e.getX();
        this.startY = e.getY();
        System.err.println("mousePressed at" + startX + ", "+ startY);
          bouferX=0; 
          bouferY=0;
         if(drawoval){  
            bufferFig=0;
         }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
   
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gcs = new GraphicsContext[100];
        gcs[fig] = TheCanvas.getGraphicsContext2D();
        gcs[fig].setFill(Color.WHITE);
        gcs[fig].fillRect(0, 0, TheCanvas.getWidth() , TheCanvas.getHeight());
        fig++;
    }    
    
}
