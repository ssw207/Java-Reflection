package com.song.woo;

public interface InterfactDeleteContTabRow {
	/**
	 * 1. map�� key�� ��Ƽ� getInfo���� 
	 * 2. Object ����
	 * 3. Object json�Ľ�
	 * @return
	 */
	public Object getInfo(DeleteInfo deleteInfo);
	
	public int deleteInfo(DeleteInfo deleteInfo);
	
	public int createInfo(Object obj);
}
