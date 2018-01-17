package com.demo.study02;

import java.io.IOException;

/**
 * @author wei.chen1
 * @since 2018/1/15
 */
public class KryoUtilsTest {

	public static void main(String[] args) {
		KryoUtils utils = new KryoUtils();
		try {
			utils.encode();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
