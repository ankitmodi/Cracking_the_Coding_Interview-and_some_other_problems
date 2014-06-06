//Linked List based implementation of a stack
public class MyStackLL
{
	
	private Node top;
	private Node bottom;
	
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
	
	public MyStackLL()
	{
		this.top = null;
		this.bottom = null;
	}
	
	
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	
	
	public int size()
	{
		int counter = 0;
		for(Node n = bottom; n !=null; n = n.next)
		{
			counter++;
		}
		System.out.println("size: "+ counter);
		return counter;
	}
	
	
	
	// traverse() has been written just to check if the implementaton works correctly
	public void traverse()
	{
		for(Node n = bottom; n !=null; n = n.next)
		{
			System.out.print(" " +n.data);
		}
		System.out.println("");
		
	}
	
	
	
	public void push (Object s)
	{
		Node tmp = new Node(s);
		if(this.isEmpty())
		{
			bottom = top = tmp;
			return;
		}
		else
		{
			top.next = tmp;
			top = tmp;
			
		}
		
	}
	
	
	
	public Object pop()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new StackEmptyException("Stack is Empty");
			} catch (StackEmptyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Node tmp;
		//when size is 1
		if(top == bottom)
		{
			tmp = top;
			top = bottom = null;
			return tmp.data;
		}
		else
		{
			Node n =bottom;
			while(n.next != top)
			{
				n = n.next;
			}
			Object popped_data = top.data;
			top = n;
			top.next = null;
			System.out.println("popped: " + popped_data);
			return popped_data;

		}
			}
	
	
	
	public void peek()
	{
		if(this.isEmpty())
		{
			try 
			{
				throw new StackEmptyException("Stack is Empty");
			} catch (StackEmptyException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Object tmp = top.data;
		System.out.println("peek: " + tmp);
	}
	
	
	
	public static void main(String args[])
	{
		MyStackLL stack = new MyStackLL();
		System.out.println("isEmpty(): " + stack.isEmpty());
		stack.size();
		//Object t = stack.pop();
		
		stack.push("a") ;
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.traverse();
		System.out.println("isEmpty(): " + stack.isEmpty());
		stack.size();
		
		stack.peek();
		
		Object s = stack.pop();
		stack.traverse();
		System.out.println("isEmpty(): " + stack.isEmpty());
		stack.size();
		
		s = stack.pop();
		stack.traverse();
		System.out.println("isEmpty(): " + stack.isEmpty());
		stack.size();
		
		
		
	}

}


class StackEmptyException extends Exception {
	public StackEmptyException(String s){
		System.out.println(s);
	}

}

