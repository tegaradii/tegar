package Main;

import inputs.Keyboardinputs;
import inputs.Mouseinputs;

import javax.swing.*;
import java.awt.*;

import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;

public class GamePanel  extends JPanel {


    private Mouseinputs mouseinputs;
    private Game game;
    public GamePanel(Game game){

        mouseinputs = new Mouseinputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseinputs);
        addMouseMotionListener(mouseinputs);
    }


    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setMinimumSize(size);
        System.out.println("Size: " + GAME_WIDTH + " " + GAME_HEIGHT);

    }



    public void updateGame(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }



}
