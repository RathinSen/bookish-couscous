package com.core.algos;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class ActivitySchedUlingGreedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Activity> activities = new ArrayList<Activity>();
		for(int i = 0 ; i < n ;i++){
			activities.add(new Activity(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(activities);
		int lastFinish = 0;
		for(int i = 0 ; i < n ; i++){
			if(lastFinish <= activities.get(i).start){
				lastFinish = activities.get(i).finish;
				System.out.println(i);
			}
		}
	}

}
class Activity implements Comparable<Activity>{
	int start;
	int finish;
	
	public Activity(int start, int finish) {
		super();
		this.start = start;
		this.finish = finish;
	}

	@Override
	public int compareTo(Activity o) {
		// TODO Auto-generated method stub
		
		return this.finish - o.finish;
	}
}
