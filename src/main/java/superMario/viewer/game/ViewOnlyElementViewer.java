package superMario.viewer.game;

import superMario.model.Position;
import superMario.model.game.ViewOnlyElement;
import superMario.gui.GUI;

import java.io.IOException;

public class ViewOnlyElementViewer {

    void draw(ViewOnlyElement viewOnlyElement,GUI gui) throws IOException {
        gui.drawViewOnlyElement(viewOnlyElement);
    }
}
