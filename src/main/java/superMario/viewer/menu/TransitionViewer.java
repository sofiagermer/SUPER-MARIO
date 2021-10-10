package superMario.viewer.menu;

import superMario.gui.FileReader;
import superMario.gui.GUI;
import superMario.model.menu.Transition;
import superMario.viewer.Viewer;

import java.io.IOException;

public class TransitionViewer extends Viewer<Transition> {

    public TransitionViewer(Transition transition) {
        super(transition);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackground();
        gui.drawTitle(new FileReader().readFile("./src/main/resources/textFiles/transition/courseClear.txt"), "#000000");
        gui.drawMarioFace(new FileReader().readFile("./src/main/resources/textFiles/menu/mario.txt"), "#b22222");
        for(int i = 0; i < getModel().getNumberOptions() ; i++){
            gui.drawButton(getModel().getOptions().get(i));
        }
    }
}
