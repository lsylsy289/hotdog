package hotdog.user.ctrl;

public class UserManagementVO {

	private String userSeq;
	private String userId;
	private String userName;
	private String password;
	private String emailAddr;
	private String gender;
	private String rgstDate;
	private String rgstUserId;
	private String updtDate;
	private String updtUserId;
	
	
	public String getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(String userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRgstDate() {
		return rgstDate;
	}
	public void setRgstDate(String rgstDate) {
		this.rgstDate = rgstDate;
	}
	public String getRgstUserId() {
		return rgstDate.isEmpty() ? "admin" : rgstDate;
	}
	public void setRgstUserId(String rgstUserId) {
		this.rgstUserId = rgstUserId;
	}
	public String getUpdtDate() {
		return updtDate.isEmpty() ? "admin" : updtDate;
	}
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}
	public String getUpdtUserId() {
		return updtUserId;
	}
	public void setUpdtUserId(String updtUserId) {
		this.updtUserId = updtUserId;
	}
	
	@Override
	public String toString() {
		return "UserManagementVO [userSeq=" + userSeq + ", userId=" + userId
				+ ", userName=" + userName + ", password=" + password
				+ ", emailAddr=" + emailAddr + ", gender=" + gender
				+ ", rgstDate=" + rgstDate + ", rgstUserId=" + rgstUserId
				+ ", updtDate=" + updtDate + ", updtUserId=" + updtUserId + "]";
	}
}
