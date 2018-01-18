package com.demo.study04;

/**
 * @author wei.chen1
 * @since 2018/1/18
 */
public class MsgModel {

	private long sendMsg;

	private long recvMsg;

	public long getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(long sendMsg) {
		this.sendMsg = sendMsg;
	}

	public long getRecvMsg() {
		return recvMsg;
	}

	public void setRecvMsg(long recvMsg) {
		this.recvMsg = recvMsg;
	}

	public void check() {
		if (this.sendMsg == this.recvMsg) {
//			System.out.println("结果正确"+this.sendMsg);
		} else {
			System.out.println("this.sendMsg=" + this.sendMsg + "this.recvMsg=" + this.recvMsg);
		}
	}
}
