package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;

public class DumbEnemy extends Enemy{

    public DumbEnemy(int x, int y, int speedX) throws IOException{
        super(x,y,"#0000FF",new FileReader().readFile("src/main/resources/textFiles/evilMushroom.txt"),speedX);
    }

}
