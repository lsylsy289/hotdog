package hotdog.admin.code.dao;

public class CodeVo {

	private String codeId; // 코드ID
	private String codeName; // 코드명
	private String upCodeId; // 상위코드ID
	private String rgstUserId; // 등록자ID
	private String rgstUserName; // 등록자명
	private String rgstDate; // 등록일자

	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getUpCodeId() {
		return upCodeId;
	}
	public void setUpCodeId(String upCodeId) {
		this.upCodeId = upCodeId;
	}
	public String getRgstUserId() {
		return rgstUserId;
	}
	public void setRgstUserId(String rgstUserId) {
		this.rgstUserId = rgstUserId;
	}
	public String getRgstUserName() {
		return rgstUserName;
	}
	public void setRgstUserName(String rgstUserName) {
		this.rgstUserName = rgstUserName;
	}
	public String getRgstDate() {
		return rgstDate;
	}
	public void setRgstDate(String rgstDate) {
		this.rgstDate = rgstDate;
	}

	@Override
	public String toString() {
		return "CodeVO [codeId=" + codeId + ", codeName=" + codeName
				+ ", upCodeId=" + upCodeId + ", rgstUserId=" + rgstUserId
				+ ", rgstUserName=" + rgstUserName + ", rgstDate=" + rgstDate
				+ "]";
	}
}
