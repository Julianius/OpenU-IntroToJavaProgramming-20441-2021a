/**
 * 
 * This class is used to represent a line using two Points.
 * 
 * @author Julian Goncharenko
 * @since 28/11/2020
 *
 */
public class Segment1 {
    final double DEFAULT_VALUE = 0;
    private Point _poLeft, _poRight;
    
    /**
     * Constructs a new segment using 4 specified x y coordinates: 
     * Two coordinates for the left point and two coordinates for the right point. 
     * If the y coordinates are different, change the y of the right point to be equal 
     * to the y of the left point.
     * 
     * @param leftX - X value of left point
     * @param leftY - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment1(double leftX, double leftY, double rightX, double rightY) {
        if (leftY != rightY) {
            rightY = leftY;
        }
        
        _poLeft = new Point(leftX, leftY);
        _poRight = new Point(rightX, rightY);
    }

    /**
     * Constructs a new segment using two Points.
     * If the y coordinates are different, change the y of the right point to be equal to the y of the left point.
     * 
     * @param left - the left point of the segment
     * @param right - the right point of the segment
     */
    public Segment1(Point left, Point right) {
        if (left.getY() != right.getY()) {
            double y = left.getY();
            right.setY(y);
        }
        _poLeft = new Point(left);
        _poRight = new Point(right);
    }
    
    /**
     * Copy Constructor.
     * Construct a segment using a reference segment.
     * 
     * @param other - the reference segment
     */
    public Segment1(Segment1 other) {
        _poLeft = new Point(other._poLeft);
        _poRight = new Point(other._poRight);
    }
    
    /**
     * Change the segment size by moving the right point by delta. 
     * Will be implemented only for a valid delta: 
     * only if the new right point remains the right point.
     *  
     * @param delta - the length change
     */
    public void changeSize(double delta) {
        Point tempPoRight = new Point(_poRight);
        _poRight.move(delta, DEFAULT_VALUE);

        if (!_poRight.isRight(_poLeft) && getLength() < DEFAULT_VALUE) {
            _poRight = new Point(tempPoRight);
        }
    }
    
    /**
     * Check if the reference segment is equal to this segment.
     * 
     * @param other - the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment1 other) {
        return other.getPoLeft().equals(_poLeft) && other.getPoRight().equals(_poRight);
    }
    
    /**
     * Returns the segment length.
     * 
     * @return The segment length
     */
    public double getLength() {
        return _poRight.getX() - _poLeft.getX();
    }
    
    /**
     * Returns the left point of the segment.
     * 
     * @return The left point of the segment
     */
    public Point getPoLeft() {
        return new Point(_poLeft);
    }
    
    /**
     * Returns the right point of the segment.
     * 
     * @return The right point of the segment
     */
    public Point getPoRight() { 
        return new Point(_poRight);
    }
        
    /**
     * Check if this segment is above a reference segment.
     * 
     * @param other - the reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other) {
        return _poLeft.isAbove(other.getPoLeft());
    }
        
    /**
     * Check if this segment is bigger than a reference segment.
     * 
     * @param other - the reference segment
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment1 other) {
        return getLength() > other.getLength();
    }

    /**
     * Check if this segment is left of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment1 other) {
        return _poLeft.isLeft(other.getPoLeft());   
    }
    
    /**
     * Check if this segment is right of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment1 other) {
        return _poRight.isRight(other.getPoRight());
    }
    
    /**
     * Check if this segment is under of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is under to the reference segment
     */
    public boolean isUnder(Segment1 other) {
        return _poLeft.isUnder(other.getPoLeft());
    }

    /**
     * Move the segment horizontally by delta.
     * 
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        _poRight.move(delta, DEFAULT_VALUE);
        _poLeft.move(delta, DEFAULT_VALUE);
    }
        
    /**
     * Move the segment vertically by delta.
     * 
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        _poRight.move(DEFAULT_VALUE, delta);
        _poLeft.move(DEFAULT_VALUE, delta);
    }
        
    /**
     * Returns the overlap size of this segment and a reference segment.
     * 
     * @param other -  the reference segment
     * @return The overlap size
     */
    public double overlap(Segment1 other) { 
       if(_poLeft.getX() <= other._poLeft.getX()) {
            if(_poRight.getX() <= other._poRight.getX() && _poRight.getX() >= other._poLeft.getX()) {
                return _poRight.getX() - other._poLeft.getX();
            }
            if(_poRight.getX() >= other._poRight.getX()) {
                return other.getLength();
            }
        } else {
            if(_poRight.getX() <= other._poRight.getX()) {
                return getLength();
            }
            if(_poRight.getX() >= other._poRight.getX() && _poLeft.getX() <= other._poRight.getX()) {
                return other._poRight.getX()  - _poLeft.getX();
            }
        }
        return DEFAULT_VALUE;
    }
    
    /**
     * Check if a point is located on the segment.
     * 
     * @param p - a point to be checked
     * @return True if p is on this segment
     */
    public boolean pointOnSegment(Point p) {
        return (!p.isUnder(_poLeft) && !p.isAbove(_poLeft) 
        	   && p.isRight(_poLeft) && p.isLeft(_poRight)) 
               || (p.equals(_poLeft) || p.equals(_poRight));
    }
    
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * 
     * @overrides toString in class java.lang.Object
     * @return String representation of this segment
     */
    @Override
    public String toString() {
        return "(" + _poLeft.getX() + "," + _poLeft.getY() + ")---(" + _poRight.getX() + "," + _poRight.getY() + ")";
    }
    
    /**
     * Compute the trapeze perimeter, 
     * which is constructed by this segment and a reference segment.
     * 
     * @param other the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment1 other) {
        double a, b, c, d;
        a = getLength();
        b = other.getLength();
        c = _poLeft.distance(other.getPoLeft());
        d = _poRight.distance(other.getPoRight());
        
        return a + b + c + d;
    } 
    
}
