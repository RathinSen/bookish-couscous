package com.core.chef.LCH15JAB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
			int sumOfOthers = 0;
			int max_occurence = 0;
			int max_occurence_char_index = 0 ;
			int[] alphabets = new int[26];
			char[] s = br.readLine().trim().toCharArray();
			for(char _char : s){
				int ascii = _char;
				alphabets[ascii%97]+=1;
				if(alphabets[ascii%97]>max_occurence){
					max_occurence = alphabets[ascii%97];
					max_occurence_char_index  = ascii%97;
				}
			}
			
			for(int i=0;i<26;i++){
				if(i == max_occurence_char_index){
					continue;
				}
				sumOfOthers+=alphabets[i];
			}
			if(sumOfOthers==max_occurence){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
