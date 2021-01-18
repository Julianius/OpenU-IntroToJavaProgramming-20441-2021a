import java.util.Scanner;

/**
 * 
 * This class is used to find various information about incircle and excircle of a rectangle.
 * The rectangle is created using left top point and right bottom point on a graph.
 * 
 * @author Julian Goncharenko
 * @since 14/11/2020
 *
 */
public class Circle {

	/**
	 * @description This method is used to find radius, area and perimeter of two circles.
	 *              The circles are inner circle and outer circle of rectangle that is created using 
	 *              two points on a graph.
	 *              The first point is the left top part of the rectangle and the second one is the
	 *              right bottom point of a rectangle.
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		double incircleR, excircleR, incircleArea, excircleArea, incirclePerimeter, excirclePerimeter;

		System.out.println("This program calculates the areas " + "and the perimeters of the excircle and the incircle "
				+ "of a given rectangle ");

		System.out.println("Please enter the two coordinates of the " + "left-upper point of the rectangle");
		int leftUpX = scan.nextInt();
        int leftUpY = scan.nextInt();

		System.out.println("Please enter the two coordinates of the " + "right-lower point of the rectangle");
		int rightDownX = scan.nextInt();
		int rightDownY = scan.nextInt();

		// Calculation of the incircle radius length
		incircleR = (leftUpY - rightDownY) / 2.0;

		// Calculation of the excircle radius length
		excircleR = Math.sqrt(Math.pow(leftUpX - rightDownX, 2) + Math.pow(leftUpY - rightDownY, 2)) / 2.0;
		
		// Calculation of the incircle area
		incircleArea = Math.PI * Math.pow(incircleR, 2);
		// Calculation of the incircle perimeter
		incirclePerimeter = 2 * Math.PI * incircleR;

		// Calculation of the excircle area
		excircleArea = Math.PI * Math.pow(excircleR, 2);
		// Calculation of the excircle perimeter
		excirclePerimeter = 2 * Math.PI * excircleR;
		
		// Here the output is printed
		System.out.println("Incircle: radius = " + incircleR + ", area = " + incircleArea + ", perimeter = " + incirclePerimeter);
		System.out.println("Excircle: radius = " + excircleR + ", area = " + excircleArea + ", perimeter = " + excirclePerimeter);
        
        scan.close();
	}

}