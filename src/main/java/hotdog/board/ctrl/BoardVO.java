package hotdog.board.ctrl;

public class BoardVO {

	private String boardSeq;
	private String title;
	private String content;
	private String fileId;
	private String rgstUserId;

	public String getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getRgstUserId() {
		return rgstUserId;
	}
	public void setRgstUserId(String rgstUserId) {
		this.rgstUserId = rgstUserId;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardSeq=" + boardSeq + ", title=" + title
				+ ", content=" + content + ", fileId=" + fileId
				+ ", rgstUserId=" + rgstUserId + "]";
	}
}
