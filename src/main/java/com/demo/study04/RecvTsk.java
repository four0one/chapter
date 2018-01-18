package com.demo.study04;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author wei.chen1
 * @since 2018/1/18
 */
public class RecvTsk implements Runnable{


	private Transceiver transceiver;

	public RecvTsk(Transceiver transceiver) {
		this.transceiver = transceiver;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(RandomUtils.nextLong(1000,10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		transceiver.recive();
	}
}
