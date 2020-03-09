import java.util.*;

class MinimumReplacements
{  
  // public static methid to return the minimum value of 2 numbers
  public static int minimumValue(int Number1 , int Number2)
  {
    return (Number1 > Number2) ? Number2 : Number1 ;
  }
  // public static recursive method using backtracking
  public static int minReplacement(int number)
  {
    if(number == 1) // base case where the solution is found. so to count no of replaceets return 0
      return 0;
    if(number <= 0) // Impossible case where infintely calling.. so, stop recursio and retrn -1 
      return -1; // impossible case stopped.
    
    if(number % 2 == 0)
      return minReplacement(number/2) + 1 ; // if number is even take a replacement and call n/2
    
    return minimumValue(minReplacement(number+1) , minReplacement(number-1))+ 1 ;
    // if the number vis odd tae the minimum possible repaement of n-1 and n+1.
  }
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    int testcaseCount = Integer.parseInt(sc.nextLine());
    while(testcaseCount > 0)
    {
      testcaseCount --;
      int number = Integer.parseInt(sc.nextLine()); // Take input
      System.out.println( minReplacement(number) ); // calling function with number and display output. 
    }
    
  }
}


/*
INPUT Format ::
5 // N of testcases
//---------
2 ----- number ibput
6
3
-2
0
--------------------------
INPUT 
5
2
6
3
-2
0

OUTPUT
1
3
2
-1
-1


*/

