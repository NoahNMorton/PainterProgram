package paintingwindow;

import paintinglogic.Logger;
import paintinglogic.PaintBrush;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:04 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingPanel extends JPanel implements MouseMotionListener, MouseListener {
    PaintBrush brush = new PaintBrush();
    Image circle, paintbucket, square, xMark, small, medium, big, huge;
    int dynamicMouseX = 0, dynamicMouseY = 0;

    public PaintingPanel() {

        Logger.logCodeMessage("Setting size of window to 900x1000");
        setSize(900, 1000); //set size to 900x1000 pixels


        //load all images, such as brush size chooser, and other icons
        try {
            circle = ImageIO.read(new File("resource/circle.png"));
            paintbucket = ImageIO.read(new File("resource/paintbucket.png"));
            square = ImageIO.read(new File("resource/square.png"));
            xMark = ImageIO.read(new File("resource/x.png"));
            small = ImageIO.read(new File("resource/small.png"));
            medium = ImageIO.read(new File("resource/medium.png"));
            big = ImageIO.read(new File("resource/big.png"));
            huge = ImageIO.read(new File("resource/hug.png"));

            Logger.logOtherMessage("ImageLoader", "Succeeded.");
        } catch (Exception e) {
            System.err.println("Error Reading images. Program will exit.");
            Logger.logErrorMessage("Error reading in images.");
            System.exit(-2);
        }
        addMouseMotionListener(this);
        addMouseListener(this);
        addNotify();
    }


    public void paint(Graphics g) {
        //System.out.println(dynamicMouseX);

        //paint gui ----------------------
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), 150);

        g.setColor(Color.BLACK);
        g.drawString("Painter Program", 10, 20);

        //draw all brush choices to the screen
        g.drawString("Brushes:", 150, 20);
        g.drawImage(paintbucket, 150, 30, null);
        g.drawImage(xMark, 10, 60, null);
        g.drawImage(circle, 215, 30, null);
        g.drawImage(square, 279, 30, null);

        //draw size choices

        g.drawImage(small, 150, 85, null);
        g.drawImage(medium, 200, 85, null);
        g.drawImage(big, 250, 85, null);
        g.drawImage(huge, 320, 85, null);
        g.drawString("Sizes:", 150, 100);

        //drawing ----------------------
        g.setColor(Color.BLACK); //todo temp placeholder, add colours
        if (brush.isDown() && dynamicMouseY > 150) //if mouse is down in the painting area
        {
            if (brush.getShape() == PaintBrush.CIRCLE) {
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        g.fillOval(dynamicMouseX, dynamicMouseY, 10, 10);
                        repaint();
                        break;
                    case PaintBrush.MEDIUM:
                        g.fillOval(dynamicMouseX, dynamicMouseY, 50, 50);
                        repaint();
                        break;
                    case PaintBrush.BIG:
                        g.fillOval(dynamicMouseX, dynamicMouseY, 90, 90);
                        repaint();
                        break;
                    case PaintBrush.HUGE:
                        g.fillOval(dynamicMouseX, dynamicMouseY, 130, 130);
                        repaint();
                        break;
                }
                repaint();
            } else if (brush.getShape() == PaintBrush.SQUARE) {
                switch (brush.getSize()) {
                    case PaintBrush.SMALL:
                        g.fillRect(dynamicMouseX, dynamicMouseY, 10, 10);
                        repaint();
                        break;
                    case PaintBrush.MEDIUM:
                        g.fillRect(dynamicMouseX, dynamicMouseY, 50, 50);
                        repaint();
                        break;
                    case PaintBrush.BIG:
                        g.fillRect(dynamicMouseX, dynamicMouseY, 90, 90);
                        repaint();
                        break;
                    case PaintBrush.HUGE:
                        g.fillRect(dynamicMouseX, dynamicMouseY, 130, 130);
                        repaint();
                        break;
                }
                repaint();
            } else if (brush.getShape() == PaintBrush.FILL) {
                //todo fill recursive method >help
                repaint();
            }
        }

    }


    @Deprecated
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        brush.setDown(true);
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();
        //System.out.println("User pressed mouse at "+e.getX()+","+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        brush.setDown(false);
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();
    }

    @Deprecated
    public void mouseEntered(MouseEvent e) {

    }

    @Deprecated
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dynamicMouseX = e.getX(); //rapidly updates the location of the mouse.
        dynamicMouseY = e.getY();
        //System.out.println("Mouse Loc:"+e.getX()+","+e.getY());
    }

    @Deprecated
    public void mouseMoved(MouseEvent e) {

    }

    /**
     * Method to fill an area with colour.
     *
     * @param g     the graphics from paint
     * @param color the colour to fill with
     */
    private void fillWithColour(Graphics g, Color color) {
        //todo recursive colour filling method
    }
}
