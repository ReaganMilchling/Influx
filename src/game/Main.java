package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application
{

    //Variables
    protected static int HEIGHT = 645;
    protected static int WIDTH = (int)(HEIGHT * 1.7778f);
    protected static int Frames, Score;
    //private boolean running = false;
    public static STATE gameState = STATE.Menu;
    Image background = new Image("res/images/board.png");


    public enum STATE {
        Game,
        Menu,
        Options,
        HowTo,
        HighScore
    }

    private static HUD hud;
    private static Handler handler;
    private Menu menu;


    public static void setGame(Scene theScene) {
        handler = new Handler();
        hud = new HUD();
        hud.HUD(handler);
        Score = 0;

        if (gameState == STATE.Game) {
            //handler.addObject(new EnemyOne(WIDTH/2, HEIGHT/2, 24, ID.Enemy1));
            //handler.addObject(new EnemyAI(WIDTH - 32, HEIGHT - 32, 24, ID.Enemy2, handler));
            handler.addObject(new Player(0, 0, 32, ID.Player, handler));
            KeyInput.keyEventHandler(theScene, handler);
        }
    }

    public static void setMenu(Scene theScene)
    {
        if (gameState == STATE.Menu) {
            KeyInput.keyEventHandlerMenu(theScene);
        }
    }

    @Override
    public void start(Stage gameStage) throws Exception
    {

        menu = new Menu();

        Pane root = new Pane();
        Scene theScene = new Scene(root);
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gameStage.setTitle("Influx");
        gameStage.setScene(theScene);
        setMenu(theScene);

        /**
         * Main game loop
         */
        new AnimationTimer()
        {
            long lastTime = System.nanoTime();
            final double amountOfTicks = 60.0;
            final double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;

            @Override
            public void handle(long now)
            {

                //long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;

                while (delta >= 1)
                {
                    tick();
                    delta--;
                }

                render(gc);
                frames++;

                if (System.currentTimeMillis() - timer > 1000)
                {
                    timer += 1000;
                    Frames = frames;
                    frames = 0;
                }
            }
        }.start();

        gameStage.show();

    }

    private void tick()
    {
        //handler handles all logic
        if (gameState == STATE.Game) {
            handler.tick();
            hud.tick();
        } else if (gameState == STATE.Menu) {
            menu.tick();
        }

    }

    public void render(GraphicsContext gc)
    {
        if (gameState == STATE.Game) {
            gc.drawImage(background, 0 , 0, 1152, 648, 0, 0, WIDTH, HEIGHT);
            hud.renderObject(gc);
            handler.renderObject(gc);

        } else if (gameState == STATE.Menu) {
            menu.render(gc);
        }

    }

    public static void setGameState(STATE id)
    {
        gameState = id;
    }

    public static void main(String[] args) {
        launch(args);
    }

    //    public void run()
//    {
//        long lastTime = System.nanoTime();
//        double amountOfTicks = 60.0;
//        double ns = 1000000000 / amountOfTicks;
//        double delta = 0;
//        long timer = System.currentTimeMillis();
//        int frames = 0;
//
//        while (running)
//        {
//            long now = System.nanoTime();
//            delta += (now - lastTime) / ns;
//            lastTime = now;
//
//            while (delta >= 1)
//            {
//                tick();
//                delta--;
//            }
//
//            if (running)
//            {
//                render();
//            }
//
//            frames++;
//
//            if (System.currentTimeMillis() - timer > 1000)
//            {
//                timer += 1000;
//                Frames = frames;
//                frames = 0;
//            }
//        }
//        stop();
//    }
}
