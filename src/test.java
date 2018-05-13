import java.util.Arrays;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		// I changed it from double to int because you cannot switch on double values
		int difference = a-b;
		 
		switch (difference) {
		case 0:
		    System.out.println("The numbers are equal");
		    break;
		default:
		    if (difference>0) {
		    	System.out.println("Positive Difference");
		    }
		    else {
		    	System.out.println("Negative Difference");
		    }
		    break;
		}
		
		
	}
}
