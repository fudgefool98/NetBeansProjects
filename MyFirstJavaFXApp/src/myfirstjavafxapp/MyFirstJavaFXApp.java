/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjavafxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class MyFirstJavaFXApp extends Application {
    // this main class for JavaFX app extends the 
    //  javafx.application.Application class
    
    // the start() method is the main entry point for all JavFX applications
    @Override
    public void start(Stage primaryStage) {
        /*
            A javaFX app defines the user interface container by means of 
                a stage and a scene
        
            The javaFX stage class is the toplevel java fz container
        
            the javasx scene class is the container for all content
        
            this example creates the stage and scene and makes the scene visible
                in the given pixel size
        
        */
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        /*
         in javafx the content of the scene is represented as a hierarchial
        scene graph of nodes
        
        in this example, the root node is a stackpane object, which is a 
        resizable layout node
        
        this means that the root node's size tracks the scene's size and 
        changes when the stage is resized by a user
        */
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        /*the root node contains one child which is a button control with text
        plus an event handler to print a message when the button is pressed
      
        */
        Scene scene = new Scene(root, 300, 250);
        /* 
        create a scene for a specific root node with a specific size
        parameters:
        root- the root node of the scene graph
        width- the wdth of the scene
        heght - the height of the scene
        */
        
        //pay attention to the order below?
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     
     main is not required for a javafx but in some environments you do need a main.
     * 
     * don't take it out.... ever..
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
