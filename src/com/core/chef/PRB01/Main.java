package com.core.chef.PRB01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> primes = generatePrimesUpto(100000);
//		for(Integer prime : primes){
//			System.out.println(prime);
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			boolean isPrime = bs(Integer.parseInt(br.readLine().trim()), primes, 0, primes.size()-1);
			if(isPrime){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
		
	}

	private static boolean bs(int no, ArrayList<Integer> primes, int l, int r) {
		if(l<=r){
			int mid = (l+r)/2;
			if(primes.get(mid)==no){
				return true;
			}else if(primes.get(mid)>no){
				return bs(no, primes, l, mid-1);
			}else{
				return bs(no, primes, mid+1, r);
			}
		}
		return false;
	}

	private static ArrayList<Integer> generatePrimesUpto(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int[] prime_helper = new int[n+1];
		prime_helper[0]=prime_helper[1]=1;
		for(int i = 2 ; i <=n ;i++){
			if(prime_helper[i]==0){
				markAllNonPrimes(i, prime_helper);
				primes.add(i);
			}
		}
		return primes;
	}

	private static void markAllNonPrimes(int a, int[] prime_helper) {
		int i = 2;
		while(a*i<prime_helper.length){
			prime_helper[a*i]=1;
			i++;
		}
	}

}
