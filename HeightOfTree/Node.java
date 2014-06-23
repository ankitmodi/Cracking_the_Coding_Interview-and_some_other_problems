class Node
{
	private Object data;
	private Node leftchild;
	private Node rightchild;

	
	
	public Node()
	{

		this.leftchild = null;
		this.rightchild = null;
	}

	
	
	public Node(Object elem)
	{
		this.data = elem;
		this.leftchild = null;
		this.rightchild = null;
	}

	
	
	public Object getData()
	{
		return data;
	}

	
	
	public void setData(Object inputData)
	{
		data = inputData;
	}

	
	
	public Node getLeftchild()
	{
		return leftchild;
	}

	
	
	public void setLeftchild(Node inputNode)
	{
		leftchild = inputNode;
	}

	
	
	public Node getRightchild()
	{
		return rightchild;
	}

	
	
	public void setRightchild(Node inputNode)
	{
		rightchild = inputNode;
	}

	

}
