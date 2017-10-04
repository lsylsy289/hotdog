package hotdog.user.vo;

public class UserVO {

	private int userSeq; // 사용자 순번
	private String userId; // 사용자ID
	private String userName; // 사용자명
	private String passwd; // 비밀번호
	private String emailAddr; // 이메일주소
	private String gender; // 성별
	private String postCode; // 우편번호
	private String addrs; // 주소
	private String addrsDtl; // 주소상세
	private String phoneNo; // 핸드폰번호
	private String birthDay; // 생년월일
	private String rgstDate; // 등록일자
	private String rgstUserId; // 등록사용자ID
	private String updtDate; // 수정일자
	private String updtUserId; // 수정사용자ID
	
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String zip) {
		this.postCode = zip;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getAddrsDtl() {
		return addrsDtl;
	}
	public void setAddrsDtl(String addrsDtl) {
		this.addrsDtl = addrsDtl;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getRgstDate() {
		return rgstDate;
	}
	public void setRgstDate(String rgstDate) {
		this.rgstDate = rgstDate;
	}
	public String getRgstUserId() {
		return rgstUserId;
	}
	public void setRgstUserId(String rgstUserId) {
		this.rgstUserId = rgstUserId;
	}
	public String getUpdtDate() {
		return updtDate;
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
		return "UserVo [userSeq=" + userSeq + ", userId=" + userId
				+ ", userName=" + userName + ", passwd=" + passwd
				+ ", emailAddr=" + emailAddr + ", gender=" + gender + ", postCode="
				+ postCode + ", addrs=" + addrs + ", addrsDtl=" + addrsDtl
				+ ", phoneNo=" + phoneNo + ", birthDay=" + birthDay
				+ ", rgstDate=" + rgstDate + ", rgstUserId=" + rgstUserId
				+ ", updtDate=" + updtDate + ", updtUserId=" + updtUserId + "]";
	}
}
