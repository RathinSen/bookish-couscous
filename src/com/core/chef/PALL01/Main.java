package com.core.chef.PALL01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			String s = br.readLine().trim();
			String[] chars = s.split("");
			StringBuffer sb = new StringBuffer();
			for(String _char : chars){
				sb.insert(0, _char);
			}
			if(s.equals(sb.toString())){
				System.out.println("wins");
			}else{
				System.out.println("losses");
			}
			
		}
	}

}
