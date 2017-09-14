import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class RandomNumbers {
	public static final Scanner scnr = new Scanner(System.in);
	public static final Random rangen = new Random();
	public static void main(String[] args){
		String[] inElements = new String[3];
		int[] inNums = new int[3];
		int low, high, count;
		String line;
		System.out.print("java RandomNumbers ");
		line = scnr.nextLine();
		
		while(line.isEmpty()){
			System.out.print("Usage: three integers required\njava RandomNumbers low high count ");			
			line = scnr.nextLine();
		}
		Scanner lineScnr = new Scanner(line);
		
			for(int i=0; i<3; ++i){
				try{
					inNums[i] = lineScnr.nextInt();
				} catch(NoSuchElementException e){
					System.out.print("Usage: three integers required\njava RandomNumbers low high count ");
					line = scnr.nextLine();
				} 
				
			}
		
			for(int i=0; i<3; ++i){
				try{
					inNums[i]=Integer.parseInt(inElements[i]);
				} catch(NumberFormatException e){
					System.out.print(inElements[i]+" is not an integer");
					line = scnr.nextLine();
				}
			}
		
		

		
//		low = scnr.nextInt();
//		high = scnr.nextInt();
//		count = scnr.nextInt();
		
		
		
	}
	
}
