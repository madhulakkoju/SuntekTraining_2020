import java.io.*;
import java.util.*;
public class Main
{
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = Integer.parseInt(sc.nextLine() );
		while(testcases > 0)
		{
		  testcases --;
		  int n = Integer.parseInt(sc.nextLine() );
	    ArrayList<Integer> all = new ArrayList<Integer>(2*n);
		  StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
      while(st.hasMoreTokens() )
      {
        all.add(Integer.parseInt(st.nextToken()));
      }

		  st = new StringTokenizer(sc.nextLine()," ");
    while(st.hasMoreTokens() )
      {
        all.add(Integer.parseInt(st.nextToken()));
      }
      Collections.sort(all);
      
      if(all.size() % 2 == 1 )
      {
        System.out.println(all.get(all.size()/2) );
      }
      else 
      {
        System.out.println( (all.get((all.size()- 1)/2) + all.get((all.size())/2))/2 );
      }
		}
	}
}

/*
INPUT
1
5
1 12 15 26 38
2 13 17 30 45

OUTPUT
16

*/
