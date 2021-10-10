package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;
import java.util.List;

public class Coin extends Element{
    private Coin(int x, int y, String hexColor, List<String> elementAppearance) {
        super(x, y+ elementAppearance.size(), hexColor, elementAppearance);
    }
    public Coin(int x, int y) throws IOException {
        this(x,y,"#FFFF00",new FileReader().readFile("src/main/resources/textFiles/coin.txt"));
    }

}
