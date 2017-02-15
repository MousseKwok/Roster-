import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
	
	private DoublyLinkedList<String> list = new DoublyLinkedList<String>();
	private DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
	
	@Before
	public void setup() {
		list.insertFirst("1");
		list.insertFirst("3");
		list.insertFirst("2");
	}
	
	@Test
	public void testEmpty() {
		assertEquals("Test if the linked list is empty", true, linkedList.isEmpty());
		assertEquals("Test isEmpty method", false, list.isEmpty());
	}
	
	@Test
	public void testGetLast() {
		assertEquals("Test getLast", "1", list.getLast());
		list.deleteLast();
		assertEquals("Test getLast method", "3", list.getLast());
		
	}

	@Test
	public void testInsertFirst() {
		assertEquals("Check the first", "2", list.getFirst());
		list.insertFirst("5");
		assertEquals("Test inserFirst method", "5", list.getFirst());
	}

	@Test
	public void testInsertLast() {
		assertEquals("Test insertLast method", "1", list.getLast());
		list.insertLast("a");
		assertEquals("Test insertLast method", "a", list.getLast());
	}

	@Test
	public void testDeleteFirst() {
		assertEquals("Check the first", "2", list.getFirst());
		list.deleteFirst();
		assertEquals("Test deleteFirst method", "3", list.getFirst());
	}

	@Test
	public void testDeleteLast() {
		assertEquals("Check the last", "1", list.getLast());
		list.deleteLast();
		assertEquals("Test deleteLast method", "3", list.getLast());
		list.deleteLast();
		assertEquals("Test deleteLast method", "2", list.getLast());
	}

	@Test
	public void testSize() {
		assertEquals("Test size method", 3, list.size());
		list.insertLast("c");
		assertEquals("Test size method", 4, list.size());
		list.deleteFirst();
		assertEquals("Test size", 3, list.size());
	}

	@Test
	public void testGetFirstNode() {
		assertEquals("Test the first node in the list", "2", list.getFirstNode().getData());
	}

	@Test
	public void testGetLastNode() {
		assertEquals("Test the last node in the list", "1", list.getLastNode().getData());
	}

	@Test
	public void testInsertAfter() {
		list.insertAfter(list.getFirstNode(), "b");
		assertEquals("Test insertAfter method", "b", list.getFirstNode().getNext().getData());
		assertEquals("Test if a node is successfully inserted", "3", list.getFirstNode().getNext().getNext().getData());
	}

	@Test
	public void testDeleteNext() {
		list.deleteNext(list.getFirstNode());
		assertEquals("Test deleteNext method", "1", list.getFirstNode().getNext().getData());
	}
	
	@Test
	public void testForwardTraversal() {
		DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		assertEquals("Test empty", true, myList.isEmpty());
		myList.insertFirst("i");
		assertEquals("Test insertFirst", "i", myList.getFirst());
		myList.insertFirst("X");
		assertEquals("Test insertFirst", "X", myList.getFirst());
		assertEquals("Test the position of i", "i", myList.getFirstNode().getNext().getData());
		myList.insertAfter(myList.getFirstNode().getNext(), "j");
		assertEquals("Test insertAfter", "j", myList.getFirstNode().getNext().getNext().getData());
		myList.insertLast("q");
		assertEquals("Test the last element in the list", "q", myList.getLast());
		myList.deleteNext(myList.getFirstNode().getNext().getNext());
		assertEquals("Test deletNext", "j", myList.getLast());
		myList.insertLast("i");
		assertEquals("Test the last element in the list", "i", myList.getLast());
		myList.insertLast("e");
		assertEquals("Test the last element in the list", "e", myList.getLast());
		
		DoublyLinkedListNode<String> node = (DoublyLinkedListNode<String>) myList.getFirstNode();
		String str = "";
		while(node != null) {
			if(node.getNext() != null) {
				str += node.getData() + "->";
			}
			else {
				str += node.getData();
			}
			node = (DoublyLinkedListNode<String>) node.getNext();
		}
		assertEquals("Test forward traversal", "X->i->j->i->e", str);
	}
	
	@Test
	public void testBackwardTraversal() {
		DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		assertEquals("Test empty", true, myList.isEmpty());
		myList.insertFirst("i");
		assertEquals("Test insertFirst", "i", myList.getFirst());
		myList.insertFirst("X");
		assertEquals("Test insertFirst", "X", myList.getFirst());
		assertEquals("Test the position of i", "i", myList.getFirstNode().getNext().getData());
		myList.insertAfter(myList.getFirstNode().getNext(), "j");
		assertEquals("Test insertAfter", "j", myList.getFirstNode().getNext().getNext().getData());
		myList.insertLast("q");
		assertEquals("Test the last element in the list", "q", myList.getLast());
		myList.deleteNext(myList.getFirstNode().getNext().getNext());
		assertEquals("Test deletNext", "j", myList.getLast());
		myList.insertLast("i");
		assertEquals("Test the last element in the list", "i", myList.getLast());
		myList.insertLast("e");
		assertEquals("Test the last element in the list", "e", myList.getLast());
		
		DoublyLinkedListNode<String> node = myList.getLastNode();
		String str = "";
		while(node != null) {
			if(node.getPrev() != null) {
				str += node.getData() + "->";
			}
			else {
				str += node.getData();
			}
			node = node.getPrev();
		}
		assertEquals("Test reverse traversal", "e->i->j->i->X", str);
	}

}
