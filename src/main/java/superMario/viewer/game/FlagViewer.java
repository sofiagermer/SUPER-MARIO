package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Flag;
import superMario.viewer.game.ElementViewer;

import java.io.IOException;

public class FlagViewer implements ElementViewer<Flag> {
    @Override
    public void drawElement(Flag flag, GUI gui) throws IOException {
        gui.drawElement(flag);
    }
}
