package inputs;

import Main.GamePanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouseinputs implements MouseListener, MouseMotionListener{

    private GamePanel gamePanel;
    public Mouseinputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            gamePanel.getGame().getPlayer().setAttacking(true);

        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

    }
}
