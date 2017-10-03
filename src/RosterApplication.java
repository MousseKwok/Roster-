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
		JFrame frame = new JFrame("Roster of Data Structure");
		
		frame.setSize(1000, 800);
		
		frame.add(new RosterController());
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setVisible(true);
	}
}
