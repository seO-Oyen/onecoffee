package login.vo;

public class CreateAccount {
    private int mem_id;
	private String name;
    private String id;
    private String pwd;
    private String phoneNumber;
    private String address;
    private String pwdAnswer;
    private int point;
	public CreateAccount() {
		// TODO Auto-generated constructor stub
	}
	public CreateAccount(int mem_id, String name, String id, String pwd, String phoneNumber, String address,
			String pwdAnswer, int point) {
		this.mem_id = mem_id;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.pwdAnswer = pwdAnswer;
		this.point = point;
	}
	public CreateAccount(String pwd, String phoneNumber, String address) {
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public CreateAccount(String name, String id, String pwd, String phoneNumber, String address, String pwdAnswer) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.pwdAnswer = pwdAnswer;
	}

	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPwdAnswer() {
		return pwdAnswer;
	}
	public void setPwdAnswer(String pwdAnswer) {
		this.pwdAnswer = pwdAnswer;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

}
