/*
 * Evaluate an expression given in an JSON format. 
 * Keys will be: Expr - contains the entire expression Elem - contains the digit, 
 * Sum, Prod - contains two or more keys whose evaluation needs to be summed or multiplied, 
 * respectively, Sub - will contain two keys or more, where the second key onwards will have to
 *  be subtracted from the first one, Div - will contain two keys in which the first key 
 *  will need to be divided by the second
Sample Input: {"expr":{"sum":{"elem":["4","6","7","3"]}}}

 */
import java.util.*;
public class BrowserStack5_JSON2 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		//String input = "{\"expr\":{\"sum\":{\"elem\":[\"4\",\"6\",\"7\",\"3\"]}}}";
		//String input = "{\"expr\":{\"prod\":{\"elem\":[\"4\",\"6\",\"7\",\"3\"]}}}";
		//String input = "{\"expr\":{\"sub\":{\"elem\":[\"4\",\"6\"]}}}";
		String input = "{\"expr\":{\"div\":{\"elem\":[\"666\",\"6\"]}}}";
		
		
		String[] parts = input.split(":");
		parts[3] = parts[3].substring(1, parts[3].length()-4);
		for(String s: parts)
		{
			System.out.println(s);
		}
		
		String op = parts[1].substring(parts[1].indexOf("\"")+1, parts[1].length()-1);
		System.out.println(op);
		
		
		if(op.equals("sum"))
		{
			String[] nums = parts[3].split(",");
			int sum=0;
			for(String s: nums)
			{
				sum += Integer.parseInt(s.substring(1, s.length()-1));
			}
			System.out.println("Sum is: "+sum);
		}
		
		else if(op.equals("prod"))
		{
			String[] nums = parts[3].split(",");
			int prod=1;
			for(String s: nums)
			{
				prod *= Integer.parseInt(s.substring(1, s.length()-1));
			}
			System.out.println("prod is: "+prod);
		}
		
		else if(op.equals("sub"))
		{
			String[] nums = parts[3].split(",");
			int sub = Integer.parseInt(nums[1].substring(1, nums[1].length()-1)) - Integer.parseInt(nums[0].substring(1, nums[0].length()-1));
			System.out.println("sub is: "+sub);
		}
		
		else if(op.equals("div"))
		{
			String[] nums = parts[3].split(",");
			int div = Integer.parseInt(nums[0].substring(1, nums[0].length()-1)) / Integer.parseInt(nums[1].substring(1, nums[1].length()-1));
			System.out.println("div is: "+div);
		}

	}

}
