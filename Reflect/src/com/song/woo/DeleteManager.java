package com.song.woo;

public class DeleteManager  {
	public int createDeleteInfo(DeleteInfo dto) {
		System.out.println(dto.toString()+" ����");
		return 1;
	}
	public DeleteInfo getDeleteInfo(DeleteInfo dto) {
		System.out.println(dto.toString()+" ����");
		return dto;
	}
	
	public int modifyYnResoreToY(DeleteInfo dto) {
		System.out.println(dto.toString()+" ����");
		return 1;
	}
}
