package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadane {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String[] tkns = br.readLine().trim().split(",");
		int[] a = new int[tkns.length];
		int all_neg = 0;
		int smallest = Integer.MIN_VALUE;
		for(int i = 0 ; i < tkns.length; i++){
			  int x = Integer.parseInt(tkns[i].trim());
			  if(x<0){
				  all_neg++;
				  smallest = Integer.max(smallest, x);
			  }
			  a[i] = x;
		}
		if(all_neg==tkns.length){
			System.out.println(smallest);
		}
		else{
			int max_sf=0;
			int max_end=0;
			for(int i = 0 ; i < tkns.length ; i++){
				if(a[i]+max_end>0){
					max_end  = a[i]+max_end;
					max_sf = Integer.max(max_sf, max_end);
				}
				else{
					max_end = 0;
				}
			}
			System.out.println(max_sf);
		}
	}

}
