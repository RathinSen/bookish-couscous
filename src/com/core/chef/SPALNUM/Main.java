package com.core.chef.SPALNUM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String[] tkns = br.readLine().trim().split(" ");
			int l = Integer.parseInt(tkns[0]);
			int r = Integer.parseInt(tkns[1]);
			System.out.println(getSumPal(l,r)); 
			
		}
	}

	private static long getSumPal(int l, int r) {
		// TODO Auto-generated method stub
		ArrayList<Integer> pals = new ArrayList<Integer>();
		int sum = 0;
		while(l<=r){
			if(isPal(l)){
				pals.add(l);
			}
			l++;
		}
		for(Integer pal : pals){
			sum += pal;
		}
		return sum;
	}

	private static boolean isPal(int l) {
		boolean isPal = false;
		String _val = String.valueOf(l);
		if(_val.equals((new StringBuffer(_val)).reverse().toString())){
			isPal = true;
		}
//		String[] s = String.valueOf(l).split("");
//		if(s.length==1)
//			return true;
//		else{
//			StringBuffer sb = new StringBuffer(s);
//			sb.r
//			
//		}
		return isPal;
	}

}
