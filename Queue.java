
public class Queue 
{
	
	private Node front;
	private Node rear;
	
	private class Node
	{
		
		private Object data;
		private Node next;
		
		public Node(Object input)
		{
			this.data = input;
			this.next = null;
		}
	}
	
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
		for(Node n = front; n !=null; n = n.next)
		{
			counter++;
		}
		System.out.println("size: "+ counter);
		return counter;
	}
	
	// traverse() has been written just to check if the implementaton works correctly
	/*
	public void traverse()
	{
		for(Node n = front; n !=null; n = n.next)
		{
			System.out.print(" " +n.data);
		}
		System.out.println("");
		
	}
	*/
	
	
	public void enqueue (Object toEnqueue)
	{
		Node tmp = new Node(toEnqueue);
		if(this.isEmpty())
		{
			front = rear = tmp;
			return;
		}
		
		rear.next = tmp;
		rear = tmp;
		
	}
	
	
	
	public Object dequeue()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new QueueEmptyException("Queue is Empty");
			} catch (QueueEmptyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Node tmp = front;
		front = front.next;
		if(front == null)
		{
			rear = null;
		}
		Object tmp2 = tmp.data;
		System.out.println("dequeue: " + tmp2);
		return tmp2;
	}
	
	
	
	public Object getFront()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new QueueEmptyException("Queue is Empty");
			} catch (QueueEmptyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Object tmp = front.data;
		System.out.println("getFront: " + tmp);
		return tmp;
	}
	
	
	
	public Object getRear()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new QueueEmptyException("Queue is Empty");
			} catch (QueueEmptyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Object tmp = rear.data;
		System.out.println("getRear: " + tmp);
		return tmp;
	}
	
	
	
	public static void main(String args[])
	{
		Queue queue = new Queue();
		System.out.println(queue.isEmpty());
		queue.size();
		//Object s = queue.dequeue();
		
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		//queue.traverse();
		System.out.println(queue.isEmpty());
		queue.size();
		
		Object g = queue.getFront();
		g = queue.getRear();
		//queue.traverse();
		
		Object s = queue.dequeue();
		//queue.traverse();
		System.out.println(queue.isEmpty());
		queue.size();
		
		s = queue.dequeue();
		//queue.traverse();
		System.out.println(queue.isEmpty());
		queue.size();
		
		
	}

}


class QueueEmptyException extends Exception {
	public QueueEmptyException(String s){
		System.out.println(s);
	}

}

