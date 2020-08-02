import java.util.*;
class Main {
public static void main(String[] args) {
  Scanner sc= new Scanner (System.in);
  int n,r=0,i,z=0,k=1,j=0,sum=0,flag=0;
  int code[]= new int [20];
  int data[]= new int [20];
  int check[]= new int[20];
  System.out.println ("Enter the number of bits");
  n= sc.nextInt();
  while (Math.pow(2,r)<(n+r))  //formula for parity bits
  {
    r++;
  }
  System.out.println ("The required parity bits are:" + r);
  System.out.println ("Enter the data bits");
  for (i=1;i<=7;i++)
  {
    data[i]= sc.nextInt();
  }
  for (i=1;i<=11;i++)
  {
    if (i==Math.pow(2,z))
    {
      z++;
    }
    else
    {
      code[i]= data[k++];
    }
  }
  z=0;
  k=0;
  System.out.println ();
  for (i=1;i<=11;i++)
  {
    if (i==Math.pow(2,z))
    {
      for (j=i+1;j<=11;j++)
      {
        if ((i&j)!=0)      
        {
          code[i]= code[i]^code[j];  
        }
      }
      z=z+1;
    }
  
  }
   for (i=1;i<=11;i++)
  {
    System.out.print (i + " ");
  }
  System.out.println ();
  for (i=1;i<=11;i++)
  {
    System.out.print (code[i]+ " ");
  }
  System.out.println ();
System.out.println ("Enter the received code:");
k=0;
z=0;
   for (i=1;i<=11;i++)
  {
    data[i]= sc.nextInt();
  }
  for (i=1;i<=11;i++)
  {
    if (i==Math.pow(2,z))
    {
      z++;
    }
    else
    {
      check[i]= data[i];
    }
  }
  z=0;
  k=0;
  System.out.println ();
  for (i=1;i<=11;i++)
  {
    if (i==Math.pow(2,z))
    {
      for (j=i+1;j<=11;j++)
      {
        if ((i&j)!=0)      
        {
          check[i]= check[i]^check[j];  
        }
      }
      z=z+1;
    }
  
  }
  for (i=1;i<=11;i++)
  {
      if (check[i]!=code[i])
      {
        flag=1;
        break;
      }
  }
  if (flag==0)
  {
    System.out.println ("No error");
  }  
  else
  {
    System.out.println ("error");
  }
  
}
}



