package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingON {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<Jobb> jobs = new ArrayList<Jobb>();
		int maxDeadline = 0;
		for(int i = 0 ; i < n ;i ++){
			String[] s = br.readLine().trim().split(" ");
			String name = s[0];
			int dline = Integer.parseInt(s[1]);
			int profit = Integer.parseInt(s[2]);
			jobs.add(new Jobb(name, dline, profit));
			maxDeadline = Integer.max(maxDeadline, profit);
		}
		Collections.sort(jobs, new Jobb());
		findMaxProf(jobs, maxDeadline);
	}

	private static void findMaxProf(ArrayList<Jobb> jobs, int maxDeadline) {
		// TODO Auto-generated method stub
		Disjoint set = new Disjoint(maxDeadline+1);
		int prof=0;
		for(Jobb job :jobs){
			int actualLocation = set.find(job.getDeadline());
			if(actualLocation>0){
				prof+=job.getProfit();
				set.merge(set.find(actualLocation-1), actualLocation);
				System.out.println(job.getJobName());
			}
			
		}
		System.out.println(prof);
		
	}

}
class Disjoint{
	int[] parent;
	
	Disjoint(int n){
		parent =  new int[n];
		for(int i = 0 ; i < n ; i ++){
			parent[i] = i;
		}
	}
	int find(int d){
		if(d==parent[d]){
			return d;
		}
		else{
			return find(parent[d]);
		}
	}
	void merge(int a, int b){
		parent[b] = a;
	}
	
}
class Jobb implements Comparator<Jobb>{
	private String jobName;
	private int deadline;
	private int profit;
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public Jobb(String jobName, int deadline, int profit) {
		super();
		this.jobName = jobName;
		this.deadline = deadline;
		this.profit = profit;
	}
	
	public Jobb() {
		super();
	}
	@Override
	public int compare(Jobb o1, Jobb o2) {
		// TODO Auto-generated method stub
		return -(o1.getProfit() - o2.getProfit());
	}
	
}
