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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author AngelRuiz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GraphicsContext[] gcs;
    private int fig=0;
    private int canvasX=515, canvasY=453;
    
    private boolean drawline = false;
    private boolean drawoval = false;
    private boolean drawrectangle = false;
    private boolean erase = false;
    private boolean freedesign = false;
    

    boolean inDrag = false;
    double startX = -1, startY = -1;
    double curX = -1, curY = -1;
    double bouferX, bouferY;

   
    @FXML
    private ColorPicker colorPicker;
     
    @FXML
    private Canvas canvasP;    
    
    @FXML
    private void clearCanvas(ActionEvent e){
        gcs[0].clearRect(0, 0,  canvasP.getWidth(), canvasP.getHeight());
        inDrag = false;
    }
    
    //private int bufferFig=0;
    
    @FXML
    private void onMousePressedListener(MouseEvent e){
        //fig=0;
        gcs[fig]=canvasP.getGraphicsContext2D();
        
        this.startX = e.getX();
        this.startY = e.getY();
        inDrag = true;
        System.err.println("mousePressed at" + startX + ", "+ startY);
          bouferX=0; 
          bouferY=0;
         /*if(drawoval){  
            bufferFig=0;
         }*/
    }

    private void dibujaOValo(){
         double w = curX - startX; 
         double h = curY - startY;                  
         
         //Esto es para la parte del buffer
         
          
          gcs[fig].setStroke(Color.WHITE);
          gcs[fig].strokeOval(startX, startY, bouferX+4, bouferY+4);
          gcs[fig].setFill(Color.WHITE);
          gcs[fig].fillOval(startX-2, startY-2, bouferX+4, bouferY+4);
    
         //gcs[fig].setStroke(null);
          //gcs[fig].setFill(Color.BLUE);        
          
          //fig++;
          //gcs[fig]=canvasP.getGraphicsContext2D();
          gcs[fig].setFill(Color.BLUE);
          gcs[fig].setStroke(Color.BLUE);
          gcs[fig].strokeOval(startX, startY, w, h);
          gcs[fig].fillOval(startX, startY, w, h);
          
          
                //gc.fillOval(startX, startY, w, h);       
          inDrag = false;
          bouferX=w; 
          bouferY=h;
          
    }

  
        private void dibujaRect(boolean isFinal){
         double w = curX - startX; 
         double h = curY - startY;         
         
         System.err.println("H:" + h);
         System.err.println("W:" + w);
         
         //gcs[fig].clearRect(startX-2, startY-2, bouferX+4, bouferY+4);
         /*gcs[fig].setStroke(Color.WHITE);
         gcs[fig].strokeRect(startX, startY, bouferX, bouferY);*/
         //Usando buffer
         gcs[fig].setStroke(Color.WHITE);
         gcs[fig].strokeRect(startX, startY, bouferX+4, bouferY+4);
         gcs[fig].setFill(Color.WHITE);
         gcs[fig].fillRect(startX-2, startY-2, bouferX+4, bouferY+4);

         gcs[fig].setStroke(Color.BLUE);
         gcs[fig].strokeRect(startX, startY, w, h);
         if (isFinal){
             gcs[fig].setFill(Color.BLUE);
         }else{
             gcs[fig].setFill(Color.WHITE);
         }
         gcs[fig].fillRect(startX, startY, w, h);
              inDrag = false;
          //gcs[fig].

          
          bouferY= h;
          bouferX= w; 
    }

    
    @FXML
    private void onMouseReleasedListener(MouseEvent e){
         curX = e.getX();
         curY = e.getY();
         if(drawoval){
             this.dibujaOValo();
         }
         if(drawrectangle){
             this.dibujaRect(true);
        }

         fig++;
         
        
    }
    double cA = 0;
    double hA = 0;
    
    @FXML
    private void onMouseDraggedListener(MouseEvent e){
         curX = e.getX();
         curY = e.getY();
         
         if (inDrag == true) {

         }
        /* if(erase){
                gc.clearRect(curX , curY, 20, 20);
                inDrag = false;                
            }
         if(drawline == true){
                gcs.strokeLine(startX, startY, curX, curY);                
                gcs.strokeLine(startX, startY, curX, curY);    
                inDrag = false;
            }
         /*if(drawoval == true){
                gc.clearRect(startX,startY, cA, hA);
                gc.setStroke(null);
                cA = w;
                hA = h;
                gc.strokeOval(startX, startY, w, h);
                //gc.fillOval(startX, startY, w, h);       
                inDrag = false;
          }*/
        
         /*if(freedesign == true){
                gcs.fillOval(curX, curY, 5, 5);
                inDrag = false;
         }*/
          
         if(drawoval){
             this.dibujaOValo();
         }
         if(drawrectangle){
             this.dibujaRect(false);
        }

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
        GraphicsContext gc;
        gcs = new GraphicsContext[100];
        gc=canvasP.getGraphicsContext2D();        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 515, 453);
        //fig++;
    }    
    
}
