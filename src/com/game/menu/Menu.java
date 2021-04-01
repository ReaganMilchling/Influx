package com.game.menu;

import com.game.Main;
import com.game.engine.GameUtils;
import com.game.gui.Table;
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

        gc.drawImage(background, 0 , 0, 1920, 1080, 0, 0, GameUtils.WIDTH, GameUtils.HEIGHT);
        renderButton(gc, GameUtils.thirdWidth, GameUtils.HEIGHT /5,  Table.STATE.Menu, "Play Game");
        renderButton(gc, GameUtils.thirdWidth, GameUtils.HEIGHT * 2/5,  Table.STATE.HowTo, "How To Play");
        renderButton(gc, GameUtils.thirdWidth, GameUtils.HEIGHT * 3/5,  Table.STATE.Options, "Options");
        renderButton(gc, GameUtils.thirdWidth, GameUtils.HEIGHT * 4/5,  Table.STATE.HighScore, "High Scores");

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 15));
        gc.fillText("Press Space to Start", GameUtils.halfWidth, GameUtils.HEIGHT * 1/5 + displace);
        gc.fillText("Press L to Learn", GameUtils.halfWidth, GameUtils.HEIGHT * 2/5 + displace);
        gc.fillText("Press O for Options", GameUtils.halfWidth, GameUtils.HEIGHT * 3/5 + displace);
        gc.fillText("Press H for High Scores", GameUtils.halfWidth, GameUtils.HEIGHT * 4/5 + displace);
    }

    public void renderButton(GraphicsContext gc, int x, int y, Table.STATE state, String name)
    {
        gc.setFill(Color.rgb(69,69,69, 0.75));
        gc.fillRect(x, y, GameUtils.thirdWidth, GameUtils.HEIGHT / 8);

        gc.setFill(Color.BLACK);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", 45));
        gc.fillText(name, GameUtils.halfWidth, y + 49);
    }
}
