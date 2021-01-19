/**
 * 
 * This class is used to define a point using polar system and perform various actions on it.
 * The class uses vector to the point and alpha angle to perform the calculations.
 * 
 * @author Julian Goncharenko
 * @since 28/11/2020
 *
 */
public class Point {

    private double _radius; 
    private double _alpha;
    
    final double DEFAULT_VALUE = 0;
    final int ROUND_DIVISOR = 10000;
    
    /**
     * Constructor for objects of class Point. 
     * Construct a new point with the specified x y coordinates. 
     * If the x coordinate is negative it is set to zero. 
     * If the y coordinate is negative it is set to zero.
     * 
     * @param x - The x coordinate
     * @param y - The y coordinate
     */
    public Point(double x, double y) {
    	double _x = DEFAULT_VALUE, _y = DEFAULT_VALUE;
    	 
    	if(x > DEFAULT_VALUE)
    		_x = x;
    	if(y > DEFAULT_VALUE)
    		_y = y;
        
        _radius = calculateRadius(_x, _y);
        _alpha = calculateAlpha(_x, _y);
    }
    
    /**
     * Constructor for objects of class Point. 
     * Copy constructor, construct a point using another point.
     * 
     * @param other - The point from which to construct the new object
     */
    public Point(Point other) {
        if (other != null) {
            _alpha = other._alpha;
            _radius = other._radius;
        };
    }
    
    /**
     * Check the distance between this point and a given point.
     * 
     * @param other - The point to check the distance from
     * 
     * @return The distance
     */
    public double distance(Point other) {
        double x1 = getX();
        double y1 = getY();
        double x2 = other.getX();
        double y2 = other.getY();
        
        return Math.sqrt(Math.pow((x1 - x2), 2.0) + Math.pow((y1 - y2), 2.0));
    };
    
    /** 
     * Check if the given point is equal to this point.  
     * 
     * @param other - The point to check equality with
     * 
     * @return True if the given point is equal to this point
     */
    public boolean equals(Point other) {
        if (other._alpha == _alpha && other._radius == _radius) {
            return true;
        } else {
            return false;
        }
    }
    
    /** 
     * This method returns the x coordinate of the point.
     * 
     * @return The x coordinate of the point
     */
    public double getX() {
        if (_alpha == (Math.PI / 2.0)) {
            return 0;
        }
        return round(Math.cos(_alpha) * _radius);
    }
    
    /** 
     * This method returns the y coordinate of the point.
     * 
     * @return The y coordinate of the point
     */
    public double getY() {
      return round(Math.sin(_alpha) * _radius);
    }
    
    /**
     * Check if this point is above a received point.
     * 
     * @param other - The point to check if this point is above
     * 
     * @return True if this point is above the other point
     */
    public boolean isAbove(Point other) {
        return other.getY() < getY();
    };
    
     /**
     * Check if this point is left of a received point.
     * 
     * @param other - The point to check if this point is left of
     * 
     * @return True if this point is left of the other point
     */
    public boolean isLeft(Point other) {
        return other.getX() > getX();
    };
    
    /**
     * Check if this point is right of a received point.
     * 
     * @param other - The point to check if this point is right of
     * 
     * @return True if this point is right of the other point
     */
    public boolean isRight(Point other) {
        return other.getX() < getX();
    };
        
    /**
     * Check if this point is below a received point.
     * 
     * @param other - The point to check if this point is below
     * 
     * @return True if this point is below the other point
     */
    public boolean isUnder(Point other) {
        return other.getY() > getY();
    };
    
    /**
     * Moves a point. If either coordinate becomes negative the point remains unchanged.
     * 
     * @param dx - The difference to add to x
     * @param dy - The difference to add to y
     */
    public void move(double dx, double dy) {
        double x = getX();
        double y = getY();
 
        x = x + dx;
        y = y + dy;
        
        if (x >= DEFAULT_VALUE && y >= DEFAULT_VALUE) {
            _alpha = calculateAlpha(x, y);
            _radius = calculateRadius(x, y);
        }
    }
    
    /** 
     * This method sets the x coordinate of the point. 
     * If the new x coordinate is negative the old x coordinate will remain unchanged.
     * 
     * @param x - The new x coordinate
     */
    public void setX(double x) {
        double y = getY();
        if(x < DEFAULT_VALUE)
        	x = getY();

        _alpha = calculateAlpha(x, y);
        _radius = calculateRadius(x, y);
    }

    /** 
     * This method sets the y coordinate of the point. 
     * If the new y coordinate is negative the old y coordinate will remain unchanged.
     * 
     * @param y - The new y coordinate
     */
    public void setY(double y) {
        double x = getX();
        if(y < DEFAULT_VALUE)
        	y = getY();
        
        _alpha = calculateAlpha(x, y);
        _radius = calculateRadius(x, y);
    }
    
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
    
    /**
     * This method is used to calculate the radius of the point.
     * 
     * @param x - The x coordinate of the point
     * @param y - The y coordinate of the point
     * 
     * @return radius - Radius that has been calculated using the two coordinates.
     */
    private double calculateRadius(double x, double y) {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
    }
    
    /**
     * This method is used to calculate the alpha of the point.
     * 
     * @param x - The x coordinate of the point
     * @param y - The y coordinate of the point
     * 
     * @return alpha - Alpha that has been calculated using the two coordinates.
     */
    private double calculateAlpha(double x, double y) {
        if (x == 0.0) {
            return Math.PI / 2.0;
        }
        return Math.atan(y / x);
    }  
    
    /**
     * This method is used to round the number to one digit after the dot.
     * 
     * @param number - The number that need to be rounded.
     * 
     * @return number - Rounded number.
     */
    private double round(double number) {
        return Math.round(number * ROUND_DIVISOR)/(double) ROUND_DIVISOR;
    }
    
}
