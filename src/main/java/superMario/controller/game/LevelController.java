package superMario.controller.game;

import superMario.Game;
import superMario.gui.GUI;
import superMario.model.game.Level;
import superMario.model.menu.GameOver;
import superMario.model.menu.Transition;
import superMario.state.StateGameOver;
import superMario.state.StateTransition;

import java.io.IOException;

public class LevelController extends PlayController{
    private final CharacterController characterController;

    public LevelController(Level level) {
        super(level);
        this.characterController=new CharacterController(level);
        getModel().startMusic();
    }

    @Override
    public void step(Game game, GUI.PressedKey keyP, long time) throws IOException {

        /** Lost all lives **/
        if(getModel().getCharacter().getLives() == 0){
            game.changeState(new StateGameOver(new GameOver(game)));
        }

        /** Finish level but still have got other levels to play**/
        else if (getModel().isAtEnd() && getModel().getCurrentLevel() < (getModel().getNumLevels())){
            getModel().nextLevel();
            game.changeState(new StateTransition(new Transition(game)));
        }

        /** Finish last level**/
        else if(getModel().isAtEnd() && getModel().getCurrentLevel() == (getModel().getNumLevels())){
            game.changeState(new StateGameOver(new GameOver(game)));
        }

        /** Playing a level**/
        else {
            characterController.step(game, keyP, time);
            getModel().updateEnemies();
            getModel().updateRelativePositions();
            getModel().checkElementCollision();
        }
    }
}
