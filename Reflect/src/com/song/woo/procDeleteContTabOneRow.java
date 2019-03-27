package com.song.woo;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class procDeleteContTabOneRow {
	
	public static void main(String[] args) {
		DeleteInfo deleteInfo = new DeleteInfo();
		deleteInfo.setSeq_delete("2");
		deleteInfo.setInfomation_delte("{\"seq_trade\":\"1\", \"no_contract\":\"13\"}");
		
//		deleteContTabRow(deleteInfo);
		
		resotreContTabRow(deleteInfo);
	}
	
	public static void deleteContTabRow(DeleteInfo deleteInfo) {
		DeleteManager deleteManger = new DeleteManager();
		
		String classPath = "com.song.woo.TradeManager";
		
		deleteInfo.setInfomation_delte(toJson(dynamicRunMethod(classPath).getInfo(deleteInfo)));
		if( 1 == deleteManger.createDeleteInfo(deleteInfo) ) {
			if( 1 == dynamicRunMethod(classPath).deleteInfo(deleteInfo) ) {
				System.out.println("삭제 전체 성공");
			}
		}
	}
	
	public static void resotreContTabRow(DeleteInfo deleteInfo) {
		DeleteManager deleteManger = new DeleteManager();

		String classPath = "com.song.woo.TradeManager";
		String voPath = "com.song.woo.TradeInfo";
		
		// 조회
		DeleteInfo getDeleteInfo= deleteManger.getDeleteInfo(deleteInfo);
		// json -> dto 변경
		Object information_delete = jsonToVo(getDeleteInfo.getInfomation_delte(), voPath);
		// 복구
		if( 1 == dynamicRunMethod(classPath).createInfo(information_delete) ) {
			System.out.println("저장 성공");
			if ( 1 == deleteManger.modifyYnResoreToY(deleteInfo)) {
				System.out.println("복구 성공");
			}
		}
	}
	
	// 복구
	// getDeletInfo
	// insert
	
	//////////////////////////// manager ////////////////////////
	/**
	 * 매서드 클래스명과 , key가 담긴 vo객체를 전달하면 매서드를 실행
	 * @param classPath 매서드 클래스 경로 
	 * @param methodName 동작할 매서드 이름 ex) getInfo 정보조회, deleteInfo정보삭제
	 * @param deleteInfo 값을 전달할 객체
	 * @return
	 * @throws Exception
	 */
	public static InterfactDeleteContTabRow dynamicRunMethod(String classPath) {
		System.out.println("동적 조회 시작");
		
		InterfactDeleteContTabRow c = null;
			// 매서드 클래스(파일경로)
			try {
				c = (InterfactDeleteContTabRow)Class.forName(classPath).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("매서드 동적 실행 실패");
			}
		return c;
	}
	
	private static String toJson(Object obj ) {
		ObjectMapper om = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = om.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("vo -> json파싱에러");
		}
		return jsonStr;
	}
	
	private static Object jsonToVo(String json, String voPath ) {
		ObjectMapper om = new ObjectMapper();
			Object vo = null;
			try {
			 	vo = om.readValue(json, Class.forName(voPath));
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				System.out.println("json -> Vo 파싱에러");
			}
		return vo;
	}
	
	
	
}
