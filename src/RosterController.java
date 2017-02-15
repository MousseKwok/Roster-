import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * RosterController class is responsible for creating GUI and managing interaction with user 
 * @author Xijie Guo
 *
 */
public class RosterController extends JPanel implements ActionListener {
	
	//Maximum # of students can enroll in the class
	private static final int MAX_NUM_STUDENTS = 4;
	
	//Add, drop buttons
	private JButton addButton, dropButton;
	
	//text field used to type students' name
	private JTextField text;
	
	//Instance of rosterList class
	private RosterList rosterList;
	
	//Instruction displayed on frame
	private JLabel instruction;
	
	//Areas for displaying enrolled students' names and waitlist students' names respectively
	private JTextArea rosterArea, waitlistArea;
	
	public RosterController() {
		super(new BorderLayout());
		rosterList = new RosterList();
		createView();
	}
	
	/**
	 * Create the whole view by creating top, middle, and bottom parts
	 */
	private void createView() {
		createTopPart();
		createCentralPart();
		createBottomPart();
	}
	
	/**
	 * 
	 */
	public void createTopPart() {
		JPanel panel = new JPanel();
		instruction = new JLabel("Type a student names to add and drop");
		text = new JTextField();
		text.addActionListener(this);
		addButton = new JButton("Add");
		addButton.setBackground(new Color(255, 255, 204));
		addButton.addActionListener(this);
		dropButton = new JButton("Drop");
		dropButton.setBackground(Color.lightGray);
		dropButton.addActionListener(this);
		
		panel.add(instruction);
		panel.add(text);
		panel.add(addButton);
		panel.add(dropButton);
		panel.setLayout(new GridLayout(1, 4));
		add(panel, BorderLayout.NORTH);
	}
	
	public void createCentralPart() {
		JPanel rosterPanel = new JPanel();
		JLabel rosterLabel = new JLabel("Registration List of Data Structure");
		rosterArea = new JTextArea();
		rosterArea.setEditable(false);
		Border border = BorderFactory.createLineBorder(Color.CYAN);
		rosterArea.setBorder(border);
		rosterPanel.add(rosterLabel);
		rosterPanel.add(rosterArea);
		rosterPanel.setLayout(new BoxLayout(rosterPanel, BoxLayout.Y_AXIS));
		
		JPanel waitlistPanel = new JPanel();
		JLabel waitlistLabel = new JLabel("Waitlist of Data Structure");
		waitlistArea = new JTextArea();
		waitlistArea.setEditable(false);
		Border waitlistBorder = BorderFactory.createLineBorder(Color.MAGENTA);
		waitlistArea.setBorder(waitlistBorder);
		waitlistPanel.add(waitlistLabel);
		waitlistPanel.add(waitlistArea);
		waitlistPanel.setLayout(new BoxLayout(waitlistPanel, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.add(rosterPanel);
		panel.add(waitlistPanel);
		panel.setLayout(new GridLayout(1, 2));
		add(panel, BorderLayout.CENTER);
	}
	
	public void createBottomPart() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Maximum number of students is 4");
		panel.add(label);
		add(panel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if(src == addButton) {
			String studentName = text.getText();
			if(studentName != null) {
				if(MAX_NUM_STUDENTS > rosterList.getSize()) {
					rosterList.addToRosterList(studentName);
					String studentList = rosterList.printList();
					rosterArea.setText(studentList);

				}

				else if(MAX_NUM_STUDENTS <= rosterList.getSize()) {
					rosterList.addToWaitlist(studentName);
					//						studentWaitlist = studentWaitlist + studentName + "\n";
					waitlistArea.setText(rosterList.printWaitlist());
				}
			}
		}

		else if(src == dropButton) {
			String studentName = text.getText();
			DoublyLinkedListNode<String >node = rosterList.getNode(studentName);
			if(studentName !=null && node != null) {
				rosterList.removeStudents(node.getPrev(), studentName);
				String studentList = rosterList.printList();
				rosterArea.setText(studentList);
				if(MAX_NUM_STUDENTS > rosterList.getSize() && rosterList.getWaitlistStudent() != null) {
					String data = rosterList.getWaitlistStudent().getData();
					rosterList.addToRosterList(data);
					rosterList.removeStudentsFromWaitlist();
					String list = rosterList.printList();
					rosterArea.setText(list);
					waitlistArea.setText(rosterList.printWaitlist());
				}
			}
		}
	}
}
