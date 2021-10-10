package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;
import java.util.List;

public class Flag extends Element{

    private Flag(int x, int y,String hexColor,List<String> elementAppearance) {
        super(x, y+elementAppearance.size(), "#FF0000", elementAppearance);
    }

    public Flag(int x, int y) throws IOException {
        this(x,y,"#FF0000",new FileReader().readFile("src/main/resources/textFiles/flag.txt"));

    }

}
