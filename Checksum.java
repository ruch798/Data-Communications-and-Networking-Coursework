import java.util.*;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    String a=new String();
    System.out.println("Transmitter Side:");
    System.out.print("Enter 64 bit data = ");
    a=sc.next();
    int s=0,i;
    for(i=0;i<a.length();i+=4)
    {
      s=s+Integer.parseInt(a.substring(i,i+4),16);
    }
    String b=new String(Integer.toHexString(s));
    System.out.println("After Addition = "+b);
    int x=Integer.parseInt(b.substring(0,1),16);
    int y=Integer.parseInt(b.substring(1,5),16);
    System.out.println("After adding carry = "+Integer.toHexString(x+y));
    int sum=65535-(x+y);
    System.out.println("Checksum (1's complement) is = "+Integer.toHexString(sum));
    System.out.println("Data sent is = "+a+Integer.toHexString(sum));
    System.out.println();
    StringBuffer dr=new StringBuffer(a+Integer.toHexString(sum));
    System.out.println("Receiver Side:");
    System.out.print("Would you like to have error in the code? ");
    String ch=sc.next();
    if(ch.equals("y")||ch.equals("Y"))
    {
      dr.setCharAt(1,'0');
    }
    s=0;
    System.out.println("Data received is = "+dr);
    for(i=0;i<dr.length();i+=4)
    {
      s=s+Integer.parseInt(dr.substring(i,i+4),16);
    }
    b=Integer.toHexString(s);
    System.out.println("After Addition = "+b);
    x=Integer.parseInt(b.substring(0,1),16);
    y=Integer.parseInt(b.substring(1,5),16);
    System.out.println("After adding carry = "+Integer.toHexString(x+y));
    sum=65535-(x+y);
    System.out.println("Checksum(1's complement) is = "+Integer.toHexString(sum));
    if(sum==0)
    {
      System.out.println("Data received has no error");
    }
    else
    {
      System.out.println("Data received has error");
    }
  }
}