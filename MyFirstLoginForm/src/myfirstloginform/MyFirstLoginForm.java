/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstloginform;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class MyFirstLoginForm extends Application {
     public String title = "myJavaFX Login";
     public int width = 600;
     public int height = 400;
     public String fontStyle = "Comic Sans MS";
     
        @Override
        public void start(Stage primaryStage){
        
        primaryStage.setTitle(title);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25,25,25,25));
        
        Label userName = new Label("username: ");
        
        
        Text sceneTitle = new Text ("welcome please login");
        sceneTitle.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,26));
        grid.add(userName,0,1);
        
        Label password = new Label("Password");
        password.setFont(Font.font(fontStyle,FontWeight.NORMAL,18));
        grid.add(password,0,2);
        
        PasswordField passwordField = new PasswordField();
        grid.add(password,1,2);
        
      
        TextField usernameTextField = new TextField();
        grid.add(usernameTextField,1,1);
        
        Button button = new Button("Sign In");
        HBox hboxForButton = new HBox(10);
        hboxForButton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxForButton.getChildren().add(button);
        grid.add(hboxForButton,1,4);
        
        final Text actionTarget = new Text();
//       grid.add(actionTarget,1,6);
        GridPane.setColumnIndex(actionTarget,1);
        GridPane.setColumnIndex(actionTarget, 6);
        grid.getChildren().add(actionTarget);
        
        button.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
                System.out.println("ussername = " + usernameTextField.getText());
                System.out.println("Password = " + passwordField.getText());
                
                if(usernameTextField.getText().length()<1){
                    System.out.println("Error: username must be at least 1 character");
                }
                if(passwordField.getText().length()<1){
                    System.out.println("Error: password must be at least 1 character");
                }
            }
        });
        
        
        Scene scene = new Scene(grid,width,height);
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
