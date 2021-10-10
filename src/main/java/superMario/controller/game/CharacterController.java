package superMario.controller.game;


import superMario.Game;
import superMario.controller.command.movementCommand.InputHandler;
import superMario.gui.GUI;
import superMario.model.game.Character;
import superMario.model.game.Level;

import java.io.IOException;


public class CharacterController extends PlayController{
    private InputHandler inputHandler;
    public CharacterController(Level level) {
        super(level);
        this.inputHandler = new InputHandler(level);
    }
    private void gravity() throws IOException {
        if(getModel().isElementFloating(this.getModel().getCharacter())){
            getModel().getCharacter().setPosition(this.getModel().getCharacter().getPosition().getDown());
        }
        if(getModel().isElementFloating(this.getModel().getCharacter())){
            getModel().getCharacter().setPosition(this.getModel().getCharacter().getPosition().getDown());
        }
    }

    @Override
    public void step(Game game, GUI.PressedKey keyP, long time) throws IOException {
        this.inputHandler.handleInput(keyP);
        if(!getModel().getCharacter().isJumping()){
            gravity();
        }
        if(getModel().getCharacter().getBottomY()==0){
            getModel().die();
        }
    }
}
