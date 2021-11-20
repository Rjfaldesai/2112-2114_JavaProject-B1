import java.util.Scanner;

public class Board {

	Integer boardSize=100;
	Dice dice;
	Snake[] snakes= {new Snake(98,79),new Snake(95,75),new Snake(87,36),new Snake(62,19),new Snake(54,34),new Snake(17,7)};
	Ladder[] ladders= {new Ladder(1,38),new Ladder(4,14),new Ladder(9,31),new Ladder(21,42),new Ladder(28,84),new Ladder(51,67),new Ladder(72,91),new Ladder(80,99)};
	 
	public void startGame(Player[] PlayerList) {
		int i=0;
		int noOfWinners=0;
		while(PlayerList.length > 1) {
			if(PlayerList[i].status==false) 
			{
			//renderBoard(PlayerList);
			Scanner s= new Scanner(System.in);
			System.out.print("Press Enter to play for Player"+PlayerList[i].id);
			s.nextLine();
			PlayerList[i].currentPosition=PlayerList[i].currentPosition+dice.rollDice();
			if(PlayerList[i].currentPosition == boardSize) {
				System.out.println("Player"+PlayerList[i].id+", "+PlayerList[i].getName()+" has won");
				PlayerList[i].status=true;
				
			}
			else if(PlayerList[i].currentPosition > boardSize) {}
			else {
				//check for snakes
				for(int j=0;j < snakes.length;j++)
				if(snakes[j].startno==PlayerList[i].currentPosition) {
					PlayerList[i].currentPosition=snakes[j].endno;
					//output "bitten by snake"
				}
				//check for ladders
				for(int j=0;j < ladders.length;j++)
					if(ladders[j].startno==PlayerList[i].currentPosition) {
						PlayerList[i].currentPosition=ladders[j].endno;
						//output "found ladder"
					}
				
			}
			
			
			
			
			
			i++;
			if(PlayerList.length==i) {
				i=0;
			}
		}
			else {
				noOfWinners++;
				if(noOfWinners==PlayerList.length)
				{
					System.out.println("Game Over");
					break;
				}
			}
		}
	}
	public void renderBoard(Player[] PlayerList) {
		
	}
}
