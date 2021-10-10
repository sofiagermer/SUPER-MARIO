package superMario.controller.menu;

import superMario.Game;
import superMario.controller.Controller;
import superMario.gui.GUI;
import superMario.model.menu.Transition;

import java.io.IOException;

public class TransitionController extends Controller<Transition> {
    public TransitionController(Transition transitionModel) {
        super(transitionModel);
    }

    @Override
    public void step(Game game, GUI.PressedKey action, long time) throws IOException {
        switch (action) {
            case UP:
            case LEFT:
                getModel().previousOption();
                break;
            case DOWN:
            case RIGHT:
                getModel().nextOption();
                break;
            case ENTER:
                getModel().getSelectedButton().getAction().execute();
                break;
            case ESCAPE:
                getModel().getOptions().get(1).getAction().execute();
            default:
                break;
        }
    }
}
