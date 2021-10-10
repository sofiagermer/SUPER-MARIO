package superMario.state;

import superMario.controller.Controller;
import superMario.controller.menu.GameOverController;
import superMario.controller.menu.TransitionController;
import superMario.model.menu.GameOver;
import superMario.model.menu.Transition;
import superMario.viewer.Viewer;
import superMario.viewer.menu.GameOverViewer;
import superMario.viewer.menu.TransitionViewer;

import java.io.IOException;

public class StateGameOver extends State<GameOver> {

    public StateGameOver(GameOver gameOver) throws IOException {
        super(gameOver);
    }

    @Override
    protected Viewer<GameOver> getViewer() throws IOException {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() throws IOException {
        return new GameOverController(getModel());
    }
}