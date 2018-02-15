/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jordansecondfxapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class JordanSecondFXApp extends Application {
    private String appName = "My Second App";
    public int width = 600;
    public int height = 400;
    
           
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(appName);
        
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.setPadding(new Insets(25,25,25,25));
        
        Text scenetitle = new Text("Welcome");
        
        grid.add(scenetitle, 0,0);
        
        Label infoLabel = new Label();
        
        grid.add(infoLabel,0,1);
        
        Button button = new Button("Hello World");
//        
//        button.setOnAction(new EventHandler<ActionEvent>(){
//        @Override
//            public void handle(ActionEvent e){
//                infoLabel.setText("Hello world from button click");
//            }
//        });
        button.setOnAction((ActionEvent e) ->{
            infoLabel.setText("Hello WOlrd from button click");
        });
        grid.add(button,1,1);
        
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
