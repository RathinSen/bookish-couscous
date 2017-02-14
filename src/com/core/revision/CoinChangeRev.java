package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeRev {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(",");
		int v = Integer.parseInt(br.readLine().trim());
		int[] a = new int[s.length];
		for(int i = 0 ; i  <s.length;i++){
			a[i] = Integer.parseInt(s[i].trim());
		}
		calWays(v,a);
	}

	private static void calWays(int v, int[] a) {
		// TODO Auto-generated method stub
		int[][] l = new int[v+1][a.length];
		for(int i = 0 ; i < a.length;i++){
			l[0][i] = 1;
		}
		for(int i = 1; i <=v ;i++){
			for(int j = 0; j < a.length;j++){
				if(i-a[j]>=0){
					if(j==0)
						l[i][j]=l[i-a[j]][j];
					else
						l[i][j] = l[i-a[j]][j] + l[i][j-1];
				}
				else
					l[i][j] = l[i][j-1];
			}
		}
		System.out.println(l[v][a.length-1]);
	}

}
