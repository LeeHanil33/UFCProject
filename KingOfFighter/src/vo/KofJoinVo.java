package vo;

public class KofJoinVo {

	private String id;
	private String pw;
	private String email;


	
	public KofJoinVo(String id, String pw, String email) { //������
		this.id = id;
		this.pw = pw;
		this.email = email;


	}
	
	
	


	public KofJoinVo(String id, String pw) { //������
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
}
