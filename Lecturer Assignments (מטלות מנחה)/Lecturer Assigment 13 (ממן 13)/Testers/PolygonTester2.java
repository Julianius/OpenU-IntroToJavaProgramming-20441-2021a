package com.openu_2020.maman13;

public class PolygonTester2 {
	
	private static void printAddedVertices(Polygon pol, double[] vertices)
	{
		for(int i = 0; i < vertices.length; i+= 2)
		{
			System.out.print("Attempting to add vertex (" + vertices[i] + ", " + vertices[i+1] + "): ");
			if(pol.addVertex(vertices[i], vertices[i+1]))
			{
				System.out.println("Succeeded");
			}
			else
			{
				System.out.println("Failed");
			}
		}
		System.out.println(""); // Space between lines
	}
	
	private static boolean isEqual(double a, double b) // checks if 2 doubles are equal
	{
		final double TOLERANCE = 0.0000000001;
		
		return Math.abs(a - b) < TOLERANCE;
	}
	
	private static void checkVertices(Polygon pol, String polName, String ExpectedString)
	{
		System.out.println(polName + ": " + pol.toString());
		System.out.println("Expected: ");
		System.out.println(ExpectedString);
		System.out.println("");
	}
	
	private static void checkHighestVertex(Polygon pol, String polName, Point expectedVertex)
	{
		System.out.print("Looking for " + polName + "'s highest vertex: ");
		if(pol.highestVertex() != null && expectedVertex != null)
		{
			if(pol.highestVertex().equals(expectedVertex))
			{
				System.out.println("OK - Expected " + expectedVertex + ", actual: " + pol.highestVertex());
			}
			else
			{
				System.out.println("ERROR - Expected " + expectedVertex + ", actual: " + pol.highestVertex());
			}
		}
		else
		{
			if(pol.highestVertex() == null && expectedVertex == null)
			{
				System.out.println("OK - Expected " + expectedVertex + ", actual: " + pol.highestVertex());
			}
			else
			{
				System.out.println("ERROR - Expected " + expectedVertex + ", actual: " + pol.highestVertex());
			}
		}
	}
	
	private static void checkPerimeter(Polygon pol, String polName, double expectedPerimeter)
	{
		System.out.print("Checking " + polName + "'s perimeter: ");
		if(isEqual(pol.calcPerimeter(), expectedPerimeter))
		{
			System.out.println("OK - Expected " + expectedPerimeter + ", actual: " + pol.calcPerimeter());
		}
		else
		{
			System.out.println("ERROR - Expected " + expectedPerimeter + ", actual: " + pol.calcPerimeter());
		}
	}
	
	private static void checkArea(Polygon pol, String polName, double expectedArea)
	{
		System.out.print("Checking " + polName + "'s area: ");
		if(isEqual(pol.calcArea(), expectedArea))
		{
			System.out.println("OK - Expected " + expectedArea + ", actual: " + pol.calcArea());
		}
		else
		{
			System.out.println("ERROR - Expected " + expectedArea + ", actual: " + pol.calcArea());
		}
	}
	
	private static void checkIsBigger(Polygon pol1, Polygon pol2, boolean expectedResult)
	{
		if(pol1.isBigger(pol2) == expectedResult)
		{
			System.out.println("OK - Expected " + expectedResult + ", actual: " + pol1.isBigger(pol2));
		}
		else
		{
			System.out.println("ERROR - Expected " + expectedResult + ", actual: " + pol1.isBigger(pol2));
		}
	}
	
	private static void checkFindVertex(Polygon pol, String polName, Point point, int expectedIndex)
	{
		System.out.println(polName + ": Looking for the point on the polygon");
		if(pol.findVertex(point) == expectedIndex)
		{
			System.out.println("OK - Expected " + expectedIndex + ", actual: " + pol.findVertex(point));
		}
		else
		{
			System.out.println("ERROR - Expected " + expectedIndex + ", actual: " + pol.findVertex(point));
		}
	}
	
	private static void checkGetNextVertex(Polygon pol, String polName, Point point, Point expectedPoint)
	{
		System.out.println(polName + ": Looking for the next point on the polygon");
		
		if(pol.getNextVertex(point) != null && expectedPoint != null)
		{
			if(pol.getNextVertex(point).equals(expectedPoint))
			{
				System.out.println("OK - Expected " + expectedPoint + ", actual: " + pol.getNextVertex(point));
			}
			else
			{
				System.out.println("ERROR - Expected " + expectedPoint + ", actual: " + pol.getNextVertex(point));
			}
		}
		else
		{
			if(pol.getNextVertex(point) == null && expectedPoint == null)
			{
				System.out.println("OK - Expected " + expectedPoint + ", actual: " + pol.getNextVertex(point));
			}
			else
			{
				System.out.println("ERROR - Expected " + expectedPoint + ", actual: " + pol.getNextVertex(point));
			}
		}
	}
	
