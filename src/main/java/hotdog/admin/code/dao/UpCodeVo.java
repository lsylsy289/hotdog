package hotdog.admin.code.dao;

public class UpCodeVo {

	private String upCodeId; // 상위코드ID
	private String upCodeName; // 상위코드명
	private String rgstUserId; // 등록자ID
	private String rgstUserName; // 등록자명
	private String rgstDate; // 등록일자

	public String getUpCodeId() {
		return upCodeId;
	}
	public void setUpCodeId(String upCodeId) {
		this.upCodeId = upCodeId;
	}
	public String getUpCodeName() {
		return upCodeName;
	}
	public void setUpCodeName(String upCodeName) {
		this.upCodeName = upCodeName;
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
		return "UpCodeVO [upCodeId=" + upCodeId + ", upCodeName=" + upCodeName
				+ ", rgstUserId=" + rgstUserId + ", rgstUserName="
				+ rgstUserName + ", rgstDate=" + rgstDate + "]";
	}
}
