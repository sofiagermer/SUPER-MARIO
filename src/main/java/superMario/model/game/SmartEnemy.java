package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;

public class SmartEnemy extends Enemy{

    private boolean neutralized;

    public SmartEnemy(int x, int y) throws IOException {
        super(x,y,"#FF0000",new FileReader().readFile("src/main/resources/textFiles/turtle.txt"),0);
    }



}