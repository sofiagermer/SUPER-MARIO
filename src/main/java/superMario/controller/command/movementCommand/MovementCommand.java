package superMario.controller.command.movementCommand;

import superMario.model.game.Level;

public abstract class MovementCommand {
    public abstract void execute(Level l);
}