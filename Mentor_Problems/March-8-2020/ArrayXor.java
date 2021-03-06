import java.util.*;
import java.io.*;
/*
QUESTION  - 1
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri], for
each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor
arr[Ri] ). Return an array containing the result for the given queries.
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
*/
class ArrayXor
{  
  // Public method which finds the Sub array's XOR value. 
  public Integer[] XorSubArray( int arrLength, Integer[] array,int queryCount, Integer[][] queries )
  { 
    Integer[] values  = new Integer[queryCount];
    // the values array stores the xor valus of tte given queries
    int valueCounter = 0; // index counter of the values array
    for(int iterator = 0; iterator<queryCount; iterator ++)
    {
      int xorValue = 0; // initial XOR value taken 0 because 0 ^ f = f 
      for(int iterator2 = queries[iterator][0] ; iterator2 <= queries[iterator][1];iterator2 ++)
      {
        xorValue = xorValue ^ array[iterator2];
      }
      values[valueCounter ++] = xorValue;
    }
    // all the values array are stored with respective xor values between indices mentioned
    return values;
  }
  //TIme Complexity : O(queryCount**2)
  //Space Complexity : O(queryCount)
  
  public Integer[] XorSubArrayOpt( int arrLength, Integer[] array,int queryCount, Integer[][] queries )
  {
    
    Integer[] values  = new Integer[queryCount];
    // the values array stores the xor valus of tte given queries
    
    Integer[] bufferVals = new Integer[arrLength];
    bufferVals[0] = array[0];
    for(int iterator = 1;iterator< arrLength;iterator++)
    {
      bufferVals[iterator] = bufferVals[iterator -1] ^ array[iterator];
    }
    // All the buffer values are stored. 
    int valueCounter = 0; // index counter of the values array
    for(int iterator = 0; iterator<queryCount; iterator ++)
    {
      int xorValue = 0; // initial XOR value taken 0 because 0 ^ f = f 
       xorValue = xorValue ^ bufferVals[queries[iterator][1]];
      if(queries[iterator][0] > 0)  
        xorValue = xorValue ^ bufferVals[queries[iterator][0] - 1];

      values[valueCounter ++] = xorValue;
    }
    // all the values array are stored with respective xor values between indices mentioned
    return values;
    
  }
  // Time Complexity : O(arrLength) + O(queryCount) ~ O(n)
  // Space Complexity : O(arrLength) + O(queryCount)  O(n)
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    ArrayXor obj = new ArrayXor();
    int t = Integer.parseInt(sc.nextLine());
    // the test cases run without any influence to eachother. so loop them
    while( t > 0 )
    {
      t--;
      
      int arrLength = Integer.parseInt(sc.nextLine());
      Integer[] array = new Integer[arrLength];
      // reading the input line into SringTokenier to split them and insert to arrays.
      StringTokenizer inputBuffer = new StringTokenizer( sc.nextLine() ," " );
      // inserting integer coponents into integer array - array
      int iterator = 0;
      while(inputBuffer.hasMoreTokens())
      {
        array[iterator ++] = Integer.parseInt(inputBuffer.nextToken());
      }
      
      // GIven input array is stored... now g for queries 
      
      int queryCount = Integer.parseInt(sc.nextLine());
      
      // each query has 2 parts = left and right indexes . 
      // cretaing 2D Integer array of size ( queryCount * 2 )
      Integer[][] queries = new Integer[queryCount][2];
      
      for(int iterator2 = 0; iterator2<queryCount; iterator2 ++)
      {
        queries[iterator2][0] = sc.nextInt();
        queries[iterator2][1] = sc.nextInt();
        sc.nextLine();
      }
      // Queries data is aso taken as input as in input format.
      
      System.out.println( " Regulat : "+ Arrays.toString( obj.XorSubArray(arrLength,array,queryCount,queries) ) ); // printing the output array 
      System.out.println( " Optimized : " + Arrays.toString( obj.XorSubArrayOpt(arrLength,array,queryCount,queries) ) ); // printing the output array 
    }
    
  }
}


/*
Input Format :: 
1 // no of testcases
//-------------------
4 // array length
1 3 4 8 // array
4 // no of queries
0 1
1 2
0 3
3 3  // all queries taken
//-------------------
Output :
 Regulat : [2, 7, 14, 8]
 Optimized : [2, 7, 14, 8]



// Test Cases for Execution



*/
