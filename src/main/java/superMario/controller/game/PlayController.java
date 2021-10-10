package superMario.controller.game;

import superMario.controller.Controller;
import superMario.model.game.Level;

public abstract class PlayController extends Controller<Level> {
    public PlayController(Level level) {
        super(level);
    }
}
