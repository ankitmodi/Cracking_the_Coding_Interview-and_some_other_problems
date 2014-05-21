
public class Mid_Of_Linked_List {
	
	public static Node getMid(SingleLinkedList1 MyList){
		
		Node double_jump = MyList.getHead();
		Node single_jump = MyList.getHead();
		
		while(double_jump.getNext() != null){
			double_jump = double_jump.getNext();
			single_jump = single_jump.getNext();
			
			if(double_jump.getNext() != null){
				double_jump = double_jump.getNext();
			}
		}
		
		return single_jump;
		
	}
	
	
	
	public static void main(String[] args){
		SingleLinkedList1 sll = new SingleLinkedList1();
		sll.traverse();
		sll.addFirst(56);
		sll.traverse();
		sll.addFirst(6);
		sll.traverse();
		sll.addLast(66);
		sll.traverse();
		sll.insertAfter(56,88);				//check insertion_normal
		sll.traverse();
		sll.insertBefore(88,99);				//check insertion_normal
		sll.traverse();
		
		Node tmp = getMid(sll);
		System.out.println("The mid element is:  " + tmp.getData());
		
		sll.delete(56);
		sll.traverse();
		
		tmp = getMid(sll);
		System.out.println("The mid element is:  " + tmp.getData());
		
		
		
	}

}




class SingleLinkedList1 {
	
	
	
	
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
