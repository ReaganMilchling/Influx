package com.game.objects;

import com.game.ID;
import com.game.Main;
import com.game.objects.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class HUD {

    public static double hudOpacity;
    private Handler handler;
    Rectangle healthBar = new Rectangle();
    Rectangle bar = new Rectangle();
    int barX = Main.WIDTH/4;
    int barY = Main.HEIGHT - 100;
    int height = Main.HEIGHT/12;


    public void HUD(Handler handler)
    {
        this.handler = handler;
        hudOpacity = 1.0;
        healthBar = new Rectangle(Main.WIDTH / 2, Main.HEIGHT - 100, Main.Frames, Main.HEIGHT/12);
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
                if(temp.getHitBox().intersects(new java.awt.Rectangle(0, (int)(Main.HEIGHT - 1.5 * height), Main.WIDTH * 3 / 4, Main.HEIGHT))){
                    hudOpacity = 0.4;
                } else {
                    hudOpacity = 1.0;
                }
            }
        }
    }

    public void renderObject(GraphicsContext gc)
    {
        gc.setGlobalAlpha(hudOpacity);
        gc.setFill(Color.WHITE);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setFont(Font.font("Verdana", 25));
        gc.fillText("Frames:" + Integer.toString(Main.Frames), height, (int)(Main.HEIGHT - 75));
        gc.fillText("Score:" + Integer.toString(Main.Score), height, (int)(Main.HEIGHT - 50));
        gc.fillRect(barX, barY, 500, height);
        gc.setFill(Color.GREEN);
        gc.fillRect(barX, barY, 400, height);


    }


}
