package com.song.woo;

public interface InterfactDeleteContTabRow {
	/**
	 * 1. map에 key를 담아서 getInfo실행 
	 * 2. Object 리턴
	 * 3. Object json파싱
	 * @return
	 */
	public Object getInfo(DeleteInfo deleteInfo);
	
	public int deleteInfo(DeleteInfo deleteInfo);
	
	public int createInfo(Object obj);
}
