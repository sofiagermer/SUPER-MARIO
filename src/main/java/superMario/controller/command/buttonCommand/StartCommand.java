package superMario.controller.command.buttonCommand;

import superMario.Game;
import superMario.model.game.Level;
import superMario.model.game.Mario;
import superMario.state.StatePlay;

import java.io.IOException;

public class StartCommand extends ButtonCommand {
    public StartCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() throws IOException {
        game.changeState(new StatePlay(game.getLevel(),1));
    }
}
