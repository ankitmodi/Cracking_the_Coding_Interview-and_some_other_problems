/*

Sticky Problem (Programming)

As a teacher for a 1st grade class, you plan an activity for the kids to introduce them to what a rectangle is.

 

In an attempt to do that, you decide to cut 4 equal sized sticks, and stick them together as a rectangle. After cutting 3 sticks and pasting them at right angles to each other (one base and 2 sides), you realize that there was some error in cutting the first 3 sticks. What you do know though, is the range within which each of the sticks length falls. Lets say the ith stick falls in the range (li, ui). Now, when the 4th stick - you want to be sure of the range in which the 4th stick should fall for it to be stuck on the remaining side, so that no part of it comes out of the rectangle.

 

                    Invalid Rectangle Image                       Valid rectangle image

 

In other words, given l1, u1, l2, u2, l3, u3 and knowing that the sticks are stuck at right angles, determine the minimum and maximum possible length for the 4th stick to be cut, assuming we are talking of scenarios when none of the edges go beyond the vertices thus formed.

 

Input will be 6 integers, 2 in each line representing the the range for base (li, ui) and the 2 sides respectively.

The output should be 2 comma separated integers, representing the rounded off range for the 4th side (lower number first, then higher number)

 

Note: both the base and the sides will be a positive number less than 500 units

 

Example:

 

1)

Input:

4,4

3,3

3,3

 

Output:

4,4

 

Explanation:

The base  (4) and the 2 sides (3) have no error, so the new side also will not have any error, and will be equal to the base.

 

2)

Input:

10,12

4,8

3,6

 

Output:

10,13

 

Explanation:
The best case is when the base is of size 10, and the sides are equal (possible in the range (4,6) ). Worst is when the base is 12, and the difference in 2 sides is 5 (the sides have size 8 and 3)
 */
import java.io.*;
import java.util.*;
public class CodeNation2_Sticky_Problem
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter base stick: ");
        String line = br.readLine();
        //System.out.println(line);
        
        String[] parts = line.split(",");
        //System.out.println(parts[0]);
        int opp_min = Integer.parseInt(parts[0]);
        int opp_max = Integer.parseInt(parts[1]);
        
        System.out.println("Enter side stick1: ");
        line = br.readLine();
        parts = line.split(",");
        int s1_min = Integer.parseInt(parts[0]);
        int s1_max = Integer.parseInt(parts[1]);
        //System.out.println(line);
        
        System.out.println("Enter side stick2: ");
        line = br.readLine();
        parts = line.split(",");
        int s2_min = Integer.parseInt(parts[0]);
        int s2_max = Integer.parseInt(parts[1]);
        
        //maximum calculation
        int base_max = opp_max;
        int perp_max = Math.max(s1_max-s2_min, s2_max-s1_min);
        
        int result_max = (int) Math.sqrt((base_max*base_max + perp_max*perp_max));
        
        //minimum calculation
        int base_min = opp_min;
        int perp_min;
        if(s1_min < s2_min)
        {
        	if(s1_max<s2_min)
        	{
        		perp_min = s2_min - s1_max;
        	}
        	else
        	{
        		perp_min = 0;
        	}
        }
        else
        {
        	if(s2_max<s1_min)
        	{
        		perp_min = s2_max - s1_min;
        	}
        	else
        	{
        		perp_min = 0;
        	}
        }
        
        int result_min = (int) Math.sqrt((base_min*base_min + perp_min*perp_min));
        
        System.out.println("Result: "+result_min + " " + result_max);


	}

}
