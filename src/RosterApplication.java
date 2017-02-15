import javax.swing.JFrame;
/**
 * Main application for starting the roster project
 * @author Xijie Guo
 *
 */
public class RosterApplication {
	
	/**
	 * Main method
	 * @param args a String type array
	 */
	public static void main(String[] args) {
		//Create a new JFrame to display the game
		JFrame frame = new JFrame("Roster of Data Structure");
		
		//Set the size of the frame
		frame.setSize(1000, 800);
		
		//Add new UnrestrictedGuessingGameController to the frame
		frame.add(new RosterController());
	    
		//Sets the operation that will happen by default when the user initiates a "close" on this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make the frame visible
		frame.setVisible(true);
	}
}