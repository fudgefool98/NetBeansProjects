/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

/**
 *
 * @author Jordan
 */
public class DocumentEditor01 extends Application {
    public String title = "Document Editor 01";
    public int width = 800;
    public int height = 700;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(20);
        
        Label titleLabel = new Label("Title");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        
        root.add(titleFieldBox,0,0);
        
        //basic ass shit right here
//        TextArea editor = new TextArea();
//        editor.setPrefRowCount(25);
//        editor.setPrefColumnCount(50);
//        root.add(editor,0,1);

          HTMLEditor editor = new HTMLEditor();
          editor.setPrefSize(600,500);
          root.add(editor,0,1);
          
          Button saveButton = new Button("Save");
          HBox saveButtonBox = new HBox();
          saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
          saveButtonBox.getChildren().add(saveButton);
          root.add(saveButtonBox,0,2);
          
          //this save button currently has no functionality it doesn't actually
          //save anything
          
         
        
        
        Scene scene = new Scene(root,width,height);
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
