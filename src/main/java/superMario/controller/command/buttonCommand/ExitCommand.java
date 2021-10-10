package superMario.controller.command.buttonCommand;

import superMario.Game;

public class ExitCommand extends ButtonCommand{
    public ExitCommand(Game game) {
        super(game);
    }

    @Override
    public void execute() {
        game.exit();
    }
}
