package com.game.gui;

import com.game.ID;
import com.game.Main;
import com.game.engine.GameUtils;
import com.game.engine.HUD;
import com.game.engine.Handler;
import com.game.engine.KeyInput;
import com.game.gameObjects.EnemyAI;
import com.game.gameObjects.EnemyOne;
import com.game.gameObjects.Player;
import com.game.menu.HighScores;
import com.game.menu.HowTo;
import com.game.menu.Menu;
import com.game.menu.Options;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Table {

    public static STATE gameState = STATE.Menu;
    Image background = new Image("res/images/board.png");

    public enum STATE {
        Game{
            @Override
            public void setState(Scene theScene) {
                handler = new Handler();
                hud = new HUD();
                hud.HUD(handler);
                Main.Score = 0;

                if (gameState == STATE.Game) {
                    handler.addObject(new EnemyOne(GameUtils.WIDTH /2, GameUtils.HEIGHT/2, 32, ID.Enemy1));
                    handler.addObject(new EnemyAI(GameUtils.WIDTH - 32, GameUtils.HEIGHT - 32, 24, ID.Enemy2, handler));
                    handler.addObject(new Player(GameUtils.halfWidth, GameUtils.halfHeight, 32, ID.Player, handler));
                    KeyInput.keyEventHandler(theScene, handler);
                }
            }
        },
        Menu {
            @Override
            public void setState(Scene theScene) {
                KeyInput.keyEventHandlerMenu(theScene);
            }
        },
        Options {
            @Override
            public void setState(Scene theScene) {
                KeyInput.keyEventHandlerOptions(theScene);
            }
        },
        HowTo {
            @Override
            public void setState(Scene theScene) {
                KeyInput.keyEventHandlerHowTo(theScene);
            }
        },
        HighScore {
            @Override
            public void setState(Scene theScene) {
                KeyInput.keyEventHandlerHighScores(theScene);
            }
        };
        public abstract void setState(Scene theScene);
    }

    private static HUD hud;
    private static Handler handler;
    private Menu menu;
    private Options options;
    private HighScores highscores;
    private HowTo howto;

    //gfx
    private Pane root;
    private Scene theScene;
    private Canvas canvas;
    private GraphicsContext gc;

    public Table() {
        this.menu = new Menu();
        this.options = new Options();
        this.highscores = new HighScores();
        this.howto = new HowTo();

        this.root = new Pane();
        this.theScene = new Scene(root);
        this.canvas = new Canvas(GameUtils.WIDTH, GameUtils.HEIGHT);
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    }

    public Scene getScene() {
        return this.theScene;
    }

    public GraphicsContext getGraphicsContext() {
        return this.gc;
    }

    public void tick()
    {
        //handler handles all logic
        if (gameState == STATE.Game) {
            handler.tick();
            hud.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        } else if (gameState == STATE.Options) {
            options.tick();
        } else if (gameState == STATE.HowTo) {
            howto.tick();
        } else if (gameState == STATE.HighScore) {
            highscores.tick();
        }

    }

    public void render(GraphicsContext gc)
    {
        //draws everything
        if (gameState == STATE.Game) {
            gc.drawImage(background, 0 , 0, 1152, 648, 0, 0, GameUtils.WIDTH, GameUtils.HEIGHT);
            hud.renderObject(gc);
            handler.renderObject(gc);

        } else if (gameState == STATE.Menu) {
            menu.render(gc);
        } else if (gameState == STATE.Options) {
            options.render(gc);
        } else if (gameState == STATE.HowTo) {
            howto.render(gc);
        } else if (gameState == STATE.HighScore) {
            highscores.render(gc);
        }

    }

    public static void setGameState(STATE id)
    {
        gameState = id;
    }

}
