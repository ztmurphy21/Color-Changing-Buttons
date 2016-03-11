/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchangingbuttons;

import com.sun.javafx.scene.layout.region.BackgroundFill;
import java.awt.Color;
import java.awt.Paint;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javax.swing.text.StyleConstants.Background;

/**
 *
 * @author Zachary Murphy
 */
public class ColorChangingButtons extends Application {
    //HBox set up globally due to event handlers    
    HBox root = new HBox(40);

    
    @Override
    public void start(Stage primaryStage) {
        
        //declaration of variables
        Button yellow = new Button();
        Button green = new Button();
        Label label = new Label();
        
        //setting the text for items
        label.setText("Pick a Color");
        green.setText("Green");
        yellow.setText("Yellow");

        //handler if yellow is selected
        yellow.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            root.setStyle("-fx-background-color: yellow");
                
            }
            
        });
        
        //handler if green is selected. 
           green.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              String enteredByUser = "Green";
            root.setStyle("-fx-background-color: green");
                
            }
            
        });
        
           //set up for layout/adding items
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, yellow, green);
        
        //setting the scene 
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Color Picker");
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
