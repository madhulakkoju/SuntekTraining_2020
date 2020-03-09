import java.util.*;

// the Method minReplacement() is Bruteforce where unnecessary repeatedcalculations occur 
// the Method minReplacementwithDp() is optimized using storing already calculated values so that repeated trees are pruned away to reduce time taken.

// However both have the same Worstcase time complexity as if the array size required is higher than the present one, the arrays tend to increase the size and take much time in copying the elements.


class MinimumReplacements
{  
  // public static methid to return the minimum value of 2 numbers
  public static int minimumValue(int Number1 , int Number2)
  {
    return (Number1 > Number2) ? Number2 : Number1 ;
  }
  
  // public static recursion using BackTracking
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
  // Time COmplexity Relation found : T(n) = T(n-1) + T(n+1) + C  --> Worst case
  // Time complexity :
  // Space Complexity : O(1)
  
  // public static method using backtracking and "Memoization" to reduce unncessary repeated calculations. 
  public static int minReplacementwithDp(int number , int[] memoryOfreplacements )
  {
    if(number == 1) // base case where the solution is found. so to count no of replaceets return 0
      return 0;
    if(number <= 0) // Impossible case where infintely calling.. so, stop recursio and retrn -1 
      return -1; // impossible case stopped.
    if(memoryOfreplacements[number] != 0)
      return memoryOfreplacements[number]; // If already present , use it ..
      
    if(number % 2 == 0)
    {
      memoryOfreplacements[ number ] = minReplacement(number/2) + 1 ; // if number is even take a replacement and call n/2
      return memoryOfreplacements[ number ];
    }
    memoryOfreplacements[ number ] = minimumValue(minReplacement(number+1) , minReplacement(number-1))+ 1 ;
    return memoryOfreplacements[ number ] ;
    // if the number vis odd tae the minimum possible repaement of n-1 and n+1.
  }
  // Time COmplexity Relation found : T(n) = T(n-1) + T(n+1) + C  --> Worst case
  // Time complexity : 
  // Space Complexity : O(number) 
  
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    int testcaseCount = Integer.parseInt(sc.nextLine());
    int[] memoryOfreplacements = new int[10]; // Initially declaring the array with 10 size 
    // if the  required size exceeds, resize the array.  
    while(testcaseCount > 0)
    {
      testcaseCount --;
      int number = Integer.parseInt(sc.nextLine()); // Take input integer
      
      System.out.print("" +" Regular : "+ minReplacement(number) ); // calling function with number and display output. 
      // ----- Method 2 -- using Memoization 
      if(number > memoryOfreplacements.length ) // If the array size is less than the required size do.. resize.
        memoryOfreplacements = Arrays.copyOf( memoryOfreplacements ,  number + 10 );
      // Resizing the array using inbuilt array copy function 
      System.out.println( "  &   Using Memoizatoin with methds : " +minReplacementwithDp(number , memoryOfreplacements) );
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
60
36
-2
0

OUTPUT

 Regular : 1  &   Using Memoizatoin with methds : 1
 Regular : 7  &   Using Memoizatoin with methds : 7
 Regular : 6  &   Using Memoizatoin with methds : 6
 Regular : -1  &   Using Memoizatoin with methds : -1
 Regular : -1  &   Using Memoizatoin with methds : -1


*/

