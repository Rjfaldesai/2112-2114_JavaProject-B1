import java.util.Scanner;

public class Board {

	Integer boardSize=100;
	Dice dice=new Dice();
	Snake[] snakes= {new Snake(98,79),new Snake(95,75),new Snake(87,36),new Snake(62,19),new Snake(54,34),new Snake(17,7)};
	Ladder[] ladders= {new Ladder(1,38),new Ladder(4,14),new Ladder(9,31),new Ladder(21,42),new Ladder(28,84),new Ladder(51,67),new Ladder(72,91),new Ladder(80,99)};
	 
	public void startGame(Player[] PlayerList) {
		int i=0;
		int noOfWinners=0;
		while(PlayerList.length > 1) {
			System.out.println("Snakes & Ladders");
			Scanner s= new Scanner(System.in);
			//to clear screen and render the board
			System.out.println(System.lineSeparator().repeat(100));
			renderBoard(PlayerList);
			if(PlayerList[i].status==false) 
			{
				//System.out.print("\u000C");
				
			int res;
			
			System.out.print("Press Enter to play for Player"+PlayerList[i].id);
			s.nextLine();
			res=dice.rollDice();
			//output the result of rolling the dice
			System.out.println("Player"+PlayerList[i].id+" got "+res);
			PlayerList[i].currentPosition=PlayerList[i].currentPosition+res;
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
					System.out.println("Oops!! Player"+PlayerList[i].id+" got bitten by snake at "+snakes[j].startno);
					
				}
				//check for ladders
				for(int j=0;j < ladders.length;j++)
					if(ladders[j].startno==PlayerList[i].currentPosition) {
						PlayerList[i].currentPosition=ladders[j].endno;
						//output "found ladder"
						System.out.println("Great!! Player"+PlayerList[i].id+" found a ladder at "+ladders[j].startno);
					}
				
			}
			
			//this is to pass the chance to other players
			i++;
			if(PlayerList.length==i) {
				i=0;
			}
		}
			else {
				
				noOfWinners++;
				//terminates when everyone finishes the game
				if(noOfWinners==PlayerList.length)
				{
					System.out.println("Game Over");
					break;
				}
			}
			System.out.print("Press Enter to Continue...");
			s.nextLine();
		}
	}
	
	public void renderBoard(Player[] PlayerList)
	 {
		
		int i=100,f=1;
		
		while(i>=1) {
	
		//for odd row
		while(f%2!=0) {
			
			System.out.print("|");	
			System.out.printf("%-6d",i);
			//to indicate players
			for(int j=0;j<PlayerList.length;j++) {
			if(PlayerList[j].currentPosition==i)
			System.out.printf(" (%d)",PlayerList[j].id);	
			}	
			
			
			if((i-1)%10==0) {
				System.out.print("|\n");
				System.out.println("-----------------------------------------------------------------------");
				f++;
				break;
				//System.out.print(i);
			}
			i--;
		}
		
		//for even row
			i=i-10;
			while(f%2==0) {
			
				System.out.print("|");	
				System.out.printf("%-6d",i);
				//to indicate players
				for(int j=0;j<PlayerList.length;j++) {
					if(PlayerList[j].currentPosition==i)
					System.out.printf(" P(%d)",PlayerList[j].id);	
						
					}	
				
				if((i)%10==0) {
					System.out.print("|\n");
					System.out.println("-----------------------------------------------------------------------");
					f++;
					break;
					//System.out.print(i);
				}
				i++;
			}
			i=i-10;
		}
	 System.out.println("List of snakes on the board");
	 for(int k=0;k < snakes.length;k++) {
		 System.out.println((k+1)+") "+snakes[k].startno+"->"+snakes[k].endno);
	 }
	 System.out.println();
	 System.out.println("List of ladders on the board");
	 for(int k=0;k < ladders.length;k++) {
		 System.out.println((k+1)+") "+ladders[k].startno+"->"+ladders[k].endno);
	 }
	 
	}
	
}
