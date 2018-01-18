package com.demo.study04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wei.chen1
 * @since 2018/1/18
 */
public class Transceiver {

	private final ReentrantLock transceiverLock = new ReentrantLock();
	private final Condition respArrive = transceiverLock.newCondition();
	private Queue<Long> resultList = new ConcurrentLinkedQueue<Long>();
	private Queue<Long> sendList = new ConcurrentLinkedQueue<>();

	public void send() {
		transceiverLock.lock();
		try {
			long id = Thread.currentThread().getId();
			sendList.add(id);
			MsgModel model = new MsgModel();
			model.setSendMsg(id);
			respArrive.await();
			model.setRecvMsg(resultList.poll());
			model.check();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transceiverLock.unlock();
		}
	}

	public void recive() {
		transceiverLock.lock();
		Long[] array = sendList.toArray(new Long[]{});
		try {
			resultList.add(array[3]);
			respArrive.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transceiverLock.unlock();
		}
	}

}
