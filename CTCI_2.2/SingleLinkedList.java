//Find the Nth Node from last of a linked in a one pass.


public class SingleLinkedList {
	
	
	
	private class Node{
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
	
	private static Node head = null;
	private Node tail = null;
	private int counter = 0;
	
	public SingleLinkedList(){
		
	}
	
	
	
	public int size(){
		return counter;
	}
	
	
	
	public void traverse(){
		if(head==null){
			System.out.println(" Linked List is empty");
		}
		else{
			for(Node n=head; n!=null;n=n.next){
				System.out.print(" "+ n.getData());
			}
			System.out.println("\nsize:  " + this.size());
		}
		
	}
	
	
	
	public void addFirst(int elem){
		if(head==null){
			
			head = new Node(elem);
		}
		else{
			
			Node inputNode = new Node(elem);
			inputNode.next = head;
			head = inputNode;
		}
		counter++;
	}
	
	
	
	public static void printNthNodeFromLast(int N){
		Node nth = head;
		Node tmp = head;
		
		if(head == null){
			System.out.println("List is empty");
		}
		
		else{
			int counter = 0;
			while(counter < N){
				
				if(tmp == null){
					System.out.println("N exceeds size of the List");
					break;
				}
				tmp = tmp.getNext();
				counter++ ;
			}
		
			while(tmp != null){
				tmp = tmp.getNext();
				nth = nth.getNext();
			}
			System.out.println("Element no. " + N + " from last is:	" + nth.getData());
		}
	}
	
	
	
	public static void main(String[] args){
		SingleLinkedList sll = new SingleLinkedList();
		
		sll.addFirst(56);
		sll.addFirst(55);
		sll.addFirst(6);
		sll.addFirst(556);
		sll.addFirst(555);
		sll.addFirst(65);
		sll.traverse();
		
		printNthNodeFromLast(3);
		
	}
	
	
	

}
