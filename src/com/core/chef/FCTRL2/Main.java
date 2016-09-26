/**
 * 
 */
package com.core.chef.FCTRL2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Thync
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(t-->0){
			list.add(sc.nextInt());
		}
		for(Integer i : list)
		{
			//System.out.println(fact(i));
			System.out.println(factViaDP(i));
//			int f = 2000000000;
//			System.out.println(f);
//			System.out.println(f+1);
		}
		
	}

	private static BigInteger factViaDP(Integer i) {
		if(i==1 || i==0)
			return BigInteger.valueOf(i);
		else{
			BigInteger[] factOf_i = new BigInteger[i]; 
			factOf_i[0] = BigInteger.valueOf(1);
			int j =1;
			while(j<i){
				factOf_i[j] =BigInteger.valueOf(j+1).multiply(factOf_i[j-1]);
				j++;
			}
			return factOf_i[i-1];
		}
		
	}

	private static BigInteger fact(Integer i) {
		if(i==1 || i==0)
			return BigInteger.valueOf(i);
		else{
			return BigInteger.valueOf(i).multiply(fact(i-1));
		}
	}

}
