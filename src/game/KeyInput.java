package game;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyInput {

//    private Handler handler;
//    private Scene scene;

    public KeyInput()
    {
//        this.handler = handler;
//        this.scene = scene;
    }

    public static void keyEventHandlerMenu(Scene scene)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE)
                {
                    Main.setGameState(Main.STATE.Game);
                    Main.setGame(scene);
                }
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });
    }

    public static void keyEventHandler(Scene scene, Handler handler)
    {
        scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>()
        {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent)
            {
                for (int i = 0; i < handler.object.size(); i++)
                {
                    GameObject temp = handler.object.get(i);
                    if (temp.getID() == ID.Player)
                    {
                        switch (keyEvent.getCode()){
                            case W: temp.setMoveUp(true); temp.setMoveDown(false); break;
                            case A: temp.setMoveLeft(true); temp.setMoveRight(false); break;
                            case S: temp.moveDown = true; temp.moveUp = false; break;
                            case D: temp.moveRight = true; temp.moveLeft = false; break;
                            case CONTROL: temp.setVelX(temp.getLowSpeed()); temp.setVelY(temp.getLowSpeed()); break;
                            case SHIFT: temp.setVelX(temp.getHighSpeed()); temp.setVelY(temp.getHighSpeed()); break;
                        }
                    }
                }
                if (keyEvent.getCode() == KeyCode.TAB){
                    Main.setGameState(Main.STATE.Menu);
                    Main.setMenu(scene);
                }
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>()
        {
            @Override
            public void handle(javafx.scene.input.KeyEvent keyEvent)
            {
                for (int i = 0; i < handler.object.size(); i++)
                {
                    GameObject temp = handler.object.get(i);
                    if (temp.getID() == ID.Player)
                    {
                        switch (keyEvent.getCode()){
                            case W: temp.moveUp = false; break;
                            case A: temp.moveLeft = false; break;
                            case S: temp.moveDown = false; break;
                            case D: temp.moveRight = false; break;
                            case CONTROL: temp.setVelX(temp.getMedSpeed()); temp.setVelY(temp.getMedSpeed()); break;
                            case SHIFT: temp.setVelY(temp.getMedSpeed()); temp.setVelX(temp.getMedSpeed()); break;
                        }
                    }
                }
            }
        });
    }
}
