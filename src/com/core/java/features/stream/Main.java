package com.core.java.features.stream;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
		
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] words = sc.next().split(",");
		ArrayList<String> s = new ArrayList<String>();
		for(String w : words){
			s.add(w);
		}
		Stream<String> stream = s.stream();
		Stream<String> pStream = s.parallelStream();
		
		//Stream<String> gte =  stream.filter(x -> x.length() >= 4);
		Stream<String> noXXXX= stream.filter(x -> !x.equals("xxxx")).filter(x -> x.length()>=4);
		
		noXXXX.forEach((x) -> System.out.println(x));
		System.out.println();
		//gte.forEach((x) -> System.out.println(x));
		sc.close();
	}

}
