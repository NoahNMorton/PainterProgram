package paintinglogic;

import java.awt.*;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:11 PM
 *         Part of Project: PaintingProgram
 */

public class PaintBrush {

    public static final int SMALL = 1, MEDIUM = 2, BIG = 3, HUGE = 4; //sizes
    public static final int CIRCLE = 1, SQUARE = 2, FILL = 3; //shapes
    private boolean down;
    private int size, shape;
    private Color color;

    public PaintBrush() {
        down = false;
        size = 1;
        shape = CIRCLE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        String wordShape = "", wordSize = "";
        Color wordColor = this.color;
        switch (shape) {
            case CIRCLE:
                wordShape = "Circle";
                break;
            case SQUARE:
                wordShape = "Square";
                break;
            case FILL:
                wordShape = "Filling";
                break;
        }
        switch (size) {
            case SMALL:
                wordSize = "Small";
                break;
            case MEDIUM:
                wordSize = "Medium";
                break;
            case BIG:
                wordSize = "Big";
                break;
            case HUGE:
                wordSize = "Huge";
                break;
        }
        return "Brush Stats:\nCurrent shape:" + wordShape + "\nCurrent size:" + wordSize + "\nCurrent color:" + wordColor.toString();
    }
}
