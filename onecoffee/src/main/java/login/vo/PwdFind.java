package login.vo;

public class PwdFind {
	private String id;
    private String pwdAnswer;
	public PwdFind() {
		// TODO Auto-generated constructor stub
	}
	public PwdFind(String id, String pwdAnswer) {
		this.id = id;
		this.pwdAnswer = pwdAnswer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwdAnswer() {
		return pwdAnswer;
	}
	public void setPwdAnswer(String pwdAnswer) {
		this.pwdAnswer = pwdAnswer;
	}
    
}
