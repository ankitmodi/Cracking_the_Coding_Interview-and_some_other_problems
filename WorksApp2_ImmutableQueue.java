package jp.co.worksap.global;

import java.util.NoSuchElementException;

public class WorksApp2_ImmutableQueue<E> 
{
	
	//Helper class : Implementing Immutable Queue using two stacks
	private static class Stack<E>
	{
		private E top;				//top element
		private Stack<E> bottom;	//Elements other than top are in a stack called
		private int size;			//keeps count of size of the stack
		public Stack()				//default constructor
		{
			this.top =null;
			this.bottom = null;
			this.size = 0;
		}
		
		private Stack(Stack<E> stack, E e)	//private constructor
		{
			this.top = e;
			this.bottom = stack;
			this.size = stack.size + 1;
		}
		
	    public boolean isEmpty()
	    {
	        return this.getSize() == 0;
	    }    
	    public int getSize()
	    {
	    	return size;
	    }
	    //returns a new stack with top as the element e and bottom as this stack
	    public Stack<E> push(E e)
	    {
	    	return new Stack(this, e);
	    }

		/*public Stack pop() 
		{
			return new Stack(this.bottom.bottom, this.bottom.top);
		}*/

	    //returns the a stack which is reverse of this stack
		public Stack reverse() 
		{
			Stack<E> reverse = new Stack<E>();
			Stack straight = this;
			while(!straight.isEmpty())
			{
				reverse = reverse.push((E) straight.top);
				straight = straight.bottom;
			}
			return reverse;
		}
	    
	}
	
	//two stacks used in Immutable Queue implementation
	private Stack<E> stackMain;			//elements pushed onto new version of this to protect immutability
	private Stack<E> stackSpare;		//elements popped from new version of this to protect immutability
	
	
	//default constructor
	public ImmutableQueue()
	{
		this.stackMain = new Stack();
		this.stackSpare = new Stack();
	}
	
	
	//private constructor
	private ImmutableQueue(Stack<E> main, Stack<E> spare)
	{
		this.stackMain = main;
		this.stackSpare = spare;
	}	
	
	
	//returns a new immutable queue by taking MODIfied version of this.stackMain
	public ImmutableQueue<E> enqueue(E e) 
	{
		if(e == null)
		{
			throw new IllegalArgumentException();
		}
		return new ImmutableQueue(this.stackMain.push(e), this.stackSpare);
	}
	
	
	//returns a new immutable queue
	public ImmutableQueue<E> dequeue()
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		//if stackSpare is empty then pour all its elements onto stackSpare and make an empty StackMain.
		if(this.stackSpare.isEmpty())
		{
			return new ImmutableQueue(new Stack(), this.stackMain.reverse().bottom);
		}
		//else simply dequeue from a new version of stackSpare
		else
		{
			return new ImmutableQueue(this.stackMain, this.stackSpare.bottom);
		}
	}


	//looks on the top element of stackSpare
	public E peek() 
	{
		if(this.isEmpty())
		{
			throw new NoSuchElementException();
		}
		//if stackSpare is empty then pour all of stackMain onto stackSpare
		if(this.stackSpare.isEmpty())
		{
			this.stackSpare = this.stackMain.reverse();
			this.stackMain = new Stack<E>();
		}
		return this.stackSpare.top;
		
	}
	
	
	public int Size()
	{
		return this.stackMain.size + this.stackSpare.size;
	}
	
	
	public boolean isEmpty()
	{
		return this.Size()==0;
	}
	
	//methods to test the correctness of implementation
	/*
	public void see()
	{
		System.out.println("is the queue Empty? " + this.isEmpty() + "\t Size is: " + this.Size());
		if(!this.isEmpty())
		{
			System.out.println("Peek: " + this.peek());
		}
	}
		
	
	public static void main(String[] args) 
	{
		ImmutableQueue q = new ImmutableQueue();
		q.see();
		ImmutableQueue q2 = q.enqueue(10);
		q2.see();
		q.see();
		ImmutableQueue q3 = q2.enqueue(20);
		q3.see();
		q2.see();
		q.see();
		ImmutableQueue q4 = q3.dequeue();
		q4 = q4.dequeue();
		q4.see();
		
		
	}
	*/
	

}
