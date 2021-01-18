import java.util.Scanner;

/**
 * 
 * This class is used to convert different temperature scales and show them to user.
 * User can convert and view Kelvin, Fahrenheit and Celsius.
 * 
 * @author Julian Goncharenko
 * @since 14/11/2020
 *
 */
public class Temperature {

	/**
	 * @description This method is used to convert different temperatures.
	 *              Temperatures it can convert are Kelvin, Celsius and Fahrenheit.
	 */
	public static void main(String[] args) {
		// Final variables declaration
		final double ABS_ZERO_KELVIN = 273.15, 
				     FAHRENHEIT_FREEZING_POINT_OF_WATER = 32.0,
				     FAHRENHEIT_TO_CELCIUS_DIVIDER = 5.0/9.0,
				     KELVIN_TO_FAHRENHEIT_DIVIDER = 9.0/5.0;
		
		// Regular variables declaration
		double celsius, fahrenheit, kelvin;
		Scanner scan = new Scanner(System.in);
		
		// User input
		String word = scan.next();
		char c = word.charAt(0);
		double temperature = scan.nextDouble();
		
		// Switch on 'c' variable to check what temperature user has inserted
		switch(c) {
			// In case temperature is in Fahrenheit convert every other temperature accordingly 
			case 'F': fahrenheit = temperature;
					  // Celsius - 5/9 * (Fahrenheit - 32) 
					  celsius = FAHRENHEIT_TO_CELCIUS_DIVIDER * (fahrenheit - FAHRENHEIT_FREEZING_POINT_OF_WATER);
					  // Kelvin = Celsius + 273.15
			          kelvin = celsius + ABS_ZERO_KELVIN;
					  break;
		    // In case temperature is in Celsius convert every other temperature accordingly
			case 'C': celsius = temperature;
					  // Kelvin = Celsius + 273.15
			          kelvin = celsius + ABS_ZERO_KELVIN;
			          // Fahrenheit = 9/5 *  Celsius + 32
			          fahrenheit = KELVIN_TO_FAHRENHEIT_DIVIDER * celsius + FAHRENHEIT_FREEZING_POINT_OF_WATER;
			          break;
		    // In case temperature is in Kelvin convert every other temperature accordingly
			default:  kelvin = temperature;
			          // Fahrenheit = 9/5 * (Kelvin - 273.15) + 32
			          fahrenheit = KELVIN_TO_FAHRENHEIT_DIVIDER * (kelvin - ABS_ZERO_KELVIN) + FAHRENHEIT_FREEZING_POINT_OF_WATER;
			          // Celsius = Kelvin - 273.15
			          celsius = kelvin - ABS_ZERO_KELVIN;
		}
		
		System.out.println(celsius + " C");
		System.out.println(fahrenheit + " F");
        System.out.println(kelvin + " K");
        
        scan.close();
	}
	
}