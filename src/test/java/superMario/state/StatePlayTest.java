package superMario.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.controller.Controller;
import superMario.controller.game.CharacterController;
import superMario.controller.game.LevelController;
import superMario.gui.LanternaGUI;
import superMario.model.game.Character;
import superMario.model.game.Level;
import superMario.model.game.Mario;
import superMario.viewer.game.LevelViewer;

import java.io.IOException;

public class StatePlayTest {

    private StatePlay sp;

    private Level level;

    @BeforeEach
    void setUp() throws IOException {
        level = new Level(new Mario());
        level.loadLevel(1);
        sp = new StatePlay(level,1);
    }

    @AfterEach
    void cleanUp(){
        level=null;
        sp=null;
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(level,sp.getModel());
    }
    @Test
    void testGetViewer() throws IOException{
        Assertions.assertEquals(new LevelViewer(level).getModel(), sp.getViewer().getModel());
    }
    @Test
    void testGetController() throws IOException{
        LevelController controller = new LevelController(level);
        Assertions.assertEquals(controller.getModel(), sp.getController().getModel());
    }




}
