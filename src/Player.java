/**
 *
 * @author Leandro Silveira
 */
public class Player {
	//this class creates the instances for a player, all the attributes that belongs to it.
	public String gamerName;
	public int gamerAge;
	public String gamerEMail;
	private int strike;
	private int fail;
	private int tries;
	
	/*THIS IS THE CONSTRUCTOR METHOD, WHICH INICIATES THE INSTANCES AND PARAMETERS 
	*AGE, NAME AND EMAIL WILL BE GIVING BY THE USER, HIT MISS AND TRIES WILL START WITH THE VALUE 0.
	*/
public Player (String name, int age, String eMail) {
	this.gamerAge = age;
	this.gamerName = name;
	this.gamerEMail = eMail;
	strike = 0;
	fail = 0;
	tries = 0;
}
//PLAYER PICS THE CORDINATES HE WILL PLAY 
public int[] picCoordinates(int row, int columns){
    int[] point = new int[2];

    point[0] = row;
    point[1] = columns;

    return point;
}
//incrementing 1 hit always its called
public void strikingIncrement() {
	strike++;
	tries++;
}
//incrementing 1 miss always its called
public void failsIncrement() {
	fail++;
	tries++;
}
//GETTER
public int getStrike() {
	return strike;
}
//GETTER 
public String getName(){
    return this.gamerName;
}
//GETTER
public int getWatershoot(){
    return this.fail;
}
}