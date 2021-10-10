package superMario.controller.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.gui.GUI;
import superMario.model.menu.GameOver;
import superMario.model.menu.Transition;

import java.io.IOException;

public class TransitionControllerTest {
    TransitionController tc;
    Transition trans;

    Game game;

    @BeforeEach
    void setUp() throws IOException {

        game = new Game();
        trans = new Transition(game);
        tc = new TransitionController(trans);
    }
    @AfterEach
    void closeGame(){
        game.exit();
        game=null;
        trans=null;
        tc=null;
    }

    @Test
    void leftTest() throws IOException{

        Transition transition = tc.getModel();

        tc.step(game, GUI.PressedKey.LEFT,0);

        transition.previousOption();

        Assertions.assertEquals(transition,tc.getModel());

    }
    @Test
    void right_Test() throws IOException{

        Transition transition = tc.getModel();

        tc.step(game, GUI.PressedKey.RIGHT,0);

        transition.nextOption();

        Assertions.assertEquals(transition,tc.getModel());

    }

    @Test
    void TestUpDown() throws IOException{

        Transition transition = tc.getModel();

        tc.step(game, GUI.PressedKey.UP,0);

        Assertions.assertEquals(transition,tc.getModel());

        tc.step(game, GUI.PressedKey.DOWN,0);

        Assertions.assertEquals(transition,tc.getModel());
    }

    @Test
    void TestEnter() throws IOException{
        Transition transition = tc.getModel();

        tc.step(game, GUI.PressedKey.ENTER,0);

        transition.getSelectedButton().getAction().execute();

        Assertions.assertEquals(transition,tc.getModel());

    }
    @Test
    void TestEscape() throws IOException{
        Transition transition = tc.getModel();

        tc.step(game, GUI.PressedKey.ESCAPE,0);

        transition.getOptions().get(1).getAction().execute();;

        Assertions.assertEquals(transition,tc.getModel());

    }

    @Test
    void TestGet() throws IOException{

        Assertions.assertEquals(trans,tc.getModel());

    }

}
