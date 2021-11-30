import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Snake & Ladder ");
		
		//details about the no. of players
		Scanner inp1= new Scanner(System.in);
		System.out.println("Enter the number of players (max. 4 & min 2):");
		
		int noOfPlayers=inp1.nextInt();
		inp1.nextLine();
		
		if(noOfPlayers<=4 && noOfPlayers >=2) {
		Player PlayerList[]= new Player[noOfPlayers];
		for(int i=0;i < PlayerList.length;i++)
		{

			PlayerList[i]=new Player();
			System.out.println("Name of Player "+(i+1)+" : ");
			String n=inp1.nextLine();
			//setting up names of the players
			PlayerList[i].setName(n);
			
			
			PlayerList[i].id=i+1;
		}
		Board b=new Board();
		//start the game
		b.startGame(PlayerList);
	}
		else {
			System.out.print("Can't have more than 4 or less than 2 players");
		}
		
	
	}

}
