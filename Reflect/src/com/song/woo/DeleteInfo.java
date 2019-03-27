package com.song.woo;

public class DeleteInfo {
	private String seq_delete;
	private String cd_type_delete;
	private String Infomation_delte;
	
	
	public String getInfomation_delte() {
		return Infomation_delte;
	}

	public void setInfomation_delte(String infomation_delte) {
		Infomation_delte = infomation_delte;
	}

	public String getCd_type_delete() {
		return cd_type_delete;
	}

	public void setCd_type_delete(String cd_type_delete) {
		this.cd_type_delete = cd_type_delete;
	}

	public String getSeq_delete() {
		return seq_delete;
	}

	public void setSeq_delete(String seq_delete) {
		this.seq_delete = seq_delete;
	}

	@Override
	public String toString() {
		return "DeleteInfo [seq_delete=" + seq_delete + ", cd_type_delete=" + cd_type_delete + ", Infomation_delte="
				+ Infomation_delte + "]";
	}
	
}
