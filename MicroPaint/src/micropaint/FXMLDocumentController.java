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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Karlos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GraphicsContext gc;
    @FXML
    private Canvas canvasP;
    @FXML
    private Button ractangle,line,ovl,penc,erraser;
    @FXML
    private MenuItem arrasall;
    
    private boolean drawline = false;
    private boolean drawoval = false;
    private boolean drawrectangle = false;
    private boolean erase = false;
    private boolean freedesign = false;
    
    private boolean inDrag = false;
    double startX = -1,startY = -1;
    double curX = -1 , curY = -1;
    
    @FXML
    private void drawRect(ActionEvent event){
        drawrectangle = true;
        drawline = false;
        drawoval = false;
        erase = false;
        freedesign = false;
    }
    
    @FXML
    private void drawLine(ActionEvent event){
        drawrectangle = false;
        drawline = true;
        drawoval = false;
        erase = false;
        freedesign = false;
    }
    
    @FXML
    private void drawOvl(ActionEvent event){
        drawrectangle = false;
        drawline = false;
        drawoval = true;
        erase = false;
        freedesign = false;
    }
    
    @FXML
    private void drawPen(ActionEvent event){
        drawrectangle = false;
        drawline = false;
        drawoval = false;
        erase = false;
        freedesign = true;
    }
    
    @FXML
    private void drawErr(ActionEvent event){
        drawrectangle = false;
        drawline = false;
        drawoval = false;
        erase = true;
        freedesign = false;
    }
    
    @FXML
    private void onMousePressedListener(MouseEvent e){
        this.startX = e.getX();
        this.startY = e.getY();
        inDrag = true;
        System.err.println("mousePressed at" + startX + ", "+ startY);
    }
    
    @FXML
    private void clearCanvas(){
        gc.clearRect(0, 0,  canvasP.getWidth(), canvasP.getHeight());
    }
    
    @FXML
    private void onMouseDraggedListener(MouseEvent e){
         curX = e.getX();
         curY = e.getY();
        
         if (inDrag == true) {
            double w = curX - startX; 
            double h = curY - startY;
            if(drawline == true){
                gc.strokeLine(startX, startY, curX, curY);
                inDrag = false;
            }else if(drawoval == true){
                gc.strokeOval(startX, startY, w, h);
                inDrag = false;
            }else if(drawrectangle == true){
                gc.strokeRect(startX, startY, w, h);
                gc.fill();
                inDrag = false;
            }else if(freedesign == true){
                gc.fillOval(curX, curY, 5, 5);
            }else if(erase){
                gc.clearRect(curX , curY, 20, 20);
            }
            
        }
    }
    
    
   @FXML
    private void onMouseExitedListener(MouseEvent event){
        System.out.println("No puedes dibujar fuera del canvas");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
