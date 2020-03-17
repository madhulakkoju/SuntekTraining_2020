import java.util.*;

class SegmentTreeNode<T extends Number>
{
  public SegmentTreeNode<T> left;
  public SegmentTreeNode<T> right;
  public T value;
  public int leftBound;
  public int rightBound;
  
  public SegmentTreeNode(int leftBound, int rightBound)
  {
    this.leftBound = leftBound;
    this.rightBound = rightBound;
  }
  public T Build(T array[],int left, int right)
  {
    if(left == right)
    {
      this.value = array[left];
      return this.value;
    }
    
    int mid = (left + right) / 2;
    this.left = new SegmentTreeNode<T>(left,mid);
    this.right = new SegmentTreeNode<T>(mid+1,right);
    
    this.value = (T) (Integer)((Integer)this.left.Build(array,left,mid) +(Integer) this.right.Build(array,mid+1,right)) ;
    
    return this.value;
  }
  public void InorderTraversal()
  {
    if(this.left != null)
    this.left.InorderTraversal();
    System.out.print(""+ this.value+" ");
    if(this.right!= null)
    this.right.InorderTraversal();
  }
  public void PreorderTraversal()
  {
    System.out.print(""+ this.value+" ");
    
    if(this.left != null)
    this.left.PreorderTraversal();
    if(this.right!= null)
    this.right.PreorderTraversal();
    return;
  }
  public void PostorderTraversal()
  {
    if(this.left != null)
    this.left.PostorderTraversal();
    if(this.right!= null)
    this.right.PostorderTraversal();
    
    System.out.print(""+ this.value+" ");
    return;
  }
  public T Update(T val,int pos)
  {
    if((leftBound == rightBound) && (leftBound == pos))
    {
      this.value = val;
      return this.value;
    }
    
    if( pos >= this.leftBound && pos <= this.rightBound )
    {
      int mid = (leftBound + rightBound ) / 2;
      this.value = (T) (Integer)((Integer)this.left.Update(val,pos) +(Integer) this.right.Update(val,pos)) ;
    }
    return this.value;
  }
  public T SumRange(int leftBounds,int rightBounds)
  {
      // This node's bounds are equal with given bounds.
      // this value is returned. 
      if(this.leftBound == leftBounds && this.rightBound == rightBounds )
        return this.value;
        
      int mid = (this.leftBound + this.rightBound)/2 ;
      // Mid is used to check the bounds forthe node and continue for next child nodes
      
      // The range is present in the left subtree
      if(leftBounds < mid && rightBounds <= mid  )
          return this.left.SumRange(leftBounds,rightBounds);
      // The range is present iun the right subtree
      if(leftBounds > mid && rightBounds > mid )
          return this.right.SumRange(leftBounds,rightBounds);
      // The range is fivided acrodd the both subtrees across this node. 
      if(leftBounds <= mid && mid < rightBounds )
          return (T)(Integer)((Integer)this.left.SumRange(leftBounds,mid)+(Integer)this.right.SumRange(mid+1,rightBounds));
      return this.value;      
  }
}
class SumSegmentTree<T extends Number>   // 0 indexing
{  
  private T array[];
  public T totalSum;
  private final int arrayLength; // No new element addition - so, final
  private SegmentTreeNode<T> head;
  //public SumSegmentTree
  
  public SumSegmentTree(T[] array)
  {
    this.array = array;
    this.arrayLength = array.length;
    return;
  }  
  public void BuildSegmentTree()
  {
    head = new SegmentTreeNode<T>(0,array.length-1);
    totalSum = head.Build(array,0,array.length-1);
  }
  public void UpdateSegmentTree( T val , int pos)
  {
    // Updating an element from the arrey
    // thereby modifying the tree elements
    array[pos] = val;
    totalSum = head.Update(val,pos);
  }
  public void InorderTraversal()
  {
  System.out.println("\nIn OrderTraversal : ");
  if(head == null)
  System.out.println("Empty");
  else
    head.InorderTraversal();
  }
  public void PreorderTraversal()
  {
  System.out.println("\nPre OrderTraversal : ");
  if(head == null)
  System.out.println("Empty");
  else
    head.PreorderTraversal();
  }
  public void PostorderTraversal()
  {
  System.out.println("\nPost OrderTraversal : ");
  if(head == null)
  System.out.println("Empty");
  else
    head.PostorderTraversal();
  }
  public T findSumRange(int left,int right)
  {
    return head.SumRange(left,right);
  }
  
}


