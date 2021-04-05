package actionothers;

import com.cofii2.components.javafx.piano.KeyAction;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import scenefx.Controller;

public class KeyActionImpl implements KeyAction {

    private Controller controller;

    public KeyActionImpl(Controller controller) {
        this.controller = controller;
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
        }
    }

    @Override
    public void whiteKeyPressedAction(String wkpName) {
        functionBasic(wkpName);

    }

    @Override
    public void blackKeyPressedAction(String bkpName) {
        functionBasic(bkpName);

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
