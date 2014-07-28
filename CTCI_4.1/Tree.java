
public class Tree 
{

	
	public static void main(String[] args)
	{

		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));

		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		
		//comment out below two lines to check for an unbalanced tree
		//root.getLeftchild().getLeftchild().setLeftchild(new Node("f"));
		//root.getLeftchild().getLeftchild().setRightchild(new Node("g"));
		
		isTreeBalancedBFT(root);
		//System.out.println("Height is: " + Height(root));
		System.out.println("Balanced ?: " + isTreeBalancedBFT(root));

	}	
	
	
	
	public static boolean isTreeBalancedBFT(Node root)
	{
		Node temp;

		Queue queue = new Queue();
		queue.enqueue(root);
		
		boolean check = true;

		while(!queue.isEmpty())
		{

			temp = queue.dequeue();
			//System.out.println("Traversed: " + temp.getData());
			check = isNodeBalanced(temp);
			if(!check)
			{
				break;
			}

			if(temp.getLeftchild() != null)
			{
				queue.enqueue(temp.getLeftchild());
			}
			if(temp.getRightchild() != null)
			{
				queue.enqueue(temp.getRightchild());
			}

			//remove this line if you just want to see the BFT and not how the queue works
			//queue.traverse();
		}
		
		return check;

	}
	
	
	
	public static boolean isNodeBalanced(Node node)
	{
		
		int heightDifference = Height(node.getLeftchild())- Height(node.getRightchild());
		if(heightDifference < 0)
		{
			heightDifference = -1 * heightDifference ;
		}
		
		if(heightDifference <= 1)
		{
			return true;
		}
		else
		{
			return false;
		}
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
