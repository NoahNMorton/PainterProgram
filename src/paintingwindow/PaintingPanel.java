package paintingwindow;

import paintinglogic.Logger;
import paintinglogic.PaintBrush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:04 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingPanel extends JPanel implements MouseListener {
    PaintBrush brush = new PaintBrush();

    public PaintingPanel() {
        setSize(900, 900); //set size to 900x900 pixels


        //load all images, such as brush size chooser, and other icons
        try {
//            catMoving = ImageIO.read(new File("resource/Cat_Moving.png"));
//            catTrapped = ImageIO.read(new File("resource/Cat_Trapped.png"));
//            cheese = ImageIO.read(new File("resource/Cheese.png"));
//            dirt = ImageIO.read(new File("resource/Dirt.png"));
//            holeMouse = ImageIO.read(new File("resource/Hole With Mouse.png"));
//            hole = ImageIO.read(new File("resource/Hole.png"));
//            movingMouse = ImageIO.read(new File("resource/Mouse_Moving.png"));
//            moveWall = ImageIO.read(new File("resource/Movable_Wall.png"));
//            trap = ImageIO.read(new File("resource/Trap.png"));
//            wall = ImageIO.read(new File("resource/Wall.png"));
//            yarn = ImageIO.read(new File("resource/Yarn.png"));
            Logger.logOtherMessage("ImageLoader", "Succeeded.");

        } catch (Exception e) {
            System.err.println("Error Reading images. Program will exit.");
            Logger.logErrorMessage("Error reading in images.");
            System.exit(-2);
        }
        addMouseListener(this);
    }


    public void paint(Graphics g) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        brush.setDown(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        brush.setDown(false);
    }

    @Deprecated
    public void mouseEntered(MouseEvent e) {

    }

    @Deprecated
    public void mouseExited(MouseEvent e) {

    }
}
