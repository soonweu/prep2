import java.util.Scanner;
import java.util.NoSuchElementException;
public class RandomNumbers {
	public static final Scanner scnr = new Scanner(System.in);
	public static void main(String[] args){
		String[] inElements = new String[3];
		int[] inNums = new int[3];
		int low=0, high=0, count=0, elementInd;
		boolean errFound;
		
		do{
			String line;
			elementInd=0;
			errFound=false;
			
			System.out.print("java RandomNumbers ");
			line = scnr.nextLine();

			if(line.isEmpty()){
					System.out.println("Usage: three integers required\njava RandomNumbers low high count ");			
					System.out.println();
					errFound=true;
			} else {
			
			Scanner lineScnr = new Scanner(line);

			for(int i=0; i<3; ++i) {
				try{
					inElements[i] = lineScnr.next();
				} catch(NoSuchElementException e){
					System.out.println("Usage: three integers required\njava RandomNumbers low high count ");
					System.out.println();
					errFound=true;
				}
			}

			while (!errFound && elementInd<3) {
				try{
					inNums[elementInd]=Integer.parseInt(inElements[elementInd]);
				} catch(NumberFormatException e){
					System.out.println(inElements[elementInd]+" is not an integer");
					System.out.println();
					errFound=true;
				}
				elementInd++;
			}

			low = inNums[0];
			high = inNums[1];
			count = inNums[2];

			if (!errFound && high<=low){
				System.out.println("low must be less than high");
				System.out.println();
				errFound=true;
			}
			
			lineScnr.close();
			}
			
		} while(errFound);
		
		java.util.Random rangen = new java.util.Random(3);
		System.out.print(count+" random values in the range "+low+" to "+high+": ");
		for (int i=0; i<count-1; i++){
			System.out.print((rangen.nextInt(high-low+1)+low)+" ");
		}
		System.out.println(rangen.nextInt(high-low+1)+low);
		
	}
	
}
