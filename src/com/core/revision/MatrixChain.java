package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixChain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] d = br.readLine().trim().split(",");
		int[] a = new int[d.length];
		for(int i =0 ; i < d.length ; i++){
			a[i] = Integer.parseInt(d[i].trim());
			
		}
		findMinMatrixProduct(a);
	}

	private static void findMinMatrixProduct(int[] a) {
		// TODO Auto-generated method stub
		int noOfMatrix = a.length;
		int[][] l  = new int[noOfMatrix][noOfMatrix];
		for(int i = 1 ; i < noOfMatrix;i++){
			l[i][i] = a[i];
		}
		for(int len=2;len<=noOfMatrix;len++){
			for(int i = 1 ; i<noOfMatrix-len+1;i++){
				int j = i+len-1;
				if(len==2){
					l[i][j] = a[i-1]*a[i]*a[j];
				}else if(len>2){
					l[i][j] = Integer.MAX_VALUE;
					for(int k=i;k<j;k++){
						l[i][j] = Integer.min(l[i][j], a[i-1]*a[k]*l[k+1][j]);
					}
				}
			}
		}
		System.out.println(l[1][a.length-1]);
	}

}
