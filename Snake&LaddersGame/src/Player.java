
public class Player {
	
	private String playerName;
	Integer id;
	boolean status;
	Integer currentPosition;
	public Player() {
		super();
		this.status = false;
		this.currentPosition = 0;
	}
	
	public void setName(String name) {
		this.playerName=name;
	}
	public String getName() {
		return playerName;
	}
}
