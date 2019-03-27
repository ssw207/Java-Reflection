package com.song.woo;

public class TradeManager implements InterfactDeleteContTabRow{
	public TradeInfo getTradeInfo(TradeInfo dto) {
		System.out.println(dto.getSeq_trade()+"tradeInfo ��ȸ");
		return dto;
	}
	
	public int deleteTradeInfo(TradeInfo dto) {
		System.out.println(dto.getSeq_trade()+" ����");
		return 1;
	}
	
	public int createTradeInfo(TradeInfo dto) {
		System.out.println(dto.toString()+"����");
		return 1;
	}

	@Override
	public Object getInfo(DeleteInfo deleteInfo) {
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setSeq_trade(deleteInfo.getSeq_delete());
		System.out.println("��ȸ����");
		return getTradeInfo(tradeInfo); 
	}

	@Override
	public int deleteInfo(DeleteInfo deleteInfo) {
		TradeInfo tradeInfo = new TradeInfo();
		tradeInfo.setSeq_trade(deleteInfo.getSeq_delete());
		System.out.println("��������");
		return deleteTradeInfo(tradeInfo);
	}

	@Override
	public int createInfo(Object obj) {
		TradeInfo tradeInfo= (TradeInfo)obj;
		System.out.println("��������");
		return createTradeInfo(tradeInfo);
	}
}
