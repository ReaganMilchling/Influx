package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.LinkedList;

public class Handler
{
    //linked list to store game objects
    LinkedList<GameObject> object = new LinkedList<>();

    //handler for all tick methods in the game
    public void tick()
    {
        for (int i = 0 ; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //handler for all rendering of objects
    public void renderObject(GraphicsContext gc)
    {
        for (int i = 0 ; i < object.size(); i++)
        {
            gc.setGlobalAlpha(1.0);
            GameObject tempObject = object.get(i);
            tempObject.renderObject(gc);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }

}
