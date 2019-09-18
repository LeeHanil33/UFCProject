package vo;

public class MatchVO {
	
	private String day;
	private String blue;
	private String red;
	private String matchname;
	private int a_Player;
	private int b_Player;
	private String winMethod;
	private int winner;
	private String date;
	private String time;
	private String match;
	
	public MatchVO(int a_Player, int b_Player, String winMethod, int winner, String date, String time, String match,
			int round) {
		this.a_Player = a_Player;
		this.b_Player = b_Player;
		this.winMethod = winMethod;
		this.winner = winner;
		this.date = date;
		this.time = time;
		this.match = match;
		this.round = round;
	}

	public int getA_Player() {
		return a_Player;
	}

	public void setA_Player(int a_Player) {
		this.a_Player = a_Player;
	}

	public int getB_Player() {
		return b_Player;
	}

	public void setB_Player(int b_Player) {
		this.b_Player = b_Player;
	}

	public String getWinMethod() {
		return winMethod;
	}

	public void setWinMethod(String winMethod) {
		this.winMethod = winMethod;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	private int round;
	
	
	
	public MatchVO(String day, String blue, String red, String matchname) {
		this.day = day;
		this.blue = blue;
		this.red = red;
		this.matchname = matchname;
	}
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getBlue() {
		return blue;
	}
	public void setBlue(String blue) {
		this.blue = blue;
	}
	public String getRed() {
		return red;
	}
	public void setRed(String red) {
		this.red = red;
	}
	public String getMatchname() {
		return matchname;
	}
	public void setMatchname(String matchname) {
		this.matchname = matchname;
	}

	
	
}
