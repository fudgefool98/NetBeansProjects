/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysecondfxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.internal.org.objectweb.asm.Label;
import javafx.scene.control.Label;

/**
 *
 * @author Jordan
 */
public class MySecondFXApp extends Application {
    private String appName = "My Second App";
    public int width = 600;
    public int height = 400;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(appName);
        
        
        
        //here the gird pane is created as the root node
        GridPane grid = new GridPane();
        
        
        //default position top left
        grid.setAlignment(Pos.CENTER);
        
        
        //manage the spacing between row and columns
        grid.setHgap(10);
        grid.setVgap(10);
        
        
        //manage the space around the edges of the grid pane
        grid.setPadding(new Insets(25, 25, 25, 25,));
        //top right bottom left
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL,20 ));
        grid.add(scenetitle, 0, 0);    
        
        Label infoLabel = new Label();
        grid.add(infoLabel, 0, 1);
        
        Button button = new Button("Hello World");
        
        button.setOnAction(new EventHandler<ActionEvent>);
        
        @Override
                public void handle(ActionEvent e){
        infoLabel.setText("hello world from button click");
    }

//another way to do the same thing commented out above
button.setOnAction(ActionEvent action)->{
       infoLabel.setText("Hello world from button click");
    });
        //for debugging you can add following line of code to see the grid layout
        grid.setGridLinesVisible(true);
        
        Scene scene = new Scene(grid, width,height);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
