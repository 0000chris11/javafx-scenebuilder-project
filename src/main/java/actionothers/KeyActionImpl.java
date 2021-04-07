package actionothers;

import com.cofii2.components.javafx.piano.KeyAction;

import game.Game;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import scenefx.Controller;

public class KeyActionImpl implements KeyAction {

    private Controller controller;

    private FadeTransition labelMessageFadeTransition = new FadeTransition();
    private TranslateTransition labelNoteTranslateTransition = new TranslateTransition();
    private FadeTransition labelNoteFadeTransition = new FadeTransition();

    public KeyActionImpl(Controller controller) {
        this.controller = controller;

        transitionsConfig();
    }
    //GAME-----------------------------------------------------
    private void gameChoice(String name){
        String selectedOption = controller.getCbOption().getSelectionModel().getSelectedItem();
        String selectedDisplay = controller.getCbDisplay().getSelectionModel().getSelectedItem();
        if(selectedOption.equals(Game.OPTIONS[0]) && selectedDisplay.equals(Game.DISPLAY[0])){
            functionBasic(name);
        }
    }
    private void functionBasic(String name) {
        String randomNote = controller.getNoteLabel().getText();
        System.out.println(randomNote);
        if (!randomNote.equals("...")) {
            String basicName = name.substring(0, name.length() - 1);
            System.out.println("originalName: " + name);
            System.out.println("randomNote: " + randomNote);
            System.out.println("basicName: " + basicName);
            Label lb = controller.getMessageLabel();
            if (randomNote.equals(basicName)) {
                
                System.out.println("\tCorrect");
                lb.setText("Correct!");
                lb.setTextFill(Color.GREEN);

                controller.randomNote();
            } else {
                System.out.println("\tWrong");
                lb.setText("Wrong!");
                lb.setTextFill(Color.RED);
            }

            labelMessageFadeTransition.play();

            labelNoteTranslateTransition.play();
            labelNoteFadeTransition.play();
        }
    }
    //TRANSITION-----------------------------------------------------
    private void transitionsConfig(){
        //LABEL MESSAGE
        labelMessageFadeTransition.setNode(controller.getMessageLabel());
        labelMessageFadeTransition.setDuration(Duration.millis(700));
        labelMessageFadeTransition.setFromValue(1.0);
        labelMessageFadeTransition.setToValue(0);
        //LABEL NOTE
        labelNoteTranslateTransition.setNode(controller.getNoteLabel());
        labelNoteTranslateTransition.setDuration(Duration.millis(400));
        labelNoteTranslateTransition.setFromX(-30);
        labelNoteTranslateTransition.setToX(0);

        labelNoteFadeTransition.setNode(controller.getNoteLabel());
        labelNoteFadeTransition.setDuration(Duration.millis(400));
        labelNoteFadeTransition.setFromValue(0);
        labelNoteFadeTransition.setToValue(1.0);
        //labelNoteFadeTransition
    }
    //KEY-ACTION----------------------------------------------------
    @Override
    public void whiteKeyPressedAction(String wkpName) {
        gameChoice(wkpName);
    }

    @Override
    public void blackKeyPressedAction(String bkpName) {
        gameChoice(bkpName);

    }

    @Override
    public void whiteKeyReleasedAction(String wkrName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void blackKeyReleasedAction(String bkrName) {
        // TODO Auto-generated method stub

    }

}
