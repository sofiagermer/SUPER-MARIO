package superMario.model.game;

import superMario.gui.GlobalConfigs;
import superMario.model.Position;
import superMario.viewer.game.MusicPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Level {
    private Character character;
    private Map map;
    private Flag endFlag;
    private MusicPlayer musicPlayer;
    private boolean end;
    private int points;
    private int currentLevel;
    private int numLevels;


    private ArrayList<Enemy> enemies;
    private ArrayList<Brick> bricks;
    private ArrayList<Coin> coins;

    public Level(Character character) throws IOException {
        this.musicPlayer = new MusicPlayer();
        this.character = character;
        this.points=0;
        this.currentLevel = 1;
        this.numLevels = 3;
    }

    public int getCurrentLevel(){return this.currentLevel;}

    public void restart() {this.currentLevel = 1;}

    public void nextLevel(){
        if(currentLevel<this.numLevels) {
            this.currentLevel++;
        }
    }

    public int getNumLevels(){return this.numLevels;}

    public Character getCharacter() {
        return character;
    }

    public boolean isElementFloating(MovingElement e) {


        List<String> block = map.getMapSection(e.getPosition().getX(), e.getPosition().getX()+e.getWidth());

        for (String s : block) {
            if (e.getBottomY() <= s.length()) {
                return false;
            }
        }
        for (int i = 0; i < bricks.size(); i++) {
            if (!isInScreen(bricks.get(i))) continue;
            if (e.getFrontX() > bricks.get(i).getPosition().getX()
                    && e.getPosition().getX() < bricks.get(i).getFrontX()
                    && e.getBottomY() == bricks.get(i).getPosition().getY()) {
                return false;
            }
        }


        if (e.getBottomY() > (map.getFloorY(e.getPosition().getX())) && (e.getBottomY() > map.getFloorY(e.getFrontX()))) {
            return true;
        } else {
            return false;
        }

    }

    public List<String> getMap() {
        return map.getMapInfo(character.getPosition().getX());
    }

    public boolean brickCollision(){
        boolean flag=false;
        for(int i = 0; i< bricks.size(); i++){
            if(checkElementCollision(bricks.get(i),character)&& character.isJumping()){
                if(bricks.get(i).breakBrick()){
                    points+=bricks.get(i).getPoints();
                }
                flag=true;
            }
        }
        return flag;
    }

    public boolean isInScreen(Element element){
        if(element.getPosition().getX()<character.getPosition().getX()+250  &&
                element.getPosition().getX()>character.getPosition().getX()-250) {
            return true;
        }

        return false;
    }

    public void die(){
        character.die();
        this.reset();
    }

    public void startMusic(){
        musicPlayer.startMusic();
    }

    private void reset() {
        try {
            loadLevel(currentLevel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetPoints(){
        points=0;
    }


    
    public Flag getEndFlag() {
        return endFlag;
    }

    public void updateRelativePositions(){

        endFlag.setRelativePosition(character.getPosition());

        for(Enemy e: enemies){
            e.setRelativePosition(character.getPosition());
        }

        for(Element b: bricks){
            b.setRelativePosition(character.getPosition());
        }

        for(Coin c: coins){
            c.setRelativePosition(character.getPosition());
        }
    }

    public void updateEnemies(){

        for(Enemy e: enemies){

            if(isElementFloating(e)){
                e.setPosition(e.getPosition().getDown());
            }else {
                if(e.getBottomY()==0) e.resetPosition();
                else {

                    if (e instanceof DumbEnemy) {


                        for (int i = 0; i < Math.abs(e.getSpeedX()); i++) {
                            Position newPos = new Position(e.getPosition().getX() + e.getSpeedX() / Math.abs(e.getSpeedX()), e.getPosition().getY());

                            if (isMoveLegal(newPos, e)) e.setPosition(newPos);
                            else {
                                e.setSpeedX(e.getSpeedX() * -1);
                            }
                        }
                    }else{

                        int xDiff = e.getPosition().getX() - character.getPosition().getX() ;
                        Position newPos;
                        if(xDiff > 0){
                           newPos  = new Position(e.getPosition().getX()-1, e.getPosition().getY());
                        }else{
                            newPos = new Position(e.getPosition().getX()+1,e.getPosition().getY());
                        }
                        if(isMoveLegal(newPos,e)) e.setPosition(newPos);
                    }
                }
            }
        }
    }

    public void checkElementCollision(){

        Iterator<Enemy> it_enemy = enemies.iterator();
        while(it_enemy.hasNext()){
            Enemy e = it_enemy.next();
            if(checkElementCollision(e,character)){

                if(!character.isJumping() && isElementFloating(character)){
                    it_enemy.remove();
                }else{
                    die();
                }


            }
        }
        Iterator<Coin> it = coins.iterator();
        while(it.hasNext()){
            Coin c = it.next();
            if(checkElementCollision(c,character)){
                it.remove();
                points+=10;
            }
        }



    }

    public boolean isAtEnd(){
        return character.getPosition().getX()>=endFlag.getPosition().getX();
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Brick> getBricks() { return bricks;}

    public ArrayList<Coin> getCoins() { return coins;}

    public boolean isMoveLegal(Position p, MovingElement e){

        if(p.getY()-e.getHeight() < map.getFloorY(p.getX())){
            return false;
        }

        if(p.getY()-e.getHeight() <  map.getFloorY(p.getX() + e.getWidth())){
            return false;
        }
        if(p.getX() <= GlobalConfigs.TERMINAL_WIDTH/2){
            return false;
        }


        Mario temp = null;
        try{
            temp = new Mario();
        }catch(IOException exception){

        }

        temp.setPosition(p);


        for(Brick b: bricks){
            if(checkElementCollision(b,temp)){
                return false;
            }

        }

        return true;
    }

    public boolean checkElementCollision(Element e, Character c){

        if(c.getPosition().getX() <= e.getPosition().getX() && c.getFrontX() >= e.getPosition().getX() ){
            if(c.getPosition().getY() <= e.getPosition().getY() && c.getPosition().getY() >= e.getBottomY()){
                return true;
            }
            if(c.getPosition().getY() > e.getPosition().getY() && c.getBottomY() < e.getPosition().getY()){
                return true;
            }
        }
        if(c.getPosition().getX() >= e.getPosition().getX() && c.getPosition().getX() <= e.getFrontX() ){
            if(c.getPosition().getY() <= e.getPosition().getY() && c.getPosition().getY() >= e.getBottomY()){
                return true;
            }
            if(c.getPosition().getY() > e.getPosition().getY() && c.getBottomY() < e.getPosition().getY()){
                return true;
            }
        }

        return false;

    }

    public int getPoints() {
        return this.points;
    }

    public void loadLevel(int level_number) throws IOException{

        this.enemies = new ArrayList<>();
        this.coins = new ArrayList<>();
        this.bricks = new ArrayList<>();
        this.end=false;

        this.character.setPosition(new Position(GlobalConfigs.TERMINAL_WIDTH/2,64));
        if(level_number == 1){

            this.map=new Map("./src/main/resources/textFiles/level1.txt");
            this.endFlag=new Flag(1575,this.map.getFloorY(0));

            bricks.add(new Brick(475,95,true));
            bricks.add(new Brick(515,95,true));
            bricks.add(new Brick(555,95,true));

            bricks.add(new Brick(1070,80,false));
            bricks.add(new Brick(1110,80,false));
            bricks.add(new Brick(1150,80,false));
            bricks.add(new Brick(1190,80,false));
            bricks.add(new Brick(1230,80,false));

            coins.add(new Coin(1070,map.getFloorY(1070)));
            coins.add(new Coin(1100,map.getFloorY(1100)));

            enemies.add(new DumbEnemy(420,GlobalConfigs.TERMINAL_HEIGHT,-2));
            enemies.add(new SmartEnemy(660,GlobalConfigs.TERMINAL_HEIGHT));

            enemies.add(new DumbEnemy(1100,map.getFloorY(1100),-2));
            enemies.add(new SmartEnemy(1150,map.getFloorY(1150)));
        }
        if(level_number == 2){

            this.map=new Map("./src/main/resources/textFiles/level2.txt");
            this.endFlag=new Flag(1575,this.map.getFloorY(0));

            bricks.add(new Brick(660,130,false));

            bricks.add(new Brick(700,130,false));

            bricks.add(new Brick(740,130,false));

            bricks.add(new Brick(780,130,false));

            bricks.add(new Brick(820,50,false));

            bricks.add(new Brick(860,50,false));

            bricks.add(new Brick(900,50,false));

            bricks.add(new Brick(980,60,false));

            bricks.add(new Brick(1060,70,false));

            bricks.add(new Brick(1140,80,false));


            coins.add(new Coin(670,130));
            coins.add(new Coin(710,130));
            coins.add(new Coin(750,130));
            coins.add(new Coin(790,130));

            coins.add(new Coin(830,50));
            coins.add(new Coin(870,50));
            coins.add(new Coin(910,50));

            coins.add(new Coin(990,60));
            coins.add(new Coin(1070,70));
            coins.add(new Coin(1150,80));


            enemies.add(new DumbEnemy(350,map.getFloorY(350),-2));
           enemies.add(new SmartEnemy(385,map.getFloorY(385)));
            enemies.add(new DumbEnemy(420,map.getFloorY(420),-2));
           enemies.add(new SmartEnemy(455,map.getFloorY(455)));


             enemies.add(new DumbEnemy(530,map.getFloorY(530),-2));
             enemies.add(new SmartEnemy(565,map.getFloorY(565)));
        }
        if(level_number == 3){

            this.map=new Map("./src/main/resources/textFiles/level3.txt");
            this.endFlag=new Flag(2000,this.map.getFloorY(2000));

            bricks.add(new Brick(1140,30,false));
            bricks.add(new Brick(1180,30,false));
            bricks.add(new Brick(1280,45,false));
            bricks.add(new Brick(1320,45,false));
            bricks.add(new Brick(1400,70,false));
            bricks.add(new Brick(1300,90,false));
            bricks.add(new Brick(1260,110,false));
            bricks.add(new Brick(1220,130,false));
            bricks.add(new Brick(1300,90,false));
            bricks.add(new Brick(1342,140,false));

            enemies.add(new DumbEnemy(345,map.getFloorY(350),2));
            enemies.add(new DumbEnemy(450,map.getFloorY(460),-2));

            enemies.add(new SmartEnemy(640,map.getFloorY(640)));

            enemies.add(new DumbEnemy(705,map.getFloorY(705),2));
            enemies.add(new SmartEnemy(820,map.getFloorY(820)));


            coins.add(new Coin(885,map.getFloorY(885)));
            coins.add(new Coin(925,map.getFloorY(925)));

          //  bricks.add(new Brick(1380,110,false));
        }
        this.updateEnemies();
        this.updateRelativePositions();
        return;
    }

}
