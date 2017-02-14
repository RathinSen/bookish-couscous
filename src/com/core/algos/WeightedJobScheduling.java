package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class WeightedJobScheduling {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<WeightedJob> jobs = new ArrayList<WeightedJob>();
		for(int i = 0 ; i < n ;i++){
			String[] tkns = br.readLine().trim().split(",");
			int start = Integer.parseInt(tkns[0]);
			int end = Integer.parseInt(tkns[1]);
			int profit = Integer.parseInt(tkns[2]);
			jobs.add(new WeightedJob(start, end, profit));
		}
		Collections.sort(jobs);
		performLISNlogn(jobs);
	}

	private static void performLISNlogn(ArrayList<WeightedJob> jobs) {
		// TODO Auto-generated method stub
		int mx_sf = jobs.get(0).getProfit();
		int[] mx = new int[jobs.size()];
		int[] la = new int[jobs.size()];
		int[] en = new int[jobs.size()];
		int len=1;
		mx[0] = la[0] = jobs.get(0).getProfit();
		en[0] = jobs.get(0).getEnd();
		for(int i = 1 ; i < jobs.size() ; i++){
			if(jobs.get(i).getStart()>en[len-1]){
				en[len] = jobs.get(i).getEnd();
				mx[len] = jobs.get(i).getProfit() + mx[len-1];
				la[len] = jobs.get(i).getProfit();
			}
			//else if(jobs.get(i).getEnd()>en[len-1])
		}
	}

}
class WeightedJob implements Comparable<WeightedJob>{
	private int start;
	private int end;
	private int profit;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public WeightedJob(int start, int end, int profit) {
		super();
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
	@Override
	public int compareTo(WeightedJob o) {
		// TODO Auto-generated method stub
		return this.end - o.end;
	}
	
}