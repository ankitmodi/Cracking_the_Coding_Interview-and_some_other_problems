
public class Tree3 
{

	
	public static void main(String[] args)
	{

		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));

		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		
		//comment out below two lines to check for an unbalanced tree
		root.getLeftchild().getLeftchild().setLeftchild(new Node("f"));
		root.getLeftchild().getLeftchild().setRightchild(new Node("g"));
		
		isTreeBalanced(root);
		//System.out.println("Height is: " + Height(root));
		System.out.println("Balanced ?: " + isTreeBalanced(root));

	}	
	
	
	
	public static boolean isTreeBalanced(Node node)
	{
		
		
		if(Height(node) == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	public static int Height(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
		{
			return 0;
		}
		
		int leftHeight = Height(node.getLeftchild());
		if(leftHeight == -1)
		{
			return -1;
		}
		
		int rightHeight = Height(node.getRightchild());
		if(rightHeight == -1)
		{
			return -1;
		}
		
		int heightDifference = difference(leftHeight , rightHeight);
		
		if(heightDifference > 1)
		{
			return -1;
		}
		else
		{
			return 1 + max(leftHeight , rightHeight);
		}
		
	}
	
	
	
	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	
	
	
	public static int difference(int a, int b) {
		// TODO Auto-generated method stub
		if(a > b)
		{
			return a-b ;
		}
		else
		{
			return b-a ;
		}
	}
	
	
}
