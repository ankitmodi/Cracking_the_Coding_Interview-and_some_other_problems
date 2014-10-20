/*Suppose all months have 30 days. There's 12 months in a year. 
 * February would have 31 days in a Leap year. condition for leap year is defined as 
 * (year%40==0) is leap, (year%200==0) is not leap, (year%1000==0) is leap. 
 * Given a date as MM/DD/YYYY, find the next Leap Day.
*/
import java.util.*;
public class Epic2_Next_Leap_Day 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the date: ");
		String date1 = scan.next();
		
		System.out.println("Enter the day: ");
		int day1 = scan.nextInt();
		//System.out.println(date1);
		
		
		String date2 = nextLeapDay(date1);
		System.out.print("Next Leap Day is: ");
		System.out.println(date2);
		
		
		int day2 = getDay(date1, day1, date2);
		System.out.print("And the day is: ");
		System.out.println(day2);

	}
	
	public static int getDay(String date1, int day, String date2)
	{
		String[] parts1 = date1.split("/");
		int year1 = Integer.valueOf(parts1[2]).intValue();
		int day1 = Integer.valueOf(parts1[1]).intValue();
		int month1 = Integer.valueOf(parts1[0]).intValue();
		int totaldays = 0;
		
		totaldays += 30*(12-month1) + (30-day1);
		if(isLeap(year1) && (month1==1 || (month1==2 && day1<=30)))
		{
			totaldays += 1;
		}
		
		
		String[] parts2 = date2.split("/");
		int year2 = Integer.valueOf(parts2[2]).intValue();
		int day2 = Integer.valueOf(parts2[1]).intValue();
		int month2 = Integer.valueOf(parts2[0]).intValue();
		
		while(year1 != year2)
		{
			year1++;
			if(!isLeap(year1))
			{
				totaldays += 360;
			}
			else
			{
				totaldays += 361;
			}
			
			
		}
		
		totaldays += (month2-1)*30 + (30-day2);
		if(isLeap(year2) && (month2>2 || (month2==2 && day2==31)))
		{
			totaldays += 1;
		}
		System.out.println("totaldays: " + totaldays);
		
		int remainder = (totaldays+day)%7 + 1;
		
		
		
		return remainder;
	}
	
	public static String nextLeapDay(String date)
	{
		String[] parts = date.split("/");
		int year = Integer.valueOf(parts[2]).intValue();
		int day = Integer.valueOf(parts[1]).intValue();
		int month = Integer.valueOf(parts[0]).intValue();
		
		if(month>12 || (day>30 && !(isLeap(year) && (month==2 && day==31))))
		{
			return "Wrong date format";
		}
		
		if(isLeap(year) && (month==1 || (month==2 && day<=30)))
		{
			String date2 = String.valueOf(2)+"/"+String.valueOf(31)+"/"+String.valueOf(year);
			return date2;
		}
		
		int year2 =year+1;
		
		while(!isLeap(year2))
		{
			year2++;
		}
		String date2 = String.valueOf(2)+"/"+String.valueOf(31)+"/"+String.valueOf(year2);
		return date2;
		
	}
	
	public static boolean isLeap(int year)
	{
		return ( (year%40==0 && year%200!=0) || year%1000==0) ;
	}

}
