package com.core.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Item> items = new ArrayList<Item>();
		for(int i  = 0 ; i < n ; i++){
			String[] tkns = sc.next().split(",");
			int v = Integer.parseInt(tkns[0]);
			int wi = Integer.parseInt(tkns[1]);
			items.add(new Item(v,wi));
		}
		Collections.sort(items);
		for(Item item : items){
			System.out.println(item.getValbyUnit());
		}
		calProfit(items,w);
	}

	private static void calProfit(ArrayList<Item> items, int w) {
		// TODO Auto-generated method stub
		int profit = 0;
		for(Item item : items){
			if(item.getWeight()<=w){
				w-=item.getWeight();
				profit+=item.getVal();
			}
			else{
				if(w==0){
					break;
				}else{
					double factor = (double)item.getWeight()/w;
					w=0;
					double val = item.getVal()/factor;
					profit +=val;
				}
			
			}
		}
		System.out.println(profit);
	}

}
class Item implements Comparable<Item>{
	private int val;
	private int weight;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Item(int val, int weight) {
		super();
		this.val = val;
		this.weight = weight;
	}
	public double getValbyUnit(){
		return (double) this.val/this.weight;
	}
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return -((int) this.getValbyUnit() - (int) o.getValbyUnit());
	}
	
}