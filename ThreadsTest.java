package com.java.eight;

import org.junit.jupiter.api.Test;

class ThreadsTest {

	@Test
	void firstTest() {

		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		Thread tt=new Thread(()-> System.out.println("tt"));
		
	
		Runnable r=()->{
			System.out.println("runnable");
		};
		
		Thread t1=new Thread(r);
		
	}

}
