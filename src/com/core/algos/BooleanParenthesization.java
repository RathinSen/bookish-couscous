package com.core.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooleanParenthesization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] oprnds = br.readLine().trim().split(",");
		String[] oprtrs = br.readLine().trim().split(",");
		findMaxWays(oprtrs, oprnds);
	}

	private static void findMaxWays(String[] opxn, String[] opnds) {
		int[][] w = new int[opnds.length][opnds.length];
		boolean[][] b = new boolean[opnds.length][opnds.length];
		//&,|,^
		for(int i = 0 ; i < opnds.length ; i++){
			if(opnds[i].equals("T"))
			{
				b[i][i] = true;
				w[i][i] = 1;
			}
		}
		for(int len = 2 ; len<=opnds.length;len++){
			for(int i = 0 ; i < opnds.length-len+1;i++){
				int j = i + len - 1;
				boolean i_op = opnds[i].equals("T")?true:false;
				boolean j_op = opnds[j].equals("T")?true:false;
				if(len==2){
					if(opxn[i].equals("|")){
						b[i][j] = i_op || j_op;
					}
					else if(opxn[i].equals("&")){
							b[i][j]	= i_op && j_op;			
					}
					else if(opxn[i].equals("^")){
						b[i][j] = i_op ^ j_op;
					}
					
					if(b[i][j]){
						w[i][j] = 1;
					}
					
				}
				else{
					for(int k=i; k<j;k++){
						boolean v = false;
						if(opxn[k].equals("|")){
							v = b[i][k] || b[k+1][j];
						}
						else if(opxn[k].equals("&")){
							v = b[i][k] && b[k+1][j];
						}
						else if(opxn[k].equals("^")){
							v = b[i][k] ^ b[k+1][j];
						}
						if(v){
							if(w[i][k]*w[k+1][j]==0){
								w[i][j]+=w[i][k] + w[k+1][j];
							}
							else{
								w[i][j]+=w[i][k]*w[k+1][j];
							}
							
						}
					}
				}
			}
			
		}
		System.out.println(w[0][opnds.length-1]);
		
	}

}
