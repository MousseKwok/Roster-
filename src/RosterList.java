/**
 * Roster list model class
 * @author Xijie Guo
 *
 */
public class RosterList {
	
	private DoublyLinkedList<String> list;
	private DoublyLinkedList<String> waitList;
	
	public RosterList() {
		list = new DoublyLinkedList<String>();
		waitList = new DoublyLinkedList<String>();
	}
	
	public void addToWaitlist(String name) {
		waitList.insertLast(name);
	}
	
	public void addToRosterList(String name) {
		if(list.isEmpty()) {
			list.insertFirst(name);
		}
		
		else if(name.compareTo(list.getFirst()) < 0) {
			list.insertFirst(name);
		}
		
		else if(name.compareTo(list.getLast()) > 0) {
			list.insertLast(name);
		}
		
		else if(name.compareTo(list.getLast()) == 0) {
			list.insertLast(name);
		}
		
		else {
			DoublyLinkedListNode<String> node;
			for(node = (DoublyLinkedListNode<String>) list.getFirstNode().getNext(); node != null; node = (DoublyLinkedListNode<String>) node.getNext()) {
				if(name.compareTo(node.getPrev().getData()) > 0 && name.compareTo(node.getData()) < 0) {
					list.insertAfter(node.getPrev(), name);
					break;
				}
				
				else if(name.compareTo(node.getData()) == 0) {
					list.insertAfter(node, name);
					break;
				}
			}	
		}
	}
	
	public void removeStudents(DoublyLinkedListNode<String> currentNode, String name) {
		if(!list.isEmpty()) {
			if(name.compareTo(list.getFirst()) == 0) {
				list.deleteFirst();
			}
			else if(name.compareTo(list.getLast()) == 0) {
				list.deleteLast();
			}
			else {
				DoublyLinkedListNode<String> node;
				for(node = (DoublyLinkedListNode<String>) list.getFirstNode(); node != null; node = (DoublyLinkedListNode<String>) node.getNext()) {
					if(currentNode.getData().equals(node.getData())) {
						list.deleteNext(currentNode);
						break;
					}
				}
			}
			
		}
	}
	
	public DoublyLinkedListNode<String> getNode(String data) {
		DoublyLinkedListNode<String> node;
		for(node = (DoublyLinkedListNode<String>) list.getFirstNode(); node != null; node = (DoublyLinkedListNode<String>) node.getNext()) {
			if(node.getData().equals(data)) {
				return node;
			}
		}
		return null;
	}
	
	public int getSize() {
		return list.size();
	}
	
	public String printList() {
		DoublyLinkedListNode<String> current = (DoublyLinkedListNode<String>) list.getFirstNode();
		String str = "";
		while(current != null) {
			if(current.getNext() != null) {
				str += (current.getData()).toString() + "\n";
			    current = (DoublyLinkedListNode<String>) current.getNext();
		    }
			else {
				str += (current.getData()).toString();
			    current = (DoublyLinkedListNode<String>) current.getNext();
		    }
		}
		return str;
	}
	
	public String printWaitlist() {
		DoublyLinkedListNode<String> current = (DoublyLinkedListNode<String>) waitList.getFirstNode();
		String str = "";
		while(current != null) {
			if(current.getNext() != null) {
				str += (current.getData()).toString() + "\n";
			    current = (DoublyLinkedListNode<String>) current.getNext();
		    }
			else {
				str += (current.getData()).toString();
			    current = (DoublyLinkedListNode<String>) current.getNext();
		    }
		}
		return str;
	}
	
	public DoublyLinkedListNode<String> getWaitlistStudent() {
		return (DoublyLinkedListNode<String>) waitList.getFirstNode();
	}
	
	public void removeStudentsFromWaitlist() {
		waitList.deleteFirst();
	}
	
}
