package com.demo.study04;

import java.util.concurrent.CountDownLatch;

/**
 * @author wei.chen1
 * @since 2018/1/18
 */
public class MsgTask implements Runnable {

	private Transceiver transceiver;

	public MsgTask(Transceiver transceiver) {
		this.transceiver = transceiver;
	}

	@Override
	public void run() {
		transceiver.send();
	}
}
