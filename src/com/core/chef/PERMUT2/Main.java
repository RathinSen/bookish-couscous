/**
 * 
 */
package com.core.chef.PERMUT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author Thync
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0){
				break;
			}else{
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				String[] tokens = br.readLine().trim().split(" ");
				int index = 1;
				for(String s : tokens){
					map.put(Integer.parseInt(s), index++);
				}
				boolean ambiguous = checkAmbiguity(map, n);
				if(ambiguous){
					System.out.println("ambiguous");
				}else{
					System.out.println("not ambiguous");
				}
			}
		}
	}

	private static boolean checkAmbiguity(HashMap<Integer, Integer> map, int n) {
		for(int i = 1 ; i <=n ;i++){
			int val = map.get(i);
			if(map.get(val)!=i){
				return false;
			}
		}
		return true;
	}

	

}
