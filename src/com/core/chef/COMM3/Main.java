package com.core.chef.COMM3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			int range = Integer.parseInt(br.readLine().trim());
			String[] chef_coordinates_string = br.readLine().trim().split(" ");
			String[] souss_coordinates_string = br.readLine().trim().split(" ");
			String[] headServer_coordinates_string = br.readLine().trim().split(" ");
			Coordinates chef = new Coordinates(chef_coordinates_string[0], chef_coordinates_string[1]);
			Coordinates souss = new Coordinates(souss_coordinates_string[0], souss_coordinates_string[1]);
			Coordinates headServer = new Coordinates(headServer_coordinates_string[0], headServer_coordinates_string[1]);
			boolean isNearby = isNearby(chef, souss, headServer, range);
			if(isNearby){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}
	}

	private static boolean isNearby(Coordinates chef, Coordinates souss,
			Coordinates headServer, int range) {
		boolean isNearby = false;
		boolean chef_and_headServer = false;
		boolean chef_and_souss = false;
		//boolean souss_and_headServer = false;
		if(range>=Math.sqrt(Math.pow(chef.getX() - headServer.getX(), 2)+Math.pow(chef.getY() - headServer.getY(), 2))){
			chef_and_headServer = true;
		}
		if(range>=Math.sqrt(Math.pow(chef.getX() - souss.getX(), 2)+Math.pow(chef.getY() - souss.getY(), 2))){
			chef_and_souss = true;
		}
		
		if(chef_and_headServer && chef_and_souss){
			isNearby = true;
		}else if(!chef_and_headServer && !chef_and_souss){
			isNearby = false;
		}else if(range>=Math.sqrt(Math.pow(headServer.getX() - souss.getX(), 2)+Math.pow(headServer.getY() - souss.getY(), 2))){
			isNearby = true;
		}
		return isNearby;
	}

}

class Coordinates{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Coordinates(String x, String y) {
		super();
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
}
