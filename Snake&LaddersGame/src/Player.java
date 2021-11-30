
public class Player {
	
	private String playerName;
	int id;
	boolean status;
	int currentPosition;
	public Player() {
		super();
		this.status = false;
		this.currentPosition = 1;
	}
	
	public void setName(String name) {
		this.playerName=name;
	}
	public String getName() {
		return playerName;
	}
}
