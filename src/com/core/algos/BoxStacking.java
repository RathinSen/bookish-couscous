package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BoxStacking {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		//Box[] boxes = new Box[3*n];
		ArrayList<Box> boxes  = new ArrayList<Box>();
		for(int i = 0 ; i < n ; i++){
			String[] tkns = br.readLine().trim().split(",");
			int l = Integer.parseInt(tkns[0].trim());
			int b = Integer.parseInt(tkns[1].trim());
			int h = Integer.parseInt(tkns[2].trim());
			boxes.add(new Box(l,b,h));
			boxes.add(new Box(b,h,l));
			boxes.add(new Box(h,l,b));
		}
		Collections.sort(boxes);
		findMaxHeight(boxes);
	}

	private static void findMaxHeight(ArrayList<Box> boxes) {
		// TODO Auto-generated method stub
		int[] l = new int[boxes.size()];
		l[0] = boxes.get(0).getHeight();
		int max = l[0];
		for(int i = 0 ; i < boxes.size() ; i++){
			l[i] = boxes.get(i).getHeight();
			max = Integer.max(max, l[i]);
		}
		for(int i = 1 ; i < boxes.size();i++){
			for(int j = 0 ; j < i ;j++){
				if(boxes.get(j).getLength()  > boxes.get(i).getLength() && boxes.get(j).getBreadth()  > boxes.get(i).getBreadth() && l[i] < l[j]+boxes.get(i).getHeight()){
					l[i] = l[j]+boxes.get(i).getHeight();
					max = Integer.max(max, l[i]);
				}
			}
		}
		System.out.println(max);
	}

}
class Box implements Comparable<Box>{
	private int length;
	private int breadth;
	private int height;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Box(int length, int breadth, int height) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	public int getBaseArea(){
		return this.breadth*this.length;
	}
	@Override
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		return -((this.getBaseArea()) - (o.getBaseArea()));
	}
	
}