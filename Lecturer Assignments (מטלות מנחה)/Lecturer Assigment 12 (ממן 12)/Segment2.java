/**
 * 
 * This class is used to represent a line using a center point and a length.
 * 
 * @author Julian Goncharenko
 * @since 28/11/2020
 *
 */
public class Segment2 {
	
    private Point _poCenter;
    private double _length;
    
    final double DEFAULT_VALUE = 0;
    
    /**
     * Constructs a new segment using 4 specified x y coordinates: 
     * two coordinates for the left point and two coordinates for the right point. 
     * If the y coordinates are different, 
     * change the y of the right point to be equal to the y of the left point.
     * 
     * @param leftX - X value of left point
     * @param leftY - Y value of left point
     * @param rightX - X value of right point
     * @param rightY - Y value of right point
     */
    public Segment2(double leftX, double leftY, double rightX, double rightY) {
    	if(leftX < DEFAULT_VALUE)
    		leftX = DEFAULT_VALUE;
    	
    	if(leftY < DEFAULT_VALUE)
    		leftY = DEFAULT_VALUE;
    	
    	if(rightX < DEFAULT_VALUE)
    		rightX = DEFAULT_VALUE;
    	
    	if(rightY < DEFAULT_VALUE)
    		rightY = DEFAULT_VALUE;
    	
        
        if (leftY != rightY) {
            rightY = leftY;
        }
        
        double x = (leftX + rightX) / 2;

        _length = rightX - leftX;
        _poCenter = new Point(x, rightY);
    }

    /**
     * Constructs a new segment using a center point and the segment length.
     * 
     * @param poCenter -  the Center Point
     * @param length - the segment length
     */
    public Segment2(Point poCenter, double length) {
       _poCenter = new Point(poCenter);
       _length = length;
    }
    
    /**
     * Constructs a new segment using two Points. 
     * If the y coordinates are different, 
     * change the y of the right point to be equal to the y of the left point.
     * 
     * @param left - The left point of the segment 
     * @param right - The right point of the segment
     */
    public Segment2(Point left, Point right) {
        double x, y;
        
        if (left.getY() != right.getY()) {
            y = left.getY();
            right.setY(y);
        }
        
        x = (right.getX() + left.getX()) / 2;

        _length = right.getX() - left.getX();
        _poCenter = new Point(x, right.getY());
    }
    
    /**
     * Copy Constructor. Construct a segment using a reference segment.
     * 
     * @param other - the reference segment
     */
    public Segment2(Segment2 other) {
        _poCenter = new Point(other._poCenter);
        _length = other._length;
    }
    
    /**
     * Change the segment size by moving the right point by delta. 
     * Will be implemented only for a valid delta: only if the new right point remains the right point.
     * 
     * @param delta - The length change
     */
    public void changeSize(double delta) {
        double tempLength = getLength();
        
        _poCenter.setX(delta / 2);
        _length = _length + delta;
        
        if (!getPoRight().isRight(getPoLeft()) && _length < DEFAULT_VALUE) {
            _length = tempLength;
        }
    }
    
    /**
     * Check if the reference segment is equal to this segment.
     * 
     * @param other - the reference segment
     * @return True if the reference segment is equal to this segment
     */
    public boolean equals(Segment2 other) {
        return other._poCenter.equals(_poCenter) && other._length == _length;
    }
    
    /**
     * Returns the segment length
     * 
     * @return The segment length
     */
    public double getLength() {
        return _length;
    }
    
    /**
     * Returns the left point of the segment.
     * 
     * @return The left point of the segment
     */
    public Point getPoLeft() {
        double x, y;
        x = _poCenter.getX() - (_length / 2);
        y = _poCenter.getY();
        return new Point(x, y);
    }
    
    /**
     * Returns the right point of the segment.
     * 
     * @return The right point of the segment
     */
    public Point getPoRight() {
        double x, y;
        x = _poCenter.getX() + (_length / 2);
        y = _poCenter.getY();
        return new Point(x, y);
    }
        
    /**
     * Check if this segment is above a reference segment.
     * 
     * @param other-  the reference segment 
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other) {
        return _poCenter.isAbove(other._poCenter);
    }
        
    /**
     * Check if this segment is bigger than a reference segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is bigger than the reference segment
     */
    public boolean isBigger(Segment2 other) {
        return getLength() > other.getLength();
    }

    /**
     * Check if this segment is left of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is left to the reference segment
     */
    public boolean isLeft(Segment2 other) {
        return _poCenter.isLeft(other._poCenter);
    }
        
    /**
     * Check if this segment is right of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is right to the reference segment
     */
    public boolean isRight(Segment2 other) {
        return getPoRight().isRight(other.getPoRight());
    }
    
    /**
     * Check if this segment is under of a received segment.
     * 
     * @param other - the reference segment 
     * @return True if this segment is under to the reference segment
     */
    public boolean isUnder(Segment2 other) {
        return _poCenter.isUnder(other.getPoLeft());
    }

    /**
     * Move the segment horizontally by delta.
     * 
     * @param delta - the displacement size
     */
    public void moveHorizontal(double delta) {
        _poCenter.move(delta, DEFAULT_VALUE);
    }
        
    /**
     * Move the segment vertically by delta.
     * 
     * @param delta - the displacement size
     */
    public void moveVertical(double delta) {
        _poCenter.move(DEFAULT_VALUE, delta);
    }
        
    /**
     * Returns the overlap size of this segment and a reference segment.
     * 
     * @param other - the reference segment
     * @return The overlap size
     */
    public double overlap(Segment2 other) { 
        if(getPoLeft().getX() <= other.getPoLeft().getX()) {
            if(getPoRight().getX() <= other.getPoRight().getX() && getPoRight().getX() >= other.getPoLeft().getX()) {
                return getPoRight().getX() - other.getPoLeft().getX();
            }
            if(getPoRight().getX() >= other.getPoRight().getX()) {
                return other.getLength();
            }
        } else {
            if(getPoRight().getX() <= other.getPoRight().getX()) {
                return getLength();
            }
            if(getPoRight().getX() >= other.getPoRight().getX() && getPoLeft().getX() <= other.getPoRight().getX()) {
                return other.getPoRight().getX()  - getPoLeft().getX();
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
        return p.isRight(getPoLeft()) && p.isLeft(getPoRight());
    }
    
    /**
     * Return a string representation of this segment in the format (3.0,4.0)---(3.0,6.0).
     * 
     * @overrides toString in class java.lang.Object
     * @return String representation of this segment
     */
    @Override
    public String toString() {
        Point left = getPoLeft();
        Point right = getPoRight();
        
        double leftX = left.getX();
        double leftY = left.getY();
        double rightX = right.getX();
        double rightY = right.getY();
        
        return "(" + leftX + "," + leftY + ")---(" + rightX + "," + rightY + ")";
    }
    
    /**
     * Compute the trapeze perimeter, 
     * which is constructed by this segment and a reference segment.
     * 
     * @param other - the reference segment
     * @return The trapeze perimeter
     */
    public double trapezePerimeter(Segment2 other) {
        double a, b, c, d;
        a = getLength();
        b = other.getLength();
        c = getPoLeft().distance(other.getPoLeft());
        d = getPoRight().distance(other.getPoRight());
        
        return a + b + c + d;
    }   
}

