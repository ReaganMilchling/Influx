package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Menu {
    GraphicsContext gc;
    Image background = new Image("res/images/mainmenu.jpg");
    int displace = 70;

    public void Menu(GraphicsContext gc)
    {
        this.gc = gc;
    }

    public void tick()
    {

    }

    public void render(GraphicsContext gc)
    {

        gc.drawImage(background, 0 , 0, 1920, 1080, 0, 0, Main.WIDTH, Main.HEIGHT);
        renderButton(gc, Main.thirdWidth, Main.HEIGHT /5,  Main.STATE.Menu, "Play Game");
        renderButton(gc, Main.thirdWidth, Main.HEIGHT * 2/5,  Main.STATE.HowTo, "How To Play");
        renderButton(gc, Main.thirdWidth, Main.HEIGHT * 3/5,  Main.STATE.Options, "Options");
        renderButton(gc, Main.thirdWidth, Main.HEIGHT * 4/5,  Main.STATE.HighScore, "High Scores");

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 15));
        gc.fillText("Press Space to Start", Main.halfWidth, Main.HEIGHT * 1/5 + displace);
        gc.fillText("Press L to Learn", Main.halfWidth, Main.HEIGHT * 2/5 + displace);
        gc.fillText("Press O for Options", Main.halfWidth, Main.HEIGHT * 3/5 + displace);
        gc.fillText("Press H for High Scores", Main.halfWidth, Main.HEIGHT * 4/5 + displace);
    }

    public void renderButton(GraphicsContext gc, int x, int y,  Main.STATE state, String name)
    {
        gc.setFill(Color.rgb(69,69,69, 0.75));
        gc.fillRect(x, y, Main.thirdWidth, Main.HEIGHT / 8);

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 45));
        gc.fillText(name, Main.halfWidth, y + 49);
    }
}
