package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static javafx.geometry.Pos.CENTER;

public class Menu {
    GraphicsContext gc;
    Image background = new Image("res/images/mainmenu.jpg");
    public Font fnt;
    int displace = 70;


    public void menu(GraphicsContext gc)
    {
        this.gc = gc;
    }

    public void tick()
    {

    }

    public void render(GraphicsContext gc)
    {

        gc.drawImage(background, 0 , 0, 1920, 1080, 0, 0, Main.WIDTH, Main.HEIGHT);
        renderButton(gc, Main.WIDTH/3, Main.HEIGHT /5,  Main.STATE.Menu, "Play Game");
        renderButton(gc, Main.WIDTH/3, Main.HEIGHT * 2/5,  Main.STATE.HowTo, "How To Play");
        renderButton(gc, Main.WIDTH/3, Main.HEIGHT * 3/5,  Main.STATE.Options, "Options");
        renderButton(gc, Main.WIDTH/3, Main.HEIGHT * 4/5,  Main.STATE.HighScore, "High Scores");

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 15));
        gc.fillText("Press Space to Start", Main.WIDTH / 2, Main.HEIGHT * 1/5 + displace);
        gc.fillText("Press L to Learn", Main.WIDTH / 2, Main.HEIGHT * 2/5 + displace);
        gc.fillText("Press O for Options", Main.WIDTH / 2, Main.HEIGHT * 3/5 + displace);
        gc.fillText("Press H for High Scores", Main.WIDTH / 2, Main.HEIGHT * 4/5 + displace);
    }

    public void renderButton(GraphicsContext gc, int x, int y,  Main.STATE state, String name)
    {
        gc.setFill(Color.rgb(69,69,69, 0.75));
        gc.fillRect(x, y, Main.WIDTH / 3, Main.HEIGHT / 8);

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 45));
        gc.fillText(name, Main.WIDTH / 2, y + 49);
    }
}
