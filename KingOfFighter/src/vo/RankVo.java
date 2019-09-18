package vo;

public class RankVo {
	
	private String name;
	private String physique_rating;
	private int winNum;
	private int rank;
	public RankVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RankVo(String name, String physique_rating, int winNum, int rank) {
		super();
		this.name = name;
		this.physique_rating = physique_rating;
		this.winNum = winNum;
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhysique_rating() {
		return physique_rating;
	}
	public void setPhysique_rating(String physique_rating) {
		this.physique_rating = physique_rating;
	}
	public int getWinNum() {
		return winNum;
	}
	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "RankVo [name=" + name + ", physique_rating=" + physique_rating + ", winNum=" + winNum + ", rank=" + rank
				+ "]";
	}

}
