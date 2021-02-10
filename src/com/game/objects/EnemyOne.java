package com.game.objects;

import com.game.ID;
import com.game.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.Rectangle;

public class EnemyOne extends GameObject
{
    //attributes/fields/variables

    //constructor
    public EnemyOne(int x, int y, int size, ID id)
    {
        super(x, y, size, id);
        velX = highSpeed;
        velY = highSpeed;

    }

    //methods
    public void tick()
    {
        x += velX;
        y += velY;

        if (x <= 0 || x >= Main.WIDTH - objectSize) { velX *= -1; }
        if (y <= 0 || y >= Main.HEIGHT - objectSize) { velY *= -1; }
    }

    public void renderObject(GraphicsContext gc)
    {
        gc.setFill(Color.RED);
        gc.fillRect(x, y, objectSize, objectSize);

    }

    public Rectangle getHitBox() {
        return new Rectangle(x, y, objectSize, objectSize);
    }

}
