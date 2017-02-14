package com.core.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BoxStackingProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<Box> boxes = new ArrayList<Box>();
		for(int i = 0 ; i < n ; i++){
			String[] tkns = br.readLine().trim().split(",");
			int h = Integer.parseInt(tkns[0]);
			int l = Integer.parseInt(tkns[1]);
			int b = Integer.parseInt(tkns[2]);
			boxes.add(new Box(h,l,b));
			boxes.add(new Box(l,b,h));
			boxes.add(new Box(b,h,l));
		}
		Collections.sort(boxes);
		maxHeight(boxes);
		
	}

	private static void maxHeight(ArrayList<Box> boxes) {
		// TODO Auto-generated method stub
		int maxHeight = 0;
		int[] h = new int[boxes.size()];
		h[0] = boxes.get(0).getH();
		for(int i = 1 ; i <boxes.size();i++){
			h[i] = boxes.get(i).getH();
			for(int j = 0 ;j < i ; j++){
				if(boxes.get(i).getB()<boxes.get(j).getB() && boxes.get(i).getL()<boxes.get(j).getL() && h[i]<h[j]+boxes.get(i).getH())
				{
					h[i] = h[j] + boxes.get(i).getH();
					maxHeight = Integer.max(maxHeight, h[i]);
				}
			}
		}
		System.out.println(maxHeight);
	}

}
class Box implements Comparable<Box>{
	private int h;
	private int l;
	private int b;
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public Box(int h, int l, int b) {
		super();
		this.h = h;
		this.l = l;
		this.b = b;
	}
	@Override
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		
		return -(this.b*this.l - o.b*o.l);
	}
}
