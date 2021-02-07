package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Options {
    GraphicsContext gc;
    Image background = new Image("res/images/mainmenu.jpg");

    public void Options()
    {
        this.gc = gc;
    }

    public void tick()
    {

    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage(background, 0 , 0, 1920, 1080, 0, 0, Main.WIDTH, Main.HEIGHT);

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 45));
        gc.fillText("Options", Main.halfWidth, Main.fourthHeight);
    }

}
