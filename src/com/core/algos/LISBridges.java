package com.core.algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LISBridges {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Port> list = new ArrayList<Port>();
		for(int i=0;i<n;i++){
			list.add(new Port(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		lisNlogN(list);
	}

	private static void lisNlogN(ArrayList<Port> list) {
		// TODO Auto-generated method stub
		int[] l = new int[list.size()];
		l[0] = list.get(0).getNorth();
		int len =1;
		for(Port i : list){
			if(i.getNorth()<l[0]){
				l[0] = i.getNorth();
			}
			else if(i.getNorth()>l[len-1]){
				l[len++]=i.getNorth();
			}
			else{
				//replace
				replace(l,0,len-1,i.getNorth());
			}
		}
		System.out.println(len);
	}

	private static void replace(int[] l, int le, int ri, int north) {
		// TODO Auto-generated method stub
		int index = ceilBS(l,le,ri,north);
		l[index] = north;
		
	}

	private static int ceilBS(int[] l, int le, int ri, int north) {
		// TODO Auto-generated method stub
		if(le<ri)
		{
			int mid = le+(ri-le)/2;
			if(l[mid] >= north){
				return ceilBS(l, le, mid, north);
			}
			else{
				return ceilBS(l, mid+1, ri, north);
			}
		}
		else if(le==ri && north <=l[ri]){
			return ri;
		}
		else{
			return -1;
		}
		//return 0;
	}
}
class Port implements Comparable<Port>{
	private int north;
	private int south;
	public int getNorth() {
		return north;
	}
	public void setNorth(int north) {
		this.north = north;
	}
	public int getSouth() {
		return south;
	}
	public void setSouth(int south) {
		this.south = south;
	}
	public Port(int north, int south) {
		super();
		this.north = north;
		this.south = south;
	}
	@Override
	public int compareTo(Port o) {
		// TODO Auto-generated method stub
		return this.south-o.south;
	}
	
}