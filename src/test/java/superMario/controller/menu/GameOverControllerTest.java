package superMario.controller.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.gui.GUI;
import superMario.model.menu.GameOver;

import java.io.IOException;

public class GameOverControllerTest {

    GameOverController goc;

    GameOver gameOver;

    Game game;

    @BeforeEach
    void setUp() throws IOException {

        game = new Game();

        gameOver = new GameOver(game);

        goc = new GameOverController(gameOver);
    }

    @AfterEach
    void cleanUp(){
        game.exit();
        game=null;
        gameOver=null;
        goc=null;
    }


    @Test
    void leftTest() throws IOException{

        GameOver go = goc.getModel();

        goc.step(game, GUI.PressedKey.LEFT,0);

        go.previousOption();

        Assertions.assertEquals(go,goc.getModel());

    }
    @Test
    void rightTest() throws IOException{

        GameOver go = goc.getModel();

        goc.step(game, GUI.PressedKey.RIGHT,0);

        go.nextOption();

        Assertions.assertEquals(go,goc.getModel());

    }

    @Test
    void TestUpDown() throws IOException{

        GameOver go = goc.getModel();

        goc.step(game, GUI.PressedKey.UP,0);

        Assertions.assertEquals(go,goc.getModel());

        goc.step(game, GUI.PressedKey.DOWN,0);

        Assertions.assertEquals(go,goc.getModel());

    }

    @Test
    void TestEnter() throws IOException{
        GameOver go = goc.getModel();

        goc.step(game, GUI.PressedKey.ENTER,0);

        go.getSelectedButton().getAction().execute();

        Assertions.assertEquals(go,goc.getModel());

    }
    @Test
    void TestEscape() throws IOException{
        GameOver go = goc.getModel();

        goc.step(game, GUI.PressedKey.ESCAPE,0);

        go.getOptions().get(1).getAction().execute();

        Assertions.assertEquals(go,goc.getModel());

    }

    @Test
    void TestGet(){

        Assertions.assertEquals(gameOver,goc.getModel());

    }


}
