package superMario.controller.command.buttonCommand;

import superMario.Game;
import superMario.state.StatePlay;

import java.io.IOException;

public class KeepPlayingCommand extends ButtonCommand {
    public KeepPlayingCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() throws IOException {
        game.changeState(new StatePlay(game.getLevel(),game.getLevel().getCurrentLevel()));
    }
}