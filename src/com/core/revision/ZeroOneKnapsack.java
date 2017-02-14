package com.core.revision;

import java.util.Scanner;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		Item[] a = new Item[n];
		for(int  i = 0 ; i < n ; i++){
			a[i] = new Item(sc.nextInt(),sc.nextInt());
		}
		findMaxProfit(a,w);
		sc.close();
	}

	private static void findMaxProfit(Item[] a, int w) {
		// TODO Auto-generated method stub
		int[][] l = new int[w+1][a.length+1];
		for(int i = 1 ; i <=w;i++){
			for(int j = 1 ; j <=a.length;j++){
				if(i-a[j-1].getWeight()>=0){
					l[i][j] = Integer.max(l[i][j-1], a[j-1].getProfit()+l[i-a[j-1].getWeight()][j-1]);
				}
				else{
					l[i][j] = l[i][j-1];
				}
			}
			
		}
		System.out.println(l[w][a.length]);
	}

}
class Item{
	private int weight;
	private int profit;
	public Item(int weight, int profit) {
		super();
		this.weight = weight;
		this.profit = profit;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}