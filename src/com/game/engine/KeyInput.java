package com.game.engine;

import com.game.ID;
import com.game.Main;
import com.game.gameObjects.GameObject;
import com.game.gui.Table;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static com.game.gui.Table.setGameState;

public class KeyInput {
    //Variables

    public KeyInput()
    {
        //nothing to construct
    }

    public static void keyEventHandlerMenu(Scene scene)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE)
                {
                    setGameState(Table.STATE.Game);
                    Table.STATE.Game.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.O)
                {
                    setGameState(Table.STATE.Options);
                    Table.STATE.Options.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.L)
                {
                    setGameState(Table.STATE.HowTo);
                    Table.STATE.HowTo.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.H)
                {
                    setGameState(Table.STATE.HighScore);
                    Table.STATE.HighScore.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });
    }

    public static void keyEventHandlerOptions(Scene scene)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.TAB){
                    setGameState(Table.STATE.Menu);
                    Table.STATE.Menu.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });
    }

    public static void keyEventHandlerHowTo(Scene scene)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.TAB){
                    setGameState(Table.STATE.Menu);
                    Table.STATE.Menu.setState(scene);
                }
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    System.exit(1);
                }
            }
        });
    }

    public static void keyEventHandlerHighScores(Scene scene)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.TAB){
                    setGameState(Table.STATE.Menu);
                    Table.STATE.Menu.setState(scene);
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
                        switch (keyEvent.getCode()) {
                            case W -> {
                                temp.setMoveUp(true);
                                temp.setMoveDown(false);
                            }
                            case A -> {
                                temp.setMoveLeft(true);
                                temp.setMoveRight(false);
                            }
                            case S -> {
                                temp.setMoveDown(true);
                                temp.setMoveUp(false);
                            }
                            case D -> {
                                temp.setMoveRight(true);
                                temp.setMoveLeft(false);
                            }
                            case CONTROL -> {
                                temp.setVelX(temp.getLowSpeed());
                                temp.setVelY(temp.getLowSpeed());
                            }
                            case SHIFT -> {
                                temp.setVelX(temp.getHighSpeed());
                                temp.setVelY(temp.getHighSpeed());
                            }
                        }
                    }
                }
                if (keyEvent.getCode() == KeyCode.TAB){
                    setGameState(Table.STATE.Menu);
                    Table.STATE.Menu.setState(scene);
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
                        switch (keyEvent.getCode()) {
                            case W -> temp.setMoveUp(false);
                            case A -> temp.setMoveLeft(false);
                            case S -> temp.setMoveDown(false);
                            case D -> temp.setMoveRight(false);
                            case CONTROL -> {
                                temp.setVelX(temp.getMedSpeed());
                                temp.setVelY(temp.getMedSpeed());
                            }
                            case SHIFT -> {
                                temp.setVelY(temp.getMedSpeed());
                                temp.setVelX(temp.getMedSpeed());
                            }
                        }
                    }
                }
            }
        });
    }
}