	private static void checkGetBoundingBox(Polygon pol, String polName, Polygon expectedBoundingBox)
	{
		System.out.println("Getting " + polName + "'s bounding box: ");
		System.out.println(pol.getBoundingBox());
		System.out.println("Expected:");
		System.out.println(expectedBoundingBox);
		
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		Polygon pol1 = new Polygon();
		Polygon pol2 = new Polygon();
		Polygon pol3 = new Polygon();

		Polygon polEmpty = new Polygon();
		
		Point point1 = new Point(1,1);
		Point point2 = new Point(2,1);
		Point point3 = new Point(3,1);
		Point point4 = new Point(1,2);
		Point pointEmpty = null;
		
		System.out.println("All the polygons should be empty here:");
		System.out.println("pol1: " + pol1.toString());
		System.out.println("pol2: " + pol2.toString());
		System.out.println("pol3: " + pol3.toString());
		System.out.println("polEmpty: " + polEmpty.toString());

		System.out.println("\n");
		
		double[] vertices1 = {1, 1,
							  1, 2,
							  2, 2,
							  2, 1}; // Even numbers are X coordinates, Odd numbers are Y coordinates
		
		double[] vertices2 = {3, 1,
							  3, 2};
		
		double[] vertices3 = {5, 1};
		
		printAddedVertices(pol1, vertices1);
		printAddedVertices(pol2, vertices2);
		printAddedVertices(pol3, vertices3);
		
		System.out.println("");

		// ----------------------------------------------------------------------
		// Check vertices
		// ----------------------------------------------------------------------
		
		checkVertices(pol1, "pol1", "((1.0,1.0),(1.0,2.0),(2.0,2.0),(2.0,1.0))");
		checkVertices(pol2, "pol2", "((3.0,1.0),(3.0,2.0))");
		checkVertices(pol3, "pol3", "((5.0,1.0))");
		checkVertices(polEmpty, "polEmpty", "Empty");
		
		System.out.println("");

		// ----------------------------------------------------------------------
		// Check highestVertex
		// ----------------------------------------------------------------------
		Point point5 = new Point(3,2);
		Point point6 = new Point(5,1);

		checkHighestVertex(pol1, "pol1", point4);
		checkHighestVertex(pol2, "pol2", point5);
		checkHighestVertex(pol3, "pol2", point6);
		checkHighestVertex(polEmpty, "pol2", pointEmpty);

		System.out.println("\n");

		// ----------------------------------------------------------------------
		// Check perimeter
		// ----------------------------------------------------------------------
		checkPerimeter(pol1, "pol1", 4);
		checkPerimeter(pol2, "pol2", 1);
		checkPerimeter(pol3, "pol3", 0);
		checkPerimeter(polEmpty, "polEmpty", 0);

		System.out.println("\n");
		
		// ----------------------------------------------------------------------
		// Check area
		// ----------------------------------------------------------------------
		checkArea(pol1, "pol1", 1);
		checkArea(pol2, "pol2", 0);
		checkArea(pol3, "pol3", 0);
		checkArea(polEmpty, "polEmpty", 0);
		
		System.out.println("\n");

		// ----------------------------------------------------------------------
		// Check isBigger
		// ----------------------------------------------------------------------
		checkIsBigger(pol1, pol2, true);
		checkIsBigger(pol1, polEmpty, true);
		checkIsBigger(pol2, pol1, false);
		checkIsBigger(pol2, polEmpty, false);

		System.out.println("\n");
		
		// ----------------------------------------------------------------------
		// Check findVertex
		// ----------------------------------------------------------------------		
		checkFindVertex(pol1, "pol1", point1, 0);
		checkFindVertex(pol1, "pol1", point2, 3);
		checkFindVertex(pol1, "pol1", point3, -1);
		
		System.out.println("");
		
		// ----------------------------------------------------------------------
		// Check getNextVertex
		// ----------------------------------------------------------------------
		Point expectedPoint1 = new Point(point4);
		Point expectedPoint2 = new Point(1,1);
		Point expectedPoint3 = null;
		
		checkGetNextVertex(pol1, "pol1", point1, expectedPoint1);
		checkGetNextVertex(pol1, "pol1", point2, expectedPoint2);
		checkGetNextVertex(pol1, "pol1", point3, expectedPoint3);
		
		System.out.println("\n");

		// ----------------------------------------------------------------------
		// Check getBoundingBox
		// ----------------------------------------------------------------------
		Polygon pol4 = new Polygon();
		pol4.addVertex(10, 1);
		pol4.addVertex(9, 2);
		pol4.addVertex(11, 3);
		pol4.addVertex(13, 2);
		pol4.addVertex(12, 1);

		Polygon expectedBoundingBox1 = new Polygon();
		expectedBoundingBox1.addVertex(1, 1);
		expectedBoundingBox1.addVertex(2, 1);
		expectedBoundingBox1.addVertex(2, 2);
		expectedBoundingBox1.addVertex(1, 2);
		
		Polygon expectedBoundingBox4 = new Polygon();
		expectedBoundingBox4.addVertex(9, 1);
		expectedBoundingBox4.addVertex(13, 1);
		expectedBoundingBox4.addVertex(13, 3);
		expectedBoundingBox4.addVertex(9, 3);

		checkGetBoundingBox(pol1, "pol1", expectedBoundingBox1);
		checkGetBoundingBox(pol2, "pol2", null);
		checkGetBoundingBox(polEmpty, "polEmpty", null);
		checkGetBoundingBox(pol4, "pol4", expectedBoundingBox4);
	}
}
