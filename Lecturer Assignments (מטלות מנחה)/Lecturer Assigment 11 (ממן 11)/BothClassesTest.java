import java.io.*;
import java.util.*;

public class BothClassesTest
{
	private static int count = 0;
	private static enum tests {TEST_1, TEST_2};
	private static LinkedList<AbstractMap.SimpleEntry<String, String>>  testsList;
	private static LinkedList<AbstractMap.SimpleEntry<String, String>>  printList;

	public static void main(String[] args) 
	{
		System.out.println("------------ BEGIN TEST Q1 ------------");
		runTest(tests.TEST_1);
		System.out.println("------------ End TEST Q1 ------------\n\n");

		System.out.println("------------ BEGIN TEST Q2 ------------");
		runTest(tests.TEST_2);
		System.out.println("------------ End TEST Q2 ------------");
	}

	private static void runTest(tests numOfTest) 
	{
		createTest(numOfTest);
		count = 0;
		for (int i = 0; i < testsList.size(); i++)
			test(testsList.get(i).getKey(),testsList.get(i).getValue(),
										   printList.get(i).getValue(), numOfTest);
	}

	private static void createTest(tests numOfTest) 
	{
		testsList = new LinkedList<AbstractMap.SimpleEntry<String, String>>();
		printList = new LinkedList<AbstractMap.SimpleEntry<String, String>>();
		
		if(numOfTest == tests.TEST_1)
		{
			testsList.add(new AbstractMap.SimpleEntry<>("1 3 5 1", 
					"((.)*(\r\n)*)*Incircle: radius = 1.0, area = 3.141[0-9]*, perimeter = 6.283[0-9]*\r\n" + 
					"Excircle: radius = 2.236[0-9]*, area = 15.707[0-9]*, perimeter = 14.049[0-9]*(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("1 3 5 1", 
					"Incircle: radius = 1.0, area = 3.141, perimeter = 6.283\r\n" + 
					"Excircle: radius = 2.236, area = 15.707, perimeter = 14.049"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("3 7 7 4", 
					"((.)*(\r\n)*)*Incircle: radius = 1.5, area = 7.068[0-9]*, perimeter = 9.424[0-9]*\r\n" + 
					"Excircle: radius = 2.5[0-9]*, area = 19.634[0-9]*, perimeter = 15.707[0-9]*(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("3 7 2 4", 
					"Incircle: radius = 1.5, area = 7.068, perimeter = 9.424\r\n" + 
					"Excircle: radius = 2.5, area = 19.634, perimeter = 15.707"));
			
			
			testsList.add(new AbstractMap.SimpleEntry<>("-1 -1 1 -6", 
					"((.)*(\r\n)*)*Incircle: radius = 2.5, area = 19.634[0-9]*, perimeter = 15.707[0-9]*\r\n" + 
					"Excircle: radius = 2.692[0-9]*, area = 22.776[0-9]*, perimeter = 16.917[0-9]*(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("-1 -1 1 -6", 
					"Incircle: radius = 2.5, area = 19.634, perimeter = 15.707\r\n" + 
					"Excircle: radius = 2.692, area = 22.776, perimeter = 16.917"));
			// Add more for test 1 here
		}
		else if(numOfTest == tests.TEST_2)
		{
			testsList.add(new AbstractMap.SimpleEntry<>("F 100", "((.)*(\r\n)*)*37.7[0-9]* C\r\n100.0 F\r\n310.9[0-9]* K(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("F 100", "37.7 C\r\n100.0 F\r\n310.9 K"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("C 100", "((.)*(\r\n)*)*100.0 C\r\n212.0 F\r\n373.1[0-9]* K(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("C 100", "100.0 C\r\n212.0 F\r\n373.1 K"));
			
			testsList.add(new AbstractMap.SimpleEntry<>("K 100", "((.)*(\r\n)*)*-173.1[0-9]* C\r\n-279.6[0-9]* F\r\n100.0 K(\r\n)*"));
			printList.add(new AbstractMap.SimpleEntry<>("K 100", "-173.1 C\r\n-279.6 F\r\n100.0 K"));
			// Add more test 2 here
		}
		else
			System.out.println("Error in createTest number " + numOfTest);
	}
	
	private static void test(String input, String output, String print, tests numOfTest) 
	{
		count++;

		InputStream stdin = System.in;
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PrintStream old = System.out;
		System.setOut(new PrintStream(b));
		try 
		{
			System.setIn(new ByteArrayInputStream(input.getBytes()));
			if (numOfTest == tests.TEST_1)
				Circle.main(new String[] {});
			else if(numOfTest == tests.TEST_2)
				Temperature.main(new String[] {});
			else
				System.out.println("Error in test number " + numOfTest);
		} catch (Exception e) 
		{
			System.out.println("Error!!!");
		}
		finally 
		{
			System.setIn(stdin);
			System.out.flush();
			System.setOut(old);
		}

		String outputStudent = b.toString();
		if (outputStudent.matches(output))
		{
			System.out.printf("%s %30s\n","Test #" + count, "\t\tPassed");
		}
		else
		{
			System.out.printf("\n%s %30s","Test #" + count, "\t\tFAILED!!!!\n");
			System.out.println("Input is:\n" + input);
			System.out.println("Student's output is:\n" + outputStudent);
			System.out.println("Output should be:\n" + print);
		}
	}
}