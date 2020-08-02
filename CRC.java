import java.util.Scanner;
class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter data:");
        String dt = sc.nextLine();
        System.out.println("Enter divisor: ");
        String div = sc.nextLine();

        int data[] = new int[dt.length() + div.length() - 1];
        int divisor[] = new int[div.length()];

        for(int i=0;i<dt.length();i++)
            data[i] = Integer.parseInt(dt.charAt(i)+"");
            
        for(int i=0;i<div.length();i++)
            divisor[i] = Integer.parseInt(div.charAt(i)+"");


        for(int i=0;i<dt.length();i++)
        {
            if(data[i]==1){
                for(int j=0;j<divisor.length;j++){
                    data[i+j] ^= divisor[j];
        }
            }
        }


        System.out.println("The CRC code is: ");

        for(int i=0;i<dt.length();i++)
            data[i] = Integer.parseInt(dt.charAt(i)+"");

        for(int i=0;i<data.length;i++) 
            System.out.println(data[i]);

        System.out.println();

        System.out.println("Enter CRC code: ");
            dt = sc.nextLine();

        System.out.println("Enter generator: ");
            div = sc.nextLine();

        data = new int[dt.length() + div.length() - 1];
            divisor = new int[div.length()];

        for(int i=0;i<dt.length();i++)
            data[i] = Integer.parseInt(dt.charAt(i)+"");

        for(int i=0;i<div.length();i++)
            divisor[i] = Integer.parseInt(div.charAt(i)+"");


        for(int i=0;i<dt.length();i++)
        {
            if(data[i]==1)
                for(int j=0;j<divisor.length;j++)
                    data[i+j] ^= divisor[j];
        }


        boolean valid = true;

        for(int i=0;i<data.length;i++)
            if(data[i]==1)
            {
                valid = false;
                break;
            }

        if(valid==true)
            System.out.println("Data is valid");
        else 
            System.out.println("Data is invalid. CRC error occured.");
        }
}
