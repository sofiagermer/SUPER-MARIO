package superMario.state;

import superMario.controller.Controller;
import superMario.controller.game.LevelController;
import superMario.controller.menu.TransitionController;
import superMario.model.game.Level;
import superMario.model.menu.Transition;
import superMario.viewer.Viewer;
import superMario.viewer.game.LevelViewer;
import superMario.viewer.menu.TransitionViewer;

import java.io.IOException;

public class StateTransition extends State<Transition> {

    public StateTransition(Transition transition) throws IOException {
        super(transition);
    }

    @Override
    protected Viewer<Transition> getViewer() throws IOException {
        return new TransitionViewer(getModel());
    }

    @Override
    protected Controller<Transition> getController() throws IOException {
        return new TransitionController(getModel());
    }
}
