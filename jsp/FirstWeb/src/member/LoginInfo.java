package member;

public class LoginInfo {
	
	private String id;
	private String name;
	private String photo;
	private String nicname;
	private int grade;
	private String pNum;
	
	
	
	public LoginInfo(String id, String name, String photo, String nicname, int grade, String pNum) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.nicname = nicname;
		this.grade = grade;
		this.pNum = pNum;
	}

	public LoginInfo(String id) {
		this.id = id;
		this.name = "손흥민";
		this.photo = "noimg";
		this.nicname = "SON";
		this.grade = 1;
		this.pNum = "000-000-0000";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoto() {
		return photo;
	}

	public String getNicname() {
		return nicname;
	}

	public int getGrade() {
		return grade;
	}

	public String getpNum() {
		return pNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
