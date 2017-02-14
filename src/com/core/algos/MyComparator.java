package com.core.algos;

import java.util.ArrayList;
import java.util.Comparator;

public class MyComparator implements Comparator<ArrayList<Integer>> {

	

	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		// TODO Auto-generated method stub
		
		return -(o1.size() - o2.size());
	}

}
