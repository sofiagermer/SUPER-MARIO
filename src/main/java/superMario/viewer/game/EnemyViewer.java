package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Enemy;
import superMario.viewer.game.ElementViewer;

import java.io.IOException;

public class EnemyViewer implements ElementViewer<Enemy> {
    @Override
    public void drawElement(Enemy element, GUI gui) throws IOException {
        gui.drawElement(element);
    }
}
