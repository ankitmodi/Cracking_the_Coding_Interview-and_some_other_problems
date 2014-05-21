public class MyStack{
	private int size;
	private int[] MyArr;
	private int top;
	
	public MyStack(int s){
		
		if(s<=0){
			throw new IllegalArgumentException ("Size must be positive");
		}
		this.size = s;
		this.top = -1;
		this.MyArr = new int[size];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == size -1);
	}
	
	public void Peek(){
		if(top==-1){
			try {
				throw new StackException ("Stack is empty");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("peek  "+MyArr[top]);
	}
	
	public void Push(int s){
		if(top==size-1){
			try {
				throw new StackException("Stack is full");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		MyArr[++top] = s;
	}
	
	public int Pop(){
		if(top==-1){
			try {
				throw new StackException ("Stack is empty");
			} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return MyArr[top--];
	}
	
	public void Print(){
		for(int i=0; i<=top;i++){
			System.out.println("print "+MyArr[i]);
		}
	}
	
	public static void main(String[] args){
		MyStack stack = new MyStack(5);
		int value;
		//value = stack.Pop();
		//System.out.println(value);
		stack.Push(5);
		stack.Push(15);
		stack.Push(55);
		stack.Print();
		stack.Peek();
		value = stack.Pop();
		System.out.println("pop  "+value);
		stack.Peek();
		stack.Print();
		stack.Push(52);
		stack.Push(154);
		stack.Push(535);
		//stack.Push(5);
		//stack.Push(15);
		//stack.Push(55);
		stack.Peek();
		stack.Print();
		value = stack.Pop();
		System.out.println("pop  "+value);
		value = stack.Pop();
		System.out.println("pop  "+value);
		value = stack.Pop();
		System.out.println("pop  "+value);
		value = stack.Pop();
		System.out.println("pop  "+value);
		stack.Peek();
		value = stack.Pop();
		System.out.println("pop  "+value);
		stack.Peek();
	}
	
}
