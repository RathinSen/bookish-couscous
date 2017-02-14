package com.core.java.features.revision.stream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split(",");
		ArrayList<String> list = new ArrayList<String>();
		for(String ss : s){
			list.add(ss);
		}
		Stream<String> fList = list.stream().filter((x) -> x.length()==4).filter((x) -> x.contains("abc"));
		fList.forEach((e) -> System.out.println(e));
		
		sc.close();
	}

}
