package v04;

public class PhoneCafeInfo extends PhoneInfo{

	String nickName;

	public PhoneCafeInfo(String name, String phoneNumber, String nickName) {
		super(name, phoneNumber);
		this.nickName = nickName;
	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub
		super.showData();
		System.out.println("닉네임 : " + nickName);
	}
	
	
	
	
	
	
}
