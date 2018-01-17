package com.demo;

public class TxnData {

	private String idTxnCtrl;

	private String OrigIdTxnCtrl;

	private int second;

	private int rowNum;

	public String getIdTxnCtrl() {
		return idTxnCtrl;
	}

	public void setIdTxnCtrl(String idTxnCtrl) {
		this.idTxnCtrl = idTxnCtrl;
	}

	public String getOrigIdTxnCtrl() {
		return OrigIdTxnCtrl;
	}

	public void setOrigIdTxnCtrl(String origIdTxnCtrl) {
		OrigIdTxnCtrl = origIdTxnCtrl;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	@Override
	public String toString() {
		return "TxnData{" +
				"idTxnCtrl='" + idTxnCtrl + '\'' +
				", OrigIdTxnCtrl='" + OrigIdTxnCtrl + '\'' +
				", second=" + second +
				", rowNum=" + rowNum +
				'}';
	}
}
