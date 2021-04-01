package com.game.gameObjects;

import com.game.engine.GameUtils;
import com.game.engine.Handler;
import com.game.ID;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Rectangle;

public class Player extends GameObject
{
    //attributes/fields
    private final Handler handler;
    Image playerImage;
    Image creeper = new Image("res/images/creeper.png");
    Image space = new Image("res/images/space.png");
    Image colors = new Image("res/images/colors.png");
    Image ice = new Image("res/images/ice.png");

    //constructor
    public Player(int x, int y, int size, ID id, Handler handler)
    {
        super(x, y, size, id);
        this.handler = handler;

        velX = medSpeed;
        velY = medSpeed;
        moveDown = false;
        moveUp = false;
        moveLeft = false;
        moveRight = false;
        playerHealth = 500;
        playerImage = creeper;
    }

    //methods
    public void tick()
    {
        if (moveRight) {
            x += velX;
        }
        if (moveLeft) {
            x -= velX;
        }
        if (moveUp) {
            y -= velY;
        }
        if (moveDown) {
            y += velY;
        }

        collisions();

        x = constrain(x, 0, GameUtils.WIDTH - objectSize);
        y = constrain(y, 0, GameUtils.HEIGHT - objectSize);
    }

    public void renderObject(GraphicsContext gc)
    {
        gc.drawImage(playerImage, x, y, objectSize, objectSize);
    }

    public void collisions()
    {
        for (int i = 0; i < handler.getList().size(); i++)
        {
            GameObject temp = (GameObject) handler.getList().get(i);
            if (temp.getID() == ID.Enemy1 || temp.getID() == ID.Enemy2)
            {
                if(getHitBox().intersects(temp.getHitBox())) {
                    playerHealth--;
                }
            }
        }
    }


    public Rectangle getHitBox()
    {
        return new Rectangle(x, y, objectSize, objectSize);
    }

    public Image getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(Image image)
    {
        this.playerImage = image;
    }

}
