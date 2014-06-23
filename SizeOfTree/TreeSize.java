
public class TreeSize 
{

	
	public static void main(String[] args)
	{

		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));

		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		root.getRightchild().setLeftchild(new Node("f"));
		root.getRightchild().setRightchild(new Node("g"));

		System.out.println("Size is: " + Size(root));

}

	public static int Size(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
		{
			return 0;
		}
		int size = 0;
		size = 1 + Size(node.getLeftchild()) + Size(node.getRightchild());
		return size;
		
	}
	
}
