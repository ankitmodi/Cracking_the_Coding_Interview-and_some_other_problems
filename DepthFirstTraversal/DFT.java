
public class DFT 
{
	
	public static void main(String[] args) 
	{
		
		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));
		
		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		
		System.out.println("Graph is: ");
		System.out.println("    a\n  b    c\nd   e");
		
		System.out.println("\nPreOrder Traversal: ");
		PreOrder(root);
		
		System.out.println("\nInOrder Traversal: ");
		InOrder(root);
		
		System.out.println("\nPostOrder Traversal: ");
		PostOrder(root);
	}
	
	
	
	public static void PreOrder(Node root)
	{
		
		if(root == null)
		{
			return;
		}
		System.out.print(" " + root.getData());
		PreOrder(root.getLeftchild());
		PreOrder(root.getRightchild());
	}
	
	
	
	public static void InOrder(Node root)
	{
		
		if(root == null)
		{
			return;
		}
		InOrder(root.getLeftchild());
		System.out.print(" " + root.getData());
		InOrder(root.getRightchild());
	}
	
	
	
	public static void PostOrder(Node root)
	{
		
		if(root == null)
		{
			return;
		}
		
		PostOrder(root.getLeftchild());
		PostOrder(root.getRightchild());
		System.out.print(" " + root.getData());
	}
}
