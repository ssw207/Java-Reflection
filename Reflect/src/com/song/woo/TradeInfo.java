package com.song.woo;

public class TradeInfo {
	private String seq_trade;
	private String no_contract;
	
	
	public String getNo_contract() {
		return no_contract;
	}

	public void setNo_contract(String no_contract) {
		this.no_contract = no_contract;
	}

	public String getSeq_trade() {
		return seq_trade;
	}

	public void setSeq_trade(String seq_trade) {
		this.seq_trade = seq_trade;
	}

	@Override
	public String toString() {
		return "TradeInfo [seq_trade=" + seq_trade + ", no_contract=" + no_contract + "]";
	}
	
}
