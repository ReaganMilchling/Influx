package game;

import javafx.scene.canvas.GraphicsContext;
import java.awt.Rectangle;

public abstract class GameObject
{
    //initializing attributes/variables/fields
    protected int x, y;
    protected int velX, velY;
    protected int objectSize;
    protected int highSpeed, medSpeed, lowSpeed;
    protected boolean moveRight, moveLeft, moveUp, moveDown;
    protected ID id;

    //constructor
    public GameObject(int x, int y, int size, ID id)
    {
        this.x = x;
        this.y = y;
        this.objectSize = size;
        this.id = id;

        highSpeed = 9;
        medSpeed = 6;
        lowSpeed = 3;
    }

    //abstract methods
    public abstract void tick();
    public abstract void renderObject(GraphicsContext gc);
    public abstract Rectangle getHitBox();

    //methods
    public static int constrain(int var, int min, int max)
    {
        if (var >= max) {
            return var = max;
        }
        else if (var <= min) {
            return var = min;
        }
        else {
            return var;
        }
    }

    //getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    public int getMedSpeed() {
        return medSpeed;
    }
    public int getLowSpeed() {
        return lowSpeed;
    }
    public int getHighSpeed() {
        return highSpeed;
    }
    public ID getID() {
        return id;
    }

    //setters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }

    public void setMoveRight(boolean r) {
        this.moveRight = r;
    }
    public void setMoveLeft(boolean l) {
        this.moveLeft = l;
    }
    public void setMoveUp(boolean u) {
        this.moveUp = u;
    }
    public void setMoveDown(boolean d) {
        this.moveDown = d;
    }
}
