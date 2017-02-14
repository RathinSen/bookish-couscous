package com.core.java.features.threading;

public class Threading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread a = new Thread(()->{
			for(int i = 0 ; i<100;i++){
				System.out.println("Thread a "+i);
				try {
					throw new Exception("what the hell");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());;
				}
			}
		});
		Thread b = new Thread(()->{
			for(int j = 100 ; j < 200 ;j++){
				System.out.println("Thread b "+j);
			}
		});
		a.start();
		b.start();
	}
	

}
