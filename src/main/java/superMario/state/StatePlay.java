package superMario.state;

import superMario.Game;
import superMario.controller.Controller;
import superMario.controller.game.LevelController;
import superMario.gui.GUI;
import superMario.model.game.Level;
import superMario.viewer.Viewer;
import superMario.viewer.game.LevelViewer;

import java.io.IOException;


public class StatePlay extends State<Level>{
    public StatePlay(Level level, int currentLevel) throws IOException {
        super(level);
        level.loadLevel(currentLevel);
    }

    @Override
    protected Viewer<Level> getViewer() throws IOException {
        return new LevelViewer(getModel());
    }

    @Override
    protected Controller<Level> getController() throws IOException {
        return new LevelController(getModel());
    }
}

