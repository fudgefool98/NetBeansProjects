
package documenteditor;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author Jordan
 */
public class Documenteditor extends Application {
    public String title = "document editor";
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        VBox root = new VBox(20);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10);
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField);
        
        grid.add(titleFieldBox,0,0);
        
        
//        HTMLEditor editor = new HTMLEditor();
//        editor.setPrefSize(600,500);
//        root.add(editor,0,1);

        TextArea editor = new TextArea();
        editor.setPrefColumnCount(45);
        editor.setPrefRowCount(25);
        grid.add(editor,0,1);

        
        
        Button saveButton = new Button("Save");
        HBox saveButtonBox = new HBox();
        saveButtonBox.setAlignment(Pos.CENTER_RIGHT);
        saveButtonBox.getChildren().add(saveButton);
        
        
        saveButton.setRotate(45);
        
       
        grid.add(saveButtonBox, 0, 2);
        
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("file");
        menuBar.getMenus().add(fileMenu);
        MenuItem openMenuItem = new MenuItem ("Open");
        fileMenu.getItems().add(openMenuItem);
        
        FileChosser chooser = new FileChooser();
        Charset charset = StandardCharsets.UTF_8;
        
        openMenuItem.setOnAction((ActionEvent event)->{
        System.out.println("Open chosen");
        
        File file = chooser.showOpenDIalog(primaryStage);
        
        if(file!=null){
            System.out.println(file.toString());
            try{
                List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()),charset);
                System.out.println(lines.toString());
                editor.sestText(lines.toString());
            }catch(IOException ex){
                Logger.getLogger(DocumentEditor.class.getName()).log(Level,SEVERE, null,ex);}
            
            }
    });
        saveMenuItem.setOnAction((ActionEent even)->{
            File file = chooser.showSaveDialog(primaryStage);
            
            System.out.println(file.toString());
            String output = titleField.getText() + "\n\n" + editor.getText();
            
            try{
                Files.write(Paths.get(file.getAbsolutePath()), Arrays.asList(output),charset,
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }catch(IOException ex){
                Logger.getLoger(DocumentEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });
        
        
        openMenuItem.setOnAction((ActionEvent event) ->{
            System.out.println("Open Chosen");
        });
        
        
        
        root.getChildren().add(menuBar);
        root.getChildren().add(grid);
        
               
        Scene scene = new Scene(root,800,700);
    }
        
        
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






