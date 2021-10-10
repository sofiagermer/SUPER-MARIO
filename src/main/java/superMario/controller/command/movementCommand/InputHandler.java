package superMario.controller.command.movementCommand;

import superMario.gui.GUI;
import superMario.model.game.Level;

public class InputHandler {
    private GoLeft left;
    private GoRight right;
    private Jump jump;

    private Level level;

    public InputHandler(Level level){
        this.level = level;

        left = new GoLeft();
        right = new GoRight();
        jump = new Jump();
    }

    public void handleInput(GUI.PressedKey action){
        switch(action){
            case UP:
                if(!level.isElementFloating(level.getCharacter())){
                    jump.execute(this.level);
                }
                break;
            case RIGHT:
                right.execute(this.level);

                break;
            case LEFT:
                left.execute(this.level);
                break;
            default:
                break;
        }
    }
}