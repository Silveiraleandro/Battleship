
public class GameBoard {
	/*THIS IS THE CLASS THAT CREATES THE ATTRIBUTES THAT BELONGS TO THE GAMEBOARD,
	 * THE BOARD IS MADE BY A 2D ARRAY, THE SIZE OF IT WILL BE CHOSSEN BY THE PLAYER
	 */
	private int row;
	private int column;
	private boolean [] [] board;
	private Boat boats;
	//THE CONSTRUCTOR OF GAMEBOARD CLASS STARTS THE ATTRIBUTES OF IT
	public GameBoard (int row, int columns) {
		this.row = row;
		this.column = columns;
		this.boats = new Boat(this.row,this.column);
		this.board = new boolean[this.row][this.column];
		
	}/*THIS METHOD CREATES THE LINES AND COLUMNS OF THE BOARD USING THE SIGN  _ | TO BUILD IT UP  AND 
	*ONE STRING STUFF WITH SPACE IN IT THAT PUTS A SPACE BEETWEN THE COLUMNS
	*/
	
	public void printBoard() {
		for(int x = 0; x <this.row; x ++) {
			for(int b = 0; b < this.column; b ++) {
				String stuff = "";
				
				if (this.board[x][b]) {
					if(ThereareBoats(x,b)) {
						stuff = " X ";
					}else {
						stuff = " O ";
					}
				}else {
					//CREATE SPACE BEETWEN THE COLUMNS
					stuff = "_ |";
				}
				System.out.print(stuff+"");
			}//JUMP A LINE WHEN THE LINE FINISHES
			System.out.println();
			
		}
	}
	//GETTER
		public Boat getBoat() {
			return boats;
		
	}
		/*THIS METHOD CHECKS THE COORDINATES OF THE BOAT ACCORDING TO THE BOARD TO CONFIRM THAT 
		 * THERE IS A BOAT ON THE GAMEBOARD
		 */
	public boolean ThereareBoats (int row,int column) {
		for(int x = 0; x < this.boats.getExtent(); x++) {
			if(boats.getDimension()[x][0] == row && boats.getDimension()[x] [1] == column) {
				return true;
			}
		}
		return false;
		
	}

	//SHOWS THE COORDINATES CHOOSING BY THE PLAYER
	public void releaseData(int row,int column) {
		this.board[row][column] = true;
	}
}
