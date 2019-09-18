package vo;

public class PlayerAddVo {
	
	private String name; // 이름
	private String pro;       // P프로,A아마 M매니저
	private String bdlevel; // 신체등급
	private int status;  // 활동여부 0,1
	
	private int age;     // 나이
	private double height;  //키
	private double weight;  //몸무게
	private double reach;   //팔길이
	private double legReach; //발길이
	private String date;  //데뷔일자
	private String picture; //사진위치
	private String social;  //sns url
	private String country; //출신
	
	
	public PlayerAddVo(String name, String pro, String bdlevel, int status, int age, double height, double weight,
			double reach, double legReach, String date, String social, String country) {
		this.name = name;
		this.pro = pro;
		this.bdlevel = bdlevel;
		this.status = status;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.reach = reach;
		this.legReach = legReach;
		this.date = date;
		this.social = social;
		this.country = country;
	}
	public PlayerAddVo(String name, String pro, String bdlevel, int status, int age, double height, double weight,
			double reach, double legReach, String date, String picture, String social, String country) {
		super();
		this.name = name;
		this.pro = pro;
		this.bdlevel = bdlevel;
		this.status = status;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.reach = reach;
		this.legReach = legReach;
		this.date = date;
		this.picture = picture;
		this.social = social;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getBdlevel() {
		return bdlevel;
	}
	public void setBdlevel(String bdlevel) {
		this.bdlevel = bdlevel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getReach() {
		return reach;
	}
	public void setReach(double reach) {
		this.reach = reach;
	}
	public double getLegReach() {
		return legReach;
	}
	public void setLegReach(double legReach) {
		this.legReach = legReach;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "PlayerAddVo [name=" + name + ", pro=" + pro + ", bdlevel=" + bdlevel + ", status=" + status + ", age="
				+ age + ", height=" + height + ", weight=" + weight + ", reach=" + reach + ", legReach=" + legReach
				+ ", date=" + date + ", picture=" + picture + ", social=" + social + ", country=" + country + "]";
	}

	

}
