package order_sol;

public class Member {
	private int mem_id;
	private String name;
	private String id;
	private String pwd;
	private String phonenum;
	private String address;
	private String pwdanswer;
	private int point;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int mem_id, String name) {
		this.mem_id = mem_id;
		this.name = name;
	}

	public Member(int mem_id, String name, String id, String pwd, String phonenum, String address, String pwdanswer,
			int point) {
		this.mem_id = mem_id;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phonenum = phonenum;
		this.address = address;
		this.pwdanswer = pwdanswer;
		this.point = point;
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
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPwdanswer() {
		return pwdanswer;
	}
	public void setPwdanswer(String pwdanswer) {
		this.pwdanswer = pwdanswer;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
