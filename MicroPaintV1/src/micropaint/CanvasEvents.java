/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micropaint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author AngelRuiz
 */
public class CanvasEvents {
    private Canvas canvas;
    private GraphicsContext gc;
    
    public CanvasEvents(Canvas canvas, GraphicsContext gc){
        this.canvas = canvas;
        this.gc = gc;
        gc = canvas.getGraphicsContext2D();
    }
    
    public Canvas getCanvas(){
        return this.canvas;
    }
    
    
    
    
}
