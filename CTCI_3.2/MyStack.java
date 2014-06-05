//Design a stack with methods push(), pop() and min(). 
//Each of them must operate in O(1) time

public class MyStack
{
	private int size;
	private int[] MyArr;
	private int top;
	private int min_idx;
	private int[] MinIdxArr;
	
	public MyStack(int s)
	{
		
		if(s<=0){
			throw new IllegalArgumentException ("Size must be positive");
		}
		this.size = s;
		this.top = -1;
		this.MyArr = new int[size];
		this.min_idx = -1;
		this.MinIdxArr = new int[size];
	}
	
	
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	
	
	public boolean isFull()
	{
		return (top == size -1);
	}
	
	
	
	public void Push(int s)
	{
		if(isFull()){
			try {
				throw new StackException("Stack is full");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(isEmpty())
		{
			top++;
			MyArr[top] = s;
			min_idx++ ;
			MinIdxArr[top] =min_idx;
		}
		
		else
		{
			top++;
			MyArr[top] = s;
			MinIdxArr[top] =min_idx;
			if(s < MyArr[min_idx])
			{
				min_idx = top;
			}
		}
		
	}
	
	
	
	public int Pop(){
		if(isEmpty()){
			try {
				throw new StackException ("Stack is empty");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(top == min_idx)
		{
			min_idx = MinIdxArr[top];
		}
		return MyArr[top--];
	}
	
	
	
	public int getMin()
	{
		return MyArr[min_idx];
	}
	
	
	
	//this function is to check if the stack implementation works as intended
	public void Print(){
		System.out.println("Array:");
		for(int i=0; i<=top;i++){
			System.out.print(" "+MyArr[i]);
		}
		System.out.println("\nMin Indices:");
		for(int i=0; i<=top;i++){
			System.out.print(" "+MinIdxArr[i]);
		}
	}
	
	
	
	public static void main(String[] args){
		MyStack stack = new MyStack(10);
		int minValue;
		int popValue;
		//value = stack.Pop();
		//System.out.println(value);
		stack.Push(4);
		stack.Push(5);
		stack.Push(2);
		stack.Push(8);
		stack.Push(-15);
		stack.Push(20);
		stack.Print();
		
		minValue = stack.getMin();
		System.out.println("\nmin  "+minValue);
		
		popValue = stack.Pop();
		System.out.println("\npop  "+popValue);
		stack.Print();
		minValue = stack.getMin();
		System.out.println("\nmin  "+minValue);
		
		popValue = stack.Pop();
		System.out.println("\npop  "+popValue);
		stack.Print();
		minValue = stack.getMin();
		System.out.println("\nmin  "+minValue);
		
		popValue = stack.Pop();
		System.out.println("\npop  "+popValue);
		stack.Print();
		minValue = stack.getMin();
		System.out.println("\nmin  "+minValue);
		
		popValue = stack.Pop();
		System.out.println("\npop  "+popValue);
		stack.Print();
		minValue = stack.getMin();
		System.out.println("\nmin  "+minValue);
		
		
	}
	
}


class StackException extends Exception {
	public StackException(String s){
		System.out.println(s);
	}

}
