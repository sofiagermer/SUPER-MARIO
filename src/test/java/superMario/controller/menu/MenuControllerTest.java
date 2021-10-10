package superMario.controller.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.gui.GUI;

import superMario.model.menu.StartMenu;

import java.io.IOException;

public class MenuControllerTest {

    MenuController mc;
    StartMenu startMenu;
    Game game;

    @BeforeEach
    void setUp() throws IOException {

        game = new Game();

        startMenu = new StartMenu(game);

        mc = new MenuController(startMenu);
    }
    @AfterEach
    void closeGame(){
        game.exit();
        game=null;
        startMenu=null;
        mc=null;
    }

    @Test
    void leftTest() throws IOException{

        StartMenu sm = mc.getModel();

        mc.step(game, GUI.PressedKey.LEFT,0);

        sm.previousOption();

        Assertions.assertEquals(sm,mc.getModel());




    }
    @Test
    void rightTest() throws IOException{

        StartMenu sm = mc.getModel();

        mc.step(game, GUI.PressedKey.RIGHT,0);

        sm.nextOption();

        Assertions.assertEquals(sm,mc.getModel());

    }

    @Test
    void TestUpDown() throws IOException{

        StartMenu go = mc.getModel();

        mc.step(game, GUI.PressedKey.UP,0);

        Assertions.assertEquals(go,mc.getModel());

        mc.step(game, GUI.PressedKey.DOWN,0);

        Assertions.assertEquals(go,mc.getModel());
    }

    @Test
    void Testenter() throws IOException{
        StartMenu go = mc.getModel();

        mc.step(game, GUI.PressedKey.ENTER,0);

        go.getSelectedButton().getAction().execute();

        Assertions.assertEquals(go,mc.getModel());

    }
    @Test
    void Testescape() throws IOException{
        StartMenu go = mc.getModel();

        mc.step(game, GUI.PressedKey.ESCAPE,0);

        go.getOptions().get(1).getAction().execute();

        Assertions.assertEquals(go,mc.getModel());

    }

    @Test
    void TestGet() throws IOException{
        Assertions.assertEquals(startMenu,mc.getModel());

    }
}
