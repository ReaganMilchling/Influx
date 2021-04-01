package com.game.engine;

import com.game.ID;
import com.game.Main;
import com.game.gameObjects.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class HUD {

    public static double hudOpacity;
    private Handler handler;
    final int barX = GameUtils.WIDTH/4;
    final int barY = GameUtils.HEIGHT - 75;
    final int height = GameUtils.HEIGHT/15;
    int playerHealth = 500;

    public void HUD(Handler handler)
    {
        this.handler = handler;
        hudOpacity = 1.0;
    }

    public void tick()
    {
        Main.Score++;
        //checks if the player on top hud, and sets to opaque if true
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get(i);
            if (temp.getID() == ID.Player)
            {
                playerHealth = temp.getPlayerHealth();
                if(temp.getHitBox().intersects(new java.awt.Rectangle(0, (int)(GameUtils.HEIGHT - 1.5 * height), GameUtils.WIDTH * 3 / 4, GameUtils.HEIGHT))){
                    hudOpacity = 0.33;
                } else {
                    hudOpacity = 1.0;
                }
            }
        }
    }

    public void renderObject(GraphicsContext gc)
    {
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get(i);
            if (temp.getID() == ID.Player)
            {

            }
        }
        gc.setGlobalAlpha(hudOpacity);
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setFont(Font.font("Verdana", 25));
        gc.fillText("Frames:" + Integer.toString(Main.Frames), height, (GameUtils.HEIGHT - 55));
        gc.fillText("Score:" + Integer.toString(Main.Score), height, (GameUtils.HEIGHT - 30));
        gc.fillRect(barX, barY, 500, height);
        gc.setFill(Color.GREEN);
        gc.fillRect(barX, barY, playerHealth, height);


    }


}
