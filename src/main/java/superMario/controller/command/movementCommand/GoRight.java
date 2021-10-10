package superMario.controller.command.movementCommand;

import superMario.model.game.Level;

public class GoRight extends MovementCommand {
    @Override
    public void execute(Level level) {
        Thread updater = new Thread(() -> {
            for(int i=0;i<10;i++) {

                if(!level.isMoveLegal(level.getCharacter().getPosition().getRight(), level.getCharacter())){
                    break;
                }

                level.getCharacter().setPosition(level.getCharacter().getPosition().getRight());
                try {
                   Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updater.start();

    }

}