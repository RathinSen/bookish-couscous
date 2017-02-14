package com.core.algos;

import java.util.Scanner;

public class DecimalBinaryConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String binary = toBinary(n);
		System.out.println(binary);
		int back = toDecimal(binary,2);
		System.out.println(back);
		sc.close();
	}

	private static int toDecimal(String binary, int base) {
		// TODO Auto-generated method stub
		int back = 0;
		//String binaryRev = new StringBuffer(binary).reverse().toString();
		for(int i = binary.length() - 1 ; i >= 0; i--){
			back += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(base, i);
		}
		return back;
	}

	private static String toBinary(int n) {
		StringBuffer b = new StringBuffer("");
		while(n>0){
			b.append(n%2);
			n/=2;
		}
		return b.reverse().toString();
	}

}
