
public class DoublyLinkedListNode<T> extends LinkedListNode<T>{
	
	public DoublyLinkedListNode<T> prev;
	
	public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> prev) {
		super(data, next);
		this.prev = prev;

	}
	
	public void setPrev(DoublyLinkedListNode<T> node) {
		this.prev = node;
	}
	
	public DoublyLinkedListNode<T> getPrev() {
		return prev;
	}
}
