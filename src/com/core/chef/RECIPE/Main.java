package com.core.chef.RECIPE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> primes= getAllPrimesUpto(1000);
//		for(Integer prime:primes){
//			System.out.println(prime);
//		}
		int t = Integer.parseInt(br.readLine());
		int[] a; 
		while(t-->0){
			String[] tokens = br.readLine().trim().split(" ");
			int noOfIngredients = Integer.parseInt(tokens[0]);
			int biggestNumber = 0;
			int smallestNumber = 0;
			a = new int[noOfIngredients];
			int i = 0;
			int j = 1;
			while(j<=noOfIngredients){
				a[i++] = Integer.parseInt(tokens[j]);
				biggestNumber=Integer.max(biggestNumber, Integer.parseInt(tokens[j++]));
			}
			PerformHCF(a, primes, biggestNumber);
			System.out.println();
		}
	}

	private static void PerformHCF(int[] a, ArrayList<Integer> primes,
			int biggestNumber) {
		for(Integer prime : primes){
			if(prime > biggestNumber){
				break;
			}
			reduction(a, prime);
		}
		
		for(int i : a){
			System.out.print(i+" ");
		}
	}

	private static void reduction(int[] a, Integer prime) {
		int[] b = new int[a.length];
		int i = 0;
		boolean onceMore = true;
		while(i<a.length){
			if(a[i]%prime!=0){
				onceMore =false;
				break;
			}else{
				b[i]=a[i]/prime;
			}
			i++;
		}
		
		if(onceMore){
			i=0;
			while(i<a.length){
				a[i] = b[i];
				i++;
			}
			reduction(a, prime);
		}
	}

	private static ArrayList<Integer> getAllPrimesUpto(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int[] prime_helper = new int[n+1];
		prime_helper[0]=prime_helper[1]=1;
		for(int i = 2 ; i<=n; i++){
			if(prime_helper[i]==0){
				primes.add(i);
				markNonPrimes(prime_helper, i);
			}
		}
		return primes;
	}

	private static void markNonPrimes(int[] prime_helper, int i) {
		int j = 2;
		while(i*j<prime_helper.length){
			prime_helper[i*j]=1;
			j++;
		}
	}

}
