package paintinglogic;

/**
 * @author K1211282
 *         Created on: 3/17/2015 , Time is: 1:11 PM
 *         Part of Project: PaintingProgram
 */

public class PaintBrush {

    public static final int SMALL = 1, MEDIUM = 2, BIG = 3, HUGE = 4; //sizes
    public static final int CIRCLE = 1, SQUARE = 2, FILL = 3; //shapes
    boolean down;
    int size, shape;

    public PaintBrush() {
        down = false;
        size = 1;
        shape = CIRCLE;
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

}
