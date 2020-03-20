import java.io.*;
import java.util.*;
public class StringGen
{
  public static ArrayList<String> strings ;
  public static void addNew()  
  {
    if(strings.size()==0 )
    {
      strings.add("0");
      return;
    }
    String prev = strings.get(strings.size()-1 );
    StringBuffer bf = new StringBuffer("");
    for(int i=0;i<prev.length();i++)
    {
      if(prev.charAt(i)=='0')
      bf.append("01");
      else 
      bf.append("10");
    }
    strings.add(new String(bf) );
  }
	public static void main(String[] args) {
	
	  Scanner sc = new Scanner(System.in);
		strings = new ArrayList<String>();
		
		int testcases = Integer.parseInt(sc.nextLine());
		while(testcases > 0)
		{
		  testcases --;
		  int n = Integer.parseInt(sc.nextLine());
		  int k = Integer.parseInt(sc.nextLine());
		  
		  for(int i = strings.size() ; i < n;i++)
		  {
		    addNew();
		  }
		  
		  System.out.println(strings);
		  System.out.println( (strings.get(n-1)).charAt(k-1) );
		}
	}
}

/*
INPUT 
4
1
1
2
1
2
2
4
5

OUTPUT

[0]
0
[0, 01]
0
[0, 01]
1
[0, 01, 0110, 01101001]
1


*/
