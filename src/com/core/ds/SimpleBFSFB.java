package com.core.ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SimpleBFSFB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		String[] relation = new String[r];
		int[] dn = new int[26];
		for(int i = 0 ; i<r;i++){
			relation[i] = sc.next();
			String[] nodes = relation[i].split("-");
			int s = nodes[0].charAt(0) - 'a';
			int d = nodes[1].charAt(0) - 'a';
			dn[s]  = 1;
			dn[d]  = 1;
			//m[s][d] = m[d][s] = 1;
		}
		int dnc = 0;
		for(int i = 0 ; i <26;i++){
			dnc+=dn[i];
		}
		int[][] m = new int[dnc][dnc];
		for(int i = 0 ; i <relation.length;i++){
			String[] nodes = relation[i].split("-");
			int s = nodes[0].charAt(0) - 'a';
			int d = nodes[1].charAt(0) - 'a';
			m[s][d] = m[d][s] = 1;
		}
		String[] p = sc.next().trim().split(",");
		int a  = p[0].charAt(0) - 'a';
		int b  = p[1].charAt(0) - 'a';
		performBfs(m,a,b);
		sc.close();
	}

	private static void performBfs(int[][] m, int a, int b) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int len = m.length;
		boolean[] v = new boolean[len];
		Arrays.fill(v, false);
		queue.add(a);
		while(!queue.isEmpty()){
			int x = queue.poll();
			if(x==b){
				System.out.println("found");
				return;
			}
			int i = 0;
			while(i<len){
				if(m[x][i]==1 && v[i]==false){
					v[i]=true;
					queue.add(i);
				}
				i++;
			}
		}
		System.out.println("not found");
	}

}
