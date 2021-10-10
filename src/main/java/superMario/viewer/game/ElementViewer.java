package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Element;

import java.io.IOException;

public interface ElementViewer<T extends Element> {

    void drawElement(T element, GUI gui) throws IOException;

}
