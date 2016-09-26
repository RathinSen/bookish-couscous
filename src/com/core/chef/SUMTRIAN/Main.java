package com.core.chef.SUMTRIAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//int t = Integer.parseInt(br.readLine().trim());
		int t = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(t-->0){
			//int n = Integer.parseInt(br.readLine().trim());
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			//Arrays.fill(a, 0);
			String[] tokens = null;
			for(int i=0;i<n;i++){
				//tokens = br.readLine().trim().split(" ");
				for(int j=0;j<=i;j++){
					//a[i][j] = Integer.parseInt(tokens[j]);
					a[i][j] = sc.nextInt();
				}
			}
			list.add(calBestPath(a, n));
		}
		for(Integer i : list){
			System.out.println(i);
		}
	}

	private static int calBestPath(int[][] a,int n) {
		// TODO Auto-generated method stub
		int[][] b = new int[n][n];
		b[0][0] = a[0][0];
		int max_sum = 0;
		for(int i=1;i<n;i++){
			for(int j=0;j<=i;j++){
				if(j==0){
					b[i][j] = a[i][j] + b[i-1][j];
				}else if(j==i){
					b[i][j]  = a[i][j] + b[i-1][j-1];
				}else{
					b[i][j] = a[i][j] + Integer.max(b[i-1][j], b[i-1][j-1]);
				}
				if(b[i][j]>max_sum){
					max_sum = b[i][j];
				}		
			}
		}
		//System.out.println(max_sum);
		return max_sum;
	}

}
