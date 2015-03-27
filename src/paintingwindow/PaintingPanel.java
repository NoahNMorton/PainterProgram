package paintingwindow;

import paintinglogic.Logger;
import paintinglogic.PaintBrush;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:04 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingPanel extends JPanel implements MouseMotionListener, MouseListener {
    PaintBrush brush = new PaintBrush();
    Image circle, paintbucket, square, xMark, small, medium, big, huge;
    BufferedImage canvas;
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
            canvas = new BufferedImage(900, 850, BufferedImage.TYPE_INT_ARGB);
            /*canvas.getGraphics().setColor(Color.WHITE);
            canvas.getGraphics().fillRect(0, 0, 900, 850);
            canvas.getGraphics().setColor(Color.RED);
            canvas.getGraphics().fillOval(200, 200, 200, 200);*/
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
        g.drawString("Clear all:", 10, 50);
        g.drawImage(xMark, 10, 60, null);
        g.drawImage(circle, 215, 30, null);
        g.drawImage(square, 279, 30, null);

        //draw size choices
        g.drawImage(small, 150, 85, null);
        g.drawImage(medium, 200, 85, null);
        g.drawImage(big, 250, 85, null);
        g.drawImage(huge, 320, 85, null);
        g.drawString("Sizes:", 150, 100);

        //draw colour choices
        g.drawString("Colours:", 500, 30);
        g.setColor(Color.RED);
        g.fillRect(500, 40, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(515, 40, 10, 10);
        g.setColor(Color.orange);
        g.fillRect(530, 40, 10, 10);
        g.setColor(Color.yellow);
        g.fillRect(545, 40, 10, 10);
        g.setColor(Color.green);
        g.fillRect(560, 40, 10, 10);
        g.setColor(Color.black);
        g.fillRect(575, 40, 10, 10);
        g.setColor(Color.CYAN);
        g.fillRect(590, 40, 10, 10);
        g.setColor(Color.PINK);
        g.fillRect(605, 40, 10, 10);
        g.setColor(Color.MAGENTA);
        g.fillRect(620, 40, 10, 10);

        g.drawImage(canvas, 0, 150, null);

    }



    @Deprecated
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        brush.setDown(true);
        dynamicMouseX = e.getX();
        dynamicMouseY = e.getY();

        //Shapes---------------------------
        if ((dynamicMouseX >= 150 && dynamicMouseX <= 150 + 64) && (dynamicMouseY >= 30 && dynamicMouseY <= 30 + 64)) {
            brush.setShape(PaintBrush.FILL);
            Logger.logUserMessage("Set brush shape to FILL.");
        } else if ((dynamicMouseX >= 215 && dynamicMouseX <= 215 + 64) && (dynamicMouseY >= 30 && dynamicMouseY <= 30 + 64)) {
            brush.setShape(PaintBrush.CIRCLE);
            Logger.logUserMessage("Set brush shape to CIRCLE.");
        } else if ((dynamicMouseX >= 279 && dynamicMouseX <= 279 + 64) && (dynamicMouseY >= 30 && dynamicMouseY <= 30 + 64)) {
            brush.setShape(PaintBrush.SQUARE);
            Logger.logUserMessage("Set brush shape to SQUARE.");
        }
        //Sizes-----------------------
        if ((dynamicMouseX >= 150 && dynamicMouseX <= 150 + 64) && (dynamicMouseY >= 85 && dynamicMouseY <= 85 + 64)) {
            brush.setSize(PaintBrush.SMALL);
            Logger.logUserMessage("Set brush SIZE to SMALL.");
        } else if ((dynamicMouseX >= 200 && dynamicMouseX <= 200 + 64) && (dynamicMouseY >= 85 && dynamicMouseY <= 85 + 64)) {
            brush.setSize(PaintBrush.MEDIUM);
            Logger.logUserMessage("Set brush size to MEDIUM.");
        } else if ((dynamicMouseX >= 250 && dynamicMouseX <= 250 + 64) && (dynamicMouseY >= 85 && dynamicMouseY <= 85 + 64)) {
            brush.setSize(PaintBrush.BIG);
            Logger.logUserMessage("Set brush size to BIG.");
        } else if ((dynamicMouseX >= 320 && dynamicMouseX <= 320 + 64) && (dynamicMouseY >= 85 && dynamicMouseY <= 85 + 64)) {
            brush.setSize(PaintBrush.HUGE);
            Logger.logUserMessage("Set brush size to HUGE");
        }
        //Colours ---------------------------
        setCurrentPaint(brush);
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
        Logger.logOtherMessage("Window", "Requesting focus on the window.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        canvas.getGraphics().setColor(Color.BLACK);
        canvas.getGraphics().fillOval(200, 200, 200, 200);
        /*if (brush.getShape() == PaintBrush.CIRCLE) {
            switch (brush.getSize()) {
                case PaintBrush.SMALL:
                    canvas.getGraphics().fillOval(e.getX(), e.getY(), 10, 10);
                    break;
                case PaintBrush.MEDIUM:
                    canvas.getGraphics().fillOval(e.getX(), e.getY(), 50, 50);
                    break;
                case PaintBrush.BIG:
                    canvas.getGraphics().fillOval(e.getX(), e.getY(), 90, 90);
                    break;
                case PaintBrush.HUGE:
                    canvas.getGraphics().fillOval(e.getX(), e.getY(), 130, 130);
                    break;
            }
        } else if (brush.getShape() == PaintBrush.SQUARE) {
            switch (brush.getSize()) {
                case PaintBrush.SMALL:
                    canvas.getGraphics().fillRect(e.getX(), e.getY(), 10, 10);
                    break;
                case PaintBrush.MEDIUM:
                    canvas.getGraphics().fillRect(e.getX(), e.getY(), 50, 50);
                    break;
                case PaintBrush.BIG:
                    canvas.getGraphics().fillRect(e.getX(), e.getY(), 90, 90);
                    break;
                case PaintBrush.HUGE:
                    canvas.getGraphics().fillRect(e.getX(), e.getY(), 130, 130);
                    break;
            }
        }*/
        repaint();
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
    private void fillWithColour(Graphics g, Color color, int startX, int startY) {
        //todo recursive colour filling method
    }

    /**
     * Method to set the current painting colour
     *
     * @param brush the brush from the panel
     */
    private void setCurrentPaint(PaintBrush brush) {
        if ((dynamicMouseX >= 500 && dynamicMouseX <= 510) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.RED);
            Logger.logUserMessage("Set the colour of the brush to RED.");
        } else if ((dynamicMouseX >= 515 && dynamicMouseX <= 525) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.BLUE);
            Logger.logUserMessage("Set the colour of the brush to BLUE.");
        } else if ((dynamicMouseX >= 530 && dynamicMouseX <= 540) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.orange);
            Logger.logUserMessage("Set the colour of the brush to ORANGE.");
        } else if ((dynamicMouseX >= 545 && dynamicMouseX <= 555) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.yellow);
            Logger.logUserMessage("Set the colour of the brush to YELLOW.");
        } else if ((dynamicMouseX >= 560 && dynamicMouseX <= 570) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.green);
            Logger.logUserMessage("Set the colour of the brush to GREEN.");
        } else if ((dynamicMouseX >= 575 && dynamicMouseX <= 585) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.black);
            Logger.logUserMessage("Set the colour of the brush to BLACK.");
        } else if ((dynamicMouseX >= 590 && dynamicMouseX <= 600) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.CYAN);
            Logger.logUserMessage("Set the colour of the brush to CYAN.");
        } else if ((dynamicMouseX >= 605 && dynamicMouseX <= 615) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.pink);
            Logger.logUserMessage("Set the colour of the brush to PINK.");
        } else if ((dynamicMouseX >= 620 && dynamicMouseX <= 630) && (dynamicMouseY >= 40 && dynamicMouseY <= 50)) {
            brush.setColor(Color.MAGENTA);
            Logger.logUserMessage("Set the colour of the brush to MAGENTA.");
        }
    }
}
