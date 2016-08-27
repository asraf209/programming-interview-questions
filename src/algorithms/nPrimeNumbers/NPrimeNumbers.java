package algorithms.nPrimeNumbers;

import java.util.Scanner;

public class NPrimeNumbers {
	
	public static boolean isPrime(int num){
		if(num<1)	return false;
		if(num<4)	return true;
		
		if(num%2==0)	return false;
		
		for(int n=3; (n*n)<=num; n+=2){
			if(num%n==0)	return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
				
	}

}
