package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trial {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		ArrayList<Integer> a  = new ArrayList<Integer>();
		for(int i = 0 ; i < s.length() ;i++){
			//a.add(Integer.parseInt(s[i]));
			System.out.println((int) s.charAt(i));
		}
//		Collections.sort(a,Collections.reverseOrder());
//		for(Integer i  : a){
//			System.out.println(i);
//		}
		
	}

}
