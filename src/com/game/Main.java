package com.game;

import com.game.engine.*;
import com.game.gui.Table;
import com.game.menu.*;
import com.game.gameObjects.*;
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
    public static int Frames, Score;

    @Override
    public void start(Stage gameStage) throws Exception
    {
        Table table = new Table();

        gameStage.setTitle("Influx");
        gameStage.setScene(table.getScene());
        Table.STATE.Menu.setState(table.getScene());

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
                    table.tick();
                    delta--;
                }
                table.render(table.getGraphicsContext());
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

    public static void main(String[] args) {
        launch(args);
    }

}
