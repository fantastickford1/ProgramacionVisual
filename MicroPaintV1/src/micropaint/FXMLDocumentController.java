/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropaint;

import com.sun.javafx.sg.prism.NGCanvas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author AngelRuiz
 */
public class FXMLDocumentController implements Initializable {
    
    private GraphicsContext[] gcs;
    private GraphicsContext gc;
    private Color color;
    private int fig=0;
    private boolean drawline = false,drawoval = false,drawrectangle = false,erase = false,freedesign = true;
    double startX = -1, startY = -1, lastX,lastY;
    double hg;
 
    @FXML private RadioButton strokeRB,fillRB;
    @FXML private Slider sliderSize;
    @FXML private ColorPicker colorPicker;
    @FXML private Canvas TheCanvas;
    
    
    @FXML 
    private void clearCanvas(ActionEvent e){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 515, 453);
    }
    
    //private int bufferFig=0;
    
    @FXML
    private void onMousePressedListener(MouseEvent e){
        
        sliderSize.setMin(0);
        sliderSize.setMax(300);
        this.hg = sliderSize.getValue();
        
        gcs[fig]=TheCanvas.getGraphicsContext2D();
        
        this.startX = e.getX();
        this.startY = e.getY();
        System.err.println("mousePressed at" + startX + ", "+ startY);
        if(drawoval){  
            this.dibujaOValo();
        }
        if(drawrectangle)
            this.dibujaRect();
    }
    
    @FXML
    private void onMouseReleaseListener(MouseEvent e){
        this.lastX = e.getX();
        this.lastY = e.getY();
        if(drawline)
            this.dibujarLinea();
        fig++;
    }
    
    @FXML
    private void onMouseDraggedListener(MouseEvent e){
        if(erase){
            gc.setFill(Color.WHITE);
            gc.setStroke(Color.WHITE);
            gc.fillOval(e.getX(), e.getY(), hg, hg);
        }
    }

    private void dibujaOValo(){
        gcs[fig].setFill(Color.BLUE);
        gcs[fig].setStroke(Color.BLUE);
        if(strokeRB.isSelected() == true){
            gcs[fig].strokeOval(startX, startY, hg, hg);
        }else
            gcs[fig].fillOval(startX, startY, hg, hg);
    }
    
    private void dibujaRect(){
        gcs[fig].setStroke(Color.BLUE);
        gcs[fig].setFill(Color.BLUE);
        if(strokeRB.isSelected() == true){
            gcs[fig].strokeRect(startX, startY, hg, hg);
        }else
            gcs[fig].fillRect(startX, startY, hg, hg);
     
    }
    
    private void dibujarLinea(){
        gcs[fig].setFill(Color.GREEN);
        gcs[fig].setStroke(Color.BLUE);
        gcs[fig].setLineWidth(5);
        gcs[fig].strokeLine(startX, startY, lastX, lastY);
    }
    
   @FXML
    private void onMouseExitedListener(MouseEvent event){
        System.out.println("No puedes dibujar fuera del canvas");
    }
    
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gcs = new GraphicsContext[100];
        gc=TheCanvas.getGraphicsContext2D();        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 515, 453);
    }    
    
}
