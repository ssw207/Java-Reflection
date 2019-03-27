package com.song.woo;

public class TradeManager implements InterfactDeleteContTabRow{
	public TradeInfo getTradeInfo(TradeInfo dto) {
		System.out.println(dto.getSeq_trade()+"tradeInfo 炼雀");
		return dto;
	}
	
	public int deleteTradeInfo(TradeInfo dto) {
		System.out.println(dto.getSeq_trade()+" 昏力");
		return 1;
	}
	
	public int createTradeInfo(TradeInfo dto) {
		System.out.println(dto.toString()+"积己");
		return 1;
	}

	@Override
	public Object getInfo(DeleteInfo deleteInfo) {
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setSeq_trade(deleteInfo.getSeq_delete());
		System.out.println("炼雀己傍");
		return getTradeInfo(tradeInfo); 
	}

	@Override
	public int deleteInfo(DeleteInfo deleteInfo) {
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setSeq_trade(deleteInfo.getSeq_delete());
		System.out.println("昏力己傍");
		return deleteTradeInfo(tradeInfo);
	}

	@Override
	public int createInfo(Object obj) {
		TradeInfo tradeInfo= (TradeInfo)obj;
		System.out.println("积己己傍");
		return createTradeInfo(tradeInfo);
	}
}
