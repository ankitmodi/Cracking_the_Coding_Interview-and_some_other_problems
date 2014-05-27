// Implement an algorithm to delete a Node in the middle of a singly linked list,
// given only acces to that node.

public class SingleLinkedList {
	
	
	
	
	private Node head = null;
	private Node tail = null;
	private static int counter = 0;
	
	public SingleLinkedList(){
		
	}
	
	
	
	public int size(){
		return counter;
	}
	
	
	
	public Node getHead(){
		return head;
	}
	
	
	
	public void traverse(){
		if(head==null){
			System.out.println(" Linked List is empty");
		}
		else{
			for(Node n=head; n!=null;n=n.getNext()){
				System.out.print(" "+ n.getData());
			}
			System.out.println("\nsize:  " + this.size());
		}
		
	}
	
	
	
	public void addLast(int elem){
		if(head==null){
			
			head = new Node(elem);
		}
		else{
			Node temp = head;
			while(temp.getNext() != null){
				temp=temp.getNext();
			}
			
			Node inputNode = new Node(elem);
			temp.setNext(inputNode);
			inputNode.setNext(tail);
		}
		counter++;
	}
	
	
	
	public static void deleteMid(Node middle){
		
		Node tmp = middle.getNext();
		middle.setData(tmp.getData());
		middle.setNext(tmp.getNext());
		counter--;
	}
	
	
	
	public static void main(String[] args){
		SingleLinkedList sll = new SingleLinkedList();
		sll.addLast(1);
		sll.addLast(2);
		sll.addLast(3);
		sll.addLast(4);
		sll.addLast(5);
		
		sll.traverse();
		Node head = sll.getHead();
		Node mid = head.getNext().getNext(); // the middle node
		deleteMid(mid);
		sll.traverse();
	}
	
}




class Node{
	private int data;
	private Node next;
	
	public Node(){
		
		this.next =null;
	}
	
	public Node(int elem){
		this.data = elem;
		this.next =null;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int inputData){
		data = inputData;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node inputNode){
		next = inputNode;
	}
	
}
