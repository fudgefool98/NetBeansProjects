/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jordan
 */
public class TextEditorFXMLController implements Initializable {
/*
    the @FXML annotation is used to tag nonpublic controller membr fields
        and handler methods for use by FXML markup
    */
    @FXML
    private VBox root;
    @FXML 
    private TextArea textArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    public void handleOpen(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();
        
        fileChooser.showOpenDialog(stage);
    }
    @FXML
    public void handleSave(ActionEvent event){
        System.out.println(textArea.getText());
        
    }
    public void printHello(){
        System.out.println("hello world");
    }
    /*
    model view controller (MVC):
        
        * FXML file (UI CODE)-> is the View
        *Java Class handles the events for UI -> controller
        *Domain Objects, on the java side, that connect to the view
            throught the controller -> model
    
    */
}
