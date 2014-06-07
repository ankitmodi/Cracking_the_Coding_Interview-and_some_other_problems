// Implement three stacks efficiently in a single array
public class ThreeStack 
{

	private int maxSize;
	private int[] MyArr;
	
	private int top1;
	private int bottom2;
	private int top2;
	private int top3;
	
	
	
	public ThreeStack(int sizeOfArray)
	{
		this.maxSize = sizeOfArray;
		this.MyArr = new int[maxSize];
		
		this.top1 = -1;
		this.bottom2 = (maxSize-1)/2;
		this.top2 = bottom2-1;
		this.top3 = maxSize;	
	}
	
	
	
	public int size1()
	{
		return top1 + 1;
	}

	
	
	public int size2()
	{
		return top2 - bottom2 + 1;
	}

	
	
	public int size3()
	{
		return maxSize - top3;
	}

	
	
	public int size()
	{
		return this.size1() + this.size2() + this.size3();
	}
	
	
	
	public void display()
	{
		System.out.println("\nDisplay");
		for(int i=0; i<maxSize; i++)
		{
			if(i<=top1 || (i>=bottom2 && i<=top2) || i>=top3)
			{
				System.out.print(" "+ MyArr[i]);
			}
			else
			{
				System.out.print(" #");
			}
		}
	}
	
	
	
	//stack1 grows rightwards
	public void push1(int s)
	{
		if(bottom2-top1-1 == 0)
		{
			ShiftStack2Right();
		}
		MyArr[++top1] = s;
	}
	
	
	
	public int pop1()
	{
		if(this.size1()==0)
		{
			try 
			{
				throw new ThreeStackException("Stack1 is empty");
			} 
			catch (ThreeStackException e) 
			{
				e.printStackTrace();
			}
		}
		int result = MyArr[top1--];
		System.out.println("\nPopped from Stack1: "+ result);
		return result;
	}
	
	
	
	//stack2 grows rightwards
	public void push2(int s)
	{
		if(top3-top2-1==0)
		{
			ShiftStack2Left();
		}
		MyArr[++top2] = s;
	}
	
	
	
	public int pop2()
	{
		if(this.size2() == 0)
		{
			try 
			{
				throw new ThreeStackException("Stack2 is empty");
			} 
			catch (ThreeStackException e) 
			{
				e.printStackTrace();
			}
		}
		int result = MyArr[top2--];
		System.out.println("\nPopped from Stack2: "+ result);
		return result;
	}
	
	
	
	public void push3(int s)
	{
		if(top3-top2-1==0)
		{
			ShiftStack2Left();
		}
		MyArr[--top3] = s;
	}
	
	
	
	public int pop3()
	{
		if(this.size3() == 0)
		{
			try 
			{
				throw new ThreeStackException("Stack3 is empty");
			} 
			catch (ThreeStackException e) 
			{
				e.printStackTrace();
			}
		}
		int result = MyArr[top3++];
		System.out.println("\nPopped from Stack3: "+ result);
		return result;
	}



	private void ShiftStack2Right() 
	{
		int remSpace = top3 - top2 - 1;
		if(remSpace==0)
		{
			try 
			{
				throw new ThreeStackException("ThreeStack is full. Can't move right");
			} 
			catch (ThreeStackException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			int moveSpace = (remSpace/2) + (remSpace%2) ;
			for (int i = top2; i >= bottom2; i--)
			{
				MyArr[i + moveSpace] = MyArr[i];
			}
			bottom2 += moveSpace;
			top2 += moveSpace;
		}
	}
	
	
	
	private void ShiftStack2Left() 
	{
		int remSpace = bottom2 - top1 - 1;
		if(remSpace==0)
		{
			try 
			{
				throw new ThreeStackException("ThreeStack is full. Can't move left");
			} 
			catch (ThreeStackException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			int moveSpace = (remSpace/2) + (remSpace%2) ;
			for (int i = bottom2; i <= top2; i++)
			{
				MyArr[i - moveSpace] = MyArr[i];
			}
			bottom2 -= moveSpace;
			top2 -= moveSpace;
		}
	}



	public static void main(String[] args) 
	{
		ThreeStack stacks = new ThreeStack(12); 
		stacks.display();
		
		//to check if all the push work fine
		stacks.push1(11);
		stacks.push2(21);
		stacks.push3(31);
		stacks.display();
		
		stacks.push1(12);
		stacks.push2(22);
		stacks.push3(32);
		stacks.display();
		
		//to check if ShiftStack2Right works fine
		stacks.push1(13);
		stacks.push1(14);
		stacks.push1(15);
		stacks.display();
		
		stacks.push1(16);
		stacks.display();
		stacks.push1(17);
		stacks.display();
		stacks.push1(18);
		stacks.display();
		
		//to check if pop1 work fine
		int pop = stacks.pop1();
		pop = stacks.pop1();
		pop = stacks.pop1();
		pop = stacks.pop1();
		stacks.display();
		
		//to check if ShiftStack2Left works fine
		stacks.push2(23);
		stacks.display();
		
		stacks.push2(24);
		stacks.display();
		
		stacks.push2(25);
		stacks.display();
		
		stacks.push2(26);
		stacks.display();
		
		int s = stacks.size1();
		System.out.print("\nSize Stack1: " + s);
		s = stacks.size2();
		System.out.print("\nSize Stack2: " + s);
		s = stacks.size3();
		System.out.print("\nSize Stack3: " + s);
		s = stacks.size();
		System.out.print("\nSize ThreeStack: " + s);
		
		//to check if pop2 work fine
		pop = stacks.pop1();
		pop = stacks.pop1();
		pop = stacks.pop2();
		pop = stacks.pop2();
		stacks.display();
		
		//to check if all size() works fine
		s = stacks.size1();
		System.out.print("\nSize Stack1: " + s);
		s = stacks.size2();
		System.out.print("\nSize Stack2: " + s);
		s = stacks.size3();
		System.out.print("\nSize Stack3: " + s);
		s = stacks.size();
		System.out.print("\nSize ThreeStack: " + s);
		
		stacks.push3(33);
		stacks.display();
		stacks.push3(34);
		stacks.display();
		stacks.push3(35);
		stacks.display();
		
		stacks.push3(36);
		stacks.display();
		//When stack is full
		//stacks.push1(15);
		
		//to check if pop3 work fine
		pop = stacks.pop3();
		pop = stacks.pop2();
		pop = stacks.pop1();
		stacks.display();
		
		//to check if all size() works fine
		s = stacks.size1();
		System.out.print("\nSize Stack1: " + s);
		s = stacks.size2();
		System.out.print("\nSize Stack2: " + s);
		s = stacks.size3();
		System.out.print("\nSize Stack3: " + s);
		s = stacks.size();
		System.out.print("\nSize ThreeStack: " + s);
		
		
	}

}



class ThreeStackException extends Exception {
	public ThreeStackException(String s){
		System.out.println("\n"+s);
	}

}
