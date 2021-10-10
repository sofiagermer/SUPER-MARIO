package superMario.state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.controller.game.LevelController;
import superMario.controller.menu.TransitionController;
import superMario.model.game.Level;
import superMario.model.game.Mario;
import superMario.model.menu.Transition;
import superMario.viewer.game.LevelViewer;
import superMario.viewer.menu.TransitionViewer;

import java.io.IOException;

public class StateTransitionTest {

    private StateTransition st;

    private Transition transition;

    private Game game;


    @BeforeEach
    void setUp() throws IOException {
        game=new Game();

        transition = new Transition(game);

        st = new StateTransition(transition);


    }

    @AfterEach
    void cleanUp(){
        game.exit();
        game=null;
        transition=null;
        st=null;
    }

    @Test
    void testGetModel(){
        Assertions.assertEquals(transition,st.getModel());
    }
    @Test
    void testGetViewer() throws IOException{
        Assertions.assertEquals(new TransitionViewer(transition).getModel(), st.getViewer().getModel());
    }
    @Test
    void testGetController() throws IOException{
        TransitionController controller = new TransitionController(transition);
        Assertions.assertEquals(controller.getModel(), st.getController().getModel());
    }

}
