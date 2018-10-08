import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.Random;
public class RockPaperScissors{
	static String restart = "";
	static int wins = 0;
	static int losses = 0;
	static int ties = 0;

	public static void main(String[] args) {
		play();

	}
	public static void play(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Type r, p, or s");
		String hand = sc.next(); // user's choice
		while (!(hand.equals("r")) && !(hand.equals("p")) && !(hand.equals("s"))){ // check if valid input
			System.out.println("Invalid input. Type r, p, or s.");
			hand = sc.next();
		}
		String[] computer = new String[3];
		computer[0] = "r";
		computer[1] = "p";
		computer[2] = "s";
		Random rand = new Random();
		int random_integer = rand.nextInt(3); 
		String computerPlay = computer[random_integer]; // computer choice
		System.out.println("Computer chooses " + computerPlay);
		check(hand, computerPlay);
		System.out.println("Your W-L-T is " + wins + "-" + losses + "-" + ties);
		System.out.println("Do you want to play again? Type y or n.");
		restart = sc.next();
		while(!(restart.equals("y"))&&!(restart.equals("n"))){
			System.out.println("Invalid input. Type y or n.");
			restart = sc.next();
		}
		while(restart.equals("y")){ // play again until user types n
			play();
		}
	}
	public static void check(String hand, String computerPlay){
		if (hand.equals(computerPlay)){
			System.out.println("It's a tie.");
			ties++;
		}
		else if (hand.equals("r")){
			if (computerPlay.equals("s")){
				System.out.println("Rock beats scissors. You win!");
				wins++;
			}
			else if(computerPlay.equals("p")){
				System.out.println("Paper beats rock. You lose!");
				losses++;
			}
		}
		else if (hand.equals("p")){
			if (computerPlay.equals("s")){
				System.out.println("Scissors beat paper. You lose!");
				losses++;
			}
			else if (computerPlay.equals("r")){
				System.out.println("Paper beats rock. You win!");
				wins++;
			}

		}
		else if (hand.equals("s")){
			if (computerPlay.equals("r")){
				System.out.println("Rock beats scissors. You lose!");
				losses++;
			}
			else if (computerPlay.equals("p")){
				System.out.println("Scissors beat paper. You win!");
				wins++;
			}
		}
	}
}
