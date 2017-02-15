import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is a JUnit tester
 * @author Xijie Guo
 *
 */
public class LinkedListTest {
	
	//Create an empty linked list for testing functionality of each of your methods in LinkedList class
	private LinkedList<String> list = new LinkedList<String>();
	
	@Before
	public void createList() {
		//Add three elements in the list, the order is: g, q, m
		list.insertFirst("m");
		list.insertFirst("q");
		list.insertFirst("g");
	}
	
	/**
	 * One final test
	 */
	@Test
	public void test() {
		
		//First create an empty linked list
		LinkedList<String> list = new LinkedList<String>();
		//Check for 1st step
		assertEquals(true, list.isEmpty());
		
		//Insert letter a in the head of the list
		list.insertFirst("a");
		//Check for 2rd step
		assertEquals("a", list.toString());
		
		//Insert v in the head of the list
		list.insertFirst("v");
		//Check for 3rd step
		assertEquals("v->a", list.toString());
		
		//Insert a in the head of the list
		list.insertFirst("a");
		//Check for 4th step
		assertEquals("a->v->a", list.toString());
		
		//Insert l in the head of the list
		list.insertFirst("l");
		//Check for 5th step
		assertEquals("l->a->v->a", list.toString());
		
		//Insert o in the head of the list
		list.insertFirst("o");
		//Check for 6th step
		assertEquals("o->l->a->v->a", list.toString());
		
		//Insert i in the head of the list
		list.insertFirst("i");
		//Check for 7th step
		assertEquals("i->o->l->a->v->a", list.toString());
		
		//Insert "j" after the node following the head node
		list.insertAfter(list.getFirstNode().getNext(), "j");
		//Check for 8th step
		assertEquals("i->o->j->l->a->v->a", list.toString());
		
		//Insert "e" after the node following the head node
		list.insertAfter(list.getFirstNode().getNext(), "e");
		//Check for 9th step
		assertEquals("i->o->e->j->l->a->v->a", list.toString());
		
		//Insert "v" after the node following the head node
		list.insertAfter(list.getFirstNode().getNext(), "v");
		//Check for 10th step
		assertEquals("i->o->v->e->j->l->a->v->a", list.toString());
		
		//Insert "l" after the head node
		list.insertAfter(list.getFirstNode(), "l");
		//Check for 11th step
		assertEquals("i->l->o->v->e->j->l->a->v->a", list.toString());

		//Delete the node after the node after the node after the node after the node after the head node
		list.deleteNext(list.getFirstNode().getNext().getNext().getNext().getNext());
		//Check for the last step
		assertEquals("i->l->o->v->e->l->a->v->a", list.toString());
		
	}
	
	
	/**
	 *Test if the linkedList is empty
	 */
	@Test
	public void testEmpty() {
		//The correct answer is false, since there are three elements in the list
		assertEquals(false, list.isEmpty());
	}
	
	/**
	 * Test the insertFirst method 
	 */
	@Test
	public void testInsertFirst() {
		//Insert the letter a at the head of the list
		list.insertFirst("a");
		
		//Check if "a" is in the head of the list by getFirst method after implementing insertFirst method
		assertEquals("a", list.getFirst());
	}
	
	/**
	 * Test insertAfter method
	 */
	@Test
	public void testInsertAfter() {
	    //Insert letter j after the first node
	    list.insertAfter(list.getFirstNode(), "j");
	    
	    //Check if the second node is j
		assertEquals("j", list.getFirstNode().getNext().getData());
	}
	
	/**
	 * Test deleteFirst method
	 */
	@Test
	public void deleteFirst() {
		//Delete the first element in the list
		list.deleteFirst();
		
		//Check if the first element has been deleted
		assertEquals("q", list.getFirst());
	}
	
	/**
	 * Test deleteLast method
	 */
	@Test
	public void deleteLast() {
		//Delete the last element in the list
		list.deleteLast();
		
		//Check if the last element has been deleted
		assertEquals("q", list.getLast());
	}
	
	/**
	 * Test for deleteNext method
	 */
	@Test
	public void deleteNext() {
		//Remove the node after the first node in the list
		list.deleteNext(list.getFirstNode());
		
		//Check if the node after the first node has been removed
		assertEquals("m", list.getFirstNode().getNext().getData());
	}
	
	/**
	 * Test for size method
	 */
	@Test
	public void testSize() {
		//Test if the size of the list is correct
		assertEquals(3, list.size());
	}
	
    /**
     * Test for toString method
     */
	@Test
	public void testToString() {
		//Check if the string representation of the list is the correct one
		assertEquals("g->q->m", list.toString());
	}
	
	/**
	 * Test for getFirst method
	 */
	@Test
	public void testGetFirst() {
		//Check if we can get the data of the first element in the list
		assertEquals("g", list.getFirst());
	}
	
	@Test 
	public void testInsertLast() {
        list.insertLast("b");
		assertEquals("b", list.getLast());
	}
	
	/**
	 * Test for getFirstNode method
	 */
	@Test
	public void testGetFirstNode() {
		//Get the first node in the list
		list.getFirstNode();
		
		//Check if we can get the correct first node by checking if the data we get is equal to the data of the first node
		assertEquals("g", list.getFirstNode().getData());
		
	}
	
	/**
	 * Test for getLast method
	 */
	@Test
	public void testGetLast() {
		//Check if we can get the data of the last element in the list
		assertEquals("m", list.getLast());
	}
	
	/**
	 * Test for getLastNode method
	 */
	@Test
	public void testGetLastNode() {
		//Get the last node in the list
		list.getLastNode();
		
		//Check if we can get the correct last node by checking if the data we get is equal to the data of the last node
		assertEquals("m", list.getLastNode().getData());
	}
}
