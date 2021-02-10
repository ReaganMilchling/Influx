package com.game.objects;


import com.game.ID;
import com.game.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.Rectangle;

public class EnemyAI extends GameObject
{
    private Handler handler;

    public EnemyAI(int x, int y, int size, ID id, Handler handler)
    {
        super(x, y, size, id);
        this.handler = handler;
        velX = 3;
        velY = 3;
    }

    public void tick()
    {
        //Changes direction of this object to move toward player
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get(i);
            if (temp.getID() == ID.Player)
            {
                if (Math.abs(x - temp.getX()) == 0) {
                    x -= ((x - temp.getX()) * velX);
                } else {
                    x -= (((x - temp.getX()) / (Math.abs(x - temp.getX()))) * velX);
                }
                if (Math.abs(y - temp.getY()) == 0) {
                    y -= ((y - temp.getY()) * velY);
                } else {
                    y -= (((y - temp.getY()) / (Math.abs(y - temp.getY()))) * velY);
                }
            }
        }
        x = constrain(x, 0, Main.WIDTH - objectSize);
        y = constrain(y, 0, Main.HEIGHT - objectSize);
    }

    public void renderObject(GraphicsContext gc)
    {
        gc.setFill(Color.DARKRED);
        gc.fillRect(x, y, objectSize, objectSize);
    }

    public Rectangle getHitBox() {
        return new Rectangle(x, y, objectSize, objectSize);
    }
}
