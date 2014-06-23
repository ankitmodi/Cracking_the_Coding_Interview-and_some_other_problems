
public class TreeHeight 
{

	
	public static void main(String[] args)
	{

		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));

		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		
		System.out.println("Height is: " + Height(root));

	}
	
	
	
	public static int Height(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
		{
			return 0;
		}
		int height = 0;
		height = 1 + max(Height(node.getLeftchild()),  Height(node.getRightchild()));
		return height;
		
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
	
	
}
