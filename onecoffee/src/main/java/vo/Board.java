package vo;

import java.util.Date;

import order_sol.Member;

public class Board {
	private int no;
	private String title;
	private String text;
	private Member member;
	private Date firstDate;
	private Date modifyDate;
	private boolean isEnd;
	private boolean isNotice;
	
	public Board() {

	}

	public Board(String title, String text, Date firstDate, boolean isNotice) {
		this.title = title;
		this.text = text;
		this.firstDate = firstDate;
		this.isNotice = isNotice;
	}
	
	public Board(int no, String title, String text, Date firstDate, boolean isEnd, boolean isNotice) {
		this.no = no;
		this.title = title;
		this.text = text;
		this.firstDate = firstDate;
		this.isEnd = isEnd;
		this.isNotice = isNotice;
	}

	public Board(int no, String title, String text, Date firstDate, Date modifyDate, boolean isEnd, boolean isNotice) {
		this.no = no;
		this.title = title;
		this.text = text;
		this.firstDate = firstDate;
		this.modifyDate = modifyDate;
		this.isEnd = isEnd;
		this.isNotice = isNotice;
	}

	public Board(int no, String title, String text, Member member, Date firstDate, boolean isEnd,
			boolean isNotice) {
		this.no = no;
		this.title = title;
		this.text = text;
		this.member = member;
		this.firstDate = firstDate;
		this.modifyDate = modifyDate;
		this.isEnd = isEnd;
		this.isNotice = isNotice;
	}

	// 기본 getter, setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public boolean isNotice() {
		return isNotice;
	}
	public void setNotice(boolean isNotice) {
		this.isNotice = isNotice;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
