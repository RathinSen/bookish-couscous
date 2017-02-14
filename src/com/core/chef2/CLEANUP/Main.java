package com.core.chef2.CLEANUP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String[] va = br.readLine().trim().split(" ");
			int n = Integer.parseInt(va[0].trim());
			int m = Integer.parseInt(va[1].trim());
			int[] jobs = new int[n+1];
			String[] finishedJobs = br.readLine().trim().split(" "); 
			for(int i = 0; i<m ; i++){
				int j = Integer.parseInt(finishedJobs[i].trim());
				jobs[j] = 1 ; 
			}
			printAnsForBothChefs(jobs);
		}
	}

	private static void printAnsForBothChefs(int[] jobs) {
		ArrayList<Integer> chef = new ArrayList<Integer>();
		ArrayList<Integer> ast = new ArrayList<Integer>();
		for(int i = 1; i < jobs.length; i++){
			if(jobs[i]==1){
				continue;
			}else{
				if(i%2==0){
					ast.add(i);
				}else{
					chef.add(i);
				}
			}
		}
		chef.forEach(i -> System.out.println(i));
		ast.forEach(i -> System.out.println(i));
	}
}
