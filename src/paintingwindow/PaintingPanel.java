package paintingwindow;

import paintinglogic.Logger;
import paintinglogic.PaintBrush;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:04 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingPanel extends JPanel implements MouseListener {
    PaintBrush brush = new PaintBrush();
    Image circle, paintbucket, square, xMark, small, medium, big, huge;

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
        addMouseListener(this);
        addNotify();
    }


    public void paint(Graphics g) {
        //todo paint gui
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


        g.drawString("Sizes:", 150, 100);

    }


    @Deprecated
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

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
