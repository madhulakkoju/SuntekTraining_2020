
import java.io.*;
import java.util.*;

public class MaxEvents
{
  
  public static int maxEvents(int start[],int end[],int n)
  {
    
    // Sorthing according to start and end day of events.
    for(int i =0;i<n;i++)
		{
		  for(int j = i+1;j<n;j++)
		  {
		    if(start[i] > start[j] )
		    {
		      int k = start[i];
		      start[i] = start[j];
		      start[j] = k;
		      
		      k = end[i];
		      end[i] = end[j];
		      end[j] = k;
		    }
		    else if(start[i] == start[j])
		    {
		      if(end[j] < end[i])
		      {
		        int k = end[i];
		      end[i] = end[j];
		      end[j] = k;
		      }
		    }
		  }
		}
		// considering each day of the event and checking whether 
		// the day is already booked for an event
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i =0;i<n;i++)
		{
		  for(int j = start[i]; j<=end[i];j++ )
		  {
		    if(! h.contains(j))
		    {
		      h.add(j);
		      break;
		    }
		    
		  }
		}
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(end));
		System.out.println(h);
		return h.size(); // the numbwer of days in set will define the total events they can come to.
    
  }
  
  
	public static void main(String[] args) {
		
		int []start ;
		int []end;
		Scanner sc = new Scanner(System.in);
		
		int testcase = Integer.parseInt(sc.nextLine());
		while(testcase > 0)
		{
		  testcase --;
		  int n = Integer.parseInt(sc.nextLine());
		start = new int[n];
		end = new int[n];
		for(int i = 0;i<n;i++ )
		{
		  start[i] = sc.nextInt();
		  end[i] = sc.nextInt();
		  sc.nextLine();
		}
		System.out.println(maxEvents(start, end, n) );
		}
		
	}
}

/*
INPUT : 
5
5
1 4
4 4
2 2
3 4
1 1
4
1 2
2 3
3 4
1 2
3
1 2
2 3
3 4
1
1 100000
7
1 1
1 2
1 3
1 4
1 5
1 6
1 7

OUTPUT :

[1, 1, 2, 3, 4]
[1, 4, 2, 4, 4]
[1, 2, 3, 4]
4
[1, 1, 2, 3]
[2, 2, 3, 4]
[1, 2, 3, 4]
4
[1, 2, 3]
[2, 3, 4]
[1, 2, 3]
3
[1]
[100000]
[1]
1
[1, 1, 1, 1, 1, 1, 1]
[1, 2, 3, 4, 5, 6, 7]
[1, 2, 3, 4, 5, 6, 7]
7


*/
