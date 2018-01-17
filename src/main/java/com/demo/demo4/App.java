package com.demo.demo4;

public class App {

	public static void main(String[] args) {
		String str = "http response:A001380102600700000000735544022017121410191420171214101914264            abcdev���ճɹ�      0     0         0<?xml version=\"1.0\" encoding=\"GBK\"?><Result><Reserve>2</Reserve></Result>";
		String substring = str.substring(87,93);
		System.out.println(substring);
	}
}
