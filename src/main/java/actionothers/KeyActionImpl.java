package actionothers;

import com.cofii2.components.javafx.piano.KeyAction;

import javafx.fxml.FXMLLoader;
import scenefx.Controller;

public class KeyActionImpl implements KeyAction {

    //RETURN NULL
    private Controller controller = (Controller) new FXMLLoader(getClass().getResource("/scenefx/App.fxml")).getController();

    @Override
    public void whiteKeyPressedAction(String wkpName) {
        String note = controller.getNoteLabel().getText();
        if (!note.equals("...")) {
            if(note.equals(wkpName.substring(0, 1))){
                System.out.println("CORRECT");
            }else{
                System.out.println("WRONG");
            }
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

}
