package com.demo.study04;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wei.chen1
 * @since 2018/1/18
 */
public class AppMain {

	public static void main(String[] args) throws InterruptedException {

		Transceiver transceiver = new Transceiver();

		Runnable target = new MsgTask(transceiver);
		Thread t1;
		for (int i = 0; i < 100; i++) {
			t1 = new Thread(target);
			t1.start();
		}
/*
		Runnable recvRnb = new RecvTsk(transceiver);
		ExecutorService recvThreadPool = Executors.newFixedThreadPool(10);
		while (true) {
			recvThreadPool.execute(recvRnb);
		}*/

		transceiver.recive();
		while(true){

		}
	}
}
