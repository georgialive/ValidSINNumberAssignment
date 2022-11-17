package ThirdComputerScienceAssignmentValidSINNumber;

import java.util.Random;
import java.util.Scanner;

public class ValidSINNumber {


	public static void main(String[] args) {
		
	Random rand = new Random();	
		
	try (Scanner cardNumber = new Scanner(System.in)) {
		String generatedNumberOrVerify;
		String SINNumber;
		String first;
		int firstNumber = 0;
			
				System.out.println("\n\nPlease indicate whether you would like a SIN number generated (Enter: 1),\n"
								+ "if you would like to have a SIN number generated given the first digit (Enter 2),\n"
								+ "or to verify whether your SIN number is valid or not. (Enter: 3)");
			
				generatedNumberOrVerify =  cardNumber.nextLine();
			
				int generatedNumberOrVerify1 = 0;
		
//making sure there are no letters		
				
				
					try
					{
						generatedNumberOrVerify1 = Math.round(Integer.parseInt(generatedNumberOrVerify));
					}
			
					catch(Exception insertWhateverHere) 
					{}

/*THE FOLLOWING PROGRAM:
 * Runs a program if 1 is entered.
 * */		
			
			if (generatedNumberOrVerify1 == 1)
			{
				String randomSINNumber;
				do
				{
					double randomNumber1 = Math.round(rand.nextInt(10));
					double randomNumber2 = Math.round(rand.nextInt(10));
					double randomNumber3 = Math.round(rand.nextInt(10));
					double randomNumber4 = Math.round(rand.nextInt(10));
					double randomNumber5 = Math.round(rand.nextInt(10));
					double randomNumber6 = Math.round(rand.nextInt(10));
					double randomNumber7 = Math.round(rand.nextInt(10));
					double randomNumber8 = Math.round(rand.nextInt(10));
					double randomNumber9 = Math.round(rand.nextInt(10));
					
					int randomInt1 = (int) randomNumber1;
					int randomInt2 = (int) randomNumber2;
					int randomInt3 = (int) randomNumber3;
					int randomInt4 = (int) randomNumber4;
					int randomInt5 = (int) randomNumber5;
					int randomInt6 = (int) randomNumber6;
					int randomInt7 = (int) randomNumber7;
					int randomInt8 = (int) randomNumber8;
					int randomInt9 = (int) randomNumber9;
				
				randomSINNumber = "" + randomInt1 + "" + randomInt2 + "" + randomInt3 + "-" + randomInt4 + "" + randomInt5 + "" + randomInt6 + "-" + randomInt7 + "" + randomInt8 + "" + randomInt9;
				
				} while (checkLuhn(randomSINNumber) == false);
				System.out.println(randomSINNumber);
			}
			
/*THE FOLLOWING PROGRAM:
 * Runs a program if 2 is entered.
 * */			
				
				
			else if (generatedNumberOrVerify1 == 2)
				{
					System.out.println("Please enter the first number to generate a random SIN number.");
				
					first = cardNumber.nextLine();
				
					try
					{
						firstNumber = Integer.parseInt(first);
					}
				
					catch(Exception insertWhateverHere) 
					{
						System.out.println("This is not a valid entry please try again.");
					}
				
				if (first.length() == 1)
					{
						String randomSINNumber;
					do
					{
						double randomNumber2 = Math.round(rand.nextInt(10));
						double randomNumber3 = Math.round(rand.nextInt(10));
						double randomNumber4 = Math.round(rand.nextInt(10));
						double randomNumber5 = Math.round(rand.nextInt(10));
						double randomNumber6 = Math.round(rand.nextInt(10));
						double randomNumber7 = Math.round(rand.nextInt(10));
						double randomNumber8 = Math.round(rand.nextInt(10));
						double randomNumber9 = Math.round(rand.nextInt(10));
					
						int randomInt1 = (int) firstNumber;
						int randomInt2 = (int) randomNumber2;
						int randomInt3 = (int) randomNumber3;
						int randomInt4 = (int) randomNumber4;
						int randomInt5 = (int) randomNumber5;
						int randomInt6 = (int) randomNumber6;
						int randomInt7 = (int) randomNumber7;
						int randomInt8 = (int) randomNumber8;
						int randomInt9 = (int) randomNumber9;
						
						randomSINNumber = "" + randomInt1 + "" + randomInt2 + "" + randomInt3 + "-" + randomInt4 + "" + randomInt5 + "" + randomInt6 + "-" + randomInt7 + "" + randomInt8 + "" + randomInt9;
				
					} while (checkLuhn(randomSINNumber) == false);
				
					System.out.println(randomSINNumber);
				}
					else 
					{
						System.out.println("This is not a valid entry please try again.");
					}
			}
/*THE FOLLOWING PROGRAM:
 * Runs a program if 3 is entered.
 * */		
			
			else if (generatedNumberOrVerify1 == 3)
				{
					try (Scanner in = new Scanner(System.in)) {
						
						System.out.println("\n\nPlease enter your SIN number: "
							+ "\n(Please note that entering a value that is not an eligable "
							+ "\nSIN number will cause a INVILD message to appear.)");

						SINNumber =  in.nextLine();
					}
			
					boolean test = false;
			
					if (isItRightLength(SINNumber))
					{
						test = checkLuhn(SINNumber);
					}
				
					if (test == true && isItRightLength(SINNumber) == true && doesItContainLetters(SINNumber) == true)
						{
							System.out.println("This is a valid card.");
						}
					else 
					{
						System.out.println("This is not a valid card.");
					}
				}
			
			
			else 
			{
				System.out.println("This is not a valid option please run again.");
			}
	}
		
	}
		
		
		
		
	
/*
 The Following Method

Making sure that the SIN number is the right length. 
Returns true if it is the right length, false if it is the right length.

 */

