package actionothers;

import com.cofii2.components.javafx.piano.KeyAction;

import game.Game;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import scenefx.Controller;

public class KeyActionImpl implements KeyAction {

    private Controller controller;
    private FadeTransition fadeTransition;

    public KeyActionImpl(Controller controller) {
        this.controller = controller;

        fadeTransitionConfig();
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

            fadeTransition.play();
        }
    }
    //TRANSITION-----------------------------------------------------
    private void fadeTransitionConfig(){
        fadeTransition = new FadeTransition(Duration.millis(700), controller.getMessageLabel());
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
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
