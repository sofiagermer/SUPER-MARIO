package superMario.controller.command.movementCommand;

import superMario.model.game.Level;

public class Jump extends MovementCommand {
    @Override
    public void execute(Level level) {

        level.getCharacter().jump();

        Thread updater = new Thread(() -> {
            for(int i=0;i<35;i++){
                if(level.brickCollision()) break;
                level.getCharacter().setPosition(level.getCharacter().getPosition().getUp());
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            level.getCharacter().jumpEnd();
        });
        updater.start();
    }
}