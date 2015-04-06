package paintingwindow;

import paintinglogic.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:02 PM
 *         Part of Project: PaintingProgram
 */

public class PaintingFrame extends JFrame {

    public PaintingFrame() {

        super("Rodent's Revenge");
        // Sets the close button to exit the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // makes the window not able to be resized
        setResizable(false);
        // creates the window
        pack();
        // creates the panel
        PaintingPanel p = new PaintingPanel();
        // gets the frames insets
        Insets frameInsets = getInsets();
        // calculates panel size
        int frameWidth = p.getWidth()
                + (frameInsets.left + frameInsets.right);
        int frameHeight = p.getHeight()
                + (frameInsets.top + frameInsets.bottom);
        // sets the frame's size
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        // turns off the layout options
        setLayout(null);
        // adds the panel to the frame
        add(p);
        // adjusts the window to meet its new preferred size
        pack();
        // shows the frame
        setVisible(true);
        Logger.logOtherMessage("Window", "Window Created.");
    }
}
