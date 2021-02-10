package com.game.objects;

import com.game.ID;
import com.game.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Color;
import java.awt.Rectangle;

public class Player extends GameObject
{
    //attributes/fields
    private final Handler handler;
    private int playerHealth;
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

        x = constrain(x, 0, Main.WIDTH - objectSize);
        y = constrain(y, 0, Main.HEIGHT - objectSize);
    }

    public void renderObject(GraphicsContext gc)
    {
        gc.drawImage(playerImage, x, y, objectSize, objectSize);
    }

    public void collisions()
    {
        for (int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get(i);
            if (temp.getID() == ID.Enemy1 || temp.getID() == ID.Enemy2)
            {
                if(getHitBox().intersects(temp.getHitBox())) {
                    playerHealth--;
                }
            }
        }
    }

    public int getHealth()
    {
        return this.playerHealth;
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
