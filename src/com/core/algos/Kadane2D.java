package com.core.algos;

import java.util.Arrays;
import java.util.Scanner;

public class Kadane2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] a = new int[r][c];
		int no_negs = 0;
		int max_neg = Integer.MIN_VALUE;
		for(int i = 0 ; i < r ; i ++){
			for(int j= 0; j < c ; j++){
				a[i][j] = sc.nextInt();
				if(a[i][j]<0){
					no_negs++;
					max_neg = Integer.max(max_neg,a[i][j]);
				}
			}
		}
		if(no_negs==r*c){
			System.out.println();
		}
		else
			findMaxSumRectangle(a,r,c);
	}

	private static void findMaxSumRectangle(int[][] a, int r, int c) {
		// TODO Auto-generated method stub
		int max_s_f=0;
		int[][] l = new int[r][c];
		int[] temp;
		for(int left = 0 ; left < c ; left++){
			//reset temp
			temp = new int[r];
			//Arrays.fill(a,0);
//			Arrays.setAll(a, 0);
			for(int right = left ; right < c ; right++){
				for(int i = 0 ; i < r ;i++){
					temp[i] += a[i][right];
				}
				max_s_f=Integer.max(max_s_f,performKadane(temp));
			}
		}
		System.out.println(max_s_f);
	}

	private static int performKadane(int[] temp) {
		// TODO Auto-generated method stub
		int max_s_f = 0;
		int max_here = 0;
		for(int i = 0 ; i < temp.length; i++){
			if(max_here+temp[i]>0){
				max_here +=temp[i];
				max_s_f = Integer.max(max_here, max_s_f);
			}else{
				max_here=0;
			}
		}
		return max_s_f;
	}

}
