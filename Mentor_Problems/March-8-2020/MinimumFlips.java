import java.util.*;

/*
QUESTION - 2

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a
and b to make ( a OR b == c ). (bitwise OR operation).
Input: a = 2, b = 6, c = 5
Output: 3
*/

class MinimumFlips
{  
  // Approach : taking three numbers and checking the least significant bit ... 
  //      thereby left shifting the numbers and repeatingt he same.
  public static int minFlips(int numberA, int numberB , int numberC)
  {
    int flips = 0;
    while( numberA > 0 || numberB > 0 || numberC > 0 )
    {
      if(numberC % 2 == 0) 
      {
        // If numberC is even, any of the numberA or numberB are also expected to be even..
          if(numberA %2 == 1 && numberB %2 == 1)
          {
              flips += 2; // both the number's LSB has to be flipped. 
          }
          else if( numberA %2 == 0 && numberB %2 == 0 )
          {/* Do Nothing because noneed of flipping  */   }
          else
          {
            flips ++; // here one of them is 1 and other is 0.. so flip any of them to obtain 0
          }
      }
      else
      {
        // If number c is odd, either of the numbers should be odd but not both.
          if(numberA %2 == 1 && numberB %2 == 1)
          {
            // both odd implies one bit to flip.
              flips ++;
          }
          else if( numberA %2 == 0 && numberB %2 == 0 )
          {
            // both even implies one bit to flip
              flips ++;
          }
      }
      numberA = numberA >> 1;
      numberB = numberB >> 1;
      numberC = numberC >> 1;
      // LSB's discarded in the numbers .. i.e., Left Shift 
    }
    return flips;
  }
  // Time Complexity : O(n)
  // Space Complexity : O(1)
  
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    int testCasesCount = Integer.parseInt(sc.nextLine());
    while(testCasesCount > 0)
    {
      testCasesCount --;
        int numberA = Integer.parseInt(sc.nextLine());
        int numberB = Integer.parseInt(sc.nextLine());
        int numberC = Integer.parseInt(sc.nextLine());
        System.out.println(minFlips(numberA,numberB,numberC));      
    }

  }
}


/*
INPUT Format : 
5 // no of test cases
//-----
5
6
3
//---
9
8
6
--


INPUT : 

5
8
6
3
5
8
9
3
3
9
12
53
65
0
2
63


OUTPUT 

3
1
4
6
5



*/


