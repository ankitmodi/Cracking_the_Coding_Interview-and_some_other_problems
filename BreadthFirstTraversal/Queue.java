
public class Queue 
{
	
	private Node front;
	private Node rear;
	
	
	public Queue()
	{
		this.front = null;
		this.rear = null;
	}
	
	
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	
	
	public int size()
	{
		int counter = 0;
		for(Node n = front; n !=null; n = n.getNext())
		{
			counter++;
		}
		//System.out.println("size: "+ counter);
		return counter;
	}
	
	
	
	// traverse() has been written just to check if the implementaton works correctly
	public void traverse()
	{
		System.out.print("Queue: ");
		for(Node n = front; n !=null; n = n.getNext())
		{
			System.out.print(" " +n.getData());
		}
		System.out.println("");
		
	}
	
	
	
	public void enqueue (Node tmp)
	{
		
		if(this.isEmpty())
		{
			front = rear = tmp;
			return;
		}
		
		rear.setNext(tmp);
		rear = tmp;
		
	}
	
	
	
	public Node dequeue()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new QueueEmptyException("Queue is Empty");
			} catch (QueueEmptyException e) 
			{
				
				e.printStackTrace();
			}
		}
		Node tmp = front;
		front = front.getNext();
		if(front == null)
		{
			rear = null;
		}
		
		return tmp;
	}
	
}


class QueueEmptyException extends Exception {
	public QueueEmptyException(String s){
		System.out.println(s);
	}

}

