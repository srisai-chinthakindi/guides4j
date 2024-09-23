package com.guides4j.basics;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Exceptions {
	public static void main(String[] args) {
//		Basic Case 1;
		try {
			int a = 5 / 0;
			throw new Exception(" UnDivisibe by Zero");
		} catch (ArithmeticException e) {
			int a = 5;
			e.printStackTrace();
			System.out.println(e.getMessage());
//			System.exit(1);
		} catch (Exception e) {
			System.out.println("Oh im getting printed as well");
			System.out.print(e.getMessage());
		}
//		catching Exception i,e. multiple Exceptions involves some heirarchy
//		It has to specific Exception to Generic i,e bottomUp
		finally {
			System.out.println("No matter what im going to get Executed");
//			So i will be used to Close the connection and DB related operations etc..
//			But is there any Exception where ill be terminated Yes Tthere is, See line 13.
		}
//		Case 2;
//		Lets try to Catch the Exceptions at onces by using Or Operator
//		 Ahh there is no syntax but see line 34 
		int[] ab = null;
		try {

			System.out.println(ab[0]); // Null Pointer Exception as well as IndexOutBound Exception
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			ab = new int[2];
			ab[0] = 1;
			
			System.out.println("Handled differenet Exceptions for common handling\n" + Arrays.toString(ab));
		}
		
//		case 3: in Case 1 we have seen that finally block is used to Close the Db Connections right
//		Instead we use a different syntax THIS applies only to a Closable Interfaces in java 5
//		they are usaually used with FileInputStream, FileOutputStream, BufferedReader, BufferedWriter 
//		Where as AutoClosable is more generic and can used to handle any Resources in java 7
		AutoCloseable c = () ->{
			throw new IOException("closable Interface is used");
		};
		try {
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
//		case 3 where try-with-resources came into play
		try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))){
			throw new IOException("File.txt Not Found");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
