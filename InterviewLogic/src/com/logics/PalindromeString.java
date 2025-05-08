package com.logics;

public class PalindromeString {

	public static void main(String[] args) {
		
		//op --> is my mother tongue
		
		String in= "Malayalam is my mother tongue"; //"He did a good deed";  
		
		String[] sp = in.split(" ");
		
		StringBuilder stBuilder = new StringBuilder();
		
		for(int i=0;i<sp.length;i++) {
			
			String  val = stBuilder.append(sp[i]).reverse().toString();
			
			if(!val.toLowerCase().equals(sp[i].toLowerCase())) {
				System.out.print(sp[i]+" ");
			}
		}
		

		
	}
}
