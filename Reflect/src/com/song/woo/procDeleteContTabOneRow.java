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
				System.out.println("���� ��ü ����");
			}
		}
	}
	
	public static void resotreContTabRow(DeleteInfo deleteInfo) {
		DeleteManager deleteManger = new DeleteManager();

		String classPath = "com.song.woo.TradeManager";
		String voPath = "com.song.woo.TradeInfo";
		
		// ��ȸ
		DeleteInfo getDeleteInfo= deleteManger.getDeleteInfo(deleteInfo);
		// json -> dto ����
		Object information_delete = jsonToVo(getDeleteInfo.getInfomation_delte(), voPath);
		// ����
		if( 1 == dynamicRunMethod(classPath).createInfo(information_delete) ) {
			System.out.println("���� ����");
			if ( 1 == deleteManger.modifyYnResoreToY(deleteInfo)) {
				System.out.println("���� ����");
			}
		}
	}
	
	// ����
	// getDeletInfo
	// insert
	
	//////////////////////////// manager ////////////////////////
	/**
	 * �ż��� Ŭ������� , key�� ��� vo��ü�� �����ϸ� �ż��带 ����
	 * @param classPath �ż��� Ŭ���� ��� 
	 * @param methodName ������ �ż��� �̸� ex) getInfo ������ȸ, deleteInfo��������
	 * @param deleteInfo ���� ������ ��ü
	 * @return
	 * @throws Exception
	 */
	public static InterfactDeleteContTabRow dynamicRunMethod(String classPath) {
		System.out.println("���� ��ȸ ����");
		
		InterfactDeleteContTabRow c = null;
			// �ż��� Ŭ����(���ϰ��)
			try {
				c = (InterfactDeleteContTabRow)Class.forName(classPath).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("�ż��� ���� ���� ����");
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
			System.out.println("vo -> json�Ľ̿���");
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
				System.out.println("json -> Vo �Ľ̿���");
			}
		return vo;
	}
	
	
	
}
