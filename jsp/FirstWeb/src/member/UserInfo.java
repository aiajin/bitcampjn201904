package member;

import java.util.Date;

// beans 클래스 구성

public class UserInfo {
	
	/* beans 클래스의 변수는 private 처리한다. */
	private String id; // ${user.id} --> getId()
	private String password;
	private String name;
	private String address;
	private String email;
	private Date registerDate;
	
	

	/* dafault 생성자가 필수 */
	/* 필드를 이용하는 생성자가 필요하다면 default 생성자를 명시적으로 정의 */
	
	public UserInfo(String id, String password, String name, String address, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.registerDate = new Date();
	}
	
	public UserInfo() {
		this.registerDate = new Date();
	}
	
	
	/* setter / getter 메서드 정의 */
	/* getVar() / setVal() */ 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", email="
				+ email + ", registerDate=" + registerDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
