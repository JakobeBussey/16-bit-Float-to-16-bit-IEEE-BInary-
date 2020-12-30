import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class BinaryDecimal {
	/**
	 * 
	 * BinaryToDecimal-
	 * 
	 * Does the full conversion of a hexadecimal number into a decimal number.
	 * 
	 * Prompts the user for input of the hexadecimal number.
	 * 
	 * @throws Exception
	 * If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static void binaryToDecimal() throws Exception
	{
		Scanner keyboard= new Scanner(System.in);
		System.out.println("Give me the Hex:");
		String hex = keyboard.nextLine();
		String full = convertFullHexToBinary(hex);
		String[] set = new String[3];
		
		set = splitBinaryToDecimal(full);
		
		int flip = 1;
		if (set[0].equals("1"))
		{
			flip = -1;
		}
		int exponent =  convertBinaryToDecimal(set[1]) -15;
		double body = 1 + postDotBinaryToDecimal(set[2]);
		
		double total = flip * body* Math.pow(2,exponent);
		System.out.println("Final: "+total+"");
		
	}
	/**
	 * convertFullHexToBinary
	 * 		Turns a String of Hexadecimal digits into a string of binary Integers.
	 * 
	 * @param hex
	 * 			4 hexadecimal digits placed in a string.
	 * @return
	 * 			Converts a hexadecimal number into a String of binary numbers.
	 * @throws Exception
	 * If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static String convertFullHexToBinary(String hex) throws Exception
	{
		//System.out.println("First one:"+hex.substring(0,1));
		//System.out.println("Second one:"+hex.substring(1,2));
		//System.out.println("Third one:"+hex.substring(2,3));
		//System.out.println("Fourth one:"+hex.substring(3,4));
		String part1 = convertHexToBinary((hex.substring(0, 1)));
		String part2 = convertHexToBinary((hex.substring(1, 2)));
		String part3 = convertHexToBinary((hex.substring(2, 3)));
		String part4 = convertHexToBinary((hex.substring(3, 4)));
		
		return part1+part2+part3+part4;
	}
	/**
	 * splitBinaryToDecimal
	 * 		This method splits the binary slots into 3 sepeate pecies,
	 * 		Representing the three different peices that go along with the
	 * 		IEEE Binary Number.
	 * @param binary
	 * 		A string of 16 binary integers.
	 * @return
	 * 		An array with the 3 different peices of the IEEE Binary.
	 */
	public static String[] splitBinaryToDecimal(String binary)
	{
		String[] set = new String[3];
		set[0] = binary.substring(0,1);
		set[1] = binary.substring(1, 6);
		set[2] = binary.substring(6);
		
		//System.out.println(set[0]);
		//System.out.println(set[1]);
		//System.out.println(set[2]);
		
		return set;
	}
	/**
	 * splitBinaryToHex
	 * 		splits the binary into slices of 4. This is in order to turn it into
	 * 		a 4 digit Hexadecimal number.
	 * @param binary
	 * 		Binary is the string of 16 binary integers.
	 * @return
	 * 		Array with 4 elements. Each a set of 4 binary numbers.
	 */
	public static String[] splitBinaryToHex(String binary)
	{
		String[] set = new String[4];
		set[0] = binary.substring(0,4);
		set[1] = binary.substring(4,8);
		set[2] = binary.substring(8, 12);
		set[3] = binary.substring(12, 16);
		for(int i = 0; i < set.length; i++)
		{
			//System.out.println(i+": "+set[i]);
		}
		return set;
	}
	/**
	 * convertHexToBinary
	 * 		Converts a single Hexadecimal number into a String of Binary numbers.
	 * @param b
	 * 		The hexadecimal number to be converted.
	 * @return
	 * 		A String of binary integers corresponding to their Hexadecimal value.
	 * @throws Exception
	 * 		If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static String convertHexToBinary(String b) throws Exception
	{
		if(b.equals("0")) {
			return "0000";
		}
		else if(b.equals("1")) {
			return "0001";
		}
		else if(b.equals("2")) {
			return "0010";
		}
		else if(b.equals("3")) {
			return "0011";
		}
		else if(b.equals("4")) {
			return "0100";
		}
		else if(b.equals("5")) {
			return "0101";
		}
		else if(b.equals("6")) {
			return "0110";
		}
		else if(b.equals("7")) {
			return "0111";
		}
		else if(b.equals("8")) {
			return "1000";
		}
		else if(b.equals("9")) {
			return "1001";
		}
		else if(b.equals("A")) {
			return "1010";
		}
		else if(b.equals("B")) {
			return "1011";
		}
		else if(b.equals("C")) {
			return "1100";
		}
		else if(b.equals("D")) {
			return "1101";
		}
		else if(b.equals("E")) {
			return "1110";
		}
		else if(b.equals("F")) {
			return "1111";
		}
		else
		{
			throw new Exception("it is not in hex.");
			
		}	
			
	}
	/**
	 * convertBinaryToDecimal
	 * 		Converts a binary string to its corresponding decimal number.
	 * @param bin
	 * 		The binary number you wish to convert.
	 * @return
	 * 		A numerical whole number. from the binary number.
	 */
	public static int convertBinaryToDecimal(String bin)
	{
		if (bin.length() >= 1)
		{
			String multi = bin.substring(0,1);
			int actual = Integer.parseInt(multi);
			int obj = (int) (actual * Math.pow(2, bin.length()-1));
			//System.out.println(obj);
			return (int) ( obj + convertBinaryToDecimal(bin.substring(1)));
		}
		else
		{
			return 0;
		}
		
	}
	/**
	 * postDotBinaryToDecimal
	 * 		converts the numbers behind the decimal marker into a binary.
	 * @param bin
	 * 		Binary after the decimal.
	 * @return
	 * 		The decimal value of the the post decimal.
	 * 		
	 */
	public static double postDotBinaryToDecimal(String bin)
	{
		double total = 0;
		for(int i = 0; i < bin.length(); i++)
		{
			int mult = Integer.parseInt((bin.substring(i, i+1)));
			double boing = mult * Math.pow(2,(-1)*(i+1));
			total = total + boing;
		}
		return total;
	}
	/**
	 * convertBinaryToHex
	 * 		Takes a string of 4 binary numbers and converts it to its corresponding
	 * 		Hex digit.
	 * @param b
	 * 		The string of binary numbers you wish to convert.
	 * @return
	 * 		A single Hexadecimal digit. It is in the form of a String.
	 * @throws Exception
	 * 		If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static String convertBinaryToHex(String b) throws Exception
	{
		if(b.equals("0000")) {
			return "0";
		}
		else if(b.equals("0001")) {
			return "1";
		}
		else if(b.equals("0010")) {
			return "2";
		}
		else if(b.equals("0011")) {
			return "3";
		}
		else if(b.equals("0100")) {
			return "4";
		}
		else if(b.equals("0101")) {
			return "5";
		}
		else if(b.equals("0110")) {
			return "6";
		}
		else if(b.equals("0111")) {
			return "7";
		}
		else if(b.equals("1000")) {
			return "8";
		}
		else if(b.equals("1001")) {
			return "9";
		}
		else if(b.equals("1010")) {
			return "A";
		}
		else if(b.equals("1011")) {
			return "B";
		}
		else if(b.equals("1100")) {
			return "C";
		}
		else if(b.equals("1101")) {
			return "D";
		}
		else if(b.equals("1110")) {
			return "E";
		}
		else if(b.equals("1111")) {
			return "F";
		}
		else
		{
			throw new Exception("it is not in binary form.");
			
		}	
			
	}
	/**
	 * main
	 * 	Is the central switch board of the problem. Mainly there to select
	 * 	which part of the program to be utilized. Hex to Decimal or Decimal to Hex.
	 * @param args
	 * 	Not utilized.
	 * @throws Exception
	 * 	If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	//	System.out.println(postDotBinaryToDecimal("1001"));
	//	String[] bin = splitBinaryToDecimal(convertFullHexToBinary("C640"));
		System.out.println("Do you want to: \n1. Convert a decmial to 16-bit binary or \n2. Convert a 16 bit Binary to decimal");
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		
		if (choice == 1)
		{
			decimalToBinary();
		}
		else if(choice == 2)
		{
			binaryToDecimal();
		}
		else
		{
			System.out.println("NO DICE! You need to chose a valid response.");
		}
		
//		System.out.println(convertFullHexToBinary(new String("AAAF")));
		
	}
	/**
	 * wholeNumberToBinary
	 * 		Turns a decimal number into a set of binary digits.
	 * @param whole
	 * 		The whole number you wish to change into Binary.
	 * @return
	 * 		The Binary set of digits.
	 */
	public static String wholeNumberToBinary(int whole)
	{
		int cont = -1;
		int rem = -1;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		while (cont != 0)
		{
			cont = (int) whole/2;
			rem = whole % 2;
		//	System.out.println("Cont: "+cont);
		//	System.out.println("Rem: "+rem);
			list.addFirst(rem);
			whole = cont;
			
			
		}
		String binary = new String();
		for (int i = 0; i < list.size(); i++)
		{
			binary = binary + list.get(i);
		}
		
		return binary;
	}
	/**
	 * numberOfRepeats
	 * 		Counts the number of repeating question digits in an array.
	 * @param check
	 * 		The array that you wish to check.
	 * @param question
	 * 		Question is the number you wiwsh to see the number of repeats of.
	 * @return
	 * 		The numebr of times the Questoin exists in the check array.
	 */
	public static int numberOfRepeats(ArrayList<Double> check, double question)
	{
		int num = 0;
		for(int i = 0; i < check.size(); i++)
		{
			if (check.get(i) == question)
			{
				num = num + 1;
			}
		}
		return num;
	}
	/**
	 * repeatList
	 * 		checks if there is anaything in the List that repeats at all.
	 * @param check
	 * 		The array that you wish to check. 
	 * @return
	 * 		if the list has any element that repeats, return true. Otherwise false.
	 */
	public static boolean repeatList(ArrayList<Double> check)
	{
		for (int i = 0; i < check.size(); i++)
		{
			if (numberOfRepeats(check,check.get(i)) > 1)
			{
				return true;
			}
	
		}
		
		
		return false;
		
	}
	
	/**
	 * findRepeat
	 * 	Finds the first number in the list that repeats. Otherwise it returns
	 * 	-1.
	 * @param check
	 * 		The array you wish to check from.
	 * @return
	 * 		the index of the repeated entry. Or -1 if it doesn't exist.
	 */
	public static int findRepeat(ArrayList<Double> check)
	{
		for(int i = 0; i< check.size(); i++)
		{
			if (numberOfRepeats(check,check.get(i)) > 1)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * floatToBinary
	 * 		This method actually converts the number post the decimal into
	 * 		It's propper binary.
	 * @param decim
	 * 		The decimal number you would like converted.
	 * @return
	 * 	There are two scenarios. In the event there is an infininately recuring number
	 * 	It gives you the same value as it would otherwise accept it also puts
	 * 	an r in the part that repeats forever. OTherwise it just releases the number.
	 */
	public static String floatToBinary(double decim)
	{
		
		
		boolean flag = false;
		ArrayList<String> things = new ArrayList<String>(); 
		ArrayList<Double> check = new ArrayList<Double>();
		while((decim != 0) && (!repeatList(check)))
		{
			decim = 2*decim;
			if (decim >= 1)
			{
				things.add("1");
				decim = decim -1;
				check.add(decim);
			}
			else
			{
				things.add("0");
				decim = decim -0;
				check.add(decim);
			}
			if (repeatList(check))
			{
				//System.out.println("UNFORTUNATLEY REPEAT.");
				int first = findRepeat(check);
				things.add(first, "r");
				things.add("r");
			}
		}
		
		String total = new String();
		for(int i = 0; i < check.size(); i++)
		{
			total = total + things.get(i);
		}
		
		return total;
	}
	/**
	 * decimalToBinary
	 * 		The main portion of the decimal to Hexadecimal program.
	 * @throws Exception
	 * 		If an Incorrect Input is placed, an Exception will be thrown.
	 */
	public static void decimalToBinary() throws Exception
	{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me the decimal:");
		double decimal = keyboard.nextDouble();
		int sign = 1;
		String bin = decimal+"";
		//System.out.println("bin: "+bin);
		
		if (bin.indexOf("-") != -1)
		{
			sign = -1;
			decimal = decimal / -1;
			bin = decimal+"";
		}
		
		
		//System.out.println("bin: "+bin);
		
		if(bin.indexOf(".") == -1)
		{
			bin = bin+ ".0";
		}
		
		
			System.out.println();
			System.out.println();
			int boing = Integer.parseInt(bin.substring(0,bin.indexOf(".")));
			double fin = Double.parseDouble(bin.substring(bin.indexOf(".")));
		String begin = ""+(wholeNumberToBinary(boing));
		String end = "."+(floatToBinary(fin));
		
		//System.out.println(begin+end);
		//System.out.println("Post Fix Length:");
		//System.out.println(fixLength(begin+end));
		String total = begin+end;
		int exp = findTwoShift(total);
		//System.out.println("Exp: "+exp);
		
		int character = 15+exp;
		String binChar = wholeNumberToBinary(character);
		
		while (binChar.length() < 5)
		{
			binChar = "0"+binChar;
		}
		String signbit = "0";
		
		if (sign == -1)
		{
			signbit = "1";
		}
		String finish = signbit + binChar;
		total = moveTheDot(total,exp);
		total = total.substring(total.indexOf(".")+1);
		//System.out.println("This is total: "+total);
		total = fixLength(total);
		finish = finish +total;
		
		//System.out.println("Complete Binary: "+finish);
		String[] art = splitBinaryToHex(finish);
		String hex = convertBinaryToHex(art[0])+convertBinaryToHex(art[1])+
				convertBinaryToHex(art[2]) + convertBinaryToHex(art[3]);
		
		System.out.println("Complete Hex: "+hex);
		
	}
	/**
	 * 	moveTheDot
	 * 		This moves the decimal to it's proper place based upon the exponent. 
	 * 		
	 * @param binary
	 * 		binary with the decimal in it.
	 * @param exp
	 * 		The proper exponent the string of binary digits should be
	 * 		raised or lowered to.
	 * @return
	 * 		The new string with the dot properly placed. Which is right behind the
	 * 		first 1.
	 */
	public static String moveTheDot(String binary,int exp) {
		// TODO Auto-generated method stub
		String finished = binary;
		int dotLocation = finished.indexOf(".");
		//System.out.println("With dot: "+finished);
		finished = finished.substring(0,dotLocation) + finished.substring(dotLocation+1);
		//System.out.println("Without dot: "+finished);
		
		int soup = dotLocation-exp;
		String complete = finished.substring(0,soup) +"."+finished.substring(soup);
		//System.out.println("This is complete: "+complete+" *2^"+exp);
		
		return complete;
	}
	/**
	 *  fixLength
	 *  	the length is often times too big or too small. In order to fix this
	 *  	This method turns the length into ten as the mantisa should be.
	 * @param decimal
	 * 		The number to be converted to a length of ten.
	 * @return
	 * 		The final string that must have a length of 10.
	 */
	public static String fixLength(String decimal)
	{
		if (decimal.length() < 10)
		{
			while(decimal.length() < 10)
			{
				decimal = decimal + "0";
				
			}
			return decimal;
		}
		else if (decimal.length() == 10)
		{
			return decimal;
		}
		else
		{
			//Longer than 16
			return decimal.substring(0,10);
		}
	}
	/**
	 * findTwoShift
	 * 		This determines the exponential value required for the binary decimal.
	 * @param binary
	 * 		The String of binary didgits including the decial.
	 * @return
	 * 		The exponent that the number should be raised to.
	 */
	public static int findTwoShift(String binary)
	{
		int firstOneLocation = binary.indexOf("1");
		int dotLocation = binary.indexOf(".");
		
		if(firstOneLocation < dotLocation)
		{
			return (dotLocation - firstOneLocation) -1;
		}
		else
		{
			return (dotLocation - firstOneLocation);
		}
		
	}

}
