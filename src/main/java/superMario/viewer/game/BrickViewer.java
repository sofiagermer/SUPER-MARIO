package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Brick;


import java.io.IOException;

public class BrickViewer implements ElementViewer<Brick> {
    @Override
    public void drawElement(Brick element, GUI gui) throws IOException {
        gui.drawElement(element);
    }
}