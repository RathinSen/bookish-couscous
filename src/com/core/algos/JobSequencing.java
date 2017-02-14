package com.core.algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JobSequencing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		Job[] jobs = new Job[n];
		int deadline_max = 0 ;
		for(int i = 0 ; i < n ; i ++){
			String name = sc.next();
			int deadline  = sc.nextInt();
			deadline_max = Integer.max(deadline_max, deadline);
			jobs[i] = new Job(name, deadline, sc.nextInt());
		}
		foundTotalPossibleJobs(jobs, deadline_max);
		sc.close();
		
		
	}

	private static void foundTotalPossibleJobs(Job[] jobs, int deadline_max) {

		int[] p = new int[deadline_max];
		Arrays.sort(jobs);
		for(int i = 0 ; i < jobs.length ; i++)
		{
			System.out.println(jobs[i].getProfit());
		}
		int ans=0;
		for(int i = 0 ; i < jobs.length ; i++){
			if(p[jobs[i].getDeadline()-1]==0){
				p[jobs[i].getDeadline()-1]=1;
				System.out.println(jobs[i].getName());
				ans++;
			}else{
				for(int j = jobs[i].getDeadline()-1; j>=0;j--){
					if(p[j]==0){
						p[j]=1;
						System.out.println(jobs[i].getName());
						ans++;
						break;
					}
				}
			}
			
		}
	}

}
class Job implements Comparable<Job>{
	private int deadline;
	private int profit;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Job(String name, int deadline, int profit) {
		super();
		this.name = name;
		this.deadline = deadline;
		this.profit = profit;
	}
	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return - (this.profit - o.profit);
	}
	
	
}
