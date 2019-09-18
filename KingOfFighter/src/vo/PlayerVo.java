package vo;

public class PlayerVo {
	
	private int idx;
	private String pro;
	private String physique_rating;
	private String name;
	private String gym;
	private int age;
	private double height;
	private double weight;
	private double reach;
	private double leg_reach;
	private String debut;
	private String picture;
	private String country;
	private String social_networks;
	private String status;
	private int gym_idx;
	
	public PlayerVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerVo(int idx, String pro, String physique_rating, String name, String gym, int age, double height,
			double weight, double reach, double leg_reach, String debut, String picture, String country,
			String social_networks, String status, int gym_idx) {
		super();
		this.idx = idx;
		this.pro = pro;
		this.physique_rating = physique_rating;
		this.name = name;
		this.gym = gym;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.reach = reach;
		this.leg_reach = leg_reach;
		this.debut = debut;
		this.picture = picture;
		this.country = country;
		this.social_networks = social_networks;
		this.status = status;
		this.gym_idx = gym_idx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getPhysique_rating() {
		return physique_rating;
	}

	public void setPhysique_rating(String physique_rating) {
		this.physique_rating = physique_rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
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

	public double getLeg_reach() {
		return leg_reach;
	}

	public void setLeg_reach(double leg_reach) {
		this.leg_reach = leg_reach;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSocial_networks() {
		return social_networks;
	}

	public void setSocial_networks(String social_networks) {
		this.social_networks = social_networks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGym_idx() {
		return gym_idx;
	}

	public void setGym_idx(int gym_idx) {
		this.gym_idx = gym_idx;
	}

	@Override
	public String toString() {
		return "PlayerVo [idx=" + idx + ", pro=" + pro + ", physique_rating=" + physique_rating + ", name=" + name
				+ ", gym=" + gym + ", age=" + age + ", height=" + height + ", weight=" + weight + ", reach=" + reach
				+ ", leg_reach=" + leg_reach + ", debut=" + debut + ", picture=" + picture + ", country=" + country
				+ ", social_networks=" + social_networks + ", status=" + status + ", gym_idx=" + gym_idx + "]";
	}	
}
