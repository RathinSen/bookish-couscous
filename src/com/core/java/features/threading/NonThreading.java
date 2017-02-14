package com.core.java.features.threading;

public class NonThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter a = new Counter(0, "a");
		Counter b = new Counter(100, "b");
		
		Thread t = new Thread(a);
		Thread t1 = new Thread(b);
		t.start();
		t1.start();
	}

}class Counter implements Runnable{
	private int i;
	private String a;

	public Counter(int i, String a) {
		super();
		this.i = i;
		this.a  = a;
	}
	public void run(){
		for(int j = i ; j<i+100;j++){
			System.out.println(this.a+" "+j);
		}
		
	}
	
}
