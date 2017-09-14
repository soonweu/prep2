/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Fall 2017 
// PROJECT:          prep2
// FILE:             RandomNumbers.java
//
// TEAM:    individual
// Authors: Yu Song
// NetID: ysong236@wisc.edu
// CS login: songy@cs.wisc.edu
// How did I become interested in Computer Science:
//    I studied basic programming back in high school and undergrad college, 
// when I thought Computer Science was just about programming to do
// calculations or make games. I am a Civil Engineering major, studying 
// transportation specifically. When I started working on my PhD degree,
// my wife was studying Computer Science for her 2nd bachelor's degree, 
// and she often share the exciting stuff she was studying. From what 
// she told me I found that Computer Science was not just about programming,
// but is a subject that related to almost every fields of modern technology.
// Computer Science is a science subject that can not only help people 
// predict the future, but also investigate the past. While as a researcher
// in an interdisciplinary field, I was amazed by the power and charm of 
// Computer Science, thus decided to learn it and use it. 
//
//////////////////////////// 80 columns wide ////////////////////////////////

import java.util.Scanner;
import java.util.NoSuchElementException;

public class RandomNumbers {
	
	public static final Scanner scnr = new Scanner(System.in);
	public static void main(String[] args){
		
		String[] inElements = new String[3];
		int[] inNums = new int[3];
		int low = 0, high = 0, count = 0, elementInd = 0;
		boolean errFound = false;
		String line;

		line = scnr.nextLine();
		
		if(line.isEmpty()){ // check for empty input
			System.out.println("Usage: three integers required\njava RandomNumbers low high count ");			
			errFound = true;
			
		} else {
			Scanner lineScnr = new Scanner(line);
			
			for(int i=0; i<3; i++) { // check for fewer than 3 input
				try{
					inElements[i] = lineScnr.next();
				} catch(NoSuchElementException e){
					System.out.println("Usage: three integers required\njava RandomNumbers low high count ");
					errFound = true;
				}
			}
			
			while (!errFound && elementInd<3) { // check for non-integer input
				try{
					inNums[elementInd] = Integer.parseInt(inElements[elementInd]);
				} catch(NumberFormatException e){
					System.out.println(inElements[elementInd]+" is not an integer");
					errFound = true;
				}
				elementInd++;
			}
			
			low = inNums[0];
			high = inNums[1];
			count = inNums[2];
			
			if (!errFound && high <= low){ // check for low greater or equals to high
				System.out.println("low must be less than high");
				errFound = true;
			}
			
			lineScnr.close();
		}
		
		if (!errFound){ // no error, present random numbers
			java.util.Random rangen = new java.util.Random(3);
			System.out.print(count+" random values in the range "+low+" to "+high+": ");
			for (int i=0; i<count-1; i++){
				System.out.print((rangen.nextInt(high-low+1)+low)+" ");
			}
			System.out.println(rangen.nextInt(high-low+1)+low);
		}
	}
}
