package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Coin;

import java.io.IOException;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void drawElement(Coin coin, GUI gui) throws IOException {
        gui.drawElement(coin);
    }
}
