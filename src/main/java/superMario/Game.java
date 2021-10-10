package superMario;

import superMario.model.game.Level;
import superMario.model.game.Mario;
import superMario.model.menu.StartMenu;
import superMario.state.State;
import superMario.state.StateMenu;
import superMario.gui.GUI;
import superMario.gui.LanternaGUI;
import superMario.viewer.game.MusicPlayer;

import java.io.IOException;

public class Game {
    private final GUI gui;
    private State state;
    private boolean exit;
    private Level level;
    public Game() throws IOException{

        gui = new LanternaGUI();
        this.state = new StateMenu(new StartMenu(this));
        this.exit = false;
        Mario mario= new Mario();
        this.level = new Level(mario);
    }

    public static void main(String[] args) throws IOException {
        Game game=new Game();
        game.start();
    }

    public void changeState(State state){
        this.state = state;
    }
    public State getState(){ return state;}

    public void exit(){
        exit = true;
    }

    private void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (!exit) {

            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }

        }

        gui.close();
    }

    public Level getLevel(){
        return this.level;
    }

}

