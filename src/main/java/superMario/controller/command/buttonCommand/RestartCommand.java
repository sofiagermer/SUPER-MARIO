package superMario.controller.command.buttonCommand;

import superMario.Game;
import superMario.model.menu.StartMenu;
import superMario.state.StateMenu;

import java.io.IOException;

public class RestartCommand extends ButtonCommand {
    public RestartCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() throws IOException {
        game.getLevel().getCharacter().resetLives();
        game.getLevel().resetPoints();
        game.changeState(new StateMenu(new StartMenu(game)));
    }
}
