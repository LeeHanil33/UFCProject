package vo;

public class GameResultVo {
	
	private String day;
	private String match;
	private String physicque_rating;
	private String opponent;
	private int round;
	private String play_time;
	private String judgement;
	public GameResultVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GameResultVo(String day, String match, String physicque_rating, String opponent, int round, String play_time,
			String judgement) {
		super();
		this.day = day;
		this.match = match;
		this.physicque_rating = physicque_rating;
		this.opponent = opponent;
		this.round = round;
		this.play_time = play_time;
		this.judgement = judgement;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public String getPhysicque_rating() {
		return physicque_rating;
	}
	public void setPhysicque_rating(String physicque_rating) {
		this.physicque_rating = physicque_rating;
	}
	public String getOpponent() {
		return opponent;
	}
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getPlay_time() {
		return play_time;
	}
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}
	public String getJudgement() {
		return judgement;
	}
	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}
	@Override
	public String toString() {
		return "GameResultVo [day=" + day + ", match=" + match + ", physicque_rating=" + physicque_rating
				+ ", opponent=" + opponent + ", round=" + round + ", play_time=" + play_time + ", judgement="
				+ judgement + "]";
	}
		
}
