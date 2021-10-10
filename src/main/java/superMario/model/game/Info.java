package superMario.model.game;


import superMario.gui.FileReader;
import superMario.gui.GlobalConfigs;
import superMario.model.game.ViewOnlyElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Info{
    private final ViewOnlyElement livesTitle;
    private final ViewOnlyElement pointsTitle;
    private final List<ViewOnlyElement> livesNumbers;
    private final List<List<String>> pointsFiles;

    public Info() throws IOException {
        this.livesTitle=new ViewOnlyElement(10, GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",new FileReader().readFile("./src/main/resources/textFiles/lives.txt"));
        this.livesNumbers =new ArrayList<>();
        for(int i=0;i<10;i++) {
            this.livesNumbers.add(new ViewOnlyElement(this.livesTitle.getFrontX() + 5, GlobalConfigs.TERMINAL_HEIGHT - 5, "#000000", new FileReader().readFile("./src/main/resources/textFiles/" + i + ".txt")));
        }
        this.pointsTitle=new ViewOnlyElement(this.livesNumbers.get(0).getFrontX()+50, GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",new FileReader().readFile("./src/main/resources/textFiles/points.txt"));
        this.pointsFiles=new ArrayList<>();
        for(int i=0;i<10;i++) {
            this.pointsFiles.add( new FileReader().readFile("./src/main/resources/textFiles/" + i + ".txt"));
        }
    }

    public ViewOnlyElement getLivesTitle() {
        return livesTitle;
    }

    public ViewOnlyElement getNumberLives(int lives) {
        return livesNumbers.get(lives);
    }

    public ViewOnlyElement getPointsTitle(){
        return pointsTitle;
    }

    public List<ViewOnlyElement> getNumberPoints(int points){
        List<ViewOnlyElement> result=new ArrayList<>();
        if(points<10){
            ViewOnlyElement n1= new ViewOnlyElement(pointsTitle.getFrontX()+5,GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points)) ;
            result.add(n1);
        }
        else if(points<100){
            ViewOnlyElement n1= new ViewOnlyElement(pointsTitle.getFrontX()+5,GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points/10)) ;
            ViewOnlyElement n2=new ViewOnlyElement(n1.getFrontX(),GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points%10)) ;
            result.add(n1);
            result.add(n2);
        }
        else if(points<1000){
            ViewOnlyElement n1= new ViewOnlyElement(pointsTitle.getFrontX()+5,GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points/100)) ;
            points-=(points/100)*100;
            ViewOnlyElement n2=new ViewOnlyElement(n1.getFrontX(),GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points/10)) ;
            ViewOnlyElement n3=new ViewOnlyElement(n2.getFrontX(),GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(points%10)) ;
            result.add(n1);
            result.add(n2);
            result.add(n3);
        }
        else result.add(new ViewOnlyElement(pointsTitle.getFrontX()+5,GlobalConfigs.TERMINAL_HEIGHT-5,"#000000",pointsFiles.get(0)));
        return result;
    }
}
