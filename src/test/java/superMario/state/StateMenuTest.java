package superMario.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.controller.menu.MenuController;
import superMario.model.menu.StartMenu;
import superMario.viewer.menu.MenuViewer;

import java.io.IOException;

public class StateMenuTest {

    private StateMenu sm;

    private StartMenu transition;

    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game=new Game();
        transition = new StartMenu(new Game());
        sm = new StateMenu(transition);
    }

    @AfterEach
    void cleanUp(){
        game.exit();
        game=null;
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,sm.getModel());
    }
    @Test
    void testGetViewer() throws IOException{
        Assertions.assertEquals(new MenuViewer(transition).getModel(), sm.getViewer().getModel());
    }
    @Test
    void testGetController() throws IOException{
        MenuController controller = new MenuController(transition);
        Assertions.assertEquals(controller.getModel(), sm.getController().getModel());
    }

}
