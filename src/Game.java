import java.util.Arrays;
import java.util.Scanner;
/*this is the main class of the program, this class controls all the other classes 
 * and here will be displayed the game for the user.
 */
public class Game {
	
	//global variables
	private boolean gameDone;
	private Player[] alocatedPlayers;
	
	//this is the constructor of the program, it execute the structure of the other classes

	public Game() {
		
		entrance();
		gameDone = false;
		alocatedPlayers = fuctionalSystem();
		GameBoard panel = BoardSystem ();
		panel.printBoard();
		
	
		int displayedBoatPoints = 0;
		
		while(!gameDone) {
			
			for(int i = 0; i < alocatedPlayers.length;i++) {
                System.out.println("Player =  "+alocatedPlayers[i].getName()+" fire on! ");

				int row;
				int column;
	/*THIS TRY AND CATCH DOES NOT LET THE PROGRAM CRASHS DOWN IN CASE THE PLAYER INPUTS 
	 * NUMBERS THAT GO OUT OF THE BOARD RANGE
	 */
			try {
				row = fromStToInt("pic a row to shoot");
				column = fromStToInt("pic a column to shoot");
			
				
				int [] point = alocatedPlayers[i].picCoordinates(row,column);
				
				panel.releaseData(point[0], point[1]);
				
				if(panel.ThereareBoats(row, column)) {
					displayedBoatPoints++;
					System.out.println(displayedBoatPoints);
					System.out.println("PERFECT SHOT!!!");
					alocatedPlayers[i].strikingIncrement();
				}else {
					System.out.println("O no, water shoot");
					alocatedPlayers[i].failsIncrement();
				}
			}catch (Exception e)  {System.out.println("the number choosen goes beyond the range of the board \n please try again");}
				panel.printBoard();
				}
		if(displayedBoatPoints == panel.getBoat().getExtent()) {
			gameDone = true;
			break;
		
		}
		
			}
	
		RankingResults();
		
	}
	//this is only a entrance method that prints a 1st message on the screen
			public void entrance ()	{
				System.out.println("________________________________________________________________________");
				System.out.println("_______________________BOAT BATTLE THE WAR GAME !!______________________");
				System.out.println("________________________________________________________________________");
				System.out.println("________________________________________________________________________\n\n");

			}
	/*THIS METHOD SETS UP THE ATRIBUITS OF THE PLAYERS, SUCH AS NAME AND EMAIL VALIDATIONS, 
	 * IT IS ALSO HERE THAT THE PLAYER WILL CHOOSE HOW MANY PEOPLE WILL PLAY FROM 1 UP TO 4 PARTICIPANTS 
	 */
		public Player [] fuctionalSystem() {
			Player[] localUser;
			
			int quantityOfPlayers;
			
			do {
				quantityOfPlayers=fromStToInt("PLEASE CHOOSE BEFORE STARTING THE GAME |1| |2| |3| or |4| PLAYERS TO PLAY ");
				
				if(quantityOfPlayers>4 || quantityOfPlayers<1) {
					System.out.println("sorry choose one given number of players");
				}
			}while (quantityOfPlayers>4 || quantityOfPlayers<1);
			
			localUser = new Player[quantityOfPlayers];
		
			for (int i = 0; i < localUser.length; i ++) {
				System.out.println("almost ready to play  !!!"+String.valueOf(i+1));
				String name; 
				String eMail;
				int age;
				name = toValidateStrings("start entering your name","[a-zA-Z]+","only characteres are aloud");
				eMail = toValidateStrings("now entering your email","[a-zA-Z0-9]+[.a-zA-Z0-9!#$%&'*+-/=?^`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}+[.]+[a-zA-Z.]{2,6}","enter at least with one @ and one .");
				age = getYearOld();
			
			localUser[i] = new Player(name,age,eMail);
			
			if(i != quantityOfPlayers -1) {
				System.out.println("now let's choose the next player");
			}
			}
			
			
			
			return localUser;
				
			
	}
		//THIS METHOD VALIDATES THE AGE OF THE PLAYER, THAT CAN NOT BE LESS THAN 12 OR BIGGER THAN 100
		private int getYearOld() {
			
			int maturity;
			boolean valid;
			do {
				maturity = fromStToInt("how old are you?");
				valid = (maturity >=12 && maturity <=100);
				if (maturity<12) {
					System.out.println("Too young, please get someone older to play");
				}else if(maturity>100) {
					System.out.println("you have typed too many numbers \n but I am going to ask again....10");
				}
			}while(!valid);
			return maturity;
			
		}
		//This method setd up the system of the board with the validations for rows and columns required by the assignment
		private GameBoard BoardSystem() {
		int row, column;
		boolean valid;
		
		do {
		row = fromStToInt("how many rows should the board have?");
		column = fromStToInt("how many columns should the board have?");
		
		valid = (row>=10 && column >=10) && (row<=10 && column <=20);
		if (!valid) {
			System.out.println("the Board range comprizes max of 10 rows and 20 columns");
			
		}
		}while(!valid);
			
		
		return new GameBoard(row,column);
		
		}
	
	

		private void print(String string) {
		// TODO Auto-generated method stub
		
	}
		

	
		//THIS METHOD SCANNER THAT GETS THE INPUT OF THE PLAYER
		public Scanner picPlayerInput (String txt) {
		System.out.println(txt);
		Scanner pic = new Scanner(System.in);
		
		return pic;
		
	}
		//METHOD THAT BUILD UP RULES TO AVOID WRONG INPUT FROM USERS, filtering the inputs
		public String toValidateStrings(String txt, String laws, String error) {
		String pic = "";
		do {
			pic = picPlayerInput(txt).nextLine();
			
			if(!pic.matches(laws)) {
				System.out.println("Wrong Input Player.. ");
			}
		}while(!pic.matches(laws));
		
		return pic;
		}

/*THIS METHOD DISPLAYS THE RESULT OF EACH HIT, MISS AND THE FINAL SCORE OF EACH PLAYER 
 * WHO WAS PLAYING IN THAT ROUND
 */
		public void RankingResults() {
			for(int i = 0; i < alocatedPlayers.length; i++){
				System.out.println("[**********************]");
				System.out.println(alocatedPlayers[i].getName());

            int strikes = alocatedPlayers[i].getStrike();
            int fails = alocatedPlayers[i].getWatershoot();
            int score = ((strikes-fails*2));
            	System.out.println("rigth Shoots: "+ strikes);
            	System.out.println("water Shoots: "+ fails);
            	System.out.println("Results: "+score);
            	System.out.println("[***********************]");
}
}
		//THIS METHOD RECEIVES A INPUNT IN STRING FROM THE PLAYER AND TRANSFORM IT INTO A INTEGER
		public int fromStToInt(String txt) {
			String message = toValidateStrings(txt, "[0-9]+","only numbers are aloud");
			return Integer.parseInt(message);
		}
		
	
	//Main method, this is the very starting point of the code
		public static void main(String[] args) {
		new Game();

	}

}
