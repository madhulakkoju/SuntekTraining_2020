import java.util.*;

class FirstMissing
{  
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    TreeSet<Integer> ts = new TreeSet<Integer>();
    StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
    while(st.hasMoreTokens())
    {
      ts.add(Integer.parseInt(st.nextToken()));
    }
    Iterator<Integer> it = ts.iterator();
    int prev = it.next();
    int cur;
    while(it.hasNext())
    {
      cur = it.next();
      if( cur != (prev+1) )
        break;
      prev = cur;
    }
    if(it.hasNext())
      System.out.println(prev+1);
    else
      System.out.println("Intact");
  }
}

/*
Input :
1 2 3 4 6 5 8 9 7 11 10
Output:
Intact

Input :
1 2 3 4 5 8 9 7 11 10
OutPut:
6



*/
