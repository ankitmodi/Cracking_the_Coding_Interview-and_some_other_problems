//Implement a queue using two stacks

import java.util.*;
public class MyQueue
{
	private Stack stack1;
	private Stack stack2;
	
	public MyQueue()
	{
		this.stack1 = new Stack();
		this.stack2 = new Stack();
	}
	
	
	
	public void enqueue(Object toEnqueue)
	{
		stack1.push(toEnqueue);
		System.out.println("Enqueue: " + toEnqueue);
	}
	
	
	
	public Object dequeue()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
		{
			try
			{
				throw new QueueEmptyException("Queue is empty");
			}
			catch(QueueEmptyException e)
			{
				e.printStackTrace();
			}
		}
		
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				Object tmp = stack1.pop();
				stack2.push(tmp);
			}
		}
		Object popped_data = stack2.pop();
		System.out.println("Dequeue: " + popped_data);
		return popped_data;
	}
	
	
	
	public static void main(String args[])
	{
		MyQueue queue = new MyQueue();
		Integer[] array = new Integer[]{new Integer(100), new Integer(101), new Integer(102)};
		
		//Object obj = queue.dequeue();
		queue.enqueue(array[0]);
		queue.enqueue(array[1]);
		queue.enqueue(array[2]);
		
		Object t = queue.dequeue();
		t = queue.dequeue();
		t = queue.dequeue();
		//t = queue.dequeue();
	}
	

}


class QueueEmptyException extends Exception {
	public QueueEmptyException(String s){
		System.out.println(s);
	}

}

