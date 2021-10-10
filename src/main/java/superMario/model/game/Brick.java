package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;

import java.util.List;
import java.util.Random;

public class Brick extends Element{
    private boolean broken;
    private List<String> brokeAppearance,normalAppearance;
    private int points;

    public Brick(int x, int y, boolean initState) throws IOException {
        super(x, y, "#FF0000",new FileReader().readFile("src/main/resources/textFiles/specialBrick.txt"));
        this.normalAppearance= getElementAppearance();
        this.brokeAppearance =new FileReader().readFile("src/main/resources/textFiles/brick.txt");

        this.broken=initState;

        Random generator=new Random();
        this.points=generator.nextInt()%10+10;

        if(this.broken){
            setElementAppearance(brokeAppearance);
        }


    }

    public boolean breakBrick(){
        if(!this.broken){
            this.broken = true;
            setElementAppearance(brokeAppearance);
            return true;
        }
        return false;
    }

    public int getPoints(){return points;}

}
