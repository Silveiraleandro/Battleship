import java.util.Random;
/**
*
* @author Leandro Silveira
*/
public class Boat {
	private int [] [] dimension;
	private int extent;
	private boolean horizontal;
	/*THE DIMENSION HAS TO BE 1/3 OF THE SIZE OF THE BOARD, TO AVOID PROBLEMS WITH DECIMAL NUMBER SUCH AS 0.3, IT'S BEEN USING 
	THE IMPORTED MATH.ROUND TO ROUND THE FIGURE.
	THE EXTENT ATTRIBUTE RECIVES A VALUE ACCORDING TO THE SIZE OF THE BOARD.
	*/
	public Boat(int row ,int column){
		horizontal = new Random().nextBoolean();
		extent = Math.round(column/3);
		
		startDimension (row, column);
	}
	public int[] [] getDimension() {
		return this.dimension;
	}
	//CONTRUCTOR METHOD THAT INITIALIZES THE ATRI
	private void startDimension(int boatRow,int boatColumn) {
		int row = this.extent;
		int column = 2;
		int [] [] currentDimension = new int [row] [column];
		//HERE THE KICK OFF POINT IS DEFINED AND ALSO THE LIMITS OF THE SHIP ON THE BOARD
		currentDimension [0] = new int [] {new Random().nextInt(boatRow),new Random().nextInt((boatColumn))};
		//THESE 2 IF STATMENTS ARE TO MAKE SURE THAT THE BOAT WILL BE FULLY ALLOCATED INSIDE THE BOARD
		if (this.horizontal) {
			if(currentDimension[0][1] > boatColumn-this.extent) {
				currentDimension[0][1] = boatColumn-this.extent;
			}
		}else {
			if(currentDimension[0][0] > boatRow-this.extent) {
				currentDimension[0][0] = boatRow-this.extent;
			}
		}
		if (this.horizontal) {
			//BASED ON THE KICK OFF POINT OF X ASSIS, ITS IMCREMENT ITSELF IN 1 , WHEN THE BOAT IS VERTICAL
			for(int x = 1; x < row; x++) {
				currentDimension[x][0] = currentDimension[0][0];
				for (int b = 1;b < column ; b ++) {
				currentDimension[x][b] = currentDimension [0] [1]+x;
				}
				System.out.println();
			}	
		}else {
			for(int x = 1; x < row; x++) {
				currentDimension[x][0] = currentDimension[0][0]+x;
				for (int b = 1;b < column ; b ++) {
				currentDimension[x][b] = currentDimension [0] [1];
			}
				
			}
			}	
		this.dimension = currentDimension;
}
	public boolean horizontal() { 
		return this.horizontal;
	}
	
	//THE USER DIFINES THE SIZE OF THE BOARD, THE BOARD DIFINES THE SIZE OF THE EXTENT OF THE BOAT AND THIS METHOD GETS THIS VALUE
	public int getExtent() {
		return this.extent;
	}
}
