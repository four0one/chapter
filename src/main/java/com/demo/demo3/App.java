package com.demo.demo3;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {

	public static void main(String[] args) {
		String fileName = "3004-TRDPAYEVE-05-20171101";
		if (fileName.indexOf("-ALEVE") > 0 || fileName.indexOf("-EVE") > 0) {//通过产品编号查询商户号
			String productCode = "";
			//交易明细流水文件接口
			if (fileName.indexOf("-EVE") > 0) {
				System.out.println("productCode = fileName.substring(startSize + 4, startSize + 8);");
				//存管系统交易明细全流水文件接口
			} else if (fileName.indexOf("-ALEVE") > 0) {
				System.out.println("productCode = fileName.substring(startSize + 6, startSize + 10);");
			}

		} else if (fileName.indexOf("TRQTRES") > 0) { //通过合作单位编号查询商户号
			int startSize = fileName.indexOf("TRQTRES-");
			System.out.println("merchantId = dictViewService.getNameByCode(P2pConstants.p2pBatchOpenAcc, conUnitCode + P2pConstants.coinstcode);");
		} else if (fileName.indexOf("REPTRAN-RESULT") > 0 || fileName.indexOf("FINTRAN-RESULT") > 0
				|| fileName.indexOf("TRNCRRES") > 0 || fileName.indexOf("SIGRES") > 0) {//通过p2p平台账号查询商户号
			System.out.println("merchantId = dictViewService.getNameByCode(P2pConstants.p2pBatchOpenAcc, p2pCode + P2pConstants.p2pCode);");

		}
	}

}
