
public class DoublyLinkedList<T> extends LinkedList<T>{

	private DoublyLinkedListNode<T> tail;

	public DoublyLinkedList() {
		this.tail = null;
	}
	
	@Override
	public T getLast() {
		return tail.getData();
	}
	
	@Override
    public DoublyLinkedListNode<T> getLastNode() {
    	return tail;
	}
	
	@Override
    public void insertFirst(T data) {
		DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(data, null, null);
    	if(head == null) {
    		head = node;
    		tail = (DoublyLinkedListNode<T>) head;
    	}
    	else {
    		((DoublyLinkedListNode<T>) head).setPrev(node);
    		node.setNext(head);
    		head = node;
    	}
	}
	
	@Override
	public void insertAfter(LinkedListNode<T> currentNode, T data) { 
		if(head == null) {
			insertFirst(data);
		}
		else {
			DoublyLinkedListNode<T> nextNode = (DoublyLinkedListNode<T>) currentNode.getNext();
			if(nextNode == null) {
				insertLast(data);
			}
			
			else {
				DoublyLinkedListNode<T> insertNode = new DoublyLinkedListNode<T>(data, null, null);
				currentNode.setNext(insertNode);
				insertNode.setPrev((DoublyLinkedListNode<T>) currentNode);
				insertNode.setNext(nextNode);
				nextNode.setPrev(insertNode);
			}
		}
	}
	
	@Override
	public void insertLast(T data) {
		if(head == null) {
			insertFirst(data);
		} 
		else {
			DoublyLinkedListNode<T> currentNode = getLastNode();
			DoublyLinkedListNode<T> nextNode = new DoublyLinkedListNode<T>(data, null, null);
			currentNode.setNext(nextNode);
			nextNode.setPrev(currentNode);
			tail = nextNode;
		}
	}
    
	@Override
    public void deleteFirst() {
    	if(head.getNext() == null) {
    		head = null;
    		tail = (DoublyLinkedListNode<T>) head;
    	}
    	
    	else {
    		head = head.getNext();
    	}
    }
    
	@Override
    public void deleteLast() {
    	DoublyLinkedListNode<T> currentNode = (DoublyLinkedListNode<T>) head;
        if(currentNode.getNext() == null) {
        	deleteFirst();
        }
        
        else {
        	DoublyLinkedListNode<T> secondToLastNode = tail.getPrev();
        	secondToLastNode.setNext(null);
        	tail = secondToLastNode;
        } 
    }
	
	@Override
	public void deleteNext(LinkedListNode<T> currentNode) {
		DoublyLinkedListNode<T> node = (DoublyLinkedListNode<T>) currentNode.getNext();
		if(node != null) {
			node = (DoublyLinkedListNode<T>) node.getNext();
			if(node !=null) {
				currentNode.setNext(node);
				node.setPrev((DoublyLinkedListNode<T>) currentNode);
			}
			else {
				deleteLast();
			}
		} 
		
	}
	
	@Override
	public boolean isEmpty() {
		if(head == tail && head == null) {
			return true;
		}
		return false;
	}
}
