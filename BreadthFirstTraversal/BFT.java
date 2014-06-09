
public class BFT 
{

	/**
	 * @param args
	 */
	public static void BreadthFirstTraversal(Node root)
	{
		Node temp;

		Queue queue = new Queue();
		queue.enqueue(root);
		
		while(!queue.isEmpty())
		{
			
			temp = queue.dequeue();
			System.out.println("Traversed: " + temp.getData());
			
			if(temp.getLeftchild() != null)
			{
				queue.enqueue(temp.getLeftchild());
			}
			if(temp.getRightchild() != null)
			{
				queue.enqueue(temp.getRightchild());
			}
			
			//remove this line if you just want to see the BFT and not how the queue works
			queue.traverse();
		}
		
	}
	
	
	
	public static void main(String[] args) 
	{
		
		Node root = new Node("a");
		root.setLeftchild(new Node("b"));
		root.setRightchild(new Node("c"));
		
		root.getLeftchild().setLeftchild(new Node("d"));
		root.getLeftchild().setRightchild(new Node("e"));
		root.getRightchild().setLeftchild(new Node("f"));
		root.getRightchild().setRightchild(new Node("g"));
		
		BreadthFirstTraversal(root);

	}
	

	

}
