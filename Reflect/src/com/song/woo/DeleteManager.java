package com.song.woo;

public class DeleteManager  {
	public int createDeleteInfo(DeleteInfo dto) {
		System.out.println(dto.toString()+" 持失");
		return 1;
	}
	public DeleteInfo getDeleteInfo(DeleteInfo dto) {
		System.out.println(dto.toString()+" 持失");
		return dto;
	}
	
	public int modifyYnResoreToY(DeleteInfo dto) {
		System.out.println(dto.toString()+" 持失");
		return 1;
	}
}
