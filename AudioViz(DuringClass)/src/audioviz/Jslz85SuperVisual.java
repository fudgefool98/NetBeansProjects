/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jordan
 */
public class Jslz85SuperVisual implements Visualizer {
    private final String name = "Jslz85 Super Visual";

    private Integer numBands;
    private AnchorPane vizPane;
    
    private final Double bandHeightPercentage = 1.3;
    private final Double minRectangleRadius = 10.0;  // 10.0
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private Double halfBandHeight = 0.0;
    
    private final Double startHue = 260.0;
    
    private Rectangle[] rectangles;
    
    private int magnitudeOffset =70;
    
    public Jslz85SuperVisual(){
        
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        rectangles = new Rectangle[numBands];
        
        for (int i = 0; i < numBands; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(bandWidth / 2 + bandWidth * i);
            rectangle.setY(height / 2);
            rectangle.setWidth(bandWidth / 2);
            rectangle.setHeight(minRectangleRadius);
            rectangle.setFill(Color.hsb(startHue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }

    }

    @Override
    public void end() {
        if (rectangles != null) {
                     for (Rectangle rectangle : rectangles) {
                         vizPane.getChildren().remove(rectangle);
                     }
                 rectangles = null;
         }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        //this is where i spend my time making the visualizer look doap.
        if (rectangles == null) {
            return;
        }
        
        Integer num = min(rectangles.length, magnitudes.length);
        
        for (int i = 0; i < num; i++) {
            rectangles[i].setY( ((60.0 + magnitudes[i])/60.0) * halfBandHeight + minRectangleRadius);
            
            rectangles[i].setFill(Color.hsb(startHue - (magnitudes[i] * -6.0), 1.0, 1.0, 1.0));
        }
    }
    
}