		public static boolean isItRightLength(String SINNumber)
		{
			if (SINNumber == null)
			{
				return false;
			}
			
			SINNumber = SINNumber.replaceAll("-", "");
			SINNumber = SINNumber.replaceAll("–", "");
			SINNumber = SINNumber.replaceAll(" ", "");
			
			if (SINNumber.length() == 9)
			{
				return true;
			}
			
				return false;

		}	
/*

The Following Method:

Making sure that the SIN number does not contain any letters.

*/
		
		public static boolean doesItContainLetters(String SINNumber)
		{
			try
			{
				Integer.parseInt(SINNumber);
			}
			
			catch(Exception insertWhateverHere) 
			{
				return true;
			}
			
			return false;
		
		   
		}
		
		
/*
 The Following Method:
 
 Java program to implement
 Luhn algorithm		
 Returns true if given
 card number is valid */

		public static boolean checkLuhn(String SINNumber)
		{	
			SINNumber = SINNumber.replaceAll("-", "");
			SINNumber = SINNumber.replaceAll("–", "");
			SINNumber = SINNumber.replaceAll(" ", "");
			
			
			char stringToChar1 = SINNumber.charAt(0);
			char stringToChar2 = SINNumber.charAt(1);
			char stringToChar3 = SINNumber.charAt(2);
			char stringToChar4 = SINNumber.charAt(3);
			char stringToChar5 = SINNumber.charAt(4);
			char stringToChar6 = SINNumber.charAt(5);
			char stringToChar7 = SINNumber.charAt(6);
			char stringToChar8 = SINNumber.charAt(7);
			char stringToChar9 = SINNumber.charAt(8);
			
			int charToInt1 = Character.getNumericValue(stringToChar1);
			int charToInt2 = Character.getNumericValue(stringToChar2)*2;
			int charToInt3 = Character.getNumericValue(stringToChar3);
			int charToInt4 = Character.getNumericValue(stringToChar4)*2;
			int charToInt5 = Character.getNumericValue(stringToChar5);
			int charToInt6 = Character.getNumericValue(stringToChar6)*2;
			int charToInt7 = Character.getNumericValue(stringToChar7);
			int charToInt8 = Character.getNumericValue(stringToChar8)*2;
			int charToInt9 = Character.getNumericValue(stringToChar9);
			
			if (charToInt2 > 9)
			{
				int first_digit2 = charToInt2/10;
				int last_digit2 = charToInt2%10;
				charToInt2 = first_digit2 + last_digit2;
			
			} 
			
			if (charToInt4 > 9)
			{
				int first_digit4 = charToInt4/10; 
				int last_digit4 = charToInt4%10;
				charToInt4 = first_digit4 + last_digit4;
		
			
			}
			
			if (charToInt6 > 9)
			{
				int first_digit6 = charToInt6/10;
				int last_digit6 = charToInt6%10;
				charToInt6 = first_digit6 + last_digit6;
			}
			
			if (charToInt8 > 9)
			{

				int first_digit8 = charToInt8/10;
				int last_digit8 = charToInt8%10;
				charToInt8 = first_digit8 + last_digit8;
			}
			
			
	
			double SumOfDigits = (charToInt1 + charToInt2 + charToInt3 + charToInt4 + charToInt5 + charToInt6 + charToInt7 + charToInt8 + charToInt9);
			
		
			if (SumOfDigits %10 == 0)
				{
					return true;
				}
		
			else
				{
					return false;
				}
		}
		
}
	
		
	
		
		
		
		