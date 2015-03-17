package paintinglogic;

import paintingwindow.PaintingFrame;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:00 PM
 *         Part of Project: PaintingProgram
 */

public class Mainfile {
    public static void main(String[] args) {
        new Logger();
        Logger.logOtherMessage("", "\n");

        Logger.logCodeMessage("Initialising, setting up window.");

        new PaintingFrame();


    }
}
