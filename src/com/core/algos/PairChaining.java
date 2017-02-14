package com.core.algos;

import java.util.Scanner;

public class PairChaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] pairs = new Pair[n];
		for(int i = 0; i < n ; i++){
			pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		compute(pairs);
		

	}

	private static void compute(Pair[] pairs) {
		// TODO Auto-generated method stub
		int[] l = new int[pairs.length];
		for(int i = 0 ; i < pairs.length;i++){
			l[i]=1;
		}
		int max =1;
		for(int i =1 ;i< pairs.length;i++){
			for(int j = 0 ; j < i ;j++){
				if(pairs[j].b<pairs[i].a && l[j]+1>l[i]){
					l[i]=l[j]+1;
				}
				max=Integer.max(max, l[i]);
			}
		}
		System.out.println(max);
	}

}
class Pair{
	int a;
	int b;
	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
}
