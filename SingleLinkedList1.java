

public class SingleLinkedList1 {
	
	
	
	
	private Node head = null;
	private Node tail = null;
	private int counter = 0;
	
	public SingleLinkedList1(){
		
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
	
	
	
	public void addFirst(int elem){
		if(head==null){
			
			head = new Node(elem);
		}
		else{
			
			Node inputNode = new Node(elem);
			inputNode.setNext(head);
			head = inputNode;
		}
		counter++;
	}
	
	
	
	public void insertAfter(int key, int toInsert){
		Node temp = head;
		while(!(temp == null) && !(temp.getData() == key) ){
			temp=temp.getNext();	
		}
		if(temp==null){
			System.out.println("\nKey not found\n");
		}
		else{
			Node temp2 = temp.getNext();
			temp.setNext( new Node (toInsert));
			temp.getNext().setNext(temp2);
			counter++;
		}
		
	}
	
	
	
	public void insertBefore(int key, int toInsert){
		if(head.getData()==key){
			addFirst(toInsert);
			counter++;
		}
		
		else{
			Node prev = null;
			Node curr = head;
			while(!(curr == null) && !(curr.getData() == key) ){
				prev = curr;
				curr = curr.getNext();
			}
			
			if(curr == null){
				System.out.println("\nKey not found\n");
			}
			else{
				prev.setNext(new Node(toInsert));
				prev.getNext().setNext(curr);
				counter++;
			}
		}
	}
	
	
	public void delete(int key){
		if(head.getData()==key){
			head = head.getNext();
			counter--;
		}
		
		else{
			Node prev = null;
			Node curr = head;
			while(!(curr == null) && !(curr.getData() == key) ){
				prev = curr;
				curr = curr.getNext();
			}
			
			if(curr == null){
				System.out.println("\nKey not found\n");
			}
			else{
				prev.setNext(curr.getNext());
				counter--;
			}
		}
	}
	
	
	
	public static void main(String[] args){
		SingleLinkedList1 sll = new SingleLinkedList1();
		sll.traverse();
		sll.addFirst(56);
		sll.traverse();
		sll.addFirst(6);
		sll.traverse();
		sll.addLast(89);
		sll.traverse();
		
		sll.insertAfter(56,88);				//check insertion_normal
		sll.traverse();
		sll.insertAfter(6,88);				//check insertion_at_front
		sll.traverse();
		sll.insertAfter(2000,599);			//check insertion_key_not_present
		sll.traverse();
		
		sll.insertBefore(56, 30);			//check insertion_normal
		sll.traverse();
		sll.insertBefore(89, 31);			//check insertion_at_end
		sll.traverse();
		sll.insertBefore(6, 32);			//check insertion_at_front
		sll.traverse();
		sll.insertBefore(88, 33);			//check insertion_double_key
		sll.traverse();
		sll.insertBefore(2000, 33);			//check insertion_key_not_present
		sll.traverse();
		
		sll.delete(56);						//check deletion_normal
		sll.traverse();
		sll.delete(32);						//check deletion_at_front
		sll.traverse();
		sll.delete(89);						//check deletion_at_end
		sll.traverse();
		sll.delete(2000);					//check deletion_key_not_present
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
