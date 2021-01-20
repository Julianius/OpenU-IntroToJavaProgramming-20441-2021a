package com.openu_2020.maman13;

/**
 * 
 * This class is used to define a polygon which consists of number of vertices
 * and perform various actions on it.
 * 
 * @author Julian Goncharenko
 * @since 12/12/2020
 *
 */
public class Polygon {
	
    private Point[] _vertices;
    private int _noOfVertices;
    private final int VERTICES_MAX = 10;
    
    /**
     * Default constructor for objects of class Polygon.
     */
    public Polygon() {
        _vertices = new Point[VERTICES_MAX];
        _noOfVertices = 0;
    }
    
    /**
     * This method is used to add vertex to polygon.
     * 
     * @param x - X coordinate of the new vertex
     * @param y - Y coordinate of the new vertex
     * 
     * @return true if the adding the vertex was successful, false if the vertices array is full.
     */
    public boolean addVertex(double x, double y) {
    	
        if (_noOfVertices == VERTICES_MAX) {
            return false;
        } 
        
        _vertices[_noOfVertices] = new Point(x, y);
        ++_noOfVertices;
        
        return true;
    }
    
    /**
     * This method is used to retrieve the highest vertex in the Polygon.
     * 
     * @return vertex - highest vertex in the polygon
     */
    public Point highestVertex() {
    	
    	if (_noOfVertices == 0) {
    		return null;
        }
    	
        Point highestPoint = _vertices[0];
        
        for (int i = 1; i < _noOfVertices; ++i) {
            if (highestPoint.isUnder(_vertices[i])) {
                highestPoint = _vertices[i];
            }
        }
        
        return new Point(highestPoint);
    }
    
    /**
     * This method is used to retrieve the String representation on the polygon.
     * If there are no vertices on the polygon than method will return message accordingly.
     * Then if there are vertices on the polygon than method will return in format:
     * 
     * The polygon has 4 vertices:
     * ((2.0,1.0),(5.0,0.0),(7.0,5.0),(4.0,6.0))
     * 
     * @return string - the string representation of the vertices located on the polygon.
     */
    @Override
    public String toString() {
        
        if (_noOfVertices == 0) {
            return "The polygon has 0 vertices.";
        }
        
        String string = "The polygon has " + _noOfVertices + " vertices:\n(" + _vertices[0];
        
        for (int i = 1; i < _noOfVertices; ++i) { 
            string += "," + _vertices[i];
        }
        
        return string + ")";     
    }
    
    /**
     * This method is used to calculate polygon's perimeter.
     * 
     * @return perimeter - perimeter of the polygon that has been calculated using polygon's vertices.
     */
    public double calcPerimeter() {
        double perimeter = 0;
        
        if (_noOfVertices <= 1) {
            return perimeter;
        }
        
        if (_noOfVertices == 2) {
            return _vertices[0].distance(_vertices[1]);
        }
        
        for (int i = 0; i < _vertices.length - 1 && _vertices[i + 1] != null; ++i) {
        	perimeter += _vertices[i].distance(_vertices[i + 1]);
        }
        
        return perimeter + _vertices[_noOfVertices - 1].distance(_vertices[0]);
    }
    
    /**
     * This method is used to calculate polygon's area.
     * 
     * @return area - area of the polygon that has been calculated using polygon's vertices.
     */
    public double calcArea() {
        double area = 0;
            
        if (_noOfVertices >= 3) {
            for (int i = 1; i < _noOfVertices - 1; ++i) {
                if (_vertices[i] != null) { 
                	// This is the heron's formula method that is used to calculate triangle's area.
                    area += triangleAreaCalc(_vertices[0], _vertices[i], _vertices[i + 1]);
                }
            }
        }
        
        return area;
    }
    
    /**
     * This method is used to check if current polygon is bigger than received polygon.
     * 
     * @param other - The other polygon to which current polygon will be compared.
     * @return true if current polygon is bigger and false otherwise.
     */
    public boolean isBigger(Polygon other) {
        return calcArea() > other.calcArea();
    }
    
    /**
     * This method is used to find specific vertex index inside the polygon's point array.
     * It will return specific vertex's index and if no such point exist in the array it will return -1.
     * 
     * @param p - the point which index will be searched for
     * @return index - the index of the vertex inside the point's array
     */
    public int findVertex(Point p) {
    	
        for (int index = 0; index < _vertices.length; index++) {
               if (_vertices[index] != null && p.equals(_vertices[index])) {
                   return index;
               }
        }
        
        return -1;
    }
    
    /**
     * This method is used to find the next vertex inside the polygon's point array.
     * If vertex that is received by the method does not exist in the point's array it will return null.
     * 
     * @param p - the vertex before the next vertex
     * @return vertex - the next vertex in the polygon or null if received vertex does not exist.
     */
    public Point getNextVertex(Point p) {
        Point nextVertex = null;
        int index = findVertex(p);
        
        if (index > -1) {
            int nextIndex = index + 1;
            
            if (nextIndex == _noOfVertices) {
                nextVertex = _vertices[0];
            } else {
                nextVertex = _vertices[nextIndex];
            }
            
            nextVertex = new Point(nextVertex);
        }
        
        return nextVertex;
    }
    
    /**
     * This method is used to calculate the bounding rectangle which bound the polygon.
     * 
     * @return polygon - the rectangle that bounds current polygon.
     */
    public Polygon getBoundingBox() {
    	
        if (_noOfVertices < 3) {
            return null;
        }
        
        Polygon box;
        Point maxY =  highestVertex();
        Point minY = _vertices[0];
        Point maxX = _vertices[0];
        Point minX = _vertices[0];
        
        for (int i = 0; i < _noOfVertices; ++i) {
        	Point current = _vertices[i];
        	
        	if (current.isUnder(minY)) {
                minY = current;
            } else if (current.isRight(maxX)) {
                maxX = current;
            } else if (current.isLeft(minX)) {
                minX = current;
            }
        	
        }
        
        box = new Polygon();
        box.addVertex(minX.getX(), minY.getY());
        box.addVertex(maxX.getX(), minY.getY());
        box.addVertex(maxX.getX(), maxY.getY());
        box.addVertex(minX.getX(), maxY.getY());
        
        return box;
        
    }
    
    /**
     * This method is used to calculate triangle's area using the heron's formula.
     * 
     * @param a - vertex a on the triangle.
     * @param b - vertex b on the triangle.
     * @param c - vertex c on the triangle.
     * @return area - the area if the triangle that has been calculated using heron's formula.
     */
    private double triangleAreaCalc(Point a, Point b, Point c) {
        double AB = a.distance(b);
        double BC = b.distance(c);
        double CA = c.distance(a);
        
        double s = (AB + BC + CA) / 2;
        
        return Math.sqrt(s * (s - AB) * (s - BC) * (s - CA));
    }
    
}
