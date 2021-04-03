package scenefx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import com.cofii2.components.javafx.piano.KeyAction;
import com.cofii2.components.javafx.piano.ScrollerPiano;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable{
    
    @FXML
    private BorderPane borderPane;
    private Label timeLabel;

    public void buttonAction(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!11");
    }

    public void buttonStartAction(){
        Timer timer = new Timer();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //NON FXML-CODE
        ScrollerPiano piano = new ScrollerPiano(new KeyAction(){

            @Override
            public void whiteKeyPressedAction(String wkpName) {
                if(!timeLabel.getText().equals("00:00")){

                }
                
            }

            @Override
            public void blackKeyPressedAction(String bkpName) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void whiteKeyReleasedAction(String wkrName) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void blackKeyReleasedAction(String bkrName) {
                // TODO Auto-generated method stub
                
            }
            
        });
        piano.setPrefWidth(800);
        borderPane.setBottom(piano);
        piano.setPrefHeight(ScrollerPiano.WK_HEIGHT + 10.0);
        
    }


}
