/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorchangingbuttons;

import com.sun.javafx.scene.layout.region.BackgroundFill;
import java.awt.Color;
import java.awt.Paint;
import static java.util.Collections.rotate;
import javafx.application.Application;
import static javafx.collections.FXCollections.rotate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import static javax.swing.text.StyleConstants.Background;

/**
 *
 * @author Zachary Murphy
 */
public class ColorChangingButtons extends Application {
    //HBox set up globally due to event handlers    
    HBox root = new HBox(40);
    //need to make alll rotation items global, or there will be errors
    Rotate rotate= new Rotate();
    double angle = 0.0;
    //rotates button has to be global too for same reason.
    Button rotates = new Button();
    

    @Override
    public void start(Stage primaryStage) {
        
        //declaration of variables
        Button yellow = new Button();
        Button green = new Button();
        Label label = new Label();
        
        //setting the text for items
        label.setText("What would you like to see?");
        green.setText("Green!");
        yellow.setText("Yellow!");
        rotates.setText("Cool Rotation");
 
        

        

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
           //transforms set for rotation 
           rotates.getTransforms().add(rotate);
           //if rotate button is fit
           rotates.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //setting angle degree
                angle += 15.0;
             // rotation actions
             rotate.setAngle(angle);
             rotate.setPivotX(rotates.getWidth()/2);
             rotate.setPivotY(rotates.getHeight()/2);
             
                
            }
            
        });
         
       
        
           //set up for layout/adding items
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label, yellow, green, rotates);
        
        //setting the scene 
        Scene scene = new Scene(root, 500, 500);
        
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
