package superMario.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.controller.menu.GameOverController;
import superMario.model.menu.GameOver;
import superMario.viewer.menu.GameOverViewer;

import java.io.IOException;

public class StateGameOverTest {
    private StateGameOver sgo;

    private GameOver transition;

    private Game game;

    @BeforeEach
    void setUp() throws IOException {
        game=new Game();
        transition = new GameOver(game);
        sgo = new StateGameOver(transition);

    }

    @AfterEach
    void cleanUp(){
        game.exit();
        game=null;
        transition=null;
        sgo=null;
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,sgo.getModel());
    }
    @Test
    void testGetViewer() throws IOException{
        Assertions.assertEquals(new GameOverViewer(transition).getModel(), sgo.getViewer().getModel());
    }
    @Test
    void testGetController() throws IOException{
        GameOverController controller = new GameOverController(transition);
        Assertions.assertEquals(controller.getModel(), sgo.getController().getModel());
    }
}
