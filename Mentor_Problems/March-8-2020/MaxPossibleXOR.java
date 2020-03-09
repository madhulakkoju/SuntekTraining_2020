import java.util.*;

// the method maxXorAllCase checks all the possible cases and  returns max of it. :: Briteforce
// the method maxXor is optimized time wise by takind 3 different conditions into consideration. 

class MaxPossibleXOR
{  
   /*
      This can be done by O(n) 
      In this problem, when we observe all combinations, we find that the max element is highly influencing the xor value in most of the cases. 
      so, we can use this max value. 
      case 1 : Max Number is used and maximum possible xor is found by iterating across array for the second time. 
      
      There is is an anamoly in this problem : 
      
      case 2 : In some cases the presence of maxnumber - 1 influences too. 
              i.e.,  if both max number and maxnumber - 1 are present , then if 1 is present too , 
                      there is some change in the xor value depending onthe last bit of each number which denotes even / odd. 
                      This can be used ,, if the number is odd, last bit is 1 and 1 is 1... uipon xor, thery come out to be 0 
                                          if the number is even, last bit is 0 and 1 is 1 .. upon xor, they will be 1 
                                          in 0 and 1 1 holds the max value. so that is returned.
    
    */
  public static int maxXorAllCase( Integer[] array ) // Brute Force 
    {// Checking all possible solutions possible for XOR(ai,aj)
    int xorval = 0;
    for(int iterator = 0;iterator < array.length-1; iterator ++) 
    {
      for(int iterator2 = iterator + 1;iterator2 < array.length; iterator2++)
      {
        if(xorval < (array[iterator2] ^ array[iterator]) )
        {
           xorval = array[iterator2] ^ array[iterator];
        }
      }
    }
    return xorval;
  }
  // Time Complexity : O(n**2) 
  // Space Complexity : O(1)
  
  public static int maxXor(Integer[] array)
  {
   
    int prevmaxNumber = 0;
    int maxNumber = 0;
    int maxIndex = -1;
    boolean one = false;
    for(int iterator2 = 0 ;iterator2 < array.length; iterator2++) // Finding the max number from the array
      {
        if(array[iterator2] == 1) // checkig the presence of 1 in array to fit the case 2 ...
          one = true;
        if(maxNumber < array[iterator2]  )
        {
          prevmaxNumber = maxNumber;
          maxNumber= array[iterator2] ;
          maxIndex = iterator2;
        }
      }
    int xorval = 0;
       for(int iterator2 = 0 ;iterator2 < array.length; iterator2++) // Finding if there is a number which is consecutive to max Number
      {
        if((maxNumber-1) == array[iterator2]  ) // storing that to prevmaxNumber
        {
          prevmaxNumber = maxNumber - 1 ;
        }
         if(xorval < (array[iterator2] ^ maxNumber) ) // parallely computng  the max xor value for the -- case 1 -- 
          xorval = array[iterator2] ^ maxNumber;
      }
    // xorval denotes the maxnumber according to CASE 1 discussed above.

      if(maxNumber == (prevmaxNumber+1) ) // checking for case 2
      {
         if(one) // checking for the presence of one in case 2
          {
            if(maxNumber%2 == 1) // if odd return  the other number 
            {
              if( (prevmaxNumber ^ 1) > xorval )
                return prevmaxNumber ^ 1;
            }
            else                      // if even return evenNumber ^ 1  -> this becomes higest val among alk
            {
               if( (maxNumber ^ 1) > xorval )
                return maxNumber ^ 1;
            }
         } 
      }
    return xorval; // max among both case1 and cas 2
  }
  // TIme Complexity : O(2*n) both worst and best cases are the same.
  // Space Complexity : O(1)
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int testCaseCount = Integer.parseInt(sc.nextLine());
    
    while(testCaseCount > 0)
    {
      testCaseCount --;
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
      System.out.println( " ALL CASE :  " + maxXorAllCase(array) + " O(n)  : " + maxXor(array) );
    }
  }
}

/*

INPUT FORMAT 
5 // Testcases count
//*------
6 // number of elements in array 
1 2 3 4 5 6
---

INPUT : 
6
7
1 3 4 5 6 9 8
9
1 2 4 55 63 62 22 21 1
10
51 52 53 59 56 55 58 57 51 52
6
1 55 56 53 98 99 
2
22 22
1
32

OUTPUT :

 ALL CASE :  15 O(n)  : 15
 ALL CASE :  63 O(n)  : 63
 ALL CASE :  15 O(n)  : 15
 ALL CASE :  99 O(n)  : 99
 ALL CASE :  0 O(n)  : 0
 ALL CASE :  0 O(n)  : 0



*/
