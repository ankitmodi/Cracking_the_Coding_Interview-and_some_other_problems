class Node{
	private Object data;
	private Node leftchild;
	private Node rightchild;
	private Node next;

	public Node(){

		this.leftchild = null;
		this.rightchild = null;
		this.next = null;
	}

	public Node(Object elem){
		this.data = elem;
		this.leftchild = null;
		this.rightchild = null;
		this.next = null;
	}

	public Object getData(){
		return data;
	}

	public void setData(Object inputData){
		data = inputData;
	}

	public Node getLeftchild(){
		return leftchild;
	}

	public void setLeftchild(Node inputNode){
		leftchild = inputNode;
	}

	public Node getRightchild(){
		return rightchild;
	}

	public void setRightchild(Node inputNode){
		rightchild = inputNode;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node inputNode){
		next = inputNode;
	}

}
