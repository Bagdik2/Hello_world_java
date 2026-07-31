package hi;

public class Human {
	private String secret;
	private String news;
	private String experience;
	private String gossip;

	public Human(String scr, String news, String exp, String gsp) {
		// TODO Auto-generated constructor stub
		this.secret = scr;
		this.news = news;
		this.experience = exp;
		this.gossip = gsp;
	}

	private String getSecret() {
		return this.secret;
	}
	
	String getGossip() {
		return this.gossip;
	}
	
	protected String getExperience() {
		return this.experience;
	}
	
	public String getNews() {
		return this.news;
	}
}
