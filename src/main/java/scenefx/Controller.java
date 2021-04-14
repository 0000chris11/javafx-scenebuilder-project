package scenefx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.cofii2.components.javafx.sheet.NoteType;
import com.cofii2.components.javafx.sheet.Sheet;
import com.cofii2.components.javafx.TimeLabel;
import com.cofii2.components.javafx.piano.Note;
import com.cofii2.components.javafx.piano.ScrollerPiano;
import com.cofii2.methods.MOthers;
import com.cofii2.mysql.DefaultConnection;
import com.cofii2.mysql.MSQLC;
import com.cofii2.mysql.MSQLP;
import com.cofii2.mysql.store.CallParam;

import actionothers.KeyActionImpl;
import game.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Controller implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox rightVBox;
    @FXML
    private ComboBox<String> cbOption;
    @FXML
    private ComboBox<String> cbDisplay;
    @FXML
    private Label timeLabel;
    @FXML
    private Label noteLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Button buttonStart;
    @FXML
    private Button buttonStop;

    private Timer timer;
    private ScrollerPiano piano;
    private TimeLabel timeLabel2;
    private Sheet sheet = new Sheet();
    //------------------------------------------------------
    public void buttonAction() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!11");
    }

    public void buttonStartAction() {
        buttonStart.setDisable(true);
        cbOption.setDisable(true);
        cbDisplay.setDisable(true);
        buttonStop.setDisable(false);

        randomNote(); 
        
        timeLabel2.resetTimer();

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                Platform.runLater(() -> {
                    timeLabel2.setTimer();
                });
                
            }
            
        }, 0, 100);

    }

    public void buttonStopAction() {
        buttonStart.setDisable(false);
        cbOption.setDisable(false);
        cbDisplay.setDisable(false);
        buttonStop.setDisable(true);

        timer.cancel();
    }
    //------------------------------------------------------
    public void randomNote(){
        int n = MOthers.getRandomNumber(1, Note.NOTE_SCALE.length);
        noteLabel.setText(Note.NOTE_SCALE[n]);
    }
    //------------------------------------------------------
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // NON FXML-CODE
        //PIANO
        piano = new ScrollerPiano(new KeyActionImpl(this));
        piano.setPrefWidth(800);
        piano.setPrefHeight(ScrollerPiano.WK_HEIGHT + 10.0);
        borderPane.setBottom(piano);
        //TIME LABEL
        timeLabel2 = new TimeLabel();
        timeLabel2.setFont(new Font(18.0));
        rightVBox.getChildren().remove(timeLabel);
        rightVBox.getChildren().add(0, timeLabel2);
        //COMBOBOXES
        cbOption.getItems().addAll(Game.OPTIONS);
        cbOption.getSelectionModel().select(Game.OPTIONS[0]);
        
        cbDisplay.getItems().addAll(Game.DISPLAY);
        cbDisplay.getSelectionModel().select(Game.DISPLAY[0]);
        cbDisplay.getSelectionModel().selectedItemProperty().addListener(e -> {
            String seletedItem = cbDisplay.getSelectionModel().getSelectedItem();
            if(seletedItem.equals(Game.DISPLAY[0])){
                rightVBox.getChildren().remove(sheet);
                rightVBox.getChildren().add(1, noteLabel);
            }else if(seletedItem.equals(Game.DISPLAY[1])){
                rightVBox.getChildren().remove(noteLabel);
                rightVBox.getChildren().add(1, sheet);
            }
        });
        //SHEET TEST
        sheet.addNote(new NoteType("Ab4", NoteType.WHOLE_NOTE));
        //-------------------------------------------------------------
        MSQLP msqlp = new MSQLP(new DefaultConnection());
        
    }
    //------------------------------------------------------
    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    public Label getNoteLabel() {
        return noteLabel;
    }

    public void setNoteLabel(Label noteLabel) {
        this.noteLabel = noteLabel;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(Label messageLabel) {
        this.messageLabel = messageLabel;
    }

    public ComboBox<String> getCbOption() {
        return cbOption;
    }

    public void setCbOption(ComboBox<String> cbOption) {
        this.cbOption = cbOption;
    }

    public ComboBox<String> getCbDisplay() {
        return cbDisplay;
    }

    public void setCbDisplay(ComboBox<String> cbDisplay) {
        this.cbDisplay = cbDisplay;
    }

}
