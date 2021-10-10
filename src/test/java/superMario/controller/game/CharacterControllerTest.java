package superMario.controller.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.controller.command.movementCommand.InputHandler;
import superMario.gui.GUI;
import superMario.model.game.Level;
import superMario.model.game.Mario;

import java.io.IOException;

public class CharacterControllerTest {
/*

    private Level level;
    private CharacterController controller;
    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game=new Game();
        level = new Level(new Mario());
        level.loadLevel(1);
        controller = new CharacterController(level);
    }

    @AfterEach
    void cleanUp(){
        game.exit();
        game=null;
        controller=null;
        level=null;
    }

   @Test
  void testLeft() throws IOException{

        Level lvl = new Level(new Mario());
        lvl.loadLevel(1);

        InputHandler ih = new InputHandler(lvl);
        ih.handleInput(GUI.PressedKey.LEFT);


        controller.step(game, GUI.PressedKey.LEFT,0);

        Assertions.assertEquals(lvl.getCharacter().getPosition().getX(),controller.getModel().getCharacter().getPosition().getX());

    }
    @Test
    void testJump() throws IOException{

        Level lvl = new Level(new Mario());
        lvl.loadLevel(1);

        InputHandler ih = new InputHandler(lvl);
        ih.handleInput(GUI.PressedKey.UP);

        controller.step(new Game(), GUI.PressedKey.UP,0);



        Assertions.assertEquals(lvl.getCharacter().getPosition().getX(),controller.getModel().getCharacter().getPosition().getX());

    }

*/
}
