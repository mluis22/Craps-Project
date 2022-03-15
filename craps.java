import java.util.Scanner;
public class craps{


	static int round = 1;
	static boolean done = false;
	static String result = "";
	public craps(){
	
		
	}


	public static String game(dice d){

		
		Scanner in = new Scanner(System.in);

		
		boolean keepGoing = false;
		int count = 0;
		
		int n = 0;
		if(!done){
			count++;
			int rollOne = d.diceRollOne();
			int rollTwo = d.diceRollTwo();
			int sum = rollOne + rollTwo;
			System.out.println("Roll " + count + ":");
			System.out.println("Rolling.....");
			delay(750);
			System.out.println("You rolled a " + rollOne + " and a " + rollTwo + ". That's a " + sum);
			
			switch(sum){
				case 7: done = true;
					result = "won";
					break;
				case 11: done = true;
					result = "won";
					break;
				case 2: done = true;
					result = "lost";
					break;
				case 3: done = true;
					result = "lost";
					break;
				case 12: done = true;
					result = "lost";
					break;
				default: 
					keepGoing = true;
					n = sum;
				}
		}

		while(keepGoing){
			
			System.out.print("You got neither! roll again(Y/n)?");
			String playGame = in.nextLine();


				if(playGame.equals("") || playGame.substring(0,1).equalsIgnoreCase("y")){
					count++;
					int rollOne = d.diceRollOne();
					int rollTwo = d.diceRollTwo();
					int sum = rollOne + rollTwo;
					System.out.println("\nRoll " + count + ":");
					System.out.println("Rolling.....");
					delay(750);
					System.out.println("You rolled a " + rollOne + " and a " + rollTwo + ". That's a " + sum);
					if(sum == n){
						done = true;
						result = "won";
						keepGoing = false;
						break;
					}else if(sum==7){
						done = true;
						result = "lost";
						keepGoing = false;
						break;
					} else{
							n = sum;
						
					}
						
				}
				else{
					keepGoing = false;
					done = true;
					result = "lost";
					break;
				}
		}

		return result;
	}

	public static void playAgain(dice d){
		Scanner in = new Scanner(System.in);
		boolean wantAgain = true;

		while(wantAgain){
			System.out.print("\nWould you like to play again (Y/n)?");
			String playGame = in.nextLine();
			if(playGame.equals("") || playGame.substring(0,1).equalsIgnoreCase("y")){
				round++;
				System.out.println();
				System.out.println("\nRound " + round + "!\n");
				System.out.println();
				done = false;
				game(d);
				System.out.println("You " + game(d) + "!");
			}else{
				System.out.println("Bye! Thanks for playing!\n");
				wantAgain = false;
			}

		}

		
	}

	private static String score(){
		System.out.println("Score!!!");
		int opp = 0;
		int prop = 0;
		if(result.equals("lost")){
			opp++;
		}else{
			prop++;
		}
		String score = "Score: " + prop + "-" + opp + "\n";
		return score;
	}


	private static void delay(int ms){

		try{
			Thread.sleep(ms);

		}catch(InterruptedException ex){

			Thread.currentThread().interrupt();
		}

	}


	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		boolean again = false;

		
		
		dice d = new dice();
		System.out.print("\nWould you like to play Craps (Y/n)?");
		String playGame = in.nextLine();
		if(playGame.equals("") || playGame.substring(0,1).equalsIgnoreCase("y")){


			System.out.print("Do you know how to play (Y/n)?");
			String knowRules = in.nextLine();
			if( knowRules.substring(0,1).equalsIgnoreCase("n")){

				System.out.println("Retrieving the rules");
				delay(800);

				System.out.println("Rule 1: Roll two six-sided die and add the numbers rolled together\n");
				delay(3500);
				System.out.println("Rule 2: On the first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 automatically loses, and the game is over. If a 4, 5, 6, 8, 9, or 10 are rolled on this first roll, that number becomes the 'point'\n");
				delay(4200);
				System.out.println("Rule 3: Continue rolling the two dice again until one of two things happens: either they roll the 'point' from that first roll again, in which case you win; or they roll a 7, in which case you lose\n");
				delay(4300);
				System.out.println("Now you know the rules!\n");
			}


			System.out.println("Great, starting game.....");
			delay(1800);
			System.out.println("\nRound " + round + "!");
			score();
			game(d);
			System.out.println("You " + game(d));
		}else{
			System.out.println("Thanks for playing, I guess");
			again = true;
		}

		if(!again){
			playAgain(d);
		}
		
	}


}