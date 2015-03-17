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

        Logger.logCodeMessage("Setting size of window to 900x1000");
        setSize(900, 1000); //set size to 900x1000 pixels


        //load all images, such as brush size chooser, and other icons
        try {
            //catMoving = ImageIO.read(new File("resource/Cat_Moving.png"));

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
        g.drawString("Painter Program", 10, 10);

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

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