class SegmentTreeImplementation
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int testcases = Integer.parseInt(sc.nextLine());
    int arrayLength;
    Integer array[];
    SumSegmentTree<Integer> tree;
    
    while(testcases > 0)
    {
      testcases --;
      arrayLength  = Integer.parseInt(sc.nextLine());
      StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
      array = new Integer[arrayLength];
      int i=0;
      while(i< arrayLength )
      {
        array[i++] = Integer.parseInt( st.nextToken() );
      }
      
      // Taking array of elements
      
      // creating segment tree using array 
      tree = new SumSegmentTree<Integer>(array);
      tree.BuildSegmentTree(); // Building Segment tree 
      System.out.println("\n\nAfter Building Tree : ");
      // Checking the tree
      tree.InorderTraversal();
      tree.PreorderTraversal();
      tree.PostorderTraversal();
      
      int queryCount = Integer.parseInt(sc.nextLine());
      // > Menu 
      // 1. Sum Range
      // 2. Update an array element 
      // 3. Tree Traversal print 
      // 4. Total Sum Of array
      // 5. Exit this 
      
      while(queryCount > 0)
      {
        queryCount --;
        int option = Integer.parseInt(sc.nextLine());
        switch(option)
        {
          case 1:
            // Sum range 
            int left =  sc.nextInt();
            int right = sc.nextInt();
            sc.nextLine();
            System.out.println("\nSum  of Range "+ left + " - "+right + " = "+ tree.findSumRange(left,right));
            break;
          case 2 :
            // update array
            int val=  sc.nextInt();
            int pos = sc.nextInt();
            sc.nextLine();
            tree.UpdateSegmentTree(val,pos);
            break;
          case 3:
            // tree  traversal 
            tree.InorderTraversal();
            tree.PreorderTraversal();
            tree.PostorderTraversal();
            break;
          case 4:
            // Total Array USm 
            System.out.println(tree.totalSum);
            break;
          case 5:
            queryCount = 0;
            break;
        }
      }
      
    }   
    
    
  }
}

/*

Input : for,at

2
11
1 2 5 6 4 7 9 11 16 3 8
6
1
2 9
2
50 3
3
4
1
0 6
3
7
3 6 9 8 5 6 2
6
1
2 5
2
50 3
3
4
1
0 6
3

Output

After Building Tree : 

In OrderTraversal : 
1 3 2 8 5 25 6 10 4 17 7 72 9 20 11 36 16 47 3 11 8 
Pre OrderTraversal : 
72 25 8 3 1 2 5 17 10 6 4 7 47 36 20 9 11 16 11 3 8 
Post OrderTraversal : 
1 2 3 5 8 6 4 10 7 17 25 9 11 20 16 36 3 8 11 47 72 
Sum  of Range 2 - 9 = 69

In OrderTraversal : 
1 3 2 8 5 69 50 54 4 61 7 116 9 20 11 36 16 47 3 11 8 
Pre OrderTraversal : 
116 69 8 3 1 2 5 61 54 50 4 7 47 36 20 9 11 16 11 3 8 
Post OrderTraversal : 
1 2 3 5 8 50 4 54 7 61 69 9 11 20 16 36 3 8 11 47 116 116

Sum  of Range 0 - 6 = 89

In OrderTraversal : 
1 3 2 8 5 69 50 54 4 61 7 116 9 20 11 36 16 47 3 11 8 
Pre OrderTraversal : 
116 69 8 3 1 2 5 61 54 50 4 7 47 36 20 9 11 16 11 3 8 
Post OrderTraversal : 
1 2 3 5 8 50 4 54 7 61 69 9 11 20 16 36 3 8 11 47 116 

After Building Tree : 

In OrderTraversal : 
3 9 6 26 9 17 8 39 5 11 6 13 2 
Pre OrderTraversal : 
39 26 9 3 6 17 9 8 13 11 5 6 2 
Post OrderTraversal : 
3 6 9 9 8 17 26 5 6 11 2 13 39 
Sum  of Range 2 - 5 = 28

In OrderTraversal : 
3 9 6 68 9 59 50 81 5 11 6 13 2 
Pre OrderTraversal : 
81 68 9 3 6 59 9 50 13 11 5 6 2 
Post OrderTraversal : 
3 6 9 9 50 59 68 5 6 11 2 13 81 81

Sum  of Range 0 - 6 = 81

In OrderTraversal : 
3 9 6 68 9 59 50 81 5 11 6 13 2 
Pre OrderTraversal : 
81 68 9 3 6 59 9 50 13 11 5 6 2 
Post OrderTraversal : 
3 6 9 9 50 59 68 5 6 11 2 13 81 

Process Finished.

*/

