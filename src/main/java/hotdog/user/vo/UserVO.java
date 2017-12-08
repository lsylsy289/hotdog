package hotdog.user.vo;

import lombok.Data;

@Data
public class UserVO {

	private int userSeq; // 사용자 순번
	private String userId; // 사용자명
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
}
