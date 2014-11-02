/*
Given two JSON objects, find the values of fields. whose values are different.
Eg. Input
{"Geeks":"Test1","Are":"hey","Cool":"yeah"}
{"Geeks":"Test1","Are":"20","Cool":['B','C']}

Output:
Are:Cool
 */
import java.util.*;
public class BrowserStack1_JSON 
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//String given = "{"Geeks":"Test1","Are":"hey","Cool":"yeah"}";
		System.out.println("Enter String1: ");
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		s1 = s1.substring(1,s1.length()-1);			//remove the curly braces
		
		System.out.println("Enter String2: ");
		String s2 = scan.next();
		s2 = s2.substring(1,s2.length()-1);
		
		String[] parts1 = s1.split(",\"");			//split via ,"
		String[] parts2 = s2.split(",\"");
		String result = "";
		
		for(int i=0; i< parts1.length; i++)
		{
			if(!parts1[i].equals(parts2[i]))					//if both strings are not equal
			{
				int idx = parts1[i].indexOf("\"");				//find index of "
				result += parts1[i].substring(0,idx)+":";		//add key+: to result
			}
		}
		System.out.println(result.substring(0,result.length()-1));		//remove the last :

	}

}
